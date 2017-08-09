package com.tiffany.phippy.food.order;

import android.content.Intent;
import android.util.Log;
import android.widget.ListView;

import com.tiffany.phippy.R;
import com.tiffany.phippy.base.BaseActivity;
import com.tiffany.phippy.food.detail.GridItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by moses on 07/08/2017.
 */

public class OrderActivity extends BaseActivity {
    @Override
    protected int getContentView() {
        return R.layout.activity_food_order;
    }

    @Override
    protected void init() {
        setToolbarTitle("订单详情");

        Intent intentGet = getIntent();
        ArrayList<GridItem> data = (ArrayList<GridItem>) intentGet.getSerializableExtra("GridItem");
        Log.e("data",""+data);

        ListView lv = (ListView) findViewById(R.id.food_order_listview);
        if(data != null){

            ArrayList arr = new ArrayList();
            arr.add(data);
            lv.setAdapter(new OrderListAdapter(this,arr));
        }




    }

    public ArrayList<ArrayList> getDataList(){




        ArrayList<ArrayList> list = new ArrayList<>();

        ArrayList<Map> list1 = new ArrayList<>();
        Map<String,Object> map1 = new HashMap<String,Object>();
        map1.put("title","aaa");
        list1.add(map1);

        Map<String,Object> map2 = new HashMap<String,Object>();
        map2.put("title","bbb");
        list1.add(map2);



        Map<String,Object> map21 = new HashMap<String,Object>();
        map21.put("title","ccc");
        list1.add(map21);
        Map<String,Object> map22 = new HashMap<String,Object>();
        map22.put("title","ddd");
        list1.add(map22);
        Map<String,Object> map23 = new HashMap<String,Object>();
        map23.put("title","eee");
        list1.add(map23);

        Map<String,Object> map24 = new HashMap<String,Object>();
        map24.put("title","ccc");
        list1.add(map24);
        Map<String,Object> map25 = new HashMap<String,Object>();
        map25.put("title","ddd");
        list1.add(map25);
        Map<String,Object> map26 = new HashMap<String,Object>();
        map26.put("title","eee");
        list1.add(map26);

        list.add(list1);

        return list;

    }
}
