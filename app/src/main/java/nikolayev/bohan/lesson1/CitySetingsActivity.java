package nikolayev.bohan.lesson1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CitySetingsActivity extends AppCompatActivity {


    Button exit;
    Button city1;
    Button city2;
    Button city3;
    TextView cityName;
    TextView date;
    TextView weather;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_setings);
        final Intent intent = new Intent(this,CityInfoActivity.class);
        exit = (Button) findViewById(R.id.exitCitySettingsBtn) ;
        city1 = (Button) findViewById(R.id.city1);
        city2 = (Button) findViewById(R.id.city2);
        city3 = (Button) findViewById(R.id.city3);
        cityName = (TextView) findViewById(R.id.textCityName);
        date = (TextView) findViewById(R.id.textDate);
        weather = (TextView) findViewById(R.id.textWeather);




        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               switch (view.getId()){
                   case R.id.exitCitySettingsBtn:
                       finish();
                        break;
                   case R.id.city1:
                       startActivity(intent);
                       break;
                   case R.id.city2:
                       startActivity(intent);
                       break;
                   case R.id.city3:
                       startActivity(intent);
                       break;
               }


            }
        };

        exit.setOnClickListener(onClickListener);
        city1.setOnClickListener(onClickListener);
        city2.setOnClickListener(onClickListener);
        city3.setOnClickListener(onClickListener);
    }
}