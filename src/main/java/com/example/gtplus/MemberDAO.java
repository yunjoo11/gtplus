package com.example.gtplus;

import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.example.gtplus.MemberVO;


@Repository
public class MemberDAO {

    @Autowired
    private DataSource dataSource;

    public List<MemberVO> listMembers() {
        List<MemberVO> list = new ArrayList<>();
        String query = "SELECT * FROM MEMBERLIST";

        try (Connection con = dataSource.getConnection();
             PreparedStatement pstmt = con.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                MemberVO vo = new MemberVO();
                vo.setId(rs.getString("id"));
                vo.setPwd(rs.getString("pwd"));
                vo.setName(rs.getString("name"));
                list.add(vo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public MemberVO getMemberById(String memberId) {
        MemberVO member = null;
        String query = "SELECT * FROM MEMBERLIST WHERE id=?";

        try (Connection con = dataSource.getConnection();
             PreparedStatement pstmt = con.prepareStatement(query)) {

            pstmt.setString(1, memberId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    member = new MemberVO();
                    member.setId(rs.getString("id"));
                    member.setPwd(rs.getString("pwd"));
                    member.setName(rs.getString("name"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return member;
    }

    public void updateMember(String memberId, String pwd, String name) {
        String query = "UPDATE MEMBERLIST SET pwd=?, name=? WHERE id=?";
        try (Connection con = dataSource.getConnection();
             PreparedStatement pstmt = con.prepareStatement(query)) {

            pstmt.setString(1, pwd);
            pstmt.setString(2, name);
            pstmt.setString(3, memberId);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void registerMember(String id, String pwd, String name) {
        String query = "INSERT INTO MEMBERLIST (id, pwd, name) VALUES (?, ?, ?)";
        try (Connection con = dataSource.getConnection();
             PreparedStatement pstmt = con.prepareStatement(query)) {

            pstmt.setString(1, id);
            pstmt.setString(2, pwd);
            pstmt.setString(3, name);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
