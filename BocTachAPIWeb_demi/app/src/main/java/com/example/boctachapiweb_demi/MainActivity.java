package com.example.boctachapiweb_demi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.Activity;
import android.os.Bundle;

import com.example.boctachapiweb_demi.databinding.ActivityMainBinding;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    String api = "{\"coord\":{\"lon\":-0.13,\"lat\":51.51},\"weather\":[{\"id\":300,\"main\":\"Drizzle\",\"description\":\"light intensity drizzle\",\"icon\":\"09d\"}],\"base\":\"stations\",\"main\":{\"temp\":280.32,\"pressure\":1012,\"humidity\":81,\"temp_min\":279.15,\"temp_max\":281.15},\"visibility\":10000,\"wind\":{\"speed\":4.1,\"deg\":80},\"clouds\":{\"all\":90},\"dt\":1485789600,\"sys\":{\"type\":1,\"id\":5091,\"message\":0.0103,\"country\":\"GB\",\"sunrise\":1485762037,\"sunset\":1485794875},\"id\":2643743,\"name\":\"London\",\"cod\":200}";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        jsonojectMain();

//        jsonwebSys();
    }

    public void jsonojectMain(){
        try {

            JSONObject jsonObject = new JSONObject(api);
            String main = jsonObject.getString("main");

            JSONObject jsonObject1 = new JSONObject(main);
            String temp = jsonObject1.getString("temp");
            String pressure = jsonObject1.getString("pressure");
            String humidity = jsonObject1.getString("humidity");
            String temp_min = jsonObject1.getString("temp_min");
            String temp_max = jsonObject1.getString("temp_max");


            binding.txtText.setText("Temp: " + temp + "\n"
                    + "Pressure: " + pressure + "\n"
                    + "Humidity: " + humidity + "\n"
                    + "Temp_min: " + temp_min + "\n"
                    + "Temp_max: " + temp_max);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void jsonwebSys(){
        try {
            JSONObject jsonObject = new JSONObject(api);
            String sys = jsonObject.getString("sys");

            jsonObject = new JSONObject(sys);
            String type = jsonObject.getString("type");
            String id = jsonObject.getString("id");
            String m = jsonObject.getString("message");
            String country = jsonObject.getString("country");
            String sunrise = jsonObject.getString("sunrise");
            String sunset = jsonObject.getString("sunset");

            binding.txtText.setText("type: "+type+"\n"+
                    "id: "+id+"\n"+
                    "message: "+m+"\n"+
                    "country: "+country+"\n"+
                    "sunrise: "+sunrise+"\n"+
                    "sunset: "+sunset+"\n");



        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}