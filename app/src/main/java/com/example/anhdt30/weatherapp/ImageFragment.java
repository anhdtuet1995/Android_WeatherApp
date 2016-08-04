package com.example.anhdt30.weatherapp;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by css2st on 8/4/2016.
 */
public class ImageFragment extends Fragment {
    private int identifier;
    private int colour;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        colour = args.getInt("colour");
        identifier = args.getInt("identifier");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        TextView v = new TextView(getActivity());
//        v.setGravity(Gravity.CENTER);
//        v.setTextSize(40);
//        v.setTextColor(Color.BLACK);
        //v.setBackgroundColor(colour);
//        Log.v("Test", colour + "");
//        v.setText("Fragment ID: " + identifier);
        ImageView v = new ImageView(getActivity());
        v.setImageResource(colour);
        return v;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean("dummy", true);
    }
}
