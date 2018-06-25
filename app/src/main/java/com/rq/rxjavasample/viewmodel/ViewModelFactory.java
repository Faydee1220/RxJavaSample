package com.rq.rxjavasample.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

/**
 * Created by Faydee on 2018/6/25.
 */
public class ViewModelFactory implements ViewModelProvider.Factory {

  @NonNull @Override public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
    //if (modelClass.isAssignableFrom())
    return null;
  }
}
