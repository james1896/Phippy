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
        this.dataList = getDataList();
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Map<String,Object> map = this.dataList.get(position);

        View item = mInflater.inflate(R.layout.tour_list_item, null);
        TextView titleTV = (TextView)item.findViewById(R.id.tour_item_title);
        TextView descTV = (TextView)item.findViewById(R.id.tour_item_desc);
//        ImageView img = (ImageView)item.findViewById(R.id.imageView);

        String titleStr = (String) map.get("title");
        String descStr = (String) map.get("desc");
//        int resid = (int) map.get("resId");
        titleTV.setText(titleStr);
        descTV.setText(descStr);
//        img.setImageResource(resid);
        return item;
    }

    private ArrayList<Map> getDataList(){
        ArrayList<Map> list = new ArrayList<>();

        Map<String,Object> map1 = new HashMap<String,Object>();
        map1.put("title","从波多黎各到维京群岛，一个人的七天六夜");
//        map1.put("resId",R.drawable.me_list_zengsong);
        map1.put("desc","决定来Puerto Rico的时间，是2017年4月20日的凌晨1点，定好所有机票和酒店的时间，是4月20日的凌晨3点。给最好的朋友发微信，\"我又要一个人去旅行了，刚订好了所有机票和酒店。\" 朋友回：\"So You\"");
        list.add(map1);

        Map<String,Object> map2 = new HashMap<String,Object>();
        map2.put("title","洛杉矶必玩！世界第一家好莱坞环球影城");
        map2.put("desc","决定来Puerto Rico的时间，是2017年4月20日的凌晨1点，定好所有机票和酒店的时间，是4月20日的凌晨3点。给最好的朋友发微信，\"我又要一个人去旅行了，刚订好了所有机票和酒店。\" 朋友回：\"So You\"");
        list.add(map2);

        Map<String,Object> map3 = new HashMap<String,Object>();
        map3.put("title","去台湾，不做这些事情就等于白去了？");
        map3.put("desc","决定来Puerto Rico的时间，是2017年4月20日的凌晨1点，定好所有机票和酒店的时间，是4月20日的凌晨3点。给最好的朋友发微信，\"我又要一个人去旅行了，刚订好了所有机票和酒店。\" 朋友回：\"So You\"");
        list.add(map3);

        Map<String,Object> map4 = new HashMap<String,Object>();
        map4.put("title","左手拉着老公，右手拉着闺蜜，浪在苏梅岛");
        map4.put("desc","决定来Puerto Rico的时间，是2017年4月20日的凌晨1点，定好所有机票和酒店的时间，是4月20日的凌晨3点。给最好的朋友发微信，\"我又要一个人去旅行了，刚订好了所有机票和酒店。\" 朋友回：\"So You\"");
        list.add(map4);

        Map<String,Object> map5 = new HashMap<String,Object>();
        map5.put("title","一张票，走遍整个瑞士！");
        map5.put("desc","决定来Puerto Rico的时间，是2017年4月20日的凌晨1点，定好所有机票和酒店的时间，是4月20日的凌晨3点。给最好的朋友发微信，\"我又要一个人去旅行了，刚订好了所有机票和酒店。\" 朋友回：\"So You\"");
        list.add(map5);

        return list;

    }
}
