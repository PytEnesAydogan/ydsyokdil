package com.example.ydsyokdil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;


public class Kolay extends AppCompatActivity {

   static final int oyunbuyuk_h = 15;
   static final int oyunbuyuk_v = 12;
   static boolean clear = false;
   int progress = 0;
   static boolean pause = false;
   static String[] cevaplar;
   static String[] anlamlar;
   static int[][] positions;
   kolayKelimeler words = new kolayKelimeler();
   static String[] blockDegistir;
   static LinearLayout ana_linearLayout;
   static LinearLayout[] sub_linearLayouts;
   static Button[][] btnquiz = new Button[oyunbuyuk_v][oyunbuyuk_h];
   static EditText input_edittext;
   static TextView textView2;
   static Button btnInsert;
   private InterstitialAd mInterstitialAd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_game_kolay );
        input_edittext = findViewById( R.id.edittext_input );
        textView2 = findViewById( R.id.textView2 );
        btnInsert = findViewById( R.id.btnKelimeEkle );

        positions = words.getPositions();
        cevaplar = words.getWords();
        anlamlar = words.getMeans();
        textView2.append( anlamlar[progress] );
        PuzzleEkle();
        BlockDegistir();

   /*  mInterstitialAd = new InterstitialAd(this);
            mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");

            reklamiYukle();

            mInterstitialAd.setAdListener( new AdListener(){

                @Override
                public void onAdClosed() {
                    super.onAdClosed();
                    reklamiYukle();
                }

                @Override
                public void onAdLoaded() {
                    super.onAdLoaded();
                    mInterstitialAd.show();
                }
            } );
*/
        }
        private void reklamiYukle() {
            AdRequest adRequest = new AdRequest.Builder()
                    .addTestDevice( AdRequest.DEVICE_ID_EMULATOR ).build();
            mInterstitialAd.loadAd(adRequest);
    }

    public void PuzzleEkle() {

        ana_linearLayout =  findViewById( R.id.game_main_layout );
        sub_linearLayouts = new LinearLayout[oyunbuyuk_v];

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT );


        LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT );

        params.height = 80;
        params.weight = 1;
        params2.width = 80;
        params2.weight = 1;

        for (int i = 0; i < oyunbuyuk_v; i++) {
            for (int j = 0; j < oyunbuyuk_h; j++) {
                btnquiz[i][j] = new Button( this );
                btnquiz[i][j].setLayoutParams( params2 );
                btnquiz[i][j].setClickable( false );
                btnquiz[i][j].setPadding( 1, 1, 1, 1 );
                btnquiz[i][j].setText( "" );

            }
        }
        for (int i = 0; i < sub_linearLayouts.length; i++) {
            sub_linearLayouts[i] = new LinearLayout( this );
            sub_linearLayouts[i].setOrientation( LinearLayout.HORIZONTAL );
            sub_linearLayouts[i].setWeightSum( oyunbuyuk_h );
            sub_linearLayouts[i].setLayoutParams( params );
            ana_linearLayout.addView( sub_linearLayouts[i] );
        }
        for (int i = 0; i < oyunbuyuk_v; i++) {
            for (int j = 0; j < oyunbuyuk_h; j++) {
                sub_linearLayouts[i].addView( btnquiz[i][j] );
            }
        }

        int h1;
        int v1;

        for (int i = 0; i < cevaplar.length; i++) {

            h1 = positions[i][1];
            v1 = positions[i][2];

            if (positions[i][0] == 0) { // yatay kelimeler
                for (int j = 0; j < cevaplar[i].length(); j++) {

                    btnquiz[h1][v1 + j].setText( " " );

                }
            } else if (positions[i][0] == 1) { //dikey kelimeler
                for (int j = 0; j < cevaplar[i].length(); j++) {

                    btnquiz[h1 + j][v1].setText( " " );
                }
            }
        }
        for (int i = 0; i < oyunbuyuk_v; i++) {
            for (int j = 0; j < oyunbuyuk_h; j++) {
                if (!btnquiz[i][j].getText().equals( "" ))
                    btnquiz[i][j].setBackgroundResource( R.drawable.sabitcerceve );

                else
                    btnquiz[i][j].setBackgroundResource(R.drawable.btnquiz_bg_transparent );
            }
        }

    }

    public void BlockDegistir() {
        int i = progress;
        int h_ = positions[i][1];
        int v_ = positions[i][2];
        if (progress > 0) {
            int pre_h = positions[i - 1][1];
            int pre_v = positions[i - 1][2];
            if (positions[i - 1][0] == 0) {
                for (int j = 0; j < cevaplar[i - 1].length(); j++) {
                    btnquiz[pre_h][pre_v + j].setBackgroundResource( R.drawable.anlikcerceve );
                }
            }
            else if (positions[i - 1][0] == 1) {
                for (int j = 0; j < cevaplar[i - 1].length(); j++) {
                    btnquiz[pre_h + j][pre_v].setBackgroundResource( R.drawable.anlikcerceve );
                }
            }

        }
        if(positions[i][0] == 0){
            for(int j = 0; j < cevaplar[i].length(); j++) {
                btnquiz[h_][v_ + j].setBackgroundResource(R.drawable.anlikcerceve );
            }
        }
        else if(positions[i][0] == 1){
            for(int j = 0; j < cevaplar[i].length(); j++){
                btnquiz[h_+j][v_].setBackgroundResource(R.drawable.anlikcerceve );
            }
        }

    }

    public void KelimeEkle() {

        int i = progress;
        int h_;
        int v_;

        h_ = positions[i][1];
        v_ = positions[i][2];

        //İngilizce Kelimeyi koy

        if (positions[i][0] == 0) {
            for (int j = 0; j < cevaplar[i].length(); j++) {
                btnquiz[h_][v_ + j].setText( Character.toString( cevaplar[i].charAt( j ) ) );

            }
        } else if (positions[i][0] == 1) {
            for (int j = 0; j < cevaplar[i].length(); j++) {
                btnquiz[h_ + j][v_].setText( Character.toString( cevaplar[i].charAt( j ) ) );
            }
        }

    }


    public void endGame() {
        //oyun bittiğinde düğmeleri devre dışı bırakır.
        input_edittext.setEnabled( false );
        btnInsert.setEnabled( false );


        finish();
        //Buraya Yeni Bulmacalar Gelecek Oyun Bittikten Sonra
        Intent intent = new Intent( getApplicationContext(),LevelSecKolay.class );
        startActivity( intent );
        Toast.makeText( this, "Tebrikler!", Toast.LENGTH_LONG ).show();
    }








    public void onInsertClicked (View v) {

        String inputted;
        inputted = input_edittext.getText().toString().toUpperCase();

        if (progress < 27 ) {
            if (inputted.equals( cevaplar[progress] )) { //girilen kelime doğruysa
                Toast.makeText( this, "Doğru!", Toast.LENGTH_SHORT ).show();

                KelimeEkle();
                clear =true;
                if (progress < 26  )
                    progress++;

                else
                    endGame();
                textView2.setText( String.format( "Soru : %s", anlamlar[progress] ) );

            }

            else {

                Toast.makeText(this, "Yanlış Kelime Girdiniz!", Toast.LENGTH_LONG).show();


            }
            if(progress<27)
                BlockDegistir();
            if(clear)
                input_edittext.setText("");



        }


    }

    public static class Kolay2 extends AppCompatActivity {

        kolayKelimeler.kolay2Kelimeler words = new kolayKelimeler.kolay2Kelimeler();
        int progress = 0;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate( savedInstanceState );
            setContentView( R.layout.activity_game_kolay );

            input_edittext = findViewById( R.id.edittext_input );
            textView2 = findViewById( R.id.textView2 );
            btnInsert = findViewById( R.id.btnKelimeEkle );

            positions = words.getPositions();
            cevaplar = words.getWords();
            anlamlar = words.getMeans();

            textView2.append( anlamlar[progress] );
            PuzzleEkle();

            BlockDegistir();


        }
        public void PuzzleEkle() {

            ana_linearLayout = findViewById( R.id.game_main_layout );
            sub_linearLayouts = new LinearLayout[oyunbuyuk_v];

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT );


            LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT );

            params.height = 80;
            params.weight = 1;
            params2.width = 80;
            params2.weight = 1;

            for (int i = 0; i < oyunbuyuk_v; i++) {
                for (int j = 0; j < oyunbuyuk_h; j++) {
                    btnquiz[i][j] = new Button( this );
                    btnquiz[i][j].setLayoutParams( params2 );
                    btnquiz[i][j].setClickable( false );
                    btnquiz[i][j].setPadding( 1, 1, 1, 1 );
                    btnquiz[i][j].setText( "" );

                }
            }
            for (int i = 0; i < sub_linearLayouts.length; i++) {
                sub_linearLayouts[i] = new LinearLayout( this );
                sub_linearLayouts[i].setOrientation( LinearLayout.HORIZONTAL );
                sub_linearLayouts[i].setWeightSum( oyunbuyuk_h );
                sub_linearLayouts[i].setLayoutParams( params );
                ana_linearLayout.addView( sub_linearLayouts[i] );
            }
            for (int i = 0; i < oyunbuyuk_v; i++) {
                for (int j = 0; j < oyunbuyuk_h; j++) {
                    sub_linearLayouts[i].addView( btnquiz[i][j] );
                }
            }

            int h1;
            int v1;

            for (int i = 0; i < cevaplar.length; i++) {

                h1 = positions[i][1];
                v1 = positions[i][2];

                if (positions[i][0] == 0) { // yatay kelimeler
                    for (int j = 0; j < cevaplar[i].length(); j++) {

                        btnquiz[h1][v1 + j].setText( " " );

                    }
                } else if (positions[i][0] == 1) { //dikey kelimeler
                    for (int j = 0; j < cevaplar[i].length(); j++) {

                        btnquiz[h1 + j][v1].setText( " " );
                    }
                }
            }
            for (int i = 0; i < oyunbuyuk_v; i++) {
                for (int j = 0; j < oyunbuyuk_h; j++) {
                    if (!btnquiz[i][j].getText().equals( "" ))
                        btnquiz[i][j].setBackgroundResource( R.drawable.sabitcerceve );

                    else
                        btnquiz[i][j].setBackgroundResource( R.drawable.btnquiz_bg_transparent );
                }
            }

        }


        public void BlockDegistir() {
            int i = progress;
            int h_ = positions[i][1];
            int v_ = positions[i][2];
            if (progress > 0) {
                int pre_h = positions[i - 1][1];
                int pre_v = positions[i - 1][2];
                if (positions[i - 1][0] == 0) {
                    for (int j = 0; j < cevaplar[i - 1].length(); j++) {
                        btnquiz[pre_h][pre_v + j].setBackgroundResource( R.drawable.anlikcerceve );
                    }
                } else if (positions[i - 1][0] == 1) {
                    for (int j = 0; j < cevaplar[i - 1].length(); j++) {
                        btnquiz[pre_h + j][pre_v].setBackgroundResource( R.drawable.anlikcerceve );
                    }
                }

            }
            if (positions[i][0] == 0) {
                for (int j = 0; j < cevaplar[i].length(); j++) {
                    btnquiz[h_][v_ + j].setBackgroundResource( R.drawable.anlikcerceve );
                }
            } else if (positions[i][0] == 1) {
                for (int j = 0; j < cevaplar[i].length(); j++) {
                    btnquiz[h_ + j][v_].setBackgroundResource( R.drawable.anlikcerceve );
                }
            }

        }

        public void KelimeEkle() {

            int i = progress;
            int h_;
            int v_;


            h_ = positions[i][1];
            v_ = positions[i][2];

            //İngilizce Kelimeyi koy

            if (positions[i][0] == 0) {
                for (int j = 0; j < cevaplar[i].length(); j++) {
                    btnquiz[h_][v_ + j].setText( Character.toString( cevaplar[i].charAt( j ) ) );

                }
            } else if (positions[i][0] == 1) {
                for (int j = 0; j < cevaplar[i].length(); j++) {
                    btnquiz[h_ + j][v_].setText( Character.toString( cevaplar[i].charAt( j ) ) );
                }
            }

        }


        public void endGame() {
            //oyun bittiğinde düğmeleri devre dışı bırakır.
            input_edittext.setEnabled( false );
            btnInsert.setEnabled( false );
            Toast.makeText( this, "Tebrikler!", Toast.LENGTH_SHORT ).show();

            finish();
            //Buraya Yeni Bulmacalar Gelecek Oyun Bittikten Sonra
            Intent intent = new Intent( getApplicationContext(), LevelSecKolay.class );
            startActivity( intent );
        }


        public void onInsertClicked(View v) {


            String inputted;
            inputted = input_edittext.getText().toString().toUpperCase();

            if (progress < 27) {
                if (inputted.equals( cevaplar[progress] )) { //girilen kelime doğruysa
                    Toast.makeText( this, "Doğru!", Toast.LENGTH_SHORT ).show();

                    KelimeEkle();
                    clear = true;
                    if (progress < 26)
                        progress++;

                    else
                        endGame();
                    textView2.setText( String.format( "Soru : %s", anlamlar[progress] ) );

                } else {

                    Toast.makeText( this, "Yanlış Kelime Girdiniz!", Toast.LENGTH_LONG ).show();


                }
                if (progress < 27)
                    BlockDegistir();
                if (clear)
                    input_edittext.setText( "" );


            }


        }


    }


    public static class Kolay3 extends AppCompatActivity {

        int progress = 0;
        kolayKelimeler.kolay3Kelimeler words =new kolayKelimeler.kolay3Kelimeler();


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate( savedInstanceState );
            setContentView( R.layout.activity_game_kolay );

            input_edittext = findViewById( R.id.edittext_input );
            textView2 = findViewById( R.id.textView2 );
            btnInsert = findViewById( R.id.btnKelimeEkle );

            positions = words.getPositions();
            cevaplar = words.getWords();
            anlamlar = words.getMeans();

            textView2.append( anlamlar[progress] );
            PuzzleEkle();
            BlockDegistir();

        }



        public void PuzzleEkle() {

            ana_linearLayout =  findViewById( R.id.game_main_layout );
            sub_linearLayouts = new LinearLayout[oyunbuyuk_v];

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT );


            LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT );

            params.height = 80;
            params.weight = 1;
            params2.width = 80;
            params2.weight = 1;

            for (int i = 0; i < oyunbuyuk_v; i++) {
                for (int j = 0; j < oyunbuyuk_h; j++) {
                    btnquiz[i][j] = new Button( this );
                    btnquiz[i][j].setLayoutParams( params2 );
                    btnquiz[i][j].setClickable( false );
                    btnquiz[i][j].setPadding( 1, 1, 1, 1 );
                    btnquiz[i][j].setText( "" );

                }
            }
            for (int i = 0; i < sub_linearLayouts.length; i++) {
                sub_linearLayouts[i] = new LinearLayout( this );
                sub_linearLayouts[i].setOrientation( LinearLayout.HORIZONTAL );
                sub_linearLayouts[i].setWeightSum( oyunbuyuk_h );
                sub_linearLayouts[i].setLayoutParams( params );
                ana_linearLayout.addView( sub_linearLayouts[i] );
            }
            for (int i = 0; i < oyunbuyuk_v; i++) {
                for (int j = 0; j < oyunbuyuk_h; j++) {
                    sub_linearLayouts[i].addView( btnquiz[i][j] );
                }
            }

            int h1;
            int v1;

            for (int i = 0; i < cevaplar.length; i++) {

                h1 = positions[i][1];
                v1 = positions[i][2];

                if (positions[i][0] == 0) { // yatay kelimeler
                    for (int j = 0; j < cevaplar[i].length(); j++) {

                        btnquiz[h1][v1 + j].setText( " " );

                    }
                } else if (positions[i][0] == 1) { //dikey kelimeler
                    for (int j = 0; j < cevaplar[i].length(); j++) {

                        btnquiz[h1 + j][v1].setText( " " );
                    }
                }
            }
            for (int i = 0; i < oyunbuyuk_v; i++) {
                for (int j = 0; j < oyunbuyuk_h; j++) {
                    if (!btnquiz[i][j].getText().equals( "" ))
                        btnquiz[i][j].setBackgroundResource( R.drawable.sabitcerceve );

                    else
                        btnquiz[i][j].setBackgroundResource(R.drawable.btnquiz_bg_transparent );
                }
            }




        }
        public void BlockDegistir() {
            int i = progress;
            int h_ = positions[i][1];
            int v_ = positions[i][2];
            if (progress > 0) {
                int pre_h = positions[i - 1][1];
                int pre_v = positions[i - 1][2];
                if (positions[i - 1][0] == 0) {
                    for (int j = 0; j < cevaplar[i - 1].length(); j++) {
                        btnquiz[pre_h][pre_v + j].setBackgroundResource( R.drawable.anlikcerceve );
                    }
                }
                else if (positions[i - 1][0] == 1) {
                    for (int j = 0; j < cevaplar[i - 1].length(); j++) {
                        btnquiz[pre_h + j][pre_v].setBackgroundResource( R.drawable.anlikcerceve );
                    }
                }

            }
            if(positions[i][0] == 0){
                for(int j = 0; j < cevaplar[i].length(); j++) {
                    btnquiz[h_][v_ + j].setBackgroundResource(R.drawable.anlikcerceve );
                }
            }
            else if(positions[i][0] == 1){
                for(int j = 0; j < cevaplar[i].length(); j++){
                    btnquiz[h_+j][v_].setBackgroundResource(R.drawable.anlikcerceve );
                }
            }

        }  public void KelimeEkle() {

            int i = progress;
            int h_;
            int v_;


            h_ = positions[i][1];
            v_ = positions[i][2];

            //İngilizce Kelimeyi koy

            if (positions[i][0] == 0) {
                for (int j = 0; j < cevaplar[i].length(); j++) {
                    btnquiz[h_][v_ + j].setText( Character.toString( cevaplar[i].charAt( j ) ) );

                }
            } else if (positions[i][0] == 1) {
                for (int j = 0; j < cevaplar[i].length(); j++) {
                    btnquiz[h_ + j][v_].setText( Character.toString( cevaplar[i].charAt( j ) ) );
                }
            }

        }


        public void endGame() {
            //oyun bittiğinde düğmeleri devre dışı bırakır.
            input_edittext.setEnabled( false );
            btnInsert.setEnabled( false );
            Toast.makeText( this, "Tebrikler!", Toast.LENGTH_SHORT ).show();


            finish();
            //Buraya Yeni Bulmacalar Gelecek Oyun Bittikten Sonra
            Intent intent = new Intent( getApplicationContext(), LevelSecKolay.class );
            startActivity( intent );
        }






        public void onInsertClicked (View v) {

            String inputted;
            inputted = input_edittext.getText().toString().toUpperCase();

            if (progress < 27 ) {
                if (inputted.equals( cevaplar[progress] )) { //girilen kelime doğruysa
                    Toast.makeText( this, "Doğru!", Toast.LENGTH_SHORT ).show();

                    KelimeEkle();
                    clear =true;
                    if (progress < 26  )
                        progress++;

                    else
                        endGame();
                    textView2.setText( String.format( "Soru : %s", anlamlar[progress] ) );

                }

                else {

                    Toast.makeText(this, "Yanlış Kelime Girdiniz!", Toast.LENGTH_LONG).show();


                }
                if(progress<27)
                    BlockDegistir();
                if(clear)
                    input_edittext.setText("");



            }


        }  }

    public static class Kolay4 extends AppCompatActivity {
        int progress = 0;
        kolayKelimeler.kolay4Kelimeler words = new kolayKelimeler.kolay4Kelimeler();


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate( savedInstanceState );
            setContentView( R.layout.activity_game_kolay );

            input_edittext = findViewById( R.id.edittext_input );
            textView2 = findViewById( R.id.textView2 );
            btnInsert = findViewById( R.id.btnKelimeEkle );

            positions = words.getPositions();
            cevaplar = words.getWords();
            anlamlar = words.getMeans();

            textView2.append( anlamlar[progress] );
            PuzzleEkle();
            BlockDegistir();

        }



        public void PuzzleEkle() {

            ana_linearLayout =  findViewById( R.id.game_main_layout );
            sub_linearLayouts = new LinearLayout[oyunbuyuk_v];

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT );


            LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT );

            params.height = 80;
            params.weight = 1;
            params2.width = 80;
            params2.weight = 1;

            for (int i = 0; i < oyunbuyuk_v; i++) {
                for (int j = 0; j < oyunbuyuk_h; j++) {
                    btnquiz[i][j] = new Button( this );
                    btnquiz[i][j].setLayoutParams( params2 );
                    btnquiz[i][j].setClickable( false );
                    btnquiz[i][j].setPadding( 1, 1, 1, 1 );
                    btnquiz[i][j].setText( "" );

                }
            }
            for (int i = 0; i < sub_linearLayouts.length; i++) {
                sub_linearLayouts[i] = new LinearLayout( this );
                sub_linearLayouts[i].setOrientation( LinearLayout.HORIZONTAL );
                sub_linearLayouts[i].setWeightSum( oyunbuyuk_h );
                sub_linearLayouts[i].setLayoutParams( params );
                ana_linearLayout.addView( sub_linearLayouts[i] );
            }
            for (int i = 0; i < oyunbuyuk_v; i++) {
                for (int j = 0; j < oyunbuyuk_h; j++) {
                    sub_linearLayouts[i].addView( btnquiz[i][j] );
                }
            }

            int h1;
            int v1;

            for (int i = 0; i < cevaplar.length; i++) {

                h1 = positions[i][1];
                v1 = positions[i][2];

                if (positions[i][0] == 0) { // yatay kelimeler
                    for (int j = 0; j < cevaplar[i].length(); j++) {

                        btnquiz[h1][v1 + j].setText( " " );

                    }
                } else if (positions[i][0] == 1) { //dikey kelimeler
                    for (int j = 0; j < cevaplar[i].length(); j++) {

                        btnquiz[h1 + j][v1].setText( " " );
                    }
                }
            }
            for (int i = 0; i < oyunbuyuk_v; i++) {
                for (int j = 0; j < oyunbuyuk_h; j++) {
                    if (!btnquiz[i][j].getText().equals( "" ))
                        btnquiz[i][j].setBackgroundResource( R.drawable.sabitcerceve );

                    else
                        btnquiz[i][j].setBackgroundResource(R.drawable.btnquiz_bg_transparent );
                }
            }




        }public void BlockDegistir() {
            int i = progress;
            int h_ = positions[i][1];
            int v_ = positions[i][2];
            if (progress > 0) {
                int pre_h = positions[i - 1][1];
                int pre_v = positions[i - 1][2];
                if (positions[i - 1][0] == 0) {
                    for (int j = 0; j < cevaplar[i - 1].length(); j++) {
                        btnquiz[pre_h][pre_v + j].setBackgroundResource( R.drawable.anlikcerceve );
                    }
                }
                else if (positions[i - 1][0] == 1) {
                    for (int j = 0; j < cevaplar[i - 1].length(); j++) {
                        btnquiz[pre_h + j][pre_v].setBackgroundResource( R.drawable.anlikcerceve );
                    }
                }

            }
            if(positions[i][0] == 0){
                for(int j = 0; j < cevaplar[i].length(); j++) {
                    btnquiz[h_][v_ + j].setBackgroundResource(R.drawable.anlikcerceve );
                }
            }
            else if(positions[i][0] == 1){
                for(int j = 0; j < cevaplar[i].length(); j++){
                    btnquiz[h_+j][v_].setBackgroundResource(R.drawable.anlikcerceve );
                }
            }

        }  public void KelimeEkle() {

            int i = progress;
            int h_;
            int v_;


            h_ = positions[i][1];
            v_ = positions[i][2];

            //İngilizce Kelimeyi koy

            if (positions[i][0] == 0) {
                for (int j = 0; j < cevaplar[i].length(); j++) {
                    btnquiz[h_][v_ + j].setText( Character.toString( cevaplar[i].charAt( j ) ) );

                }
            } else if (positions[i][0] == 1) {
                for (int j = 0; j < cevaplar[i].length(); j++) {
                    btnquiz[h_ + j][v_].setText( Character.toString( cevaplar[i].charAt( j ) ) );
                }
            }

        }


        public void endGame() {
            //oyun bittiğinde düğmeleri devre dışı bırakır.
            input_edittext.setEnabled( false );
            btnInsert.setEnabled( false );
            Toast.makeText( this, "Tebrikler!", Toast.LENGTH_SHORT ).show();


            finish();
            //Buraya Yeni Bulmacalar Gelecek Oyun Bittikten Sonra
            Intent intent = new Intent( getApplicationContext(), LevelSecKolay.class );
            startActivity( intent );
        }






        public void onInsertClicked (View v) {


            String inputted;
            inputted = input_edittext.getText().toString().toUpperCase();

            if (progress < 27 ) {
                if (inputted.equals( cevaplar[progress] )) { //girilen kelime doğruysa
                    Toast.makeText( this, "Doğru!", Toast.LENGTH_SHORT ).show();

                    KelimeEkle();
                    clear =true;
                    if (progress < 26  )
                        progress++;

                    else
                        endGame();
                    textView2.setText( String.format( "Soru : %s", anlamlar[progress] ) );

                }

                else {

                    Toast.makeText(this, "Yanlış Kelime Girdiniz!", Toast.LENGTH_LONG).show();


                }
                if(progress<27)
                    BlockDegistir();
                if(clear)
                    input_edittext.setText("");



            }


        }  }

    public static class Kolay5 extends AppCompatActivity {
        int progress = 0;
        kolayKelimeler.kolay5Kelimeler words = new kolayKelimeler.kolay5Kelimeler();



        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate( savedInstanceState );
            setContentView( R.layout.activity_game_kolay );

            input_edittext = findViewById( R.id.edittext_input );
            textView2 = findViewById( R.id.textView2 );
            btnInsert = findViewById( R.id.btnKelimeEkle );

            positions = words.getPositions();
            cevaplar = words.getWords();
            anlamlar = words.getMeans();

            textView2.append( anlamlar[progress] );
            PuzzleEkle();
            BlockDegistir();

        }



        public void PuzzleEkle() {

            ana_linearLayout =  findViewById( R.id.game_main_layout );
            sub_linearLayouts = new LinearLayout[oyunbuyuk_v];

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT );


            LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT );

            params.height = 80;
            params.weight = 1;
            params2.width = 80;
            params2.weight = 1;

            for (int i = 0; i < oyunbuyuk_v; i++) {
                for (int j = 0; j < oyunbuyuk_h; j++) {
                    btnquiz[i][j] = new Button( this );
                    btnquiz[i][j].setLayoutParams( params2 );
                    btnquiz[i][j].setClickable( false );
                    btnquiz[i][j].setPadding( 1, 1, 1, 1 );
                    btnquiz[i][j].setText( "" );

                }
            }
            for (int i = 0; i < sub_linearLayouts.length; i++) {
                sub_linearLayouts[i] = new LinearLayout( this );
                sub_linearLayouts[i].setOrientation( LinearLayout.HORIZONTAL );
                sub_linearLayouts[i].setWeightSum( oyunbuyuk_h );
                sub_linearLayouts[i].setLayoutParams( params );
                ana_linearLayout.addView( sub_linearLayouts[i] );
            }
            for (int i = 0; i < oyunbuyuk_v; i++) {
                for (int j = 0; j < oyunbuyuk_h; j++) {
                    sub_linearLayouts[i].addView( btnquiz[i][j] );
                }
            }

            int h1;
            int v1;

            for (int i = 0; i < cevaplar.length; i++) {

                h1 = positions[i][1];
                v1 = positions[i][2];

                if (positions[i][0] == 0) { // yatay kelimeler
                    for (int j = 0; j < cevaplar[i].length(); j++) {

                        btnquiz[h1][v1 + j].setText( " " );

                    }
                } else if (positions[i][0] == 1) { //dikey kelimeler
                    for (int j = 0; j < cevaplar[i].length(); j++) {

                        btnquiz[h1 + j][v1].setText( " " );
                    }
                }
            }
            for (int i = 0; i < oyunbuyuk_v; i++) {
                for (int j = 0; j < oyunbuyuk_h; j++) {
                    if (!btnquiz[i][j].getText().equals( "" ))
                        btnquiz[i][j].setBackgroundResource( R.drawable.sabitcerceve );

                    else
                        btnquiz[i][j].setBackgroundResource(R.drawable.btnquiz_bg_transparent );
                }
            }




        }public void BlockDegistir() {
            int i = progress;
            int h_ = positions[i][1];
            int v_ = positions[i][2];
            if (progress > 0) {
                int pre_h = positions[i - 1][1];
                int pre_v = positions[i - 1][2];
                if (positions[i - 1][0] == 0) {
                    for (int j = 0; j < cevaplar[i - 1].length(); j++) {
                        btnquiz[pre_h][pre_v + j].setBackgroundResource( R.drawable.anlikcerceve );
                    }
                }
                else if (positions[i - 1][0] == 1) {
                    for (int j = 0; j < cevaplar[i - 1].length(); j++) {
                        btnquiz[pre_h + j][pre_v].setBackgroundResource( R.drawable.anlikcerceve );
                    }
                }

            }
            if(positions[i][0] == 0){
                for(int j = 0; j < cevaplar[i].length(); j++) {
                    btnquiz[h_][v_ + j].setBackgroundResource(R.drawable.anlikcerceve );
                }
            }
            else if(positions[i][0] == 1){
                for(int j = 0; j < cevaplar[i].length(); j++){
                    btnquiz[h_+j][v_].setBackgroundResource(R.drawable.anlikcerceve );
                }
            }

        }  public void KelimeEkle() {

            int i = progress;
            int h_;
            int v_;


            h_ = positions[i][1];
            v_ = positions[i][2];

            //İngilizce Kelimeyi koy

            if (positions[i][0] == 0) {
                for (int j = 0; j < cevaplar[i].length(); j++) {
                    btnquiz[h_][v_ + j].setText( Character.toString( cevaplar[i].charAt( j ) ) );

                }
            } else if (positions[i][0] == 1) {
                for (int j = 0; j < cevaplar[i].length(); j++) {
                    btnquiz[h_ + j][v_].setText( Character.toString( cevaplar[i].charAt( j ) ) );
                }
            }

        }


        public void endGame() {
            //oyun bittiğinde düğmeleri devre dışı bırakır.
            input_edittext.setEnabled( false );
            btnInsert.setEnabled( false );
            Toast.makeText( this, "Tebrikler!", Toast.LENGTH_SHORT ).show();

            finish();
            //Buraya Yeni Bulmacalar Gelecek Oyun Bittikten Sonra
            Intent intent = new Intent( getApplicationContext(), LevelSecKolay.class );
            startActivity( intent );
        }






        public void onInsertClicked (View v) {


            String inputted;
            inputted = input_edittext.getText().toString().toUpperCase();

            if (progress < 27 ) {
                if (inputted.equals( cevaplar[progress] )) { //girilen kelime doğruysa
                    Toast.makeText( this, "Doğru!", Toast.LENGTH_SHORT ).show();

                    KelimeEkle();
                    clear =true;
                    if (progress < 26  )
                        progress++;

                    else
                        endGame();
                    textView2.setText( String.format( "Soru : %s", anlamlar[progress] ) );

                }

                else {

                    Toast.makeText(this, "Yanlış Kelime Girdiniz!", Toast.LENGTH_LONG).show();


                }
                if(progress<27)
                    BlockDegistir();
                if(clear)
                    input_edittext.setText("");



            }


        }  }

    public static class Kolay6 extends AppCompatActivity {
        int progress = 0;
        kolayKelimeler.kolay6Kelimeler words = new kolayKelimeler.kolay6Kelimeler();


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate( savedInstanceState );
            setContentView( R.layout.activity_game_kolay );

            input_edittext = findViewById( R.id.edittext_input );
            textView2 = findViewById( R.id.textView2 );
            btnInsert = findViewById( R.id.btnKelimeEkle );

            positions = words.getPositions();
            cevaplar = words.getWords();
            anlamlar = words.getMeans();

            textView2.append( anlamlar[progress] );
            PuzzleEkle();
            BlockDegistir();

        }



        public void PuzzleEkle() {

            ana_linearLayout =  findViewById( R.id.game_main_layout );
            sub_linearLayouts = new LinearLayout[oyunbuyuk_v];

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT );


            LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT );

            params.height = 80;
            params.weight = 1;
            params2.width = 80;
            params2.weight = 1;

            for (int i = 0; i < oyunbuyuk_v; i++) {
                for (int j = 0; j < oyunbuyuk_h; j++) {
                    btnquiz[i][j] = new Button( this );
                    btnquiz[i][j].setLayoutParams( params2 );
                    btnquiz[i][j].setClickable( false );
                    btnquiz[i][j].setPadding( 1, 1, 1, 1 );
                    btnquiz[i][j].setText( "" );

                }
            }
            for (int i = 0; i < sub_linearLayouts.length; i++) {
                sub_linearLayouts[i] = new LinearLayout( this );
                sub_linearLayouts[i].setOrientation( LinearLayout.HORIZONTAL );
                sub_linearLayouts[i].setWeightSum( oyunbuyuk_h );
                sub_linearLayouts[i].setLayoutParams( params );
                ana_linearLayout.addView( sub_linearLayouts[i] );
            }
            for (int i = 0; i < oyunbuyuk_v; i++) {
                for (int j = 0; j < oyunbuyuk_h; j++) {
                    sub_linearLayouts[i].addView( btnquiz[i][j] );
                }
            }

            int h1;
            int v1;

            for (int i = 0; i < cevaplar.length; i++) {

                h1 = positions[i][1];
                v1 = positions[i][2];

                if (positions[i][0] == 0) { // yatay kelimeler
                    for (int j = 0; j < cevaplar[i].length(); j++) {

                        btnquiz[h1][v1 + j].setText( " " );

                    }
                } else if (positions[i][0] == 1) { //dikey kelimeler
                    for (int j = 0; j < cevaplar[i].length(); j++) {

                        btnquiz[h1 + j][v1].setText( " " );
                    }
                }
            }
            for (int i = 0; i < oyunbuyuk_v; i++) {
                for (int j = 0; j < oyunbuyuk_h; j++) {
                    if (!btnquiz[i][j].getText().equals( "" ))
                        btnquiz[i][j].setBackgroundResource( R.drawable.sabitcerceve );

                    else
                        btnquiz[i][j].setBackgroundResource(R.drawable.btnquiz_bg_transparent );
                }
            }




        }
        public void BlockDegistir() {
            int i = progress;
            int h_ = positions[i][1];
            int v_ = positions[i][2];
            if (progress > 0) {
                int pre_h = positions[i - 1][1];
                int pre_v = positions[i - 1][2];
                if (positions[i - 1][0] == 0) {
                    for (int j = 0; j < cevaplar[i - 1].length(); j++) {
                        btnquiz[pre_h][pre_v + j].setBackgroundResource( R.drawable.anlikcerceve );
                    }
                }
                else if (positions[i - 1][0] == 1) {
                    for (int j = 0; j < cevaplar[i - 1].length(); j++) {
                        btnquiz[pre_h + j][pre_v].setBackgroundResource( R.drawable.anlikcerceve );
                    }
                }

            }
            if(positions[i][0] == 0){
                for(int j = 0; j < cevaplar[i].length(); j++) {
                    btnquiz[h_][v_ + j].setBackgroundResource(R.drawable.anlikcerceve );
                }
            }
            else if(positions[i][0] == 1){
                for(int j = 0; j < cevaplar[i].length(); j++){
                    btnquiz[h_+j][v_].setBackgroundResource(R.drawable.anlikcerceve );
                }
            }

        }  public void KelimeEkle() {

            int i = progress;
            int h_;
            int v_;


            h_ = positions[i][1];
            v_ = positions[i][2];

            //İngilizce Kelimeyi koy

            if (positions[i][0] == 0) {
                for (int j = 0; j < cevaplar[i].length(); j++) {
                    btnquiz[h_][v_ + j].setText( Character.toString( cevaplar[i].charAt( j ) ) );

                }
            } else if (positions[i][0] == 1) {
                for (int j = 0; j < cevaplar[i].length(); j++) {
                    btnquiz[h_ + j][v_].setText( Character.toString( cevaplar[i].charAt( j ) ) );
                }
            }

        }

        public void endGame() {
            //oyun bittiğinde düğmeleri devre dışı bırakır.
            input_edittext.setEnabled( false );
            btnInsert.setEnabled( false );
            Toast.makeText( this, "Tebrikler!", Toast.LENGTH_SHORT ).show();

            finish();
            //Buraya Yeni Bulmacalar Gelecek Oyun Bittikten Sonra
            Intent intent = new Intent( getApplicationContext(), LevelSecKolay.class );
            startActivity( intent );
        }






        public void onInsertClicked (View v) {


            String inputted;
            inputted = input_edittext.getText().toString().toUpperCase();

            if (progress < 27 ) {
                if (inputted.equals( cevaplar[progress] )) { //girilen kelime doğruysa
                    Toast.makeText( this, "Doğru!", Toast.LENGTH_SHORT ).show();

                    KelimeEkle();
                    clear =true;
                    if (progress < 26  )
                        progress++;

                    else
                        endGame();
                    textView2.setText( String.format( "Soru : %s", anlamlar[progress] ) );

                }

                else {

                    Toast.makeText(this, "Yanlış Kelime Girdiniz!", Toast.LENGTH_LONG).show();


                }
                if(progress<27)
                    BlockDegistir();
                if(clear)
                    input_edittext.setText("");



            }


        }   public void reklamaGir(View view) {
            if (progress < 27) {
                KelimeEkle();
                clear =true;
                if (progress < 26  )
                    progress++;

                else
                    endGame();
                textView2.setText( String.format( "Soru : %s", anlamlar[progress] ) );

                if(progress<27)
                    BlockDegistir();
                if(clear)
                    input_edittext.setText("");
            }
        }}

    public static class Kolay7 extends AppCompatActivity {
        int progress = 0;
        kolayKelimeler.kolay7Kelimeler words = new kolayKelimeler.kolay7Kelimeler();


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate( savedInstanceState );
            setContentView( R.layout.activity_game_kolay );

            input_edittext = findViewById( R.id.edittext_input );
            textView2 = findViewById( R.id.textView2 );
            btnInsert = findViewById( R.id.btnKelimeEkle );

            positions = words.getPositions();
            cevaplar = words.getWords();
            anlamlar = words.getMeans();

            textView2.append( anlamlar[progress] );
            PuzzleEkle();
            BlockDegistir();

        }



        public void PuzzleEkle() {

            ana_linearLayout =  findViewById( R.id.game_main_layout );
            sub_linearLayouts = new LinearLayout[oyunbuyuk_v];

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT );


            LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT );

            params.height = 80;
            params.weight = 1;
            params2.width = 80;
            params2.weight = 1;

            for (int i = 0; i < oyunbuyuk_v; i++) {
                for (int j = 0; j < oyunbuyuk_h; j++) {
                    btnquiz[i][j] = new Button( this );
                    btnquiz[i][j].setLayoutParams( params2 );
                    btnquiz[i][j].setClickable( false );
                    btnquiz[i][j].setPadding( 1, 1, 1, 1 );
                    btnquiz[i][j].setText( "" );

                }
            }
            for (int i = 0; i < sub_linearLayouts.length; i++) {
                sub_linearLayouts[i] = new LinearLayout( this );
                sub_linearLayouts[i].setOrientation( LinearLayout.HORIZONTAL );
                sub_linearLayouts[i].setWeightSum( oyunbuyuk_h );
                sub_linearLayouts[i].setLayoutParams( params );
                ana_linearLayout.addView( sub_linearLayouts[i] );
            }
            for (int i = 0; i < oyunbuyuk_v; i++) {
                for (int j = 0; j < oyunbuyuk_h; j++) {
                    sub_linearLayouts[i].addView( btnquiz[i][j] );
                }
            }

            int h1;
            int v1;

            for (int i = 0; i < cevaplar.length; i++) {

                h1 = positions[i][1];
                v1 = positions[i][2];

                if (positions[i][0] == 0) { // yatay kelimeler
                    for (int j = 0; j < cevaplar[i].length(); j++) {

                        btnquiz[h1][v1 + j].setText( " " );

                    }
                } else if (positions[i][0] == 1) { //dikey kelimeler
                    for (int j = 0; j < cevaplar[i].length(); j++) {

                        btnquiz[h1 + j][v1].setText( " " );
                    }
                }
            }
            for (int i = 0; i < oyunbuyuk_v; i++) {
                for (int j = 0; j < oyunbuyuk_h; j++) {
                    if (!btnquiz[i][j].getText().equals( "" ))
                        btnquiz[i][j].setBackgroundResource( R.drawable.sabitcerceve );

                    else
                        btnquiz[i][j].setBackgroundResource(R.drawable.btnquiz_bg_transparent );
                }
            }




        }public void BlockDegistir() {
            int i = progress;
            int h_ = positions[i][1];
            int v_ = positions[i][2];
            if (progress > 0) {
                int pre_h = positions[i - 1][1];
                int pre_v = positions[i - 1][2];
                if (positions[i - 1][0] == 0) {
                    for (int j = 0; j < cevaplar[i - 1].length(); j++) {
                        btnquiz[pre_h][pre_v + j].setBackgroundResource( R.drawable.anlikcerceve );
                    }
                }
                else if (positions[i - 1][0] == 1) {
                    for (int j = 0; j < cevaplar[i - 1].length(); j++) {
                        btnquiz[pre_h + j][pre_v].setBackgroundResource( R.drawable.anlikcerceve );
                    }
                }

            }
            if(positions[i][0] == 0){
                for(int j = 0; j < cevaplar[i].length(); j++) {
                    btnquiz[h_][v_ + j].setBackgroundResource(R.drawable.anlikcerceve );
                }
            }
            else if(positions[i][0] == 1){
                for(int j = 0; j < cevaplar[i].length(); j++){
                    btnquiz[h_+j][v_].setBackgroundResource(R.drawable.anlikcerceve );
                }
            }

        }
        public void KelimeEkle() {

            int i = progress;
            int h_;
            int v_;


            h_ = positions[i][1];
            v_ = positions[i][2];

            //İngilizce Kelimeyi koy

            if (positions[i][0] == 0) {
                for (int j = 0; j < cevaplar[i].length(); j++) {
                    btnquiz[h_][v_ + j].setText( Character.toString( cevaplar[i].charAt( j ) ) );

                }
            } else if (positions[i][0] == 1) {
                for (int j = 0; j < cevaplar[i].length(); j++) {
                    btnquiz[h_ + j][v_].setText( Character.toString( cevaplar[i].charAt( j ) ) );
                }
            }

        }


        public void endGame() {
            //oyun bittiğinde düğmeleri devre dışı bırakır.
            input_edittext.setEnabled( false );
            btnInsert.setEnabled( false );
            Toast.makeText( this, "Tebrikler!", Toast.LENGTH_SHORT ).show();

            finish();
            //Buraya Yeni Bulmacalar Gelecek Oyun Bittikten Sonra
            Intent intent = new Intent( getApplicationContext(), LevelSecKolay.class );
            startActivity( intent );
        }






        public void onInsertClicked (View v) {


            String inputted;
            inputted = input_edittext.getText().toString().toUpperCase();

            if (progress < 27 ) {
                if (inputted.equals( cevaplar[progress] )) { //girilen kelime doğruysa
                    Toast.makeText( this, "Doğru!", Toast.LENGTH_SHORT ).show();

                    KelimeEkle();
                    clear =true;
                    if (progress < 26  )
                        progress++;

                    else
                        endGame();
                    textView2.setText( String.format( "Soru : %s", anlamlar[progress] ) );

                }

                else {

                    Toast.makeText(this, "Yanlış Kelime Girdiniz!", Toast.LENGTH_LONG).show();


                }
                if(progress<27)
                    BlockDegistir();
                if(clear)
                    input_edittext.setText("");



            }


        }   }

    public static class Kolay8 extends AppCompatActivity {
        int progress = 0;
        kolayKelimeler.kolay8Kelimeler words = new kolayKelimeler.kolay8Kelimeler();



        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate( savedInstanceState );
            setContentView( R.layout.activity_game_kolay );

            input_edittext = findViewById( R.id.edittext_input );
            textView2 = findViewById( R.id.textView2 );
            btnInsert = findViewById( R.id.btnKelimeEkle );

            positions = words.getPositions();
            cevaplar = words.getWords();
            anlamlar = words.getMeans();

            textView2.append( anlamlar[progress] );
            PuzzleEkle();
            BlockDegistir();

        }



        public void PuzzleEkle() {

            ana_linearLayout =  findViewById( R.id.game_main_layout );
            sub_linearLayouts = new LinearLayout[oyunbuyuk_v];

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT );


            LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT );

            params.height = 80;
            params.weight = 1;
            params2.width = 80;
            params2.weight = 1;

            for (int i = 0; i < oyunbuyuk_v; i++) {
                for (int j = 0; j < oyunbuyuk_h; j++) {
                    btnquiz[i][j] = new Button( this );
                    btnquiz[i][j].setLayoutParams( params2 );
                    btnquiz[i][j].setClickable( false );
                    btnquiz[i][j].setPadding( 1, 1, 1, 1 );
                    btnquiz[i][j].setText( "" );

                }
            }
            for (int i = 0; i < sub_linearLayouts.length; i++) {
                sub_linearLayouts[i] = new LinearLayout( this );
                sub_linearLayouts[i].setOrientation( LinearLayout.HORIZONTAL );
                sub_linearLayouts[i].setWeightSum( oyunbuyuk_h );
                sub_linearLayouts[i].setLayoutParams( params );
                ana_linearLayout.addView( sub_linearLayouts[i] );
            }
            for (int i = 0; i < oyunbuyuk_v; i++) {
                for (int j = 0; j < oyunbuyuk_h; j++) {
                    sub_linearLayouts[i].addView( btnquiz[i][j] );
                }
            }

            int h1;
            int v1;

            for (int i = 0; i < cevaplar.length; i++) {

                h1 = positions[i][1];
                v1 = positions[i][2];

                if (positions[i][0] == 0) { // yatay kelimeler
                    for (int j = 0; j < cevaplar[i].length(); j++) {

                        btnquiz[h1][v1 + j].setText( " " );

                    }
                } else if (positions[i][0] == 1) { //dikey kelimeler
                    for (int j = 0; j < cevaplar[i].length(); j++) {

                        btnquiz[h1 + j][v1].setText( " " );
                    }
                }
            }
            for (int i = 0; i < oyunbuyuk_v; i++) {
                for (int j = 0; j < oyunbuyuk_h; j++) {
                    if (!btnquiz[i][j].getText().equals( "" ))
                        btnquiz[i][j].setBackgroundResource( R.drawable.sabitcerceve );

                    else
                        btnquiz[i][j].setBackgroundResource(R.drawable.btnquiz_bg_transparent );
                }
            }




        }public void BlockDegistir() {
            int i = progress;
            int h_ = positions[i][1];
            int v_ = positions[i][2];
            if (progress > 0) {
                int pre_h = positions[i - 1][1];
                int pre_v = positions[i - 1][2];
                if (positions[i - 1][0] == 0) {
                    for (int j = 0; j < cevaplar[i - 1].length(); j++) {
                        btnquiz[pre_h][pre_v + j].setBackgroundResource( R.drawable.anlikcerceve );
                    }
                }
                else if (positions[i - 1][0] == 1) {
                    for (int j = 0; j < cevaplar[i - 1].length(); j++) {
                        btnquiz[pre_h + j][pre_v].setBackgroundResource( R.drawable.anlikcerceve );
                    }
                }

            }
            if(positions[i][0] == 0){
                for(int j = 0; j < cevaplar[i].length(); j++) {
                    btnquiz[h_][v_ + j].setBackgroundResource(R.drawable.anlikcerceve );
                }
            }
            else if(positions[i][0] == 1){
                for(int j = 0; j < cevaplar[i].length(); j++){
                    btnquiz[h_+j][v_].setBackgroundResource(R.drawable.anlikcerceve );
                }
            }

        }  public void KelimeEkle() {

            int i = progress;
            int h_;
            int v_;


            h_ = positions[i][1];
            v_ = positions[i][2];

            //İngilizce Kelimeyi koy

            if (positions[i][0] == 0) {
                for (int j = 0; j < cevaplar[i].length(); j++) {
                    btnquiz[h_][v_ + j].setText( Character.toString( cevaplar[i].charAt( j ) ) );

                }
            } else if (positions[i][0] == 1) {
                for (int j = 0; j < cevaplar[i].length(); j++) {
                    btnquiz[h_ + j][v_].setText( Character.toString( cevaplar[i].charAt( j ) ) );
                }
            }

        }




        public void endGame() {
            //oyun bittiğinde düğmeleri devre dışı bırakır.
            input_edittext.setEnabled( false );
            btnInsert.setEnabled( false );
            Toast.makeText( this, "Tebrikler!", Toast.LENGTH_SHORT ).show();


            finish();
            //Buraya Yeni Bulmacalar Gelecek Oyun Bittikten Sonra
            Intent intent = new Intent( getApplicationContext(), LevelSecKolay.class );
            startActivity( intent );
        }






        public void onInsertClicked (View v) {

            String inputted;
            inputted = input_edittext.getText().toString().toUpperCase();

            if (progress < 27 ) {
                if (inputted.equals( cevaplar[progress] )) { //girilen kelime doğruysa
                    Toast.makeText( this, "Doğru!", Toast.LENGTH_SHORT ).show();

                    KelimeEkle();
                    clear =true;
                    if (progress < 26  )
                        progress++;

                    else
                        endGame();
                    textView2.setText( String.format( "Soru : %s", anlamlar[progress] ) );

                }

                else {

                    Toast.makeText(this, "Yanlış Kelime Girdiniz!", Toast.LENGTH_LONG).show();


                }
                if(progress<27)
                    BlockDegistir();
                if(clear)
                    input_edittext.setText("");



            }


        }  }

    public static class Kolay9 extends AppCompatActivity {
        int progress = 0;
        kolayKelimeler.kolay9Kelimeler words = new kolayKelimeler.kolay9Kelimeler();



        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate( savedInstanceState );
            setContentView( R.layout.activity_game_kolay );

            input_edittext = findViewById( R.id.edittext_input );
            textView2 = findViewById( R.id.textView2 );
            btnInsert = findViewById( R.id.btnKelimeEkle );

            positions = words.getPositions();
            cevaplar = words.getWords();
            anlamlar = words.getMeans();

            textView2.append( anlamlar[progress] );
            PuzzleEkle();
            BlockDegistir();

        }



        public void PuzzleEkle() {

            ana_linearLayout =  findViewById( R.id.game_main_layout );
            sub_linearLayouts = new LinearLayout[oyunbuyuk_v];

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT );


            LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT );

            params.height = 80;
            params.weight = 1;
            params2.width = 80;
            params2.weight = 1;

            for (int i = 0; i < oyunbuyuk_v; i++) {
                for (int j = 0; j < oyunbuyuk_h; j++) {
                    btnquiz[i][j] = new Button( this );
                    btnquiz[i][j].setLayoutParams( params2 );
                    btnquiz[i][j].setClickable( false );
                    btnquiz[i][j].setPadding( 1, 1, 1, 1 );
                    btnquiz[i][j].setText( "" );

                }
            }
            for (int i = 0; i < sub_linearLayouts.length; i++) {
                sub_linearLayouts[i] = new LinearLayout( this );
                sub_linearLayouts[i].setOrientation( LinearLayout.HORIZONTAL );
                sub_linearLayouts[i].setWeightSum( oyunbuyuk_h );
                sub_linearLayouts[i].setLayoutParams( params );
                ana_linearLayout.addView( sub_linearLayouts[i] );
            }
            for (int i = 0; i < oyunbuyuk_v; i++) {
                for (int j = 0; j < oyunbuyuk_h; j++) {
                    sub_linearLayouts[i].addView( btnquiz[i][j] );
                }
            }

            int h1;
            int v1;

            for (int i = 0; i < cevaplar.length; i++) {

                h1 = positions[i][1];
                v1 = positions[i][2];

                if (positions[i][0] == 0) { // yatay kelimeler
                    for (int j = 0; j < cevaplar[i].length(); j++) {

                        btnquiz[h1][v1 + j].setText( " " );

                    }
                } else if (positions[i][0] == 1) { //dikey kelimeler
                    for (int j = 0; j < cevaplar[i].length(); j++) {

                        btnquiz[h1 + j][v1].setText( " " );
                    }
                }
            }
            for (int i = 0; i < oyunbuyuk_v; i++) {
                for (int j = 0; j < oyunbuyuk_h; j++) {
                    if (!btnquiz[i][j].getText().equals( "" ))
                        btnquiz[i][j].setBackgroundResource( R.drawable.sabitcerceve );

                    else
                        btnquiz[i][j].setBackgroundResource(R.drawable.btnquiz_bg_transparent );
                }
            }




        }public void BlockDegistir() {
            int i = progress;
            int h_ = positions[i][1];
            int v_ = positions[i][2];
            if (progress > 0) {
                int pre_h = positions[i - 1][1];
                int pre_v = positions[i - 1][2];
                if (positions[i - 1][0] == 0) {
                    for (int j = 0; j < cevaplar[i - 1].length(); j++) {
                        btnquiz[pre_h][pre_v + j].setBackgroundResource( R.drawable.anlikcerceve );
                    }
                }
                else if (positions[i - 1][0] == 1) {
                    for (int j = 0; j < cevaplar[i - 1].length(); j++) {
                        btnquiz[pre_h + j][pre_v].setBackgroundResource( R.drawable.anlikcerceve );
                    }
                }

            }
            if(positions[i][0] == 0){
                for(int j = 0; j < cevaplar[i].length(); j++) {
                    btnquiz[h_][v_ + j].setBackgroundResource(R.drawable.anlikcerceve );
                }
            }
            else if(positions[i][0] == 1){
                for(int j = 0; j < cevaplar[i].length(); j++){
                    btnquiz[h_+j][v_].setBackgroundResource(R.drawable.anlikcerceve );
                }
            }

        }
        public void KelimeEkle() {

            int i = progress;
            int h_;
            int v_;


            h_ = positions[i][1];
            v_ = positions[i][2];

            //İngilizce Kelimeyi koy

            if (positions[i][0] == 0) {
                for (int j = 0; j < cevaplar[i].length(); j++) {
                    btnquiz[h_][v_ + j].setText( Character.toString( cevaplar[i].charAt( j ) ) );

                }
            } else if (positions[i][0] == 1) {
                for (int j = 0; j < cevaplar[i].length(); j++) {
                    btnquiz[h_ + j][v_].setText( Character.toString( cevaplar[i].charAt( j ) ) );
                }
            }

        }

        public void endGame() {
            //oyun bittiğinde düğmeleri devre dışı bırakır.
            input_edittext.setEnabled( false );
            btnInsert.setEnabled( false );
            Toast.makeText( this, "Tebrikler!", Toast.LENGTH_SHORT ).show();

            finish();
            //Buraya Yeni Bulmacalar Gelecek Oyun Bittikten Sonra
            Intent intent = new Intent( getApplicationContext(), LevelSecKolay.class );
            startActivity( intent );
        }






        public void onInsertClicked (View v) {


            String inputted;
            inputted = input_edittext.getText().toString().toUpperCase();

            if (progress < 27 ) {
                if (inputted.equals( cevaplar[progress] )) { //girilen kelime doğruysa
                    Toast.makeText( this, "Doğru!", Toast.LENGTH_SHORT ).show();

                    KelimeEkle();
                    clear =true;
                    if (progress < 26  )
                        progress++;

                    else
                        endGame();
                    textView2.setText( String.format( "Soru : %s", anlamlar[progress] ) );

                }

                else {
                    Toast.makeText(this, "Yanlış Kelime Girdiniz!", Toast.LENGTH_LONG).show();


                }
                if(progress<27)
                    BlockDegistir();
                if(clear)
                    input_edittext.setText("");



            }


        }   }

    public static class Kolay10 extends AppCompatActivity {
        int progress = 0;
        kolayKelimeler.kolay10Kelimeler words = new kolayKelimeler.kolay10Kelimeler();



        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate( savedInstanceState );
            setContentView( R.layout.activity_game_kolay );

            input_edittext = findViewById( R.id.edittext_input );
            textView2 = findViewById( R.id.textView2 );
            btnInsert = findViewById( R.id.btnKelimeEkle );

            positions = words.getPositions();
            cevaplar = words.getWords();
            anlamlar = words.getMeans();

            textView2.append( anlamlar[progress] );
            PuzzleEkle();
            BlockDegistir();

        }



        public void PuzzleEkle() {

            ana_linearLayout =  findViewById( R.id.game_main_layout );
            sub_linearLayouts = new LinearLayout[oyunbuyuk_v];

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT );


            LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT );

            params.height = 80;
            params.weight = 1;
            params2.width = 80;
            params2.weight = 1;

            for (int i = 0; i < oyunbuyuk_v; i++) {
                for (int j = 0; j < oyunbuyuk_h; j++) {
                    btnquiz[i][j] = new Button( this );
                    btnquiz[i][j].setLayoutParams( params2 );
                    btnquiz[i][j].setClickable( false );
                    btnquiz[i][j].setPadding( 1, 1, 1, 1 );
                    btnquiz[i][j].setText( "" );

                }
            }
            for (int i = 0; i < sub_linearLayouts.length; i++) {
                sub_linearLayouts[i] = new LinearLayout( this );
                sub_linearLayouts[i].setOrientation( LinearLayout.HORIZONTAL );
                sub_linearLayouts[i].setWeightSum( oyunbuyuk_h );
                sub_linearLayouts[i].setLayoutParams( params );
                ana_linearLayout.addView( sub_linearLayouts[i] );
            }
            for (int i = 0; i < oyunbuyuk_v; i++) {
                for (int j = 0; j < oyunbuyuk_h; j++) {
                    sub_linearLayouts[i].addView( btnquiz[i][j] );
                }
            }

            int h1;
            int v1;

            for (int i = 0; i < cevaplar.length; i++) {

                h1 = positions[i][1];
                v1 = positions[i][2];

                if (positions[i][0] == 0) { // yatay kelimeler
                    for (int j = 0; j < cevaplar[i].length(); j++) {

                        btnquiz[h1][v1 + j].setText( " " );

                    }
                } else if (positions[i][0] == 1) { //dikey kelimeler
                    for (int j = 0; j < cevaplar[i].length(); j++) {

                        btnquiz[h1 + j][v1].setText( " " );
                    }
                }
            }
            for (int i = 0; i < oyunbuyuk_v; i++) {
                for (int j = 0; j < oyunbuyuk_h; j++) {
                    if (!btnquiz[i][j].getText().equals( "" ))
                        btnquiz[i][j].setBackgroundResource( R.drawable.sabitcerceve );

                    else
                        btnquiz[i][j].setBackgroundResource(R.drawable.btnquiz_bg_transparent );
                }
            }




        }public void BlockDegistir() {
            int i = progress;
            int h_ = positions[i][1];
            int v_ = positions[i][2];
            if (progress > 0) {
                int pre_h = positions[i - 1][1];
                int pre_v = positions[i - 1][2];
                if (positions[i - 1][0] == 0) {
                    for (int j = 0; j < cevaplar[i - 1].length(); j++) {
                        btnquiz[pre_h][pre_v + j].setBackgroundResource( R.drawable.anlikcerceve );
                    }
                }
                else if (positions[i - 1][0] == 1) {
                    for (int j = 0; j < cevaplar[i - 1].length(); j++) {
                        btnquiz[pre_h + j][pre_v].setBackgroundResource( R.drawable.anlikcerceve );
                    }
                }

            }
            if(positions[i][0] == 0){
                for(int j = 0; j < cevaplar[i].length(); j++) {
                    btnquiz[h_][v_ + j].setBackgroundResource(R.drawable.anlikcerceve );
                }
            }
            else if(positions[i][0] == 1){
                for(int j = 0; j < cevaplar[i].length(); j++){
                    btnquiz[h_+j][v_].setBackgroundResource(R.drawable.anlikcerceve );
                }
            }

        }
        public void KelimeEkle() {

            int i = progress;
            int h_;
            int v_;


            h_ = positions[i][1];
            v_ = positions[i][2];

            //İngilizce Kelimeyi koy

            if (positions[i][0] == 0) {
                for (int j = 0; j < cevaplar[i].length(); j++) {
                    btnquiz[h_][v_ + j].setText( Character.toString( cevaplar[i].charAt( j ) ) );

                }
            } else if (positions[i][0] == 1) {
                for (int j = 0; j < cevaplar[i].length(); j++) {
                    btnquiz[h_ + j][v_].setText( Character.toString( cevaplar[i].charAt( j ) ) );
                }
            }

        }

        public void endGame() {
            //oyun bittiğinde düğmeleri devre dışı bırakır.
            input_edittext.setEnabled( false );
            btnInsert.setEnabled( false );


            finish();
            //Buraya Yeni Bulmacalar Gelecek Oyun Bittikten Sonra
            Intent intent = new Intent( getApplicationContext(), MainActivity.class );
            startActivity( intent );
        }






        public void onInsertClicked (View v) {


            String inputted;
            inputted = input_edittext.getText().toString().toUpperCase();

            if (progress < 27 ) {
                if (inputted.equals( cevaplar[progress] )) { //girilen kelime doğruysa
                    Toast.makeText( this, "Doğru!", Toast.LENGTH_SHORT ).show();

                    KelimeEkle();
                    clear =true;
                    if (progress < 26  )
                        progress++;

                    else
                        endGame();
                    textView2.setText( String.format( "Soru : %s", anlamlar[progress] ) );
                }
                else {
                    Toast.makeText(this, "Yanlış Kelime Girdiniz!", Toast.LENGTH_LONG).show();

                }
                if(progress<27)
                    BlockDegistir();
                if(clear)
                    input_edittext.setText("");

            }

        }  }

}

