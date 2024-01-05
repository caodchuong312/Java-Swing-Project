package quanlychitieu.DAO;

import quanlychitieu.models.NganSach;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import quanlychitieu.DBconnection;

public class NganSachDAO {
    // Lấy ra Ngân Sách theo id
    public NganSach layNganSachTheoID(int nganSachID) {
        NganSach nganSach = null;
        try (Connection connection = DBconnection.getConnection()) {
            String sql = "SELECT * FROM tblNganSach WHERE id=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, nganSachID);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    nganSach = new NganSach();
                    nganSach.setId(resultSet.getInt("id"));
                    nganSach.setDanhMucId(resultSet.getInt("danhMucID"));
                    nganSach.setNganSach(resultSet.getDouble("nganSach"));                    
                    nganSach.setThangNam(resultSet.getString("ThangNam"));
                    nganSach.setUserId(resultSet.getInt("userId"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return nganSach;
    }
    
    // Lấy ra danh sách các Ngân Sách của user
    public List<NganSach> layDanhSachNganSachTheoUser(int userID) {
        List<NganSach> danhSachNganSach = new ArrayList<>();

        try (Connection connection = DBconnection.getConnection()) {
            String sql = "SELECT * FROM tblNganSach WHERE userId=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, userID);
                ResultSet resultSet = preparedStatement.executeQuery();
                
                while (resultSet.next()) {
                    NganSach nganSach = new NganSach();
                    nganSach.setId(resultSet.getInt("id"));
                    nganSach.setDanhMucId(resultSet.getInt("danhMucID"));
                    nganSach.setNganSach(resultSet.getDouble("nganSach"));                    
                    nganSach.setThangNam(resultSet.getString("ThangNam"));
                    nganSach.setUserId(resultSet.getInt("userId")); 
                    danhSachNganSach.add(nganSach);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSachNganSach;
    }
    
    // Lấy ra danh sách các Ngân Sách của user theo tháng và năm
    public List<NganSach> layDanhSachNganSachTheoUserVaThangNam(int userID, String thangNam) {
        List<NganSach> danhSachNganSach = new ArrayList<>();
        try (Connection connection = DBconnection.getConnection()) {
            String sql = "SELECT * FROM tblNganSach WHERE userId=? AND ThangNam=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, userID);
                preparedStatement.setString(2, thangNam);

                ResultSet resultSet = preparedStatement.executeQuery();
                
                while (resultSet.next()) {
                    NganSach nganSach = new NganSach();
                    nganSach.setId(resultSet.getInt("id"));
                    nganSach.setDanhMucId(resultSet.getInt("danhMucID"));
                    nganSach.setNganSach(resultSet.getDouble("nganSach"));                    
                    nganSach.setThangNam(resultSet.getString("ThangNam"));
                    nganSach.setUserId(resultSet.getInt("userId")); 
                    danhSachNganSach.add(nganSach);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSachNganSach;
    }
    
    // Thêm Ngân Sách
    public boolean themNganSach(NganSach nganSach) {
        try (Connection connection = DBconnection.getConnection()) {
            String sql = "INSERT INTO tblNganSach (danhMucID, nganSach, userId, thangNam) VALUES (?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, nganSach.getDanhMucId());
                preparedStatement.setDouble(2, nganSach.getNganSach());
                preparedStatement.setInt(3, nganSach.getUserId());
                preparedStatement.setString(4, nganSach.getThangNam());
                int affectedRows = preparedStatement.executeUpdate();
                return affectedRows > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    // Cập nhật Ngân Sách
    public boolean capNhatNganSach(int nganSachID, double soTienMoi, String thangNam) {
        try (Connection connection = DBconnection.getConnection()) {
            String sql = "UPDATE tblNganSach SET nganSach=?,ThangNam=? WHERE id=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setDouble(1, soTienMoi);
                 preparedStatement.setString(2, thangNam);
                preparedStatement.setInt(3, nganSachID);
                int affectedRows = preparedStatement.executeUpdate();
                return affectedRows > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    // Xóa Ngân Sách
    public boolean xoaNganSach(int nganSachID) {
        try (Connection connection = DBconnection.getConnection()) {
            String sql = "DELETE FROM tblNganSach WHERE id=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, nganSachID);
                int affectedRows = preparedStatement.executeUpdate();
                return affectedRows > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
   
}
