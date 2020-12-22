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

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LichSuFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LichSuFragment extends Fragment {
    private GridView gridView;
    Context context;
    private ConstraintLayout rela;
    private List<sanpham> douongData;
    private DoUongAdapter adapter;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public LichSuFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LichSuFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LichSuFragment newInstance(String param1, String param2) {
        LichSuFragment fragment = new LichSuFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        context=getActivity();
        // Inflate the layout for this fragment
        View root =inflater.inflate(R.layout.fragment_lich_su, container, false);
        gridView = root.findViewById(R.id.gridviewdouong);
//        rela = root.findViewById(R.id.rela);
        douongData = new ArrayList<sanpham>();
        database db = new database(getActivity());
        db.createDefaultsanphamIfNeed();
        douongData =db.getAllcdouong();
        muahang();
        adapter=new DoUongAdapter(context,R.layout.list_phobien,douongData);
        gridView.setAdapter(adapter);
        registerForContextMenu(gridView);



        return root;
    }
    private void muahang() {
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {

                Dialog dialog = new Dialog(LichSuFragment.this.getActivity());
                dialog.setContentView(R.layout.activity_muahang);
                dialog.show();
            }
        });
        gridView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Dialog dialog = new Dialog(LichSuFragment.this.getActivity());
                dialog.setContentView(R.layout.fragment_lich_su);
                dialog.show();
                return true;
            }
        });
    }
}