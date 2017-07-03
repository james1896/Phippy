package com.tiffany.phippy.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;

import com.tiffany.phippy.food.FoodFragment;
import com.tiffany.phippy.me.MeFragment;
import com.tiffany.phippy.life.LifeFragment;
import com.tiffany.phippy.tour.TourFragment;

import java.util.ArrayList;
import java.util.List;


public class MainActivityAdpter extends FragmentPagerAdapter {
    private List<Fragment> fragments = new ArrayList<>();
    private FragmentActivity context;

    public MainActivityAdpter(FragmentActivity context) {
        super(context.getSupportFragmentManager());
        this.context = context;

        this.fragments.add(new TourFragment());
        this.fragments.add(new FoodFragment());
        this.fragments.add(new LifeFragment());
        this.fragments.add(new MeFragment());
    }

    @Override
    public Fragment getItem(int position) {
        return this.fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
    @Override
    public CharSequence getPageTitle(int position) {
        return new String[]{"水果","格铺","我的","我的"}[position];
    }
}
