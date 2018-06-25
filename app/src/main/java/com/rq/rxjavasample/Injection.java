package com.rq.rxjavasample;

import com.rq.rxjavasample.database.AppDatabase;
import com.rq.rxjavasample.database.LocalUserDataSource;
import com.rq.rxjavasample.database.UserDataSource;

/**
 * Created by Faydee on 2018/6/25.
 */
public class Injection {
  public static UserDataSource provideUserDataSource() {
    AppDatabase database = AppDatabase.getInstance();
    return new LocalUserDataSource(database.userDao());
  }
}
