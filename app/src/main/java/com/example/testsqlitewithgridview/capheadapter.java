package com.example.testsqlitewithgridview;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class capheadapter extends BaseAdapter {
    Context context;
    int layout;
    List<caphe> capheList;

    public capheadapter(Context context, int layout, List<caphe> capheList) {
        this.context = context;
        this.layout = layout;
        this.capheList = capheList;
    }

    @Override
    public int getCount() {
        return capheList.size();
    }

    @Override
    public Object getItem(int position) {
        return capheList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
    private class viewholder{
        TextView tensp;
        TextView giasp;
        ImageView hinhanh;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        viewholder viewholder;
        if(convertView == null){
            viewholder = new viewholder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout,null);
            viewholder.tensp = (TextView) convertView.findViewById(R.id.tensanpham425);
            viewholder.giasp = (TextView) convertView.findViewById(R.id.giasp425);
            viewholder.hinhanh = (ImageView) convertView.findViewById(R.id.imagesanpham425);
            convertView.setTag(viewholder);
        }
        else{
            viewholder = (viewholder) convertView.getTag();
        }
        caphe cf = capheList.get(position);
        String image = cf.getHinhanh();
        int resId = (context).getResources().getIdentifier(image,"drawable",(context).getPackageName());
        viewholder.tensp.setText(cf.getTensp());
        viewholder.giasp.setText(cf.getGia());
        viewholder.hinhanh.setImageResource(resId);
        return convertView;
    }
}
