package nikolayev.bohan.lesson1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements Constants{

    private final static int REQUEST_CODE = 10;

    ImageView imageSettings;
    Button citySettingsBtn;
    TextView cityNameMain;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageSettings = (ImageView) findViewById(R.id.imageSettings);
        citySettingsBtn = (Button) findViewById(R.id.citySettings);
        cityNameMain = findViewById(R.id.textView);



        final Intent SETTINGS = new Intent(this, SettingsActivity.class);



        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            switch (view.getId()){
                case R.id.imageSettings:
                    startActivity(SETTINGS);
                    break;
                case R.id.citySettings:
                    Parcel parcel = new Parcel();
                    parcel.cityName = cityNameMain.getText().toString();
                    Intent citySettings = new Intent(MainActivity.this,CitySetingsActivity.class);
                    citySettings.putExtra(CITY_KEY,parcel);
                    startActivityForResult(citySettings,REQUEST_CODE);
                    break;
            }
            }
        };

        imageSettings.setOnClickListener(onClickListener);
        citySettingsBtn.setOnClickListener(onClickListener);




    }


    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        if(requestCode != REQUEST_CODE){
            super.onActivityResult( requestCode, resultCode, data);
            return;
        }

        if(resultCode == RESULT_OK){
           TextView mainCityName = findViewById(R.id.textView);
            mainCityName.setText(data.getStringExtra(CITY_RESULT));
        }
    }
}