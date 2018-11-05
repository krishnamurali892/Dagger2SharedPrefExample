package example.dagger2.murali.com.dagger2example;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import example.dagger2.murali.com.dagger2example.di.ContextModule;
import example.dagger2.murali.com.dagger2example.di.DaggerSharedPrefComponent;
import example.dagger2.murali.com.dagger2example.di.SharedPrefComponent;

public class DaggerMainActivity extends AppCompatActivity {

    @BindView(R.id.etSave)
    EditText etSave;
    @BindView(R.id.tvRetrieve)
    TextView tvRetrieve;
    @BindView(R.id.btnSave)
    Button btnSave;
    @BindView(R.id.btnRetrieve)
    Button btnRetrieve;

    private SharedPrefComponent sharedPrefComponent;
    @Inject
    SharedPreferences sharedPreferences;

    private static final String KEY_NAME = "name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dagger_main);
        ButterKnife.bind(this);

        sharedPrefComponent = DaggerSharedPrefComponent.builder().contextModule(new ContextModule(this)).build();
        sharedPrefComponent.inject(this);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sharedPreferences.edit().putString(KEY_NAME, etSave.getText().toString()).commit();
            }
        });

        btnRetrieve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvRetrieve.setText(sharedPreferences.getString(KEY_NAME, "empty"));
            }
        });
    }
}
