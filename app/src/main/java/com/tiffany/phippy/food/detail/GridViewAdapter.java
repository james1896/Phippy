package com.tiffany.phippy.food.detail;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.tiffany.phippy.R;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by moses on 26/07/2017.
 */

public class GridViewAdapter extends ArrayAdapter<GridItem> {

    private Context mContext;
    private int layoutResourceId;
    private ArrayList<GridItem> mGridData = new ArrayList<GridItem>();

    public int itemNumber;

    private FoodInterface foodInterface;
    public FoodInterface getFoodInterface() {
        return foodInterface;
    }

    public void setFoodInterface(FoodInterface foodInterface) {
        this.foodInterface = foodInterface;
    }


    public GridViewAdapter(Context context, int resource, ArrayList<GridItem> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.layoutResourceId = resource;
        this.mGridData = objects;
    }

    public void setGridData(ArrayList<GridItem> mGridData) {
        this.mGridData = mGridData;
        notifyDataSetChanged();
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;

        if (convertView == null) {
            LayoutInflater inflater = ((Activity)mContext).getLayoutInflater();
            convertView = inflater.inflate(layoutResourceId, parent, false);
            holder = new ViewHolder();
            holder.textView = (TextView) convertView.findViewById(R.id.textview_item);
            holder.imageView = (ImageView) convertView.findViewById(R.id.imgview_item);
            holder.checkImage = (ImageView) convertView.findViewById(R.id.food_grid_item_check);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        final GridItem item = mGridData.get(position);
        holder.textView.setText(item.getTitle());
        Picasso.with(mContext).load(item.getImage()).into(holder.imageView);
        holder.checkImage.setVisibility((item.getCheck()==true?View.VISIBLE:View.INVISIBLE));
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(foodInterface != null){
                   holder.checkImage.setVisibility((holder.checkImage.getVisibility() == View.INVISIBLE?View.VISIBLE:View.INVISIBLE));
                    item.setCheck((holder.checkImage.getVisibility() == View.INVISIBLE?false:true));
                    Log.e("sss",""+mGridData);
                    foodInterface.foodMenuSelectedAt(itemNumber,position);
                }

            }
        });
        return convertView;
    }

    private class ViewHolder {
        TextView textView;
        ImageView imageView;
        ImageView checkImage;
    }
}

