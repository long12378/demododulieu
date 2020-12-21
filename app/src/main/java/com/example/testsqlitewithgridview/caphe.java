package com.example.testsqlitewithgridview;

public class caphe {
    int id;
    String Tensp;
    String gia;
    String hinhanh;

    public caphe(int id, String tensp, String gia, String hinhanh) {
        this.id = id;
        Tensp = tensp;
        this.gia = gia;
        this.hinhanh = hinhanh;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTensp() {
        return Tensp;
    }

    public void setTensp(String tensp) {
        Tensp = tensp;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }

    public String getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(String hinhanh) {
        this.hinhanh = hinhanh;
    }
}
