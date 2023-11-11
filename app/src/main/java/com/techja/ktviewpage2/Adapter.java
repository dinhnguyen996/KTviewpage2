package com.techja.ktviewpage2;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class Adapter extends FragmentStateAdapter {
    public Adapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Fragment fragment; // khai báo biến
        if (position ==0){
            fragment=new Fragment1();
        } else {
            fragment=new Fragment2();
        }
        return fragment;
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
