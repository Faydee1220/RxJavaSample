package com.rq.rxjavasample.database;

import io.reactivex.Flowable;

/**
 * Created by Faydee on 2018/6/25.
 */
public interface UserDataSource {

  Flowable<User> getUser();
  void insertOrUpdateUser(User user);
  void deleteAllUsers();
}
