package com.example.ydsyokdil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LevelSecKolay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_level_sec_kolay );


    }

    public void onClicked4 (View v){
        Intent intent = new Intent( getApplicationContext(), Kolay.class );
        startActivity( intent );
    }

    public void onClicked5(View view) {
        Intent intent = new Intent( getApplicationContext(), Kolay.Kolay2.class );
        startActivity( intent );
    }

    public void onClicked6(View v) {
        Intent intent = new Intent( getApplicationContext(), Kolay.Kolay3.class );
        startActivity( intent );
    }
    public void onClicked7(View view) {
        Intent intent = new Intent( getApplicationContext(), Kolay.Kolay4.class );
        startActivity( intent );
    }
    public void onClicked8 (View v){
        Intent intent = new Intent( getApplicationContext(), Kolay.Kolay5.class );
        startActivity( intent );
    }

    public void onClicked9(View view) {
        Intent intent = new Intent( getApplicationContext(), Kolay.Kolay6.class );
        startActivity( intent );
    }

    public void onClicked10(View view) {
        Intent intent = new Intent( getApplicationContext(), Kolay.Kolay7.class );
        startActivity( intent );
    }
    public void onClicked11(View view) {
        Intent intent = new Intent( getApplicationContext(), Kolay.Kolay8.class );
        startActivity( intent );
    }
    public void onClicked12(View view) {
        Intent intent = new Intent( getApplicationContext(), Kolay.Kolay9.class );
        startActivity( intent );
    }
    public void onClicked13(View view) {
        Intent intent = new Intent( getApplicationContext(), Kolay.Kolay10.class );
        startActivity( intent );
    }

}
