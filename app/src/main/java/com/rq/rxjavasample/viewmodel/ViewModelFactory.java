package com.rq.rxjavasample.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;
import com.rq.rxjavasample.database.UserDataSource;

/**
 * Created by Faydee on 2018/6/25.
 */
public class ViewModelFactory implements ViewModelProvider.Factory {

  private final UserDataSource mDataSource;

  public ViewModelFactory(UserDataSource dataSource) {
    mDataSource = dataSource;
  }

  @SuppressWarnings("unchecked")
  @NonNull @Override public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
    if (modelClass.isAssignableFrom(UserViewModel.class)) {
      return (T) new UserViewModel(mDataSource);
    }
    throw new IllegalArgumentException("Unknown ViewModel class");
  }
}
