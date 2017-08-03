package com.tiffany.phippy.base;

import android.widget.LinearLayout;

import com.tiffany.phippy.R;

/**
 * Created by moses on 03/08/2017.
 */

public class ShowAddressActivity extends BaseActivity {
    @Override
    protected int getContentView() {
        return R.layout.activity_show_address;
    }

    @Override
    protected void init() {
        setToolbarTitle("问路卡");
        LinearLayout ll = (LinearLayout) findViewById(R.id.show_address_linearlayout);
        ll.setKeepScreenOn(true);

    }
}
