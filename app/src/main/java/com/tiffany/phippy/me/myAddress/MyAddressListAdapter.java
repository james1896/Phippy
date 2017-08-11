package com.tiffany.phippy.me.myAddress;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tiffany.phippy.PHIUserManager;
import com.tiffany.phippy.R;
import com.tiffany.phippy.base.BaseListAdapter;
import com.tiffany.phippy.base.BaseListAdapter1;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by moses on 27/06/2017.
 */

public class MyAddressListAdapter extends BaseListAdapter {


//    protected ArrayList<Map> dataList;

    public MyAddressListAdapter(Context context, ArrayList<Map> list) {
        super(context,list);

    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        final ViewHolder holder;

        Map<String,Object> map = (Map<String, Object>) this.dataList.get(position);

        if(convertView == null){
            convertView = mInflater.inflate(R.layout.myaddress_item, null);

            holder = new ViewHolder();
            holder.name = (TextView) convertView.findViewById(R.id.myaddress_item_name);
            holder.phoneNumber = (TextView) convertView.findViewById(R.id.myaddress_item_phone);
            holder.address = (TextView) convertView.findViewById(R.id.myaddress_item_address);
            holder.cancel = (TextView) convertView.findViewById(R.id.myaddress_item_cancel);
            holder.edit = (TextView) convertView.findViewById(R.id.myaddress_item_edit);
            holder.hline = (LinearLayout) convertView.findViewById(R.id.myaddress_item_hline);
            holder.vline = (LinearLayout) convertView.findViewById(R.id.myaddress_item_vline);

            holder.check = (ImageView) convertView.findViewById(R.id.myaddress_item_check);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }

        boolean selected = (boolean) map.get("selected");
        if(selected){
            holder.check.setVisibility(View.VISIBLE);
            setSelectedColor(holder);
        }else {
            holder.check.setVisibility(View.INVISIBLE);
            setUnselectedColor(holder);

        }
        final String name = (String) map.get("name");
        final String phone = (String) map.get("phone");
        final String address = (String) map.get("address");
        holder.name.setText(name);
        holder.phoneNumber.setText(phone);
        holder.address.setText(address);

        holder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("edit",""+position);
                Intent intent = new Intent(context,EditAddressActivity.class);
                intent.putExtra("com.tiffany.me.editaddress.name",name);
                intent.putExtra("com.tiffany.me.editaddress.phone",phone);
                intent.putExtra("com.tiffany.me.editaddress.address",address);
                context.startActivity(intent);
            }
        });
        return convertView;
    }

    private void setSelectedColor(ViewHolder holder){

        holder.name.setTextColor(Color.parseColor("#696969"));
        holder.phoneNumber.setTextColor(Color.parseColor("#696969"));
        holder.address.setTextColor(Color.parseColor("#696969"));
        holder.cancel.setTextColor(Color.parseColor("#696969"));
        holder.edit.setTextColor(Color.parseColor("#696969"));
        holder.hline.setBackgroundColor(Color.parseColor("#696969"));
        holder.vline.setBackgroundColor(Color.parseColor("#696969"));
    }

    private void setUnselectedColor(ViewHolder holder){
        holder.name.setTextColor(Color.parseColor("#D3D3D3"));
        holder.phoneNumber.setTextColor(Color.parseColor("#D3D3D3"));
        holder.address.setTextColor(Color.parseColor("#D3D3D3"));
        holder.cancel.setTextColor(Color.parseColor("#D3D3D3"));
        holder.edit.setTextColor(Color.parseColor("#D3D3D3"));

        holder.hline.setBackgroundColor(Color.parseColor("#D3D3D3"));
        holder.vline.setBackgroundColor(Color.parseColor("#D3D3D3"));
    }

    public class ViewHolder{
        ImageView check;
        TextView name;
        TextView phoneNumber;
        TextView address;

        TextView cancel;
        TextView edit;

        LinearLayout hline;
        LinearLayout vline;
    }

}
