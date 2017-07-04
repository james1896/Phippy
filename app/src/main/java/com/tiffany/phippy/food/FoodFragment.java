package com.tiffany.phippy.food;


import android.content.Intent;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.tiffany.phippy.BaseFragment;
import com.tiffany.phippy.R;
import com.tiffany.phippy.tour.TourListAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class FoodFragment extends BaseFragment implements View.OnClickListener {


    public FoodFragment() {
        // Required empty public constructor
    }

    @Override
    public int getContentView() {
        return R.layout.fragment_food;
    }

    @Override
    public void init() {
        ListView listview = (ListView) contentView.findViewById(R.id.food_listview);

        LinearLayout mLoadingLayout = (LinearLayout) View.inflate(getContext(), R.layout.tour_or_food_header, null);

        TextView headerText = (TextView) mLoadingLayout.findViewById(R.id.header_text);
        headerText.setText("猜你喜欢");
        listview.addHeaderView(mLoadingLayout);
        listview.setAdapter(new FoodListAdapter(getContext(),null));


        ViewGroup upleft = (ViewGroup) mLoadingLayout.findViewById(R.id.upleft);
        ViewGroup upright = (ViewGroup) mLoadingLayout.findViewById(R.id.upright);
        ViewGroup downleft = (ViewGroup) mLoadingLayout.findViewById(R.id.downleft);
        ViewGroup downright = (ViewGroup) mLoadingLayout.findViewById(R.id.downright);

        upleft.setOnClickListener(this);
        upright.setOnClickListener(this);
        downleft.setOnClickListener(this);
        downright.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(getActivity(),FoodRecActivity.class);
        startActivity(intent);
        switch (view.getId()){
            case R.id.upleft:{

                break;
            }

            case R.id.upright:{

                break;
            }

            case R.id.downleft:{
                break;
            }

            case R.id.downright:{
                break;
            }
        }
    }
}
