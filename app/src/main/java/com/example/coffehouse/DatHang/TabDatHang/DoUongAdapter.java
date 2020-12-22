package com.example.coffehouse.DatHang.TabDatHang;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.coffehouse.R;

import java.util.List;

public class DoUongAdapter extends BaseAdapter {
    Context context;
    int layout;
    List<sanpham> douongList;

    public DoUongAdapter(Context context, int layout, List<sanpham> douongList) {
        this.context = context;
        this.layout = layout;
        this.douongList = douongList;
    }

    @Override
    public int getCount() {
        return douongList.size();
    }

    @Override
    public Object getItem(int i) {
        return douongList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return douongList.get(i).getId();
    }

    public class douongviewholder{
        TextView tensp;
        TextView giasp;
        ImageView hinhanh;
    }
    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        douongviewholder holder;
        if(view == null){
            holder = new douongviewholder();
            LayoutInflater inflater = (LayoutInflater)  context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout,null);
            holder.tensp = (TextView) view.findViewById(R.id.tensanpham_118);
            holder.giasp = (TextView) view.findViewById(R.id.gia_118);
            holder.hinhanh = (ImageView) view.findViewById(R.id.sanpham_118);
            view.setTag(holder);
        }
        else{
            holder = (douongviewholder) view.getTag();
        }
        sanpham pb = douongList.get(position);
        String image = pb.getHinhanh();
        int resId = (context).getResources().getIdentifier(image,"drawable",(context).getPackageName());
        holder.tensp.setText(pb.getTensp());
        holder.giasp.setText(pb.getGia());
        holder.hinhanh.setImageResource(resId);

        return view;
    }
}
