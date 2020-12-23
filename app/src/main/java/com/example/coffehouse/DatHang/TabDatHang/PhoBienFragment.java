package com.example.coffehouse.DatHang.TabDatHang;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.coffehouse.R;
import com.example.coffehouse.database.database;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;


public class PhoBienFragment extends Fragment{
    public static final String TENSANPHAM = "TENSAMPHAM";
    public static final String GIASANPHAM = "GIASANPHAM";
    public static final String HINHANH = "HINHANH";
    private GridView gridView;
    Context context;
    private ConstraintLayout rela;
    private List<sanpham> phobienData;
    private PhoBienAdapter phobienAdapter;
    public static TextView tongtien;
    public static sanphamorder productorder;


    public PhoBienFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        context=getActivity();
        View root =inflater.inflate(R.layout.fragment_pho_bien, container, false);
        gridView = root.findViewById(R.id.gridview_118);
//        rela = root.findViewById(R.id.rela);
        phobienData = new ArrayList<sanpham>();
        database db = new database(getActivity());
        db.createDefaultsanphamIfNeed();
        phobienData =db.getAllphobien();
        muahang();
        phobienAdapter=new PhoBienAdapter(context,R.layout.list_phobien,phobienData);
        gridView.setAdapter(phobienAdapter);
        registerForContextMenu(gridView);



        return root;
    }


    private void muahang() {
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {

                final Dialog dialog = new Dialog(PhoBienFragment.this.getActivity());
                dialog.setContentView(R.layout.activity_muahang);
                TextView tensporder = dialog.findViewById(R.id.dathang_tensanpham_118);
                ImageView imagesporder = dialog.findViewById(R.id.dathang_sanpham_118);
                TextView giasporder = dialog.findViewById(R.id.dathang_gia_118);
                tongtien = dialog.findViewById(R.id.tongtien);
                TextView soluong = dialog.findViewById(R.id.number_118);
                tensporder.setText(phobienData.get(i).getTensp());
                String hinhanhorder = phobienData.get(i).getHinhanh();
                int bitmaporder = (PhoBienFragment.this.getActivity()).getResources().getIdentifier(hinhanhorder,"drawable",PhoBienFragment.this.getActivity().getPackageName());
                imagesporder.setImageResource(bitmaporder);
                soluong.setText("1");
                giasporder.setText(phobienData.get(i).getGia());
                tongtien.setText(phobienData.get(i).getGia());
                int thanhtien = Integer.parseInt(phobienData.get(i).getGia());

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
        gridView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Dialog dialog = new Dialog(PhoBienFragment.this.getActivity());
                dialog.setContentView(R.layout.fragment_pho_bien);
                dialog.show();
                return true;
            }
        });
    }
    public void byextraphobien(String tensp, String gia, String hinh){
    }
}