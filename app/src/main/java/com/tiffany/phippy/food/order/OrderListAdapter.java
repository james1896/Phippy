package com.tiffany.phippy.food.order;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.tiffany.phippy.R;
import com.tiffany.phippy.base.BaseListAdapter;
import com.tiffany.phippy.food.FoodModel;
import com.tiffany.phippy.food.detail.GridItem;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by moses on 07/08/2017.
 */

public class OrderListAdapter extends BaseListAdapter {
    public OrderListAdapter(Context context, ArrayList list) {
        super(context, list);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ArrayList<GridItem> list      = (ArrayList<GridItem>) this.dataList.get(position);

        View item                   = mInflater.inflate(R.layout.food_order_item, null);

        ListView lv = (ListView) item.findViewById(R.id.food_order_item_listview);
        lv.setAdapter(new OrderListItemAdapter(context,list));

        return item;
    }

}

class OrderListItemAdapter extends BaseListAdapter {
    public OrderListItemAdapter(Context context, ArrayList list) {
        super(context, list);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        GridItem gitem      = (GridItem) this.dataList.get(position);

        View item                   = mInflater.inflate(R.layout.food_order_item_item, null);


        TextView titleTv = (TextView) item.findViewById(R.id.food_order_item_item_title);
        TextView priceTv = (TextView) item.findViewById(R.id.food_order_item_item_price);
        TextView countTv = (TextView) item.findViewById(R.id.food_order_item_item_count);
        ImageView img    = (ImageView) item.findViewById(R.id.food_order_item_item_img);

        titleTv.setText(gitem.getTitle());
        priceTv.setText(""+gitem.getPrice());
        countTv.setText(""+gitem.getCount());
        Picasso.with(context).load(gitem.getImage()).into(img);
        return item;
    }
}
