package com.tiffany.phippy.base;

import android.view.View;
import android.widget.Button;

import com.tiffany.phippy.R;

/**
 * Created by moses on 31/07/2017.
 */

public class RegisterActivity extends BaseActivity {
    @Override
    protected int getContentView() {
        return R.layout.activity_register;
    }

    @Override
    protected void init() {

        Button backBtn = (Button) findViewById(R.id.register_backButton);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
