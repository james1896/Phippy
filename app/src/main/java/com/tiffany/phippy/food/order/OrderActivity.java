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

public class OrderActivity extends BaseActivity implements OrderInterface {
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

            OrderListAdapter adapter = new OrderListAdapter(this,arr);
            adapter.setOrderInterface(this);
            lv.setAdapter(adapter);
        }
    }

    @Override
    public void plusButtonClickOn(int position) {
        Log.e("order","plus"+position);
    }

    @Override
    public void subButtonClickOn(int position) {
        Log.e("order","sub"+position);
    }
}
