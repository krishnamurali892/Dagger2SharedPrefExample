package example.dagger2.murali.com.dagger2example.di;

import android.content.SharedPreferences;

import dagger.Component;
import example.dagger2.murali.com.dagger2example.DaggerMainActivity;

@Component(modules = SharedPrefModule.class)
public interface SharedPrefComponent {

    SharedPreferences getSharedPref();

    void inject(DaggerMainActivity daggerMainActivity);
}
