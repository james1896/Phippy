package com.tiffany.phippy.me.myAddress;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.tiffany.phippy.PHIUserManager;
import com.tiffany.phippy.R;
import com.tiffany.phippy.base.BaseListAdapter1;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by moses on 27/06/2017.
 */

public class MyAddressListAdapter extends BaseListAdapter1 {


//    protected ArrayList<Map> dataList;

    public MyAddressListAdapter(Context context, ArrayList<Map> list) {
        super(context,list);

    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final ViewHolder holder;

        Map<String,Object> map = this.dataList.get(position);

        if(convertView == null){
            convertView = mInflater.inflate(R.layout.myaddress_item, null);

            holder = new ViewHolder();
            holder.name = (TextView) convertView.findViewById(R.id.myaddress_item_name);
            holder.phoneNumber = (TextView) convertView.findViewById(R.id.myaddress_item_phone);
            holder.address = (TextView) convertView.findViewById(R.id.myaddress_item_address);
            holder.cancel = (Button) convertView.findViewById(R.id.myaddress_item_cancel);
            holder.edit = (Button) convertView.findViewById(R.id.myaddress_item_edit);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.name.setText((String) map.get("name"));
        holder.phoneNumber.setText((String) map.get("phone"));
        holder.address.setText((String) map.get("address"));
        return convertView;
    }

    public class ViewHolder{
        TextView name;
        TextView phoneNumber;
        TextView address;

        Button cancel;
        Button edit;
    }

}
