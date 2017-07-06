package com.tiffany.phippy.food;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.tiffany.phippy.R;

public class FoodDetailActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_detail);

//        intent.putExtra("com.tiffany.food.fooddetail.title", (String) map.get("title"));

        Intent intent = getIntent();
//        intent.putExtra("com.tiffany.food.fooddetail.Resource",R.mipmap.food_rec_header_img);

        String title = intent.getStringExtra("com.tiffany.food.fooddetail.title");
        int resourceId = intent.getIntExtra("com.tiffany.food.fooddetail.Resource",0);
        Log.e("food",title);

        RelativeLayout mLoadingLayout = (RelativeLayout) View.inflate(this, R.layout.tour_or_food_rec_header, null);
        TextView textView = (TextView) mLoadingLayout.findViewById(R.id.tf_rec_header_title);
        textView.setText(title);
        ImageView img = (ImageView) mLoadingLayout.findViewById(R.id.tf_rec_header_groundimage);
        img.setImageResource(resourceId);

        ListView listview = (ListView) findViewById(R.id.food_detail_listview);
        listview.addHeaderView(mLoadingLayout);
        listview.setAdapter(new FoodDetailListAdapter(this,null));

    }
}
