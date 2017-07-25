package com.tiffany.phippy.life.xiaoniangzi;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.tiffany.phippy.R;
import com.tiffany.phippy.base.BaseListAdapter;
import com.tiffany.phippy.base.BaseListAdapter1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by toby on 20/04/2017.
 */

public class MedicineAdapter extends BaseListAdapter1 {

    public MedicineAdapter(Context context, ArrayList<Map> list) {
        super(context, list);

        this.dataList = getDataList();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Map<String,Object> map = this.dataList.get(position);

        View item = mInflater.inflate(R.layout.medicine_listview_item, null);
        TextView title = (TextView)item.findViewById(R.id.home_textView);
        ImageView img = (ImageView)item.findViewById(R.id.imageView);

        String titleS = (String) map.get("title");
//        int resid = (int) map.get("resId");
        title.setText(titleS);

//        img.setImageResource(resid);
        return item;
    }

    public ArrayList<Map> getDataList(){
        ArrayList<Map> list = new ArrayList<>();

        Map<String,Object> map1 = new HashMap<String,Object>();
        map1.put("title","滋补调养");
//        map1.put("resId",R.drawable.me_list_zengsong);
        list.add(map1);

        Map<String,Object> map2 = new HashMap<String,Object>();
        map2.put("title","男科用药");
//        map2.put("resId",R.drawable.me_list_key);
        list.add(map2);

        Map<String,Object> map3 = new HashMap<String,Object>();
        map3.put("title","风湿骨科");
//        map3.put("resId",R.drawable.me_list_yijian);
        list.add(map3);

        Map<String,Object> map4 = new HashMap<String,Object>();
        map4.put("title","肠胃用药");
//        map4.put("resId",R.drawable.me_list_thank);
        list.add(map4);

        Map<String,Object> map5 = new HashMap<String,Object>();
        map5.put("title","维生素钙");
//        map5.put("resId",R.drawable.me_list_about);
        list.add(map5);

        Map<String,Object> map6 = new HashMap<String,Object>();
        map6.put("title","五官用药");
//        map5.put("resId",R.drawable.me_list_about);
        list.add(map6);

        Map<String,Object> map7 = new HashMap<String,Object>();
        map7.put("title","皮肤用药");
//        map5.put("resId",R.drawable.me_list_about);
        list.add(map7);


        Map<String,Object> map8 = new HashMap<String,Object>();
        map8.put("title","妇儿用药");
//        map5.put("resId",R.drawable.me_list_about);
        list.add(map8);

        Map<String,Object> map9 = new HashMap<String,Object>();
        map9.put("title","感冒发烧");
//        map5.put("resId",R.drawable.me_list_about);
        list.add(map9);

//        if(AppManager.getInstance().getLogin()){
//            Map<String,Object> map6 = new HashMap<String,Object>();
//            map6.put("title","退出账户");
//            map6.put("resId",R.drawable.me_list_exit);
//            list.add(map6);
//        }
        return list;

    }
}
