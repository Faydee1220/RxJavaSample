package com.rq.rxjavasample;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import com.rq.rxjavasample.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
  private static final String TAG = MainActivity.class.getSimpleName();

  private ActivityMainBinding mBinding;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    mBinding = DataBindingUtil
        .setContentView(this, R.layout.activity_main);
    mBinding.buttonMainUpdate.setOnClickListener(view -> updateButtonPressed());

  }


  private void updateButtonPressed() {
    Log.d(TAG, "updateButtonPressed");
  }
}
