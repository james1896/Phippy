package com.tiffany.phippy.food;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.tiffany.phippy.R;
import com.tiffany.phippy.base.BaseListAdapter;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by moses on 27/06/2017.
 */

public class FoodListAdapter extends BaseListAdapter {


//    protected ArrayList<Map> dataList;

    public FoodListAdapter(Context context, ArrayList<FoodModel> list) {
        super(context,list);
//        //根据context上下文加载布局，这里的是 本身，即this
//        this.mInflater = LayoutInflater.from(context);


        if(list == null){
            ArrayList<FoodModel> l = new ArrayList<>();
            l.add(new FoodModel());
            this.dataList = l;
        }else {
            this.dataList = list;
        }

    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        FoodModel model      = (FoodModel) this.dataList.get(position);
//        View item                   = mInflater.inflate(R.layout.food_list_wechat_item, null);
        if(convertView == null){
            convertView = mInflater.inflate(R.layout.food_list_wechat_item, null);
            holder = new ViewHolder();
            holder.img               = (ImageView)convertView.findViewById(R.id.food_wechat_list_img);
            holder.titleTV            = (TextView) convertView.findViewById(R.id.food_wechat_list_name);
            holder.deliveryTimeTV     = (TextView) convertView.findViewById(R.id.food_wechat_list_deliveryTime);
            holder.qisongconditionTV  = (TextView) convertView.findViewById(R.id.food_wechat_list_qisongcondition);
            holder.addressTV          = (TextView) convertView.findViewById(R.id.food_wechat_list_address);
            holder.contactTV          = (TextView) convertView.findViewById(R.id.food_wechat_list_contact);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }

        String titleStr           = model.getName();
        String deliveryTimeStr    = model.getDeliver_time();
        String qisongconditionStr = model.getQisong_condition();
        String addressStr         = model.getAdress();
        String contactStr         = model.getPhone_number();

        holder.titleTV.setText(titleStr);
        holder.deliveryTimeTV.setText(deliveryTimeStr);
        holder.qisongconditionTV.setText(qisongconditionStr);
        holder.addressTV.setText(addressStr);
        holder.contactTV.setText(contactStr);

//        img.setImageResource(resid);
        return convertView;
    }

    private class ViewHolder {
        ImageView img;
        TextView titleTV;
        TextView deliveryTimeTV;
        TextView qisongconditionTV;
        TextView addressTV;
        TextView contactTV;

    }
}
