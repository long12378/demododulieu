package com.example.coffehouse.DatHang.TabDatHang;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.coffehouse.R;
import com.example.coffehouse.database.database;

import java.util.ArrayList;
import java.util.List;


public class DoAnFragment extends Fragment {

    private GridView gridView2;
    Context context;
    private List<sanpham> doanData;
    private DoAnAdapter doanAdapter;
    public static TextView tongtien;
    public static sanphamorder productorder;
    public DoAnFragment(){
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        context=getActivity();
        View root =inflater.inflate(R.layout.fragment_do_an, container, false);
        gridView2 = root.findViewById(R.id.gridview2_118);
        doanData = new ArrayList<sanpham>();
        database db = new database(getActivity());
        db.createDefaultsanphamIfNeed();
        doanData =db.getAlldoan();
        muahang();
        doanAdapter=new DoAnAdapter(getActivity(),R.layout.list_phobien,doanData);
        gridView2.setAdapter(doanAdapter);
        registerForContextMenu(gridView2);
        return root;
    }
    private void muahang() {
        gridView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {

                final Dialog dialog = new Dialog(DoAnFragment.this.getActivity());
                dialog.setContentView(R.layout.activity_muahang);
                TextView tensporder = dialog.findViewById(R.id.dathang_tensanpham_118);
                ImageView imagesporder = dialog.findViewById(R.id.dathang_sanpham_118);
                TextView giasporder = dialog.findViewById(R.id.dathang_gia_118);
                tongtien = dialog.findViewById(R.id.tongtien);
                TextView soluong = dialog.findViewById(R.id.number_118);
                tensporder.setText(doanData.get(i).getTensp());
                String hinhanhorder = doanData.get(i).getHinhanh();
                int bitmaporder = (DoAnFragment.this.getActivity()).getResources().getIdentifier(hinhanhorder,"drawable",DoAnFragment.this.getActivity().getPackageName());
                imagesporder.setImageResource(bitmaporder);
                soluong.setText("1");
                giasporder.setText(doanData.get(i).getGia());
                tongtien.setText(doanData.get(i).getGia());
                int thanhtien = Integer.parseInt(doanData.get(i).getGia());

                productorder = new sanphamorder();
                productorder.setGiasp(thanhtien);
                productorder.setSoluong(Integer.parseInt((String) soluong.getText()));
                productorder.setTensp(tensporder.toString());
                productorder.setImagesp(bitmaporder);
                dialog.findViewById(R.id.giamsoluong_118).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(productorder.getSoluong() > 1){
                            productorder.setSoluong(productorder.getSoluong() - 1);
                        }
                        tongtien.setText(String.valueOf(productorder.thanhtien()));
                        TextView numberofproduct = dialog.findViewById(R.id.number_118);
                        numberofproduct.setText(String.valueOf(productorder.getSoluong()));
                        if(productorder.getSoluong()<1){
                            productorder.setSoluong(1);
                        }
                    }
                });
                dialog.findViewById(R.id.tangsoluong_118).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        productorder.setSoluong(productorder.getSoluong()+1);
                        tongtien.setText(String.valueOf(productorder.thanhtien()));
                        TextView numberofproduct = dialog.findViewById(R.id.number_118);
                        numberofproduct.setText(String.valueOf(productorder.getSoluong()));
                        if(productorder.getSoluong()>1){
                            dialog.findViewById(R.id.tangsoluong_118).setClickable(true);
                        }
                    }
                });

                dialog.show();
            }
        });
        gridView2.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Dialog dialog = new Dialog(DoAnFragment.this.getActivity());
                dialog.setContentView(R.layout.fragment_pho_bien);
                dialog.show();
                return true;
            }
        });
    }

}