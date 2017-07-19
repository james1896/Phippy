package com.tiffany.phippy.me;
import android.os.Bundle;
import android.widget.ListView;


import com.tiffany.phippy.R;
import com.tiffany.phippy.base.BaseActivity;
import com.tiffany.phippy.food.FoodListAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SettingActivity extends BaseActivity {



    @Override
    protected int getContentView() {
        return R.layout.activity_setting;
    }

    @Override
    protected void init() {
        ListView listview = (ListView) findViewById(R.id.setting_listview);
        listview.setAdapter(new SettingListAdapter(this,getDataList()));
    }

    private ArrayList<Map> getDataList() {
        ArrayList<Map> list = new ArrayList<>();
        Map<String,Object> map1 = new HashMap<String,Object>();
        map1.put("title","仅WIFI环境下加载图片");
        list.add(map1);
        return list;
    }
}
