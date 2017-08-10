package com.tiffany.phippy.me.myAddress;

import android.widget.ListView;

import com.tiffany.phippy.R;
import com.tiffany.phippy.base.BaseActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by moses on 10/08/2017.
 */

public class MyAddressActivity extends BaseActivity {
    @Override
    protected int getContentView() {
        return R.layout.activity_me_myaddress;
    }

    @Override
    protected void init() {

        setToolbarTitle("收货地址");
        ListView lv = (ListView) findViewById(R.id.myaddress_listview);
        lv.setAdapter(new MyAddressListAdapter(this,getDataList()));
    }

    ArrayList<Map> getDataList(){
        ArrayList<Map> list = new ArrayList<>();

        Map<String,Object> map1 = new HashMap<String, Object>();
        map1.put("name","james");
        map1.put("phone","09162511897");
        map1.put("address","antel spa hotel makati manila phidela costa evune antel sopa hotel dela costa address");

        Map<String,Object> map2 = new HashMap<String, Object>();
        map2.put("name","james");
        map2.put("phone","09162511897");
        map2.put("address","antel spa hotel makati manila phi");

        Map<String,Object> map3 = new HashMap<String, Object>();
        map3.put("name","james");
        map3.put("phone","09162511897");
        map3.put("address","antel spa hotel makati manila phi");

        list.add(map1);
        list.add(map2);
        list.add(map3);
        return list;
    }
}
