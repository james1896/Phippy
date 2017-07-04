package com.tiffany.phippy.tour;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.tiffany.phippy.BaseActivity;
import com.tiffany.phippy.R;

/**
 * Created by moses on 03/07/2017.
 */

public class TourRecActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tour_recommend);

        RelativeLayout mLoadingLayout = (RelativeLayout) View.inflate(this, R.layout.tour_or_food_rec_header, null);
        ImageView imageview = (ImageView) mLoadingLayout.findViewById(R.id.tf_rec_header_groundimage);
        TextView textview = (TextView) mLoadingLayout.findViewById(R.id.tf_rec_header_title);
        imageview.setImageResource(R.mipmap.tour_rec_header_img);
        textview.setText("最美旅游");

        ListView listview = (ListView) findViewById(R.id.tour_rec_listview);
        listview.addHeaderView(mLoadingLayout);
        listview.setAdapter(new TourRecListAdapter(this,null));

    }

}
