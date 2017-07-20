package com.tiffany.phippy.me;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;


import com.tiffany.phippy.PHIUserManager;
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

        setToolbarTitle("常用设置");
        ListView listview = (ListView) findViewById(R.id.setting_listview);
        listview.setAdapter(new SettingListAdapter(this,getDataList()));
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:{
                        PHIUserManager.getInstance().setDownloadImageOnlyWIFI(!PHIUserManager.getInstance().isDownloadImageOnlyWIFI());
                        //仅在wifi环境 下载图片
                        TextView textView = (TextView) view.findViewById(R.id.setting_switch_textview);
                        textView.setText((PHIUserManager.getInstance().isDownloadImageOnlyWIFI()?"开":"关"));
                        break;
                    }
                }
            }
        });
    }

    private ArrayList<Map> getDataList() {
        ArrayList<Map> list = new ArrayList<>();
        Map<String,Object> map1 = new HashMap<String,Object>();
        map1.put("title","仅WIFI环境下加载图片");
        list.add(map1);
        return list;
    }
}
