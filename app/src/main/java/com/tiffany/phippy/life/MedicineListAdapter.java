package com.tiffany.phippy.life;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.tiffany.phippy.R;
import com.tiffany.phippy.base.BaseListAdapter;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by toby on 20/04/2017.
 */

public class MedicineListAdapter extends BaseListAdapter {

    public MedicineListAdapter(Context context, ArrayList<Map> list) {
        super(context, list);
        this.dataList = list;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Map<String,Object> map = this.dataList.get(position);

        View item = mInflater.inflate(R.layout.medicinelist_listview_item, null);
        TextView title = (TextView)item.findViewById(R.id.ItemTitle);
        ImageView img = (ImageView)item.findViewById(R.id.imageView);
        TextView priceTv = (TextView) item.findViewById(R.id.price);

        String titleS = (String) map.get("title");
        int resid = (int) map.get("resId");
        String price = (String) map.get("price");

        title.setText(titleS);
        priceTv.setText(price);
        img.setImageResource(resid);

        return item;
    }
}
