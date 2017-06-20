package com.tiffany.phippy;

import android.os.Build;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.view.WindowManager;

import com.tiffany.phippy.BaseActivity;
import com.tiffany.phippy.R;
import com.tiffany.phippy.TabLayoutItemView;
import com.tiffany.phippy.adapter.MainActivityAdpter;


public class MainActivity extends BaseActivity implements TabLayout.OnTabSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //viewPage
        ViewPager viewPage = (ViewPager) findViewById(R.id.viewpage);
        viewPage.setOffscreenPageLimit(4);
        viewPage.setAdapter(new MainActivityAdpter(this));

        //tablayout
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPage);
        tabLayout.addOnTabSelectedListener(this);
        tabLayout.getTabAt(0).setCustomView(new TabLayoutItemView(this,"旅游",R.drawable.tab_home_icon_selector));
        tabLayout.getTabAt(1).setCustomView(new TabLayoutItemView(this,"美食",R.drawable.tab_grid_icon_selector));
        tabLayout.getTabAt(2).setCustomView(new TabLayoutItemView(this,"生活",R.drawable.tab_home_icon_selector));
        tabLayout.getTabAt(3).setCustomView(new TabLayoutItemView(this,"我的",R.drawable.tab_grid_icon_selector));
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}
