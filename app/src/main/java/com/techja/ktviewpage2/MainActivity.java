package com.techja.ktviewpage2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Adapter adapter=new Adapter(this);
        ViewPager2 viewPager2=findViewById(R.id.vp2_layout);
        viewPager2.setAdapter(adapter);
        viewPager2.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
        //xử láy tab layout
        TabLayout tabLayout=findViewById(R.id.tab_layout);//lấy lay out
        tabLayout.setTabMode(TabLayout.MODE_FIXED);// set kiểu hiển thị

        new TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                if (position == 0){
                    tab.setText("HOME");
                }else {
                    tab.setText("SECOND");
                }
            }
        }).attach();
        // xử lý bottom navigation
        BottomNavigationView bottomNavigationView=findViewById(R.id.nav_bottom);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.fr1){
                    viewPager2.setCurrentItem(0);
                }
                if (item.getItemId() == R.id.fr2){
                    viewPager2.setCurrentItem(1);
                }
                return true;
            }
        });


    }
}