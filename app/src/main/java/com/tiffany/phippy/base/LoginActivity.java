package com.tiffany.phippy.base;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.tiffany.phippy.R;

/**
 * Created by moses on 31/07/2017.
 */

public class LoginActivity extends BaseActivity {
    @Override
    protected int getContentView() {
        return R.layout.activity_login;
    }

    @Override
    protected void init() {

        Button registerBtn = (Button) findViewById(R.id.login_register);
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });

        Button backBtn = (Button) findViewById(R.id.login_backButton);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
