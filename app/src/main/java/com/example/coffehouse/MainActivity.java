package com.example.coffehouse;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.coffehouse.CuaHang.CuaHangFragment;
import com.example.coffehouse.DatHang.DatHangFragment;
import com.example.coffehouse.TaiKhoan.TaiKhoanFragment;
import com.example.coffehouse.TinTuc.TinTucFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);
        //I added this if statement to keep the selected fragment when rotating the device
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new TinTucFragment()).commit();
        }

    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;
                    switch (item.getItemId()) {
                        case R.id.navigation_tintuc:
                            selectedFragment = new TinTucFragment();
                            break;
                        case R.id.navigation_dathang:
                            selectedFragment = new DatHangFragment();
                            break;
                        case R.id.navigation_cuahang:
                            selectedFragment = new CuaHangFragment();
                            break;
                        case R.id.navigation_taikhoan:
                            selectedFragment = new TaiKhoanFragment();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
                    return true;
                }
            };
}