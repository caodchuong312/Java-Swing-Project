package quanlychitieu.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import quanlychitieu.DBconnection;

public class UserDAO {

    public int getIdByUsername(String username) {
        int userId = -1; // Giả sử trả về -1 nếu không tìm thấy
        try (Connection connection = DBconnection.getConnection()) {
            String sql = "SELECT id FROM tblUser WHERE username=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, username);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    userId = resultSet.getInt("id");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userId;
    }
    public boolean register(String username, String password, String repassword) {
        // Kiểm tra mật khẩu và mật khẩu nhập lại
        if (!password.equals(repassword)) {
            JOptionPane.showMessageDialog(null, "Mật khẩu không trùng khớp");
            return false;
        }

        String checkUserQuery = "SELECT * FROM tblUser WHERE username=?";
        String insertUserQuery = "INSERT INTO tblUser (username, password) VALUES (?, ?)";

        try (Connection conn = DBconnection.getConnection()) {
            try (PreparedStatement checkUserStatement = conn.prepareStatement(checkUserQuery)) {
                checkUserStatement.setString(1, username);
                ResultSet rs = checkUserStatement.executeQuery();
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "Tên đăng nhập đã tồn tại");
                    return false;
                }
            }
            // Nếu tên đăng nhập chưa tồn tại, thêm người dùng mới
            try (PreparedStatement insertUserStatement = conn.prepareStatement(insertUserQuery)) {
                insertUserStatement.setString(1, username);
                insertUserStatement.setString(2, password);
                int rowsAffected = insertUserStatement.executeUpdate();
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Đăng ký thành công");
                    return true;
                } else {
                    JOptionPane.showMessageDialog(null, "Đăng ký thất bại");
                    return false;
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }
    public boolean login(String username, String password) {
        try (Connection connection = DBconnection.getConnection()) {
            String sql = "SELECT * FROM tblUser WHERE username=? AND password=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);
                ResultSet resultSet = preparedStatement.executeQuery();
                return resultSet.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
