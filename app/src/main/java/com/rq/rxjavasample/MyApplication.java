package com.rq.rxjavasample;

import android.app.Application;
import android.content.Context;

/**
 * Created by Faydee on 2018/6/25.
 */
public class MyApplication extends Application {
  private static Context context;

  @Override public void onCreate() {
    super.onCreate();
    context = this;
  }

  public static Context getAppContext() {
    return context;
  }
}
