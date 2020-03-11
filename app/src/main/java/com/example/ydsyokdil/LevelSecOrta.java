package com.example.ydsyokdil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;



public class LevelSecOrta extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_level_sec_orta );

    }

    public void onClicked24 (View v){
        Intent intent = new Intent( getApplicationContext(), Orta.class );
        startActivity( intent );
    }

    public void onClicked25(View view) {
        Intent intent = new Intent( getApplicationContext(), Orta.Orta2.class );
        startActivity( intent );
    }

    public void onClicked26(View v) {
        Intent intent = new Intent( getApplicationContext(), Orta.Orta3.class );
        startActivity( intent );
    }
    public void onClicked27(View view) {
        Intent intent = new Intent( getApplicationContext(), Orta.Orta4.class );
        startActivity( intent );
    }
    public void onClicked28 (View v){
        Intent intent = new Intent( getApplicationContext(), Orta.Orta5.class );
        startActivity( intent );
    }

    public void onClicked29(View view) {
        Intent intent = new Intent( getApplicationContext(), Orta.Orta6.class );
        startActivity( intent );
    }

    public void onClicked30(View view) {
        Intent intent = new Intent( getApplicationContext(), Orta.Orta7.class );
        startActivity( intent );
    }
    public void onClicked31(View view) {
        Intent intent = new Intent( getApplicationContext(), Orta.Orta8.class );
        startActivity( intent );
    }
    public void onClicked32(View view) {
        Intent intent = new Intent( getApplicationContext(), Orta.Orta9.class );
        startActivity( intent );
    }
    public void onClicked33(View view) {
        Intent intent = new Intent( getApplicationContext(), Orta.Orta10.class );
        startActivity( intent );
    }}






