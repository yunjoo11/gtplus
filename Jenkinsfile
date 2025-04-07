import java.text.SimpleDateFormat

def TODAY = (new SimpleDateFormat("yyyyMMddHHmmss")).format(new Date())

pipeline {
    agent any
    environment {
        strDockerTag = "${TODAY}_${BUILD_ID}"
        strDockerImage ="yunjoo95/gtplus:${strDockerTag}"
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'test', url:'https://github.com/yunjoo11/gtplus.git'

                dir('/home/k8s/gtplus'){
                  
                }
            }
        }

        stage('Build') {
            steps {
                sh 'chmod +x ./mvnw'
                sh './mvnw clean package'
            }
        }

        stage('Docker Image Build') {
            steps {
                script {
                    oDockImage = docker.build(strDockerImage, "--build-arg VERSION=${strDockerTag} -f Dockerfile .")
                }
            }
        }

        stage('Docker Image Push') {
            steps {
                script {
                    docker.withRegistry('', 'DockerHub_Credential') {
                        oDockImage.push()
                    }
                }
            }
        }

        stage('Config-Repo PUSH') {
            environment {
                GITHUB_ACCESS_TOKEN = credentials('github-access-token')
            }
            steps {
                dir('/home/k8s/gtplus/gtp'){
                    sh '''
                        sed -i "s/gtplus:.*/gtplus:${strDockerTag}/g" deployment.yaml
                        git add deployment.yaml
                        git commit -m "[UPDATE] gtplus image tag - ${strDockerImage} (by jenkins)"
                        git push "https://yunjoo11:${GITHUB_ACCESS_TOKEN}@github.com/yunjoo11/gtplus.git"
                    '''
                }
            }
        }

        stage('ArgoCD Sync') {
            environment {
                ARGOCD_API_TOKEN = credentials('argocd-api-token')
            }
            steps {
                sh '''
                    TOKEN="${ARGOCD_API_TOKEN}"
                    PAYLOAD='{"prune": true}'
                    curl -v -k -XPOST \
                        -H "Authorization: Bearer ${TOKEN}" \
                        https://192.168.56.110/api/v1/applications/gtplus/sync
                '''
            }
        }
    }
}

