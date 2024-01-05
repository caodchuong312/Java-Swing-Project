package quanlychitieu.models;

public class DanhMuc {
    private int id;
    private String danhMuc;

    public DanhMuc() {
    }

    public DanhMuc(int id, String danhMuc) {
        this.id = id;
        this.danhMuc = danhMuc;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDanhMuc() {
        return danhMuc;
    }

    public void setDanhMuc(String danhMuc) {
        this.danhMuc = danhMuc;
    }

   

   
}
