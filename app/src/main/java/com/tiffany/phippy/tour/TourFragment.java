package com.tiffany.phippy.tour;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.tiffany.phippy.BaseFragment;
import com.tiffany.phippy.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class TourFragment extends BaseFragment {


    public TourFragment() {
        // Required empty public constructor
    }


//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_tour, container, false);
//    }

    @Override
    public int getContentView() {
        return R.layout.fragment_tour;
    }

    @Override
    public void init() {
        ListView listview = (ListView) contentView.findViewById(R.id.tour_listview);
        listview.setAdapter(new TourListAdapter(getContext(),getDataList()));
        Log.e("init","aa");
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
