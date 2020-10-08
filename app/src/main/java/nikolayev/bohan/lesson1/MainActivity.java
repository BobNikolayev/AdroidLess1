package nikolayev.bohan.lesson1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ImageView imageSettings;
    Button citySettingsBtn;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageSettings = (ImageView) findViewById(R.id.imageSettings);
        citySettingsBtn = (Button) findViewById(R.id.citySettings);
        textView = (TextView) findViewById(R.id.textView);
        final Intent SETTINGS = new Intent(this, SettingsActivity.class);
        final Intent citySettings = new Intent(this,CitySetingsActivity.class);


        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            switch (view.getId()){
                case R.id.imageSettings:
                    startActivity(SETTINGS);
                    break;
                case R.id.citySettings:
                    startActivity(citySettings);
                    break;
            }
            }
        };

        imageSettings.setOnClickListener(onClickListener);
        citySettingsBtn.setOnClickListener(onClickListener);




    }


}