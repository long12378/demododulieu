package com.example.coffehouse.DatHang.TabDatHang;

public class sanpham {
    int id, phobien;
    String loaisp, tensp, gia, hinhanh;

    public sanpham(int id, int phobien, String loaisp, String tensp, String gia, String hinhanh) {
        this.id = id;
        this.phobien = phobien;
        this.loaisp = loaisp;
        this.tensp = tensp;
        this.gia = gia;
        this.hinhanh = hinhanh;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPhobien() {
        return phobien;
    }

    public void setPhobien(int phobien) {
        this.phobien = phobien;
    }

    public String getLoaisp() {
        return loaisp;
    }

    public void setLoaisp(String loaisp) {
        this.loaisp = loaisp;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
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
