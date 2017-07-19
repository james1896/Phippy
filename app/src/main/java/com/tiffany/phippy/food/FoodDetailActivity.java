package com.tiffany.phippy.food;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.tiffany.phippy.R;
import com.tiffany.phippy.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

public class FoodDetailActivity extends BaseActivity {



    @Override
    protected int getContentView() {
        return R.layout.activity_food_detail;
    }

    @Override
    protected void init() {
        Intent intent = getIntent();
//        intent.putExtra("com.tiffany.food.fooddetail.Resource",R.mipmap.food_rec_header_img);

        String title = intent.getStringExtra("com.tiffany.food.fooddetail.title");
        int resourceId = intent.getIntExtra("com.tiffany.food.fooddetail.Resource",0);
        Log.e("food",title);

//        LinearLayout mLoadingLayout = (LinearLayout) View.inflate(this, R.layout.tour_or_food_rec_header, null);
//        TextView textView = (TextView) mLoadingLayout.findViewById(R.id.tf_rec_header_title);
//        textView.setText(title);
//        ImageView img = (ImageView) mLoadingLayout.findViewById(R.id.tf_rec_header_groundimage);
//        img.setImageResource(resourceId);
//
//        ListView listview = (ListView) findViewById(R.id.food_detail_listview);
//        listview.addHeaderView(mLoadingLayout);
//        listview.setAdapter(new FoodDetailListAdapter(this,null));

        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.food_detail_RecyclerView);
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
        View header = LayoutInflater.from(this).inflate(R.layout.recyclerview_header_footer, mRecyclerView, false);
        adapter.setHeaderView(header);
        adapter.setOnItemClickListener(new FoodRecRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Log.e("onItem",""+position);
            }
        });
    }
}
