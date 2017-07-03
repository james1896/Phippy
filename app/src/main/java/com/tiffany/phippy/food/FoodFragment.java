package com.tiffany.phippy.food;


import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.tiffany.phippy.BaseFragment;
import com.tiffany.phippy.R;
import com.tiffany.phippy.tour.TourListAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class FoodFragment extends BaseFragment {


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
    }

}
