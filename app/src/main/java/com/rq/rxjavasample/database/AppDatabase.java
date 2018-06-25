package com.rq.rxjavasample.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import com.rq.rxjavasample.MyApplication;

/**
 * Created by Faydee on 2018/6/25.
 */
@Database(entities = {
    User.class },
    version = 1,
    exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

  private static final String DATABASE_NAME = "myDatabase";
  private static volatile AppDatabase sInstance;

  public static AppDatabase getInstance() {
    if (sInstance == null) {
      synchronized (AppDatabase.class) {
        sInstance = Room.databaseBuilder(
            MyApplication.getAppContext(),
            AppDatabase.class,
            DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build();
      }
    }
    return sInstance;
  }

}
