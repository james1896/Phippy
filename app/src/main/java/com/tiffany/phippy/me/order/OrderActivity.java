package com.tiffany.phippy.me.order;

import android.widget.ListView;

import com.tiffany.phippy.R;
import com.tiffany.phippy.base.BaseActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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

        ListView listView = (ListView) findViewById(R.id.order_listview);
        listView.setAdapter(new OrderListAdapter(this,getDataList()));
    }

    public ArrayList<Map> getDataList(){
        ArrayList<Map> list = new ArrayList<>();

        Map<String,Object> map1 = new HashMap<String,Object>();
        map1.put("title","滋补调养");
//        map1.put("resId",R.drawable.me_list_zengsong);
        list.add(map1);

        Map<String,Object> map2 = new HashMap<String,Object>();
        map2.put("title","男科用药");
//        map2.put("resId",R.drawable.me_list_key);
        list.add(map2);

        return list;

    }
}
