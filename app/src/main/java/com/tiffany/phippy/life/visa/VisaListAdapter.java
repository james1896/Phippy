package com.tiffany.phippy.life.visa;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tiffany.phippy.R;
import com.tiffany.phippy.base.BaseListAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by moses on 27/06/2017.
 */

public class VisaListAdapter extends BaseListAdapter {


//    protected ArrayList<Map> dataList;

    public VisaListAdapter(Context context, ArrayList<Map> list) {
        super(context,list);
//        //根据context上下文加载布局，这里的是 本身，即this
//        this.mInflater = LayoutInflater.from(context);
        this.dataList = getDataList();
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Map<String,Object> map = this.dataList.get(position);

        View item = mInflater.inflate(R.layout.food_list_item, null);
        TextView titleTV = (TextView)item.findViewById(R.id.food_list_item_name);
        TextView addressTV = (TextView)item.findViewById(R.id.food_list_item_address);
        TextView current_priceTV = (TextView)item.findViewById(R.id.food_list_item_price);
        TextView original_priceTV = (TextView)item.findViewById(R.id.food_list_item_price1);

        TextView hotTV = (TextView)item.findViewById(R.id.food_list_item_hot);

//        ImageView img = (ImageView)item.findViewById(R.id.imageView);

        String titleStr = (String) map.get("title");
        String addressStr = (String) map.get("add");
        String current_priceStr = (String) map.get("current_price");
        String original_priceStr = (String) map.get("original_price");
        String hotStr = (String) map.get("hot");


        titleTV.setText(titleStr);
        addressTV.setText(addressStr);
        current_priceTV.setText(current_priceStr);
        original_priceTV.setText(original_priceStr);
        hotTV.setText(hotStr);

//        int resid = (int) map.get("resId");
//        img.setImageResource(resid);
        return item;
    }

    private ArrayList<Map> getDataList(){
        ArrayList<Map> list = new ArrayList<>();

        Map<String,Object> map1 = new HashMap<String,Object>();
        map1.put("title","保关");
//        map1.put("resId",R.drawable.me_list_zengsong);
        map1.put("add","海鲜大咖套餐1份，有赠品");
        map1.put("current_price","188");
        map1.put("original_price","门市价:¥288");
        map1.put("hot","热度5");
        list.add(map1);

        Map<String,Object> map2 = new HashMap<String,Object>();
        map2.put("title","驾照");
        map2.put("add","10元代金券1张，可叠加");
        map2.put("current_price","8.5");
        map2.put("original_price","门市价:¥10");
        map2.put("hot","热度5");
        list.add(map2);

        Map<String,Object> map3 = new HashMap<String,Object>();
        map3.put("title","旅游签证");
        map3.put("add","精品烤鸭5-6人餐1份");
        map3.put("current_price","588");
        map3.put("original_price","门市价:¥736");
        map3.put("hot","热度5");
        list.add(map3);

        Map<String,Object> map4 = new HashMap<String,Object>();
        map4.put("title","工作签证");
        map4.put("add","海盗船1份，免费包间");
        map4.put("current_price","98");
        map4.put("original_price","门市价:¥168");
        map4.put("hot","热度5");
        list.add(map4);



        return list;

    }
}
