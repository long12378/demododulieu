package com.example.coffehouse.DatHang.TabDatHang;

public class sanphamorder {
    String tensp;
    int giasp;
    int imagesp;
    int soluong;

    public sanphamorder(){
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public int getGiasp() {
        return giasp;
    }

    public void setGiasp(int giasp) {
        this.giasp = giasp;
    }

    public int getImagesp() {
        return imagesp;
    }

    public void setImagesp(int imagesp) {
        this.imagesp = imagesp;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }
    public int thanhtien(){
        return soluong * giasp;
    }
}
