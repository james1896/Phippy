package com.tiffany.phippy.me.order;

import android.widget.ListView;

import com.tiffany.phippy.R;
import com.tiffany.phippy.base.BaseActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by moses on 06/08/2017.
 */

public class OrderActivity extends BaseActivity {
    @Override
    protected int getContentView() {
        return R.layout.activity_order;
    }

    @Override
    protected void init() {
        setToolbarTitle("我的订单");
        ListView listView = (ListView) findViewById(R.id.order_listview);
        listView.setAdapter(new OrderListAdapter(this,getDataList()));

    }

    public ArrayList<ArrayList> getDataList(){
        ArrayList<ArrayList> list = new ArrayList<>();

//        Map<String,Object> map1 = new HashMap<String,Object>();
//        map1.put("title","滋补调养");
////        map1.put("resId",R.drawable.me_list_zengsong);
//        list.add(map1);
//
//        Map<String,Object> map2 = new HashMap<String,Object>();
//        map2.put("title","男科用药");
////        map2.put("resId",R.drawable.me_list_key);
//        list.add(map2);


        ArrayList<Map> list1 = new ArrayList<>();
        Map<String,Object> map1 = new HashMap<String,Object>();
        map1.put("title","aaa");
        list1.add(map1);
        Map<String,Object> map2 = new HashMap<String,Object>();
        map2.put("title","bbb");
        list1.add(map2);


        ArrayList<Map> list2 = new ArrayList<>();
        Map<String,Object> map21 = new HashMap<String,Object>();
        map21.put("title","ccc");
        list2.add(map21);
        Map<String,Object> map22 = new HashMap<String,Object>();
        map22.put("title","ddd");
        list2.add(map22);
        Map<String,Object> map23 = new HashMap<String,Object>();
        map23.put("title","eee");
        list2.add(map23);


        ArrayList<Map> list3 = new ArrayList<>();
        Map<String,Object> map31 = new HashMap<String,Object>();
        map31.put("title","fff");
        list3.add(map31);
        Map<String,Object> map32 = new HashMap<String,Object>();
        map32.put("title","ggg");
        list3.add(map32);
        Map<String,Object> map33 = new HashMap<String,Object>();
        map33.put("title","hhh");
        list3.add(map33);

        list.add(list1);
        list.add(list2);
        list.add(list3);
        return list;

    }
}
