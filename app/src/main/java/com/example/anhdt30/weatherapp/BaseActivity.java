package com.example.anhdt30.weatherapp;

import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

/**
 * Created by AnhDT30 on 8/2/2016.
 */
public abstract class BaseActivity extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener {
    private RequestQueue queue;


    public void execute(String url){
        preExeCute();
        queue = Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, this, this);
        queue.add(jsonObjectRequest);
    }

    public void execute(String url, Response.Listener response){
        queue = Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, response, this);
        queue.add(jsonObjectRequest);
    }

    public void execute(String url, Response.Listener response, Response.ErrorListener errorListener){
        queue = Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, response, errorListener);
        queue.add(jsonObjectRequest);
    }

    @Override
    public void onErrorResponse(VolleyError volleyError) {
        Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
    }

    protected abstract void preExeCute();
}
