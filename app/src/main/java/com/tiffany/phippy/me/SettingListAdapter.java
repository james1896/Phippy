package com.tiffany.phippy.me;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.tiffany.phippy.R;
import com.tiffany.phippy.base.BaseListAdapter;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by moses on 27/06/2017.
 */

public class SettingListAdapter extends BaseListAdapter {


//    protected ArrayList<Map> dataList;

    public SettingListAdapter(Context context, ArrayList<Map> list) {
        super(context,list);
//        //根据context上下文加载布局，这里的是 本身，即this
//        this.mInflater = LayoutInflater.from(context);
        this.dataList = list;
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Map<String,Object> map = this.dataList.get(position);

        View item = mInflater.inflate(R.layout.setting_item, null);
        String titleStr = (String) map.get("title");
        TextView titleTV = (TextView) item.findViewById(R.id.setting_item_title);
        titleTV.setText(titleStr);

        return item;
    }

}
