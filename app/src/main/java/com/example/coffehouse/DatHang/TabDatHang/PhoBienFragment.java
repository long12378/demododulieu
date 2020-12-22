package com.example.coffehouse.DatHang.TabDatHang;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

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

import java.util.ArrayList;
import java.util.List;


public class PhoBienFragment extends Fragment {
    private GridView gridView;
    Context context;
    private ConstraintLayout rela;
    private List<sanpham> phobienData;
    private PhoBienAdapter phobienAdapter;



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

                Dialog dialog = new Dialog(PhoBienFragment.this.getActivity());
                dialog.setContentView(R.layout.activity_muahang);
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
}