package com.tiffany.phippy;

import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.view.ViewPager;
import android.support.design.widget.TabLayout;
import android.util.Log;
import android.view.View;

import com.tiffany.phippy.base.BaseActivity;
import com.tiffany.phippy.venv.RequestCallBack;
import com.tiffany.phippy.venv.RequestManager;

import java.util.Date;

import okhttp3.Call;
import okhttp3.Response;


public class MainActivity extends BaseActivity implements TabLayout.OnTabSelectedListener {

    protected TabLayoutItemView foodTab;
    protected TabLayoutItemView tourTab;
    protected TabLayoutItemView lifeTab;
    protected TabLayoutItemView meTab;

    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void init() {
//viewPage
        ViewPager viewPage = (ViewPager) findViewById(R.id.viewpage);
        viewPage.setOffscreenPageLimit(4);
        viewPage.setAdapter(new MainActivityAdpter(this));

        //tablayout
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPage);
        tabLayout.addOnTabSelectedListener(this);

        //        tabbar
        this.foodTab = new TabLayoutItemView(this,"美食",R.drawable.tab_food_icon_selector);
        this.tourTab = new TabLayoutItemView(this,"旅游",R.drawable.tab_tour_icon_selector);
        this.lifeTab = new TabLayoutItemView(this,"生活",R.drawable.tab_life_icon_selector);
        this.meTab   = new TabLayoutItemView(this,"我的",R.drawable.tab_me_icon_selector);
        tabLayout.getTabAt(0).setCustomView(foodTab);
        tabLayout.getTabAt(1).setCustomView(tourTab);
        tabLayout.getTabAt(2).setCustomView(lifeTab);
        tabLayout.getTabAt(3).setCustomView(meTab);

//        showBadgeOnItemIndex(0);

        JniHello hello = new JniHello();
        Log.e("hello",hello.SayHello());
        SimpleDateFormat formatter = new SimpleDateFormat ("yyyy年MM月dd日 HH:mm:ss ");
        Date curDate = new Date(System.currentTimeMillis());//获取当前时间
        String dateTime = formatter.format(curDate);
        RequestManager.getInstant().initializeUser(CommonUtils.getIPAddress(this), "userId",
                                                    dateTime, CommonUtils.getUniquePsuedoID(),
                                                    CommonUtils.collectDeviceInfo(this), CommonUtils.getAppVersionName(this),
                                                    CommonUtils.getCurrentSystemLanguage(this), new RequestCallBack() {
            @Override
            public void onSuccess(String s, Call call, Response response) {
                super.onSuccess(s, call, response);
            }
        });


    }

    protected void showBadgeOnItemIndex(int index){
        View badge = null;
        if(index == 0){
            badge = foodTab.findViewById(R.id.tablayout_red_message);
        }

        if (badge != null) badge.setVisibility(View.VISIBLE);
    }

    protected void hideBadgeOnItemIndex(int index){
        View badge = null;
        if(index == 0){
            badge = foodTab.findViewById(R.id.tablayout_red_message);
        }

        if (badge != null) badge.setVisibility(View.GONE);
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
