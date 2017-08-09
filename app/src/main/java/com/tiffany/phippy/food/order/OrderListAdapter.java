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
import com.tiffany.phippy.food.detail.GridViewAdapter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

        final ViewHolder holder;

        ArrayList<GridItem> list      = (ArrayList<GridItem>) this.dataList.get(position);

//        View item                   = mInflater.inflate(R.layout.food_order_item, null);
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.food_order_item, parent, false);
            holder = new ViewHolder();
            holder.listView = (ListView) convertView.findViewById(R.id.food_order_item_listview);
            holder.dateTv = (TextView) convertView.findViewById(R.id.food_order_item_date);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.listView.setAdapter(new OrderListItemAdapter(context,list));

//        获得当前时间 作为订单时间
        SimpleDateFormat formatter   =   new   SimpleDateFormat   ("yyyy年MM月dd日   HH:mm:ss");
        Date curDate =  new Date(System.currentTimeMillis());
        String   dateStr   =   formatter.format(curDate);
        holder.dateTv.setText(dateStr);

        return convertView;
    }
    private class ViewHolder {
        ListView listView;
        TextView dateTv;

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
