package com.example.btthandroid;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

import java.util.List;

public class adapter extends BaseAdapter {
    Context context;
    List<sanpham> spList;
    int layout;

    public adapter(Context context, List<sanpham> spList, int layout) {
        this.context = context;
        this.spList = spList;
        this.layout = layout;
    }

    @Override
    public int getCount() {
        return spList.size();
    }

    @Override
    public Object getItem(int position) {
        return spList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return spList.get(position).getId();
    }
 public class viewholder{
        ImageView hinhanh;
        TextView ten, gia;
 }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        viewholder holder = new viewholder();
        if(convertView == null) {

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout, null);
            holder.ten = (TextView) convertView.findViewById(R.id.tensp);
            holder.gia = (TextView) convertView.findViewById(R.id.giasp);
            holder.hinhanh = (ImageView) convertView.findViewById(R.id.hinhanh);
            convertView.setTag(holder);
        }
        else{
            holder = (viewholder) convertView.getTag();
        }
        sanpham sp = spList.get(position);
        String image = sp.getHinhanh();
        int imagebit = (context).getResources().getIdentifier(image,"drawable",(context).getPackageName());
        holder.ten.setText(sp.getTensp());
        holder.gia.setText(sp.getGia());
        holder.hinhanh.setImageResource(imagebit);
        return convertView;
    }
}
