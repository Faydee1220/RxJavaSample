package com.rq.rxjavasample.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;
import io.reactivex.Flowable;

/**
 * Created by Faydee on 2018/6/25.
 */
@Dao
public interface UserDao {
  @Query("SELECT * FROM users LIMIT 1")
  Flowable<User> getUser();
}
