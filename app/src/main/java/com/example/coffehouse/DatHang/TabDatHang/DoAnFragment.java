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

import com.example.coffehouse.R;
import com.example.coffehouse.database.database;

import java.util.ArrayList;
import java.util.List;


public class DoAnFragment extends Fragment {

    private GridView gridView2;
    Context context;
    private List<sanpham> doanData;
    private DoAnAdapter doanAdapter;

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

                Dialog dialog = new Dialog(DoAnFragment.this.getActivity());
                dialog.setContentView(R.layout.activity_muahang);
                dialog.show();
            }
        });
        gridView2.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Dialog dialog = new Dialog(DoAnFragment.this.getActivity());
                dialog.setContentView(R.layout.fragment_do_an);
                dialog.show();
                return true;
            }
        });
    }

}