package com.example.ydsyokdil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );


        Button kolayGir = findViewById(R.id.kolayGir);
        Button ortaGir = findViewById(R.id.ortaGir);
        Button zorGir = findViewById(R.id.zorGir );
        Button fiilGir = findViewById(R.id.fiilGir );
        Toast.makeText( this, "Oyununuzu Oynarken Lütfen Büyük Harflerle Giriş Yapınız!", Toast.LENGTH_LONG ).show();

        }



    public void onClicked (View v){
        Intent intent = new Intent( getApplicationContext(), LevelSecKolay.class );
        startActivity( intent );
    }
    public void onClicked1 (View v){
        Intent intent = new Intent( getApplicationContext(), LevelSecOrta.class);
        startActivity( intent );
    } public void onClicked2 (View v){
        Intent intent = new Intent( getApplicationContext(), LevelSecZor.class);
        startActivity( intent );
    }

}