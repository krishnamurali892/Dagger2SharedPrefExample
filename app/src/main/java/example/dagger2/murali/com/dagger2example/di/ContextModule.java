package example.dagger2.murali.com.dagger2example.di;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

@Module
public class ContextModule {
    private final Context context;

    public ContextModule(Context context) {
        this.context = context;
    }

    @Provides
    public Context getContext() {
        return context;
    }

}
