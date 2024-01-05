package quanlychitieu.models;

public class NganSach {
    private int id;
    private int danhMucId;
    private double nganSach;
    private int userId;
    private String ThangNam;

    public NganSach() {
    }

    public NganSach(int id, int danhMucId, double nganSach, int userId, String ThangNam) {
        this.id = id;
        this.danhMucId = danhMucId;
        this.nganSach = nganSach;
        this.userId = userId;
        this.ThangNam = ThangNam;
    }

    // Getter and Setter methods
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDanhMucId() {
        return danhMucId;
    }

    public void setDanhMucId(int danhMucId) {
        this.danhMucId = danhMucId;
    }

    public double getNganSach() {
        return nganSach;
    }

    public void setNganSach(double nganSach) {
        this.nganSach = nganSach;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getThangNam() {
        return ThangNam;
    }

    public void setThangNam(String ThangNam) {
        this.ThangNam = ThangNam;
    }
    
}
