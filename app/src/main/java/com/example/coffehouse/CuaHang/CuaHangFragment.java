package com.example.coffehouse.CuaHang;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListPopupWindow;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import com.example.coffehouse.R;
import com.example.coffehouse.TaiKhoan.TaiKhoanFragment;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;


public class CuaHangFragment extends Fragment implements OnMapReadyCallback {

    private static final String LOG_TAG ="PopupMenuExample"; ;
    private static CuaHangFragment INSTANCE=null;
    SupportMapFragment supportMapFragment;
    FusedLocationProviderClient client;
    View view;
    GoogleMap map;
    MapView mapView;
    Button btnchonkhuvuc_118;
   ListPopupWindow listPopupWindow;

    public CuaHangFragment(){
    }
    public static CuaHangFragment getINSTANCE(){
        if (INSTANCE==null)
            INSTANCE=new CuaHangFragment();
        return INSTANCE;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        super.onCreateView(inflater, container, savedInstanceState);
        View root = inflater.inflate(R.layout.fragment_cuahang, container, false);
        //1. Button chọn khu vực
        btnchonkhuvuc_118 = root.findViewById(R.id.btnchonkhuvuc_118);
        btnchonkhuvuc_118.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button1Clicked( );
            }
        });
        //2. Set nút menu
        return root;
    }

    @Override
    public void onViewCreated(@Nullable View view,@Nullable Bundle savedInstanceState){
        super.onViewCreated(view,savedInstanceState);
        mapView=view.findViewById(R.id.mapsView);
        if(mapView!=null){
            mapView.onCreate(null);
            mapView.onResume();
            mapView.getMapAsync(this);
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        MapsInitializer.initialize(getContext());
        map=googleMap;
    }
    public void button1Clicked()  {
        //1. Khi kích vào button sẽ tạo 1 menu
        PopupMenu popup = new PopupMenu(CuaHangFragment.this.getActivity(), this.btnchonkhuvuc_118);
        popup.inflate(R.menu.menu_chonkhuvuc);


        Menu menu = popup.getMenu();

        // com.android.internal.view.menu.MenuBuilder
        Log.i(LOG_TAG, "Menu class: " + menu.getClass().getName());

        // Đăng kí gọi chữ
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                return menuItemClicked(item);
            }
        });
        // Hiển thị Popupmenu
        popup.show();
    }
    private boolean menuItemClicked(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.cantho_118:
                Toast.makeText(CuaHangFragment.this.getActivity(), "Cần Thơ", Toast.LENGTH_SHORT).show();
                break;
            case R.id.thanhhoa_118:
                Toast.makeText(CuaHangFragment.this.getActivity(), "Thanh Hóa", Toast.LENGTH_SHORT).show();
                break;
            default:
                Toast.makeText(CuaHangFragment.this.getActivity(), item.getTitle(), Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }
}