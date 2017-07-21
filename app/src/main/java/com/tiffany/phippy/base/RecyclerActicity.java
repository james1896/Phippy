package com.tiffany.phippy.base;

import android.support.v7.widget.RecyclerView;

/**
 * Created by moses on 20/07/2017.
 */

public class RecyclerActicity extends BaseActivity {

    private int layoutResID;
    private int recyclerViewId;
    protected RecyclerView recyclerView;

    RecyclerActicity(int layoutResID,int recyclerViewId){
        this.layoutResID = layoutResID;
        this.recyclerViewId = recyclerViewId;
    }
    @Override
    protected int getContentView() {
        return this.layoutResID;
    }

    @Override
    protected void init() {
        this.recyclerView = (RecyclerView) findViewById(this.recyclerViewId);
    }
}
