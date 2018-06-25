package com.rq.rxjavasample.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import io.reactivex.Flowable;

/**
 * Created by Faydee on 2018/6/25.
 */
@Dao
public interface UserDao {
  @Insert(onConflict = OnConflictStrategy.REPLACE)
  void insertUser(User user);

  @Query("SELECT * FROM users LIMIT 1")
  Flowable<User> getUser();

  @Query("DELETE FROM users")
  void deleteAllUsers();
}
