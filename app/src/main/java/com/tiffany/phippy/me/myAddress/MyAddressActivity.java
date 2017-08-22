package com.tiffany.phippy.me.myAddress;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.tiffany.phippy.R;
import com.tiffany.phippy.base.BaseActivity;
import com.tiffany.phippy.base.db.PhippyDBHelper;
import com.tiffany.phippy.base.db.T_DeliveryAddress;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by moses on 10/08/2017.
 */

public class MyAddressActivity extends BaseActivity {
    ArrayList<Map> dataList = new ArrayList<>();
    MyAddressListAdapter adapter;
    @Override
    protected int getContentView() {
        return R.layout.activity_me_myaddress;
    }

    @Override
    protected void init() {

        setToolbarTitle("收货地址");
        this.dataList = getDataList();
        query();


        this.adapter = new MyAddressListAdapter(this,this.dataList);
        ListView lv = (ListView) findViewById(R.id.myaddress_listview);
        lv.setAdapter(this.adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Log.e("address",""+i);
//                Map<String,Object> map = dataList.get(i);
//                map.put("selected",true);

//                Map<String,Object> map1 = dataList.get(0);
//                map1.put("selected",false);

                for(int y=0;y<dataList.size();y++){

                    Map<String,Object> tmpMap = dataList.get(y);

                    boolean flog = (boolean) tmpMap.get("selected");
                    if(flog){
                        tmpMap.put("selected",false);
                        break;
                    }
                }

                Log.e("address","size:"+dataList.size());
                Map<String,Object> map = dataList.get(i);
                map.put("selected",true);
                adapter.notifyDataSetChanged();
            }
        });


    }

    private void query(){
        PhippyDBHelper dbHelper = new PhippyDBHelper(MyAddressActivity.this,T_DeliveryAddress.t_delivery_address,null,1);
        //得到一个可写的数据库
        SQLiteDatabase db =dbHelper.getReadableDatabase();
        //参数1：表名
        //参数2：要想显示的列
        //参数3：where子句
        //参数4：where子句对应的条件值
        //参数5：分组方式
        //参数6：having条件
        //参数7：排序方式
        //Cursor cursor = db.query("stu_table", new String[]{"id","sname","sage","ssex"}, "id=?", new String[]{"1"}, null, null, null);

        Cursor cursor = db.query(T_DeliveryAddress.t_delivery_address,
                new String[]{T_DeliveryAddress.user_id,
                        T_DeliveryAddress.user_name,
                        T_DeliveryAddress.user_address,
                        T_DeliveryAddress.landmark},
                null, null, null, null, null);
        String str =null;

        if(cursor.getCount() == 0){
            Log.e("cursor","0");
        }else {
            Log.e("cursor","not 0");
        }

        while(cursor.moveToNext()){
            int id = cursor.getInt(0);
            String name = cursor.getString(cursor.getColumnIndex(T_DeliveryAddress.user_id));
            String age = cursor.getString(cursor.getColumnIndex(T_DeliveryAddress.user_name));
            String sex = cursor.getString(cursor.getColumnIndex(T_DeliveryAddress.user_address));
            String landmark = cursor.getString(cursor.getColumnIndex(T_DeliveryAddress.landmark));

            System.out.println("query------->" +"id:" + id + "姓名："+name+" "+"年龄："+age+" "+"性别："+sex);
            str += "\n姓名："+name+" "+"年龄："+age+" "+"性别："+sex;
        }

        //关闭数据库
        db.close();
    }

    ArrayList<Map> getDataList(){
        ArrayList<Map> list = new ArrayList<>();

        Map<String,Object> map1 = new HashMap<String, Object>();
        map1.put("selected",true);
        map1.put("name","james");
        map1.put("phone","09162511897");
        map1.put("address","antel spa hotel makati manila phidela costa evune antel sopa hotel dela costa address");

        Map<String,Object> map2 = new HashMap<String, Object>();
        map2.put("selected",false);
        map2.put("name","james");
        map2.put("phone","09162511897");
        map2.put("address","antel spa hotel makati manila phi");

        Map<String,Object> map3 = new HashMap<String, Object>();
        map3.put("selected",false);
        map3.put("name","james");
        map3.put("phone","09162511897");
        map3.put("address","antel spa hotel makati manila phi");

        Map<String,Object> map4 = new HashMap<String, Object>();
        map4.put("selected",false);
        map4.put("name","james");
        map4.put("phone","09162511897");
        map4.put("address","antel spa hotel makati manila phi");

        Map<String,Object> map5 = new HashMap<String, Object>();
        map5.put("selected",false);
        map5.put("name","james");
        map5.put("phone","09162511897");
        map5.put("address","antel spa hotel makati manila phi");

        Map<String,Object> map6 = new HashMap<String, Object>();
        map6.put("selected",false);
        map6.put("name","james");
        map6.put("phone","09162511897");
        map6.put("address","antel spa hotel makati manila phi");
        list.add(map1);
        list.add(map2);
        list.add(map3);
        list.add(map4);
        list.add(map5);
        list.add(map6);

        return list;
    }
}
