package com.wolkabout.hexiwear.activity;

import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.gson.Gson;
import com.wolkabout.hexiwear.R;

public class MyActivity extends AppCompatActivity implements View.OnClickListener{

    Button button,range;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        button=(Button)findViewById(R.id.button);
        button.setOnClickListener(this);

        range=(Button)findViewById(R.id.range);
        range.setOnClickListener(this);
    }


    public void onClick(View view) {
        if(view.equals(button)){
            String deviceJson= getIntent().getStringExtra("device");
            BluetoothDevice device=new Gson().fromJson(deviceJson,BluetoothDevice.class);
            ReadingsActivity_.intent(this).flags(Intent.FLAG_ACTIVITY_SINGLE_TOP).device(device).start();
        }
        else if(view.equals(range)){
            Intent intent=new Intent(this,Range.class);
            startActivity(intent);
        }
    }
}
