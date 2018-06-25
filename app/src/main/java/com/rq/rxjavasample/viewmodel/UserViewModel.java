package com.rq.rxjavasample.viewmodel;

import android.arch.lifecycle.ViewModel;
import com.rq.rxjavasample.database.User;
import com.rq.rxjavasample.database.UserDataSource;
import io.reactivex.Completable;
import io.reactivex.Flowable;

/**
 * Created by Faydee on 2018/6/25.
 */
public class UserViewModel extends ViewModel {

  private final UserDataSource mDataSource;
  private User mUser;

  public UserViewModel(UserDataSource dataSource) {
    mDataSource = dataSource;
  }

  public Flowable<String> getUserName() {
    return mDataSource.getUser()
        .map(user -> {
          mUser = user;
          return user.name;
        });
  }

  public Completable updateUserName(String name) {
    return Completable.fromAction(() -> {
      if (mUser == null) {
        mUser = new User();
      }
      mUser.name = name;
      mDataSource.insertOrUpdateUser(mUser);
    });
  }
}
