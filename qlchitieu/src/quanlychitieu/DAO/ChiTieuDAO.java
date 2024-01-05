package quanlychitieu.DAO;
import quanlychitieu.models.ChiTieu;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import quanlychitieu.DBconnection;

public class ChiTieuDAO {
    // Thêm chi tiêu
    public void themChiTieu(ChiTieu chiTieu) {
        try (Connection connection = DBconnection.getConnection()) {
            String sql = "INSERT INTO tblChiTieu (ngay, danhMucId, tien, userID) VALUES (?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setDate(1, chiTieu.getNgay());
                preparedStatement.setInt(2, chiTieu.getDanhMucId());
                preparedStatement.setDouble(3, chiTieu.getTien());
                preparedStatement.setInt(4, chiTieu.getUserID());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    // Lấy ra Chi Tiêu theo id
    public ChiTieu layChiTieuTheoId(int chiTieuId) {
        ChiTieu chiTieu = null;
        try (Connection connection = DBconnection.getConnection()) {
            String sql = "SELECT * FROM tblChiTieu WHERE id=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, chiTieuId);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        chiTieu = new ChiTieu();
                        chiTieu.setId(resultSet.getInt("id"));
                        chiTieu.setNgay(resultSet.getDate("ngay"));
                        chiTieu.setDanhMucId(resultSet.getInt("danhMucId"));
                        chiTieu.setTien(resultSet.getDouble("tien"));
                        chiTieu.setUserID(resultSet.getInt("userID"));
                        // Thêm các trường khác tùy thuộc vào cấu trúc bảng
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    return chiTieu;
}

    // Sửa Chi Tiêu
    public void suaChiTieu(Date ngay, int danhMucId, double tien, int id) {
        try (Connection connection = DBconnection.getConnection()) {
            String sql = "UPDATE tblChiTieu SET ngay=?, danhMucId=?, tien=? WHERE id=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setDate(1, ngay);
                preparedStatement.setInt(2, danhMucId);
                preparedStatement.setDouble(3, tien);
                preparedStatement.setInt(4, id);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Xóa Chi Tiêu
    public void xoaChiTieu(int chiTieuID) {
        try (Connection connection = DBconnection.getConnection()) {
            String sql = "DELETE FROM tblChiTieu WHERE id=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, chiTieuID);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    // Lấy ra danh sách Chi Tiêu theo người dùng (dùng List)
    public List<ChiTieu> layDanhSachChiTieuTheoUser(int userID) {
        List<ChiTieu> danhSachChiTieu = new ArrayList<>();
        try (Connection connection = DBconnection.getConnection()) {
            String sql = "SELECT * FROM tblChiTieu WHERE userID=? ORDER BY ngay DESC";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, userID);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    ChiTieu chiTieu = new ChiTieu();
                    chiTieu.setId(resultSet.getInt("id"));
                    chiTieu.setNgay(resultSet.getDate("ngay"));
                    chiTieu.setDanhMucId(resultSet.getInt("danhMucId"));
                    chiTieu.setTien(resultSet.getDouble("tien"));
                    chiTieu.setUserID(resultSet.getInt("userID"));
                    danhSachChiTieu.add(chiTieu);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSachChiTieu;
    }
    
    // Tính tổng các khoản thu toàn bộ
    public double tinhTongThu(int userID) {
        double tongThu = 0;
        try (Connection connection = DBconnection.getConnection()) {
            String sql = "SELECT SUM(tien) AS tongThu FROM tblChiTieu WHERE userID=? AND danhMucID IN (7, 8, 9)";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, userID);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        tongThu = resultSet.getDouble("tongThu");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tongThu;
    }
    
    // Tính tổng các khoản thu theo tháng và năm
    public double tinhTongThuTheoThangNam(int userID, int thang, int nam) {
        double tongThu = 0;
        try (Connection connection = DBconnection.getConnection()) {
            // Sử dụng MONTH và YEAR để lọc theo tháng và năm
            String sql = "SELECT SUM(tien) AS tongThu FROM tblChiTieu " +
                         "WHERE userID=? AND danhMucID IN (7, 8, 9) " +
                         "AND MONTH(ngay) = ? AND YEAR(ngay) = ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, userID);
                preparedStatement.setInt(2, thang);
                preparedStatement.setInt(3, nam);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        tongThu = resultSet.getDouble("tongThu");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tongThu;
    }
    // Tính tổng toàn bộ khoản chi
    public double tinhTongChi(int userID) {
        double tongChi = 0;

        try (Connection connection = DBconnection.getConnection()) {
            String sql = "SELECT SUM(tien) AS tongChi FROM tblChiTieu WHERE userID=? AND danhMucID IN (1, 2, 3, 4, 5, 6)";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, userID);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        tongChi = resultSet.getDouble("tongChi");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tongChi;
    }
    
    // Tính tổng khoản chi theo tháng và năm
    public double tinhTongChiTheoThangNam(int userID, int thang, int nam) {
        double tongChi = 0;
        try (Connection connection = DBconnection.getConnection()) {
            String sql = "SELECT SUM(tien) AS tongChi FROM tblChiTieu " +
                         "WHERE userID=? AND danhMucID IN (1, 2, 3, 4, 5, 6) " +
                         "AND MONTH(ngay) = ? AND YEAR(ngay) = ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, userID);
                preparedStatement.setInt(2, thang);
                preparedStatement.setInt(3, nam);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        tongChi = resultSet.getDouble("tongChi");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tongChi;
    }
    
    // Tính tổng khoản chi theo danh mục
    public double tinhTongChiTheoDanhMucVaUser(int userID, int danhMucId) {
        double tongChi = 0;

        try (Connection connection = DBconnection.getConnection()) {
            String sql = "SELECT SUM(tien) AS tongChi FROM tblChiTieu WHERE userID=? AND danhMucID =?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, userID);                
                preparedStatement.setInt(2, danhMucId);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        tongChi = resultSet.getDouble("tongChi");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tongChi;
    }
    
    // Tính tổng khoản thu theo tháng năm
    public double tinhTongChiTheoDanhMucVaUserVaThangNam(int userID, int danhMucId, int month, int year) {
        double tongChi = 0;

        try (Connection connection = DBconnection.getConnection()) {
            String sql = "SELECT SUM(tien) AS tongChi FROM tblChiTieu WHERE userID=? AND danhMucID=? AND YEAR(ngay)=? AND MONTH(ngay)=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, userID);
                preparedStatement.setInt(2, danhMucId);
                preparedStatement.setInt(3, year);               
                preparedStatement.setInt(4, month);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        tongChi = resultSet.getDouble("tongChi");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tongChi;
    }
    
    // Lấy ra danh sách Chi Tiêu theo filter (tháng và năm)
    public List<ChiTieu> layDanhSachChiTieuTheoUserVaFilter(int userID, int month, int year){
         List<ChiTieu> danhSachChiTieu = new ArrayList<>();
        try (Connection connection = DBconnection.getConnection()) {
            String sql = "SELECT * FROM tblChiTieu WHERE userID=? AND MONTH(ngay)=? AND YEAR(ngay)=? ORDER BY ngay DESC";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, userID);                
                preparedStatement.setInt(2, month);
                preparedStatement.setInt(3, year);

                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    ChiTieu chiTieu = new ChiTieu();
                    chiTieu.setId(resultSet.getInt("id"));
                    chiTieu.setNgay(resultSet.getDate("ngay"));
                    chiTieu.setDanhMucId(resultSet.getInt("danhMucId"));
                    chiTieu.setTien(resultSet.getDouble("tien"));
                    chiTieu.setUserID(resultSet.getInt("userID"));
                    danhSachChiTieu.add(chiTieu);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSachChiTieu;
    }
    

}
