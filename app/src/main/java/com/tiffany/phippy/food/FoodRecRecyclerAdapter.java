package com.tiffany.phippy.food;

/**
 * Created by moses on 19/07/2017.
 */


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tiffany.phippy.R;

import java.util.List;

/**
 * RecyclerView适配器
 */
public class FoodRecRecyclerAdapter extends RecyclerView.Adapter<FoodRecRecyclerAdapter.ViewHolder> implements View.OnClickListener {

    private List<String> mDataList;

    public static final int TYPE_HEADER = 0;  //说明是带有Header的
    public static final int TYPE_FOOTER = 1;  //说明是带有Footer的
    public static final int TYPE_NORMAL = 2;  //说明是不带有header和footer的
    private View mHeaderView;
    private View mFooterView;

    private OnItemClickListener mOnItemClickListener = null;

    //HeaderView和FooterView的get和set函数
    public View getHeaderView() {
        return mHeaderView;
    }
    public void setHeaderView(View headerView) {
        mHeaderView = headerView;
        notifyItemInserted(0);
    }
    public View getFooterView() {
        return mFooterView;
    }
    public void setFooterView(View footerView) {
        mFooterView = footerView;
        notifyItemInserted(getItemCount()-1);
    }

    /** 重写这个方法，很重要，是加入Header和Footer的关键，我们通过判断item的类型，从而绑定不同的view    * */
    @Override
    public int getItemViewType(int position) {
        if (mHeaderView == null && mFooterView == null){
            return TYPE_NORMAL;
        }
        if (position == 0){
            //第一个item应该加载Header
            return TYPE_HEADER;
        }
        if (position == getItemCount()-1){
            //最后一个,应该加载Footer
            return TYPE_FOOTER;
        }
        return TYPE_NORMAL;
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }

    //构造函数
    public FoodRecRecyclerAdapter(List<String> list) {
        mDataList = list;
    }

    public int getItemCount() {
        if(mHeaderView == null && mFooterView == null){
            return mDataList.size();
        }else if(mHeaderView == null && mFooterView != null){
            return mDataList.size() + 1;
        }else if (mHeaderView != null && mFooterView == null){
            return mDataList.size() + 1;
        }else {
            return mDataList.size() + 2;
        }
    }




    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {


        if(getItemViewType(position) == TYPE_NORMAL){
            if(holder instanceof ViewHolder) {
                //这里加载数据的时候要注意，是从position-1开始，因为position==0已经被header占用了
                ((ViewHolder) holder).mTvTitle.setText(mDataList.get(position-1));
                ((ViewHolder) holder).itemView.setTag(position);
                return;
            }
            return;
        }else if(getItemViewType(position) == TYPE_HEADER){
            return;
        }else{
            return;
        }
    }

    @Override
    public void onClick(View view) {
        if (mOnItemClickListener != null) {
            //注意这里使用getTag方法获取position
            mOnItemClickListener.onItemClick(view,(int)view.getTag());
        }
    }

    //define interface
    public static interface OnItemClickListener {
        void onItemClick(View view , int position);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if(mHeaderView != null && viewType == TYPE_HEADER) {
            return new ViewHolder(mHeaderView);
        }
        if(mFooterView != null && viewType == TYPE_FOOTER){
            return new ViewHolder(mFooterView);
        }
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.food_detail_item, parent, false);
    layout.setOnClickListener(this);
        return new ViewHolder(layout);
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView mTvTitle;

        public ViewHolder(View itemView) {
            super(itemView);
            mTvTitle = (TextView) itemView.findViewById(R.id.food_detail_item_textview);

        }


    }

}