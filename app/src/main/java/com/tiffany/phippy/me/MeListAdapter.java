package com.tiffany.phippy.me;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.tiffany.phippy.R;
import com.tiffany.phippy.base.BaseListAdapter;
import com.tiffany.phippy.base.BaseListAdapter1;
import com.tiffany.phippy.food.order.OrderActivity;
import com.tiffany.phippy.me.myOrder.MyOrderActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by moses on 27/06/2017.
 */

public class MeListAdapter extends BaseListAdapter {


//    protected ArrayList<Map> dataList;

    public MeListAdapter(Context context, ArrayList<Map> list) {
        super(context,list);
//        //根据context上下文加载布局，这里的是 本身，即this
//        this.mInflater = LayoutInflater.from(context);
        this.dataList = getDataList();
    }

    @Override
    public View getView(int position, final View convertView, ViewGroup parent) {

        ArrayList<Map> list = (ArrayList<Map>) this.dataList.get(position);

        View item = mInflater.inflate(R.layout.me_listview_item, null);
//        TextView titleTV = (TextView)item.findViewById(R.id.me_item_title);
//        TextView addressTV = (TextView)item.findViewById(R.id.food_list_item_address);
//        TextView current_priceTV = (TextView)item.findViewById(R.id.food_list_item_price);
//        TextView original_priceTV = (TextView)item.findViewById(R.id.food_list_item_price1);
//
//        TextView hotTV = (TextView)item.findViewById(R.id.food_list_item_hot);

//        ImageView img = (ImageView)item.findViewById(R.id.imageView);

//        String titleStr = (String) map.get("title");
//        String addressStr = (String) map.get("add");
//        String current_priceStr = (String) map.get("current_price");
//        String original_priceStr = (String) map.get("original_price");
//        String hotStr = (String) map.get("hot");


//        titleTV.setText(titleStr);
//        addressTV.setText(addressStr);
//        current_priceTV.setText(current_priceStr);
//        original_priceTV.setText(original_priceStr);
//        hotTV.setText(hotStr);

//        int resid = (int) map.get("resId");
//        img.setImageResource(resid);

        final int pos = position;
        ListView lv = (ListView) item.findViewById(R.id.me_item_listview);
        lv.setAdapter(new MeListItemAdapter(context,list));
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.e("me_listview_click","section:"+pos+"index:"+i);
                if(pos == 1 && i == 0){
                    Intent intent = new Intent(context,OrderActivity.class);
                    context.startActivity(intent);
                }
            }
        });
        return item;
    }

    public ArrayList<ArrayList> getDataList(){
        ArrayList<ArrayList> list = new ArrayList<>();

        ArrayList<Map> list1 = new ArrayList<>();
        Map<String,Object> map1 = new HashMap<String,Object>();
        map1.put("title","我的订单");
//        map1.put("resId",R.drawable.me_list_zengsong);

        list1.add(map1);

        ArrayList<Map> list2 = new ArrayList<>();
        Map<String,Object> map2 = new HashMap<String,Object>();
        map2.put("title","应急求助");

        list2.add(map2);


        Map<String,Object> map3 = new HashMap<String,Object>();
        map3.put("title","常用设置");
        list2.add(map3);

        Map<String,Object> map4 = new HashMap<String,Object>();
        map4.put("title","意见反馈");

        list2.add(map4);
//

        Map<String,Object> map5 = new HashMap<String,Object>();
        map5.put("title","商务合作");

        list2.add(map5);

        Map<String,Object> map6 = new HashMap<String,Object>();
        map6.put("title","关于我们");

        list2.add(map6);

        ArrayList<Map> list3 = new ArrayList<>();
        Map<String,Object> map7 = new HashMap<String,Object>();
        map7.put("title","退出登录");

        list3.add(map7);

        Map<String,Object> map8 = new HashMap<String,Object>();
        map8.put("title","DBDebug");
        list3.add(map8);


        list.add(list1);
        list.add(list2);
        list.add(list3);


        return list;

    }


}

class MeListItemAdapter extends BaseListAdapter{

    public MeListItemAdapter(Context context, ArrayList list) {
        super(context, list);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Map<String,Object> map = (Map<String, Object>) this.dataList.get(position);

        View item = mInflater.inflate(R.layout.me_listview_item_item, null);
        TextView titleTV = (TextView)item.findViewById(R.id.me_item_title);
        titleTV.setText((String) map.get("title"));
        return item;
    }

}
