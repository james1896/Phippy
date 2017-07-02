package com.tiffany.phippy.me;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tiffany.phippy.BaseFragment;
import com.tiffany.phippy.R;

/**
 * Created by moses on 09/06/2017.
 */

public class MeFragment extends BaseFragment {
    protected View contentView;

    @Override
    public int getContentView() {
        return R.layout.me_fragment;
    }

    @Override
    public void init() {

    }
}
