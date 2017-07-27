package com.tiffany.phippy.food;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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

        FoodModel model      = (FoodModel) this.dataList.get(position);
        View item                   = mInflater.inflate(R.layout.food_list_wechat_item, null);
        ImageView img               = (ImageView)item.findViewById(R.id.food_wechat_list_img);
        TextView titleTV            = (TextView) item.findViewById(R.id.food_wechat_list_name);
        TextView deliveryTimeTV     = (TextView) item.findViewById(R.id.food_wechat_list_deliveryTime);
        TextView qisongconditionTV  = (TextView) item.findViewById(R.id.food_wechat_list_qisongcondition);
        TextView addressTV          = (TextView) item.findViewById(R.id.food_wechat_list_address);
        TextView contactTV          = (TextView) item.findViewById(R.id.food_wechat_list_contact);

//        String titleStr           = (String) map.get("title");
//        String deliveryTimeStr    = (String) map.get("deliveryTime");
//        String qisongconditionStr = (String) map.get("qisongcondition");
//        String addressStr         = (String) map.get("address");
//        String contactStr         = (String) map.get("contact");
//        int resid                 = (int) map.get("resId");
        String titleStr           = model.getName();
        String deliveryTimeStr    = model.getDeliver_time();
        String qisongconditionStr = model.getQisong_condition();
        String addressStr         = model.getAdress();
        String contactStr         = model.getPhone_number();
        titleTV.setText(titleStr);
        deliveryTimeTV.setText(deliveryTimeStr);
        qisongconditionTV.setText(qisongconditionStr);
        addressTV.setText(addressStr);
        contactTV.setText(contactStr);

//        img.setImageResource(resid);
        return item;
    }

}
