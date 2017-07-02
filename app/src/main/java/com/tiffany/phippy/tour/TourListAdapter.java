package com.tiffany.phippy.tour;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.tiffany.phippy.R;
import com.tiffany.phippy.adapter.BaseListAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by moses on 27/06/2017.
 */

public class TourListAdapter extends BaseListAdapter {


//    protected ArrayList<Map> dataList;

    public TourListAdapter(Context context, ArrayList<Map> list) {
        super(context,list);
//        //根据context上下文加载布局，这里的是 本身，即this
//        this.mInflater = LayoutInflater.from(context);
        this.dataList = list;
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Map<String,Object> map = this.dataList.get(position);

        View item = mInflater.inflate(R.layout.tour_list_item, null);
        TextView title = (TextView)item.findViewById(R.id.tour_textview);
//        ImageView img = (ImageView)item.findViewById(R.id.imageView);

        String titleS = (String) map.get("title");
//        int resid = (int) map.get("resId");
        title.setText(titleS);
        Log.e("getView","position:"+position+" title:"+titleS);
//        img.setImageResource(resid);
        return item;
    }

    private ArrayList<Map> getDataList(){
        ArrayList<Map> list = new ArrayList<>();

        Map<String,Object> map1 = new HashMap<String,Object>();
        map1.put("title","礼物赠送");
//        map1.put("resId",R.drawable.me_list_zengsong);
        list.add(map1);

        Map<String,Object> map2 = new HashMap<String,Object>();
        map2.put("title","生活助手");
//        map2.put("resId",R.drawable.me_list_key);
        list.add(map2);

        Map<String,Object> map3 = new HashMap<String,Object>();
        map3.put("title","意见反馈");
//        map3.put("resId",R.drawable.me_list_yijian);
        list.add(map3);

        Map<String,Object> map4 = new HashMap<String,Object>();
        map4.put("title","呜谢组织");
//        map4.put("resId",R.drawable.me_list_thank);
        list.add(map4);

        Map<String,Object> map5 = new HashMap<String,Object>();
        map5.put("title","关于我们");
//        map5.put("resId",R.drawable.me_list_about);
        list.add(map5);

        return list;

    }
}
