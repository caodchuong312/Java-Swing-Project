package quanlychitieu.models;
import java.sql.Date;

public class ChiTieu {
    private int id;
    private Date ngay;
    private int danhMucId;
    private double tien;
    private int userID;
    public ChiTieu(){}
    public ChiTieu(int id, Date ngay, int danhMucId, double tien, int userID) {
        this.id = id;
        this.ngay = ngay;
        this.danhMucId = danhMucId;
        this.tien = tien;
        this.userID = userID;
    } 
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getNgay() {
        return ngay;
    }

    public void setNgay(Date ngay) {
        this.ngay = ngay;
    }

    public int getDanhMucId() {
        return danhMucId;
    }

    public void setDanhMucId(int danhMucId) {
        this.danhMucId = danhMucId;
    }

    public double getTien() {
        return tien;
    }

    public void setTien(double tien) {
        this.tien = tien;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
    
}
