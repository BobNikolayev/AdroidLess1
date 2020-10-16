package nikolayev.bohan.lesson1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CitySetingsActivity extends AppCompatActivity implements Constants {

    private final static int REQUEST_CODE = 10;

    private final String COUNTER_KEY = "COUNTER_KEY";
    int counter = 0;
    Button exit;
    Button selectBtn;
    Button city2;
    Button city3;
    TextView cityName;
    TextView date;
    TextView weather;
    TextView counterTest;
    EditText editCityText;


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

        Parcel parcel = (Parcel) getIntent().getExtras().getSerializable(CITY_KEY);
        editCityText = findViewById(R.id.editTextCity);
        editCityText.setText(parcel.cityName);


        final Intent intent = new Intent(this,CityInfoActivity.class);
        final Intent mainActivityIntent = new Intent(CitySetingsActivity.this,MainActivity.class);
        exit =  findViewById(R.id.exitCitySettingsBtn) ;
        city2 =  findViewById(R.id.city2);
        city3 =  findViewById(R.id.city3);
        cityName =  findViewById(R.id.textCityName);
        date =  findViewById(R.id.textDate);
        weather =  findViewById(R.id.textWeather);
        counterTest = findViewById(R.id.counterTest);
        selectBtn = findViewById(R.id.select);

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
                   case R.id.select:
                        Intent intentResult = new Intent();
                        intentResult.putExtra(CITY_RESULT,editCityText.getText().toString());
                        setResult(RESULT_OK,intentResult);
                        finish();
                       break;
//                   case R.id.city2:
////                       startActivity(intent);
//                       break;
//                   case R.id.city3:
////                       startActivity(intent);
//                       break;
               }
            }
        };
        selectBtn.setOnClickListener(onClickListener);
        exit.setOnClickListener(onClickListener);
        city2.setOnClickListener(onClickListener);
        city3.setOnClickListener(onClickListener);
    }

//    @Override
//    protected void onActivityResult(int requestCode,int resultCode,Intent data){
//        if(requestCode != REQUEST_CODE){
//            super.onActivityResult( requestCode, resultCode, data);
//            return;
//        }
//
//        if(resultCode == RESULT_OK){
//            TextView cityMain = findViewById(R.id.textView) ;
//            cityMain.setText(data.getStringExtra("City11111"));
//        }
//    }

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
    protected void onSaveInstanceState(@NonNull Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putInt(COUNTER_KEY,counter);
        Toast.makeText(getApplicationContext(),"onSaveInstanceSate Save",Toast.LENGTH_SHORT).show();
    }
}