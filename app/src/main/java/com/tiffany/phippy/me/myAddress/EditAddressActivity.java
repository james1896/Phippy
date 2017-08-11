package com.tiffany.phippy.me.myAddress;

import android.content.Intent;
import android.widget.EditText;

import com.tiffany.phippy.R;
import com.tiffany.phippy.base.BaseActivity;

/**
 * Created by moses on 11/08/2017.
 */

public class EditAddressActivity extends BaseActivity {
    @Override
    protected int getContentView() {
        return R.layout.activity_edit_address;
    }

    @Override
    protected void init() {

        setToolbarTitle("编辑地址");
        Intent intent = getIntent();

        String name = intent.getStringExtra("com.tiffany.me.editaddress.name");
        String phone = intent.getStringExtra("com.tiffany.me.editaddress.phone");
        String address = intent.getStringExtra("com.tiffany.me.editaddress.address");

        EditText nameEdit = (EditText) findViewById(R.id.edit_address_name);
        EditText phoneEdit = (EditText) findViewById(R.id.edit_address_phone);
        EditText addressEdit = (EditText) findViewById(R.id.edit_address_address);

        nameEdit.setText(name.toCharArray(),0,name.length());
        phoneEdit.setText(phone.toCharArray(),0,phone.length());
        addressEdit.setText(address.toCharArray(),0,address.length());
    }
}
