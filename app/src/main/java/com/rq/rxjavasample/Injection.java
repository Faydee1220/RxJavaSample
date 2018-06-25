package com.rq.rxjavasample;

import com.rq.rxjavasample.database.AppDatabase;
import com.rq.rxjavasample.database.LocalUserDataSource;
import com.rq.rxjavasample.database.UserDataSource;
import com.rq.rxjavasample.viewmodel.ViewModelFactory;

/**
 * Created by Faydee on 2018/6/25.
 */
public class Injection {

  private static UserDataSource provideUserDataSource() {
    AppDatabase database = AppDatabase.getInstance();
    return new LocalUserDataSource(database.userDao());
  }

  public static ViewModelFactory provideViewModelFactory() {
    UserDataSource dataSource = provideUserDataSource();
    return new ViewModelFactory(dataSource);
  }
}
