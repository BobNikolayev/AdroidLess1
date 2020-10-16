package nikolayev.bohan.lesson1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class CitySetingsActivity extends AppCompatActivity {

    private final String COUNTER_KEY = "COUNTER_KEY";
    int counter = 0;
    Button exit;
    Button city1;
    Button city2;
    Button city3;
    TextView cityName;
    TextView date;
    TextView weather;
    TextView counterTest;


    @Override
    protected void onStart(){
        super.onStart();
        Toast.makeText(getApplicationContext(), "onStart", Toast.LENGTH_SHORT).show();
        Log.d("CitySetingsActivity", "onStart");
    }

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
        counterTest = (TextView) findViewById(R.id.counterTest);

        Toast.makeText(getApplicationContext(), "onCreate", Toast.LENGTH_SHORT).show();
        Log.d("CitySetingsActivity", "onCreate");
        if (savedInstanceState == null) {
            Toast.makeText(getApplicationContext(),"First Start",Toast.LENGTH_SHORT).show();
        } else{
            Toast.makeText(getApplicationContext(),"Second start",Toast.LENGTH_SHORT).show();
            counter = savedInstanceState.getInt(COUNTER_KEY);
        }

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               switch (view.getId()){
                   case R.id.exitCitySettingsBtn:
                       finish();
                        break;
                   case R.id.city1:
//                       startActivity(intent);
                        counter++;
                        counterTest.setText(String.valueOf(counter));
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

    @Override
    protected void onResume(){
        super.onResume();
        Toast.makeText(getApplicationContext(), "onResume", Toast.LENGTH_SHORT).show();
        Log.d("CitySetingsActivity", "onResume");

    }
    @Override
    protected void onPause(){
        super.onPause();
        Toast.makeText(getApplicationContext(), "onPause", Toast.LENGTH_SHORT).show();
        Log.d("CitySetingsActivity", "onPause");
    }
    @Override
    protected void onStop(){
        super.onStop();
        Toast.makeText(getApplicationContext(), "onStop", Toast.LENGTH_SHORT).show();
        Log.d("CitySetingsActivity", "onStop");
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        Toast.makeText(getApplicationContext(), "onDestroy", Toast.LENGTH_SHORT).show();
        Log.d("CitySetingsActivity", "onDestroy");
    }
    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putInt(COUNTER_KEY,counter);
        Toast.makeText(getApplicationContext(),"onSaveInstanceSate Save",Toast.LENGTH_SHORT).show();
    }
}