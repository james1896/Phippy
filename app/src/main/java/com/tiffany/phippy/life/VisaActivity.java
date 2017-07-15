package com.tiffany.phippy.life;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.tiffany.phippy.base.BaseActivity;
import com.tiffany.phippy.R;

/**
 * Created by moses on 03/07/2017.
 */

public class VisaActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visa);

        TextView titleTV = (TextView) findViewById(R.id.toolbar_sub_textview);
        titleTV.setText("全民签证");

        RelativeLayout header = (RelativeLayout) View.inflate(this, R.layout.tour_or_food_rec_header, null);
        ImageView imageview = (ImageView) header.findViewById(R.id.tf_rec_header_groundimage);
        imageview.setImageResource(R.mipmap.visa_header_img);

        ListView listview = (ListView) findViewById(R.id.visa_list_view);
        listview.addHeaderView(header);
        listview.setAdapter(new VisaListAdapter(this,null));
    }
}
