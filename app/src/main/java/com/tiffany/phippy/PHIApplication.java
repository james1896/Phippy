package com.tiffany.phippy;

import android.app.Application;
import android.content.Context;

/**
 * Created by moses on 20/07/2017.
 */

public class PHIApplication extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context=getApplicationContext();
    }

    public static Context getContext() {
        return context;
    }
}
