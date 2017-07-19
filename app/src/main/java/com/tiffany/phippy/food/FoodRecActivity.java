package com.tiffany.phippy.food;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.tiffany.phippy.base.BaseActivity;
import com.tiffany.phippy.R;
import com.tiffany.phippy.tour.TourRecListAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by moses on 03/07/2017.
 */

public class FoodRecActivity extends BaseActivity {

    @Override
    protected int getContentView() {
        return R.layout.activity_food_recommend;
    }

    @Override
    protected void init() {
//        RelativeLayout mLoadingLayout = (RelativeLayout) View.inflate(this, R.layout.tour_or_food_rec_header, null);
//        ImageView imageview = (ImageView) mLoadingLayout.findViewById(R.id.tf_rec_header_groundimage);
//        TextView textview = (TextView) mLoadingLayout.findViewById(R.id.tf_rec_header_title);
//        imageview.setImageResource(R.mipmap.food_rec_header_img);
//        textview.setText("最豪食府");

//        ListView listview = (ListView) findViewById(R.id.food_rec_listview);
//        listview.addHeaderView(mLoadingLayout);
//        listview.setAdapter(new TourRecListAdapter(this,null));

        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.food_rec_RecyclerView);
        //设置线性管理器
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        List<String> mDataList = new ArrayList<String>();
        for (int i=0;i<50;i++){
            mDataList.add("内容 - "+i);
        }
        /*
        设置适配器
         */
     FoodRecRecyclerAdapter adapter = new FoodRecRecyclerAdapter(mDataList);
        mRecyclerView.setAdapter(adapter);
    }
}
