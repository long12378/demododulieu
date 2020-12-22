package com.example.coffehouse.TaiKhoan;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.coffehouse.Login;
import com.example.coffehouse.R;
import com.example.coffehouse.TaiKhoan.ThongTinCaNhan.XemThongTinCaNhan;
import com.example.coffehouse.TaiKhoan.ThongTinThanhVien.XemThongTinThanhVien;


public class TaiKhoanFragment extends Fragment {
    ImageView anhdaidien_118;
    TextView txt_dangxuat_118,txt_thongtintaikhoan_118,txt_thecoffehouserewards_118;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View root = inflater.inflate(R.layout.fragment_tai_khoan, container, false);
        //1. Mở trang XemThongTinCaNhan bằng ảnh đại diện
        anhdaidien_118 = root.findViewById(R.id.anhdaidien_118);
        anhdaidien_118.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openXemThongTinCaNhan();
            }
        });
        //2. Mở trang XemThongTinCaNhan bằng chức năng Thông tin tài khoản
        txt_thongtintaikhoan_118 = root.findViewById(R.id.txt_thongtintaikhoan_118);
        txt_thongtintaikhoan_118.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openXemThongTinCaNhan2();
            }
        });
        //3. Đăng xuất về trang login
        txt_dangxuat_118 = root.findViewById(R.id.txt_dangxuat_118);
        txt_dangxuat_118.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLogin();
            }
        });
        //4. Mở trang XemThongTinThanhVien bằng chức năng The Coffe House Rewards
        txt_thecoffehouserewards_118 = root.findViewById(R.id.txt_thecoffehouserewards_118);
        txt_thecoffehouserewards_118.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openXemThongTinThanhVien();
            }
        });
        return root;
    }
    //1.
    public void openXemThongTinCaNhan(){
        Intent intent=new Intent(TaiKhoanFragment.this.getActivity(), XemThongTinCaNhan.class);
        startActivity(intent);
    }
    //2
    public void openXemThongTinCaNhan2(){
        Intent intent=new Intent(TaiKhoanFragment.this.getActivity(), XemThongTinCaNhan.class);
        startActivity(intent);
    }
    //3
    public void openLogin(){
        Intent intent=new Intent(TaiKhoanFragment.this.getActivity(), Login.class);
        startActivity(intent);
    }
    //4
    public void openXemThongTinThanhVien(){
        Intent intent=new Intent(TaiKhoanFragment.this.getActivity(), XemThongTinThanhVien.class);
        startActivity(intent);
    }
}