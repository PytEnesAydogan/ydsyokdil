package com.example.ydsyokdil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LevelSecZor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_level_sec_zor );


    }

    public void onClicked14 (View v){
        Intent intent = new Intent( getApplicationContext(), Zor.class );
        startActivity( intent );
    }

    public void onClicked15(View view) {
        Intent intent = new Intent( getApplicationContext(), Zor.Zor2.class );
        startActivity( intent );
    }

    public void onClicked16(View v) {
        Intent intent = new Intent( getApplicationContext(), Zor.Zor3.class );
        startActivity( intent );
    }
    public void onClicked17(View view) {
        Intent intent = new Intent( getApplicationContext(), Zor.Zor4.class );
        startActivity( intent );
    }
    public void onClicked18 (View v){
        Intent intent = new Intent( getApplicationContext(), Zor.Zor5.class );
        startActivity( intent );
    }

    public void onClicked19(View view) {
        Intent intent = new Intent( getApplicationContext(), Zor.Zor6.class );
        startActivity( intent );
    }

    public void onClicked20(View view) {
        Intent intent = new Intent( getApplicationContext(), Zor.Zor7.class );
        startActivity( intent );
    }
    public void onClicked21(View view) {
        Intent intent = new Intent( getApplicationContext(), Zor.Zor8.class );
        startActivity( intent );
    }
    public void onClicked22(View view) {
        Intent intent = new Intent( getApplicationContext(), Zor.Zor9.class );
        startActivity( intent );
    }
    public void onClicked23(View view) {
        Intent intent = new Intent( getApplicationContext(), Zor.Zor10.class );
        startActivity( intent );


    }}

