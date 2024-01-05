package quanlychitieu.DAO;

import quanlychitieu.models.DanhMuc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import quanlychitieu.DBconnection;

public class DanhMucDAO {
    
    public int getIdByTenDanhMuc(String tenDanhMuc) {
        int danhMucId = -1; // Giả sử không tìm thấy danh mục
        try (Connection connection = DBconnection.getConnection()) {
            String sql = "SELECT id FROM tblDanhMuc WHERE danhMuc=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, tenDanhMuc);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    danhMucId = resultSet.getInt("id");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return danhMucId;
    }
    public String getTenDanhMucById(int danhMucId) {
        String tenDanhMuc = null;

        try (Connection connection = DBconnection.getConnection()) {
            String sql = "SELECT danhMuc FROM tblDanhMuc WHERE id=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, danhMucId);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    tenDanhMuc = resultSet.getString("danhMuc");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    return tenDanhMuc;
}


    // Thêm danh mục (k cần)
//    public void themDanhMuc(DanhMuc danhMuc) {
//        try (Connection connection = DBconnection.getConnection()) {
//            String sql = "INSERT INTO tblDanhMuc (danhMuc) VALUES (?)";
//            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
//                preparedStatement.setString(1, danhMuc.getDanhMuc());
//                preparedStatement.executeUpdate();
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

}

