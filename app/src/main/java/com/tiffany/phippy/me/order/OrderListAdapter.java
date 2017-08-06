package com.tiffany.phippy.me.order;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.tiffany.phippy.R;
import com.tiffany.phippy.base.BaseListAdapter;
import com.tiffany.phippy.food.FoodModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by moses on 27/06/2017.
 */

public class OrderListAdapter extends BaseListAdapter {


//    protected ArrayList<Map> dataList;

    public OrderListAdapter(Context context, ArrayList<Map> list) {
        super(context,list);
//        //根据context上下文加载布局，这里的是 本身，即this
//        this.mInflater = LayoutInflater.from(context);


//        if(list == null){
//            ArrayList<FoodModel> l = new ArrayList<>();
//            l.add(new FoodModel());
//            this.dataList = l;
//        }else {
//            this.dataList = list;
//        }


    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Map<String,Object> map = (Map<String, Object>) this.dataList.get(position);
        View item                   = mInflater.inflate(R.layout.order_listview_item, null);

        ListView lv = (ListView) item.findViewById(R.id.order_item_listview);
        lv.setAdapter(new OrderItemListViewAdapter(context,getDataList()));
        return item;
    }

}

class OrderItemListViewAdapter extends BaseListAdapter{

    public OrderItemListViewAdapter(Context context, ArrayList<Map> list) {
        super(context, list);
        this.dataList = getDataList();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Map<String,Object> map = (Map<String, Object>) this.dataList.get(position);
        View item                   = mInflater.inflate(R.layout.order_listview_item_item, null);

        TextView title = (TextView) item.findViewById(R.id.order_item_item_title);
        title.setText((String) map.get("title"));

        return item;
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
