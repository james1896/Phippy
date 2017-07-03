package com.tiffany.phippy.tour;


import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.tiffany.phippy.BaseFragment;
import com.tiffany.phippy.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class TourFragment extends BaseFragment {


    public TourFragment() {
        // Required empty public constructor
    }


//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_tour, container, false);
//    }

    @Override
    public int getContentView() {
        return R.layout.fragment_tour;
    }

    @Override
    public void init() {
        ListView listview = (ListView) contentView.findViewById(R.id.tour_listview);

        LinearLayout mLoadingLayout = (LinearLayout) View.inflate(getContext(), R.layout.tour_or_food_header, null);
        listview.addHeaderView(mLoadingLayout);
        listview.setAdapter(new TourListAdapter(getContext(),null));


        TextView headerText = (TextView) mLoadingLayout.findViewById(R.id.header_text);
        headerText.setText("推荐攻略");


    }
}
