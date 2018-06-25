package com.rq.rxjavasample.database;

import io.reactivex.Flowable;

/**
 * Created by Faydee on 2018/6/25.
 */
public class LocalUserDataSource implements UserDataSource {

  private final UserDao mUserDao;

  public LocalUserDataSource(UserDao userDao) {
    mUserDao = userDao;
  }

  @Override public Flowable<User> getUser() {
    return mUserDao.getUser();
  }

  @Override public void insertOrUpdateUser(User user) {
    mUserDao.insertUser(user);
  }

  @Override public void deleteAllUsers() {
    mUserDao.deleteAllUsers();
  }

}
