package example.dagger2.murali.com.dagger2example.di;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import dagger.Module;
import dagger.Provides;

@Module(includes = {ContextModule.class})
public class SharedPrefModule {

    @Provides
    public SharedPreferences sharedPref(Context context){
        return PreferenceManager.getDefaultSharedPreferences(context);
    }
}
