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

    protected OrderListAdapter orderAdapter;
    protected ArrayList<GridItem> dataArray;
    @Override
    protected void init() {
        setToolbarTitle("订单详情");

        Intent intentGet = getIntent();
        this.dataArray = (ArrayList<GridItem>) intentGet.getSerializableExtra("GridItem");
        Log.e("data",""+this.dataArray);

        ListView lv = (ListView) findViewById(R.id.food_order_listview);
        if(this.dataArray != null){

            ArrayList arr = new ArrayList();
            arr.add(this.dataArray);

            this.orderAdapter = new OrderListAdapter(this,arr);
            this.orderAdapter.setOrderInterface(this);
            lv.setAdapter(this.orderAdapter);
        }
    }

    @Override
    public void plusButtonClickOn(int position) {
        Log.e("order","plus"+position);

        GridItem item = this.dataArray.get(position);
        item.setCount(item.getCount()+1);

        ArrayList arr = new ArrayList();
        arr.add(this.dataArray);
        this.orderAdapter.setDataList(arr);
        this.orderAdapter.notifyDataSetChanged();
    }

    @Override
    public void subButtonClickOn(int position) {
        Log.e("order","sub"+position);

        GridItem item = this.dataArray.get(position);

        if(item.getCount() >1){
            item.setCount(item.getCount()-1);
            ArrayList arr = new ArrayList();
            arr.add(this.dataArray);
            this.orderAdapter.setDataList(arr);
            this.orderAdapter.notifyDataSetChanged();
        }else {
            Log.e("order","最小值是 1");
        }

    }
}
