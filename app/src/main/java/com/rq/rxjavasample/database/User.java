package com.rq.rxjavasample.database;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Faydee on 2018/6/25.
 */
@Entity(tableName = "users")
public class User {

  @PrimaryKey(autoGenerate = true)
  public long id;

  public String name;
}
