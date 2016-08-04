package com.example.anhdt30.weatherapp;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends BaseActivity{

    private TextView tvCityName, tvTemperature, tvHumidity, tvWindSpeed;
    private Button btnRefresh;

    private String API_KEY;
    private String URL = "http://api.openweathermap.org/data/2.5/weather?q=Hanoi&units=metric&appid=";

    private ProgressBar pb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        API_KEY = getResources().getString(R.string.API_KEY);
        URL += API_KEY;
        assignUIElements();

        execute(URL);

        assignHandleEvents();

    }

    
    public void assignUIElements(){
        tvCityName = (TextView) findViewById(R.id.tvCityName);
        tvTemperature = (TextView) findViewById(R.id.tvTemperature);
        tvHumidity = (TextView) findViewById(R.id.tvHumidity);
        tvWindSpeed = (TextView) findViewById(R.id.tvWindSpeed);
        btnRefresh = (Button) findViewById(R.id.btnRefresh);
        pb = (ProgressBar) findViewById(R.id.pb);
    }

    public void assignHandleEvents(){
        btnRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                execute(URL);
            }
        });
    }

    @Override
    public void onResponse(JSONObject jsonObject) {
        try{
            double temp = jsonObject.getJSONObject("main").getDouble("temp");
            double humidity = jsonObject.getJSONObject("main").getDouble("humidity");
            double windspeed = jsonObject.getJSONObject("wind").getDouble("speed");
            pb.setVisibility(View.GONE);
            tvTemperature.setText(temp + " C");
            tvHumidity.setText(humidity + " %");
            tvWindSpeed.setText(windspeed + " m/s");

        }
        catch (JSONException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void preExeCute() {
        pb.setVisibility(View.VISIBLE);
    }
}
