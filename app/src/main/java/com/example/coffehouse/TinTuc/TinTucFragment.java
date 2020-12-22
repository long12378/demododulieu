package com.example.coffehouse.TinTuc;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.coffehouse.R;


public class TinTucFragment extends Fragment {

    Button btnuudai1_118;
    public TinTucFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View root = inflater.inflate(R.layout.fragment_tin_tuc, container, false);
        //1. Mở trang XemThongTinCaNhan bằng ảnh đại diện
        btnuudai1_118 = root.findViewById(R.id.btnuudai1_118);
//        btnuudai1_118.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                openDatHangFragment();
//            }
//        });
        return root;
    }
//    public void openDatHangFragment(){
//        Intent intent=new Intent(TinTucFragment.this.getActivity(), DatHangFragment.class);
//        startActivity(intent);
////        Intent intent=new Intent(TinTucFragment.this.getActivity(), Uudai1.class);
////        startActivity(intent);
//    }
}