package com.tiffany.phippy.food;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.tiffany.phippy.base.BaseActivity;
import com.tiffany.phippy.R;
import com.tiffany.phippy.tour.TourRecListAdapter;

/**
 * Created by moses on 03/07/2017.
 */

public class FoodRecActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_recommend);


        RelativeLayout mLoadingLayout = (RelativeLayout) View.inflate(this, R.layout.tour_or_food_rec_header, null);
        ImageView imageview = (ImageView) mLoadingLayout.findViewById(R.id.tf_rec_header_groundimage);
        TextView textview = (TextView) mLoadingLayout.findViewById(R.id.tf_rec_header_title);
        imageview.setImageResource(R.mipmap.food_rec_header_img);
        textview.setText("最豪食府");

        ListView listview = (ListView) findViewById(R.id.food_rec_listview);
        listview.addHeaderView(mLoadingLayout);
        listview.setAdapter(new TourRecListAdapter(this,null));

    }
}
