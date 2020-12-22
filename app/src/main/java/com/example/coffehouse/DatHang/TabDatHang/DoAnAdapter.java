package com.example.coffehouse.DatHang.TabDatHang;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.coffehouse.R;

import java.util.ArrayList;
import java.util.List;

public class DoAnAdapter extends BaseAdapter {
    Context context;
    int layout;
    List<sanpham> doanList;

    public DoAnAdapter(Context context, int layout, List<sanpham> doanList) {
        this.context = context;
        this.layout = layout;
        this.doanList = doanList;
    }

    @Override
    public int getCount() {
        return doanList.size();
    }

    @Override
    public Object getItem(int i) {
        return doanList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return doanList.get(i).getId();
    }

    public class doanviewholder{
        TextView tensp;
        TextView giasp;
        ImageView hinhanh;
    }
    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        doanviewholder holder;
        if(view == null){
            holder = new doanviewholder();
            LayoutInflater inflater = (LayoutInflater)  context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout,null);
            holder.tensp = (TextView) view.findViewById(R.id.tensanpham_118);
            holder.giasp = (TextView) view.findViewById(R.id.gia_118);
            holder.hinhanh = (ImageView) view.findViewById(R.id.sanpham_118);
            view.setTag(holder);
        }
        else{
            holder = (doanviewholder) view.getTag();
        }
        sanpham pb = doanList.get(position);
        String image = pb.getHinhanh();
        int resId = (context).getResources().getIdentifier(image,"drawable",(context).getPackageName());
        holder.tensp.setText(pb.getTensp());
        holder.giasp.setText(pb.getGia());
        holder.hinhanh.setImageResource(resId);

        return view;
    }
}
