package com.tiffany.phippy.food.detail;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tiffany.phippy.R;
import com.tiffany.phippy.base.BaseListAdapter1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by moses on 27/06/2017.
 */

public class FoodDetailListAdapter extends BaseListAdapter1 {

    private FoodInterface foodInterface;


//    private GridView mGridView = null;
//    private GridViewAdapter mGridViewAdapter = null;

   //------------------------------------------------------------


    Context context;
//    protected ArrayList<Map> dataList;

    public FoodInterface getFoodInterface() {
        return foodInterface;
    }

    public void setFoodInterface(FoodInterface foodInterface) {
        this.foodInterface = foodInterface;
    }

    public FoodDetailListAdapter(Context context, ArrayList<Map> list) {
        super(context,list);
//        //根据context上下文加载布局，这里的是 本身，即this
//        this.mInflater = LayoutInflater.from(context);
        this.context = context;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        Map<String,Object> map = this.dataList.get(position);
//
        View item = mInflater.inflate(R.layout.food_detail_listview_item, null);
        TextView titleTV = (TextView)item.findViewById(R.id.header);
        NoScrollGridView gridView = (NoScrollGridView) item.findViewById(R.id.gridview);
//

        String titleStr = (String) map.get("title");
        titleTV.setText(titleStr);
//        String addressStr = (String) map.get("add");
//        String current_priceStr = (String) map.get("current_price");
//        String original_priceStr = (String) map.get("original_price");
//        String hotStr = (String) map.get("hot");

        ArrayList<GridItem> list = (ArrayList<GridItem>) map.get("data");

        GridViewAdapter mGridViewAdapter = new GridViewAdapter(context, R.layout.food_detail_listview_gridview_item, list);
        mGridViewAdapter.itemNumber = position;
        mGridViewAdapter.setFoodInterface(foodInterface);
        gridView.setAdapter(mGridViewAdapter);
        return item;

    }


}
