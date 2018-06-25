package com.rq.rxjavasample;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import com.rq.rxjavasample.databinding.ActivityMainBinding;
import com.rq.rxjavasample.viewmodel.UserViewModel;
import com.rq.rxjavasample.viewmodel.ViewModelFactory;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

  private static final String TAG = MainActivity.class.getSimpleName();

  private ActivityMainBinding mBinding;
  private ViewModelFactory mViewModelFactory;
  private UserViewModel mUserViewModel;
  private final CompositeDisposable mDisposable = new CompositeDisposable();

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

  @Override protected void onStart() {
    super.onStart();
    mDisposable.add(mUserViewModel.getUserName()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(userName -> mBinding.textViewMainUserName.setText(userName),
            throwable -> Log.e(TAG, "unable to get user name", throwable)));
  }

  @Override protected void onStop() {
    super.onStop();
    mDisposable.clear();
  }

  private void updateButtonPressed() {
    Log.d(TAG, "updateButtonPressed");
    String name = mBinding.editTextMainUserName.getText().toString();
    mBinding.buttonMainUpdate.setEnabled(false);
    mDisposable.add(mUserViewModel.updateUserName(name)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(() -> mBinding.buttonMainUpdate.setEnabled(true),
            throwable -> Log.e(TAG, "unable to update user name", throwable)));
  }
}
