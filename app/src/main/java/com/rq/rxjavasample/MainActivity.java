package com.rq.rxjavasample;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import com.rq.rxjavasample.databinding.ActivityMainBinding;
import com.rq.rxjavasample.viewmodel.UserViewModel;
import com.rq.rxjavasample.viewmodel.ViewModelFactory;

public class MainActivity extends AppCompatActivity {

  private static final String TAG = MainActivity.class.getSimpleName();

  private ActivityMainBinding mBinding;
  private ViewModelFactory mViewModelFactory;
  private UserViewModel mUserViewModel;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    mBinding = DataBindingUtil
        .setContentView(this, R.layout.activity_main);

    mViewModelFactory = Injection.provideViewModelFactory();
    mUserViewModel = ViewModelProviders
        .of(this, mViewModelFactory)
        .get(UserViewModel.class);

    mBinding.buttonMainUpdate.setOnClickListener(view -> updateButtonPressed());
  }

  private void updateButtonPressed() {
    Log.d(TAG, "updateButtonPressed");
  }
}
