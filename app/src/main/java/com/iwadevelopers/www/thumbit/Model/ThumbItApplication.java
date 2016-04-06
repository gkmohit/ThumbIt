package com.iwadevelopers.www.thumbit.Model;

import android.app.Application;
import android.util.Log;

/**
 * Created by AirUnknown on 16-04-04.
 */
public class ThumbItApplication extends Application {

    public static final String TAG = ThumbItApplication.class.getSimpleName();
    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "********************I was here********************");
    }
}
