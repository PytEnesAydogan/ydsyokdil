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


public class Zor extends AppCompatActivity {

    public static final int oyunbuyuk_h = 15;
    public static final int oyunbuyuk_v = 11;
    public static boolean clear = false;
    public static int progress = 0;
    public static boolean pause = false;
    public static String[] cevaplar;
    public static String[] anlamlar;
    public static int[][] positions;
    zorKelimeler words = new zorKelimeler();


    static LinearLayout ana_linearLayout;
    static LinearLayout[] sub_linearLayouts;

    static Button[][] btnquiz = new Button[oyunbuyuk_v][oyunbuyuk_h];


    public static EditText input_edittext;
    public static TextView textView2;

    public static Button btnInsert;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_game_zor );

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

    public static void BlockDegistir() {
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

    public static void KelimeEkle() {

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
        Intent intent = new Intent( getApplicationContext(), Zor2.class );
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

    public static class Zor2 extends AppCompatActivity {

        zorKelimeler.zor2Kelimeler words = new zorKelimeler.zor2Kelimeler();


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate( savedInstanceState );
            setContentView( R.layout.activity_game_zor );

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

        public void endGame() {
            //oyun bittiğinde düğmeleri devre dışı bırakır.

            input_edittext.setEnabled( false );
            btnInsert.setEnabled( false );


            finish();
            //Buraya Yeni Bulmacalar Gelecek Oyun Bittikten Sonra
            Intent intent = new Intent( getApplicationContext(), Zor3.class );
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

    public static class Zor3 extends AppCompatActivity {

        zorKelimeler.zor3Kelimeler words = new zorKelimeler.zor3Kelimeler();

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate( savedInstanceState );
            setContentView( R.layout.activity_game_zor );

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

        public void endGame() {
            //oyun bittiğinde düğmeleri devre dışı bırakır.
            input_edittext.setEnabled( false );
            btnInsert.setEnabled( false );


            finish();
            //Buraya Yeni Bulmacalar Gelecek Oyun Bittikten Sonra
            Intent intent = new Intent( getApplicationContext(), Zor4.class );
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

    public static class Zor4 extends AppCompatActivity {


        zorKelimeler.zor4Kelimeler words = new zorKelimeler.zor4Kelimeler();


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate( savedInstanceState );
            setContentView( R.layout.activity_game_zor );

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


        public void endGame() {
            //oyun bittiğinde düğmeleri devre dışı bırakır.
            input_edittext.setEnabled( false );
            btnInsert.setEnabled( false );


            finish();
            //Buraya Yeni Bulmacalar Gelecek Oyun Bittikten Sonra
            Intent intent = new Intent( getApplicationContext(), Zor5.class );
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

    public static class Zor5 extends AppCompatActivity {

        zorKelimeler.zor5Kelimeler words = new zorKelimeler.zor5Kelimeler();

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate( savedInstanceState );
            setContentView( R.layout.activity_game_zor );

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


        public void endGame() {
            //oyun bittiğinde düğmeleri devre dışı bırakır.
            input_edittext.setEnabled( false );
            btnInsert.setEnabled( false );


            finish();
            //Buraya Yeni Bulmacalar Gelecek Oyun Bittikten Sonra
            Intent intent = new Intent( getApplicationContext(), Zor6.class );
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

    public static class Zor6 extends AppCompatActivity {


        zorKelimeler.zor6Kelimeler words = new zorKelimeler.zor6Kelimeler();


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate( savedInstanceState );
            setContentView( R.layout.activity_game_zor );

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

        public void endGame() {
            //oyun bittiğinde düğmeleri devre dışı bırakır.
            input_edittext.setEnabled( false );
            btnInsert.setEnabled( false );


            finish();
            //Buraya Yeni Bulmacalar Gelecek Oyun Bittikten Sonra
            Intent intent = new Intent( getApplicationContext(), Zor7.class );
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

    public static class Zor7 extends AppCompatActivity {


        zorKelimeler.zor7Kelimeler words = new zorKelimeler.zor7Kelimeler();


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate( savedInstanceState );
            setContentView( R.layout.activity_game_zor );

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


        public void endGame() {
            //oyun bittiğinde düğmeleri devre dışı bırakır.
            input_edittext.setEnabled( false );
            btnInsert.setEnabled( false );


            finish();
            //Buraya Yeni Bulmacalar Gelecek Oyun Bittikten Sonra
            Intent intent = new Intent( getApplicationContext(), Zor8.class );
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

    public static class Zor8 extends AppCompatActivity {


        zorKelimeler.zor8Kelimeler words = new zorKelimeler.zor8Kelimeler();

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate( savedInstanceState );
            setContentView( R.layout.activity_game_zor );

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

        public void endGame() {
            //oyun bittiğinde düğmeleri devre dışı bırakır.
            input_edittext.setEnabled( false );
            btnInsert.setEnabled( false );


            finish();
            //Buraya Yeni Bulmacalar Gelecek Oyun Bittikten Sonra
            Intent intent = new Intent( getApplicationContext(), Zor9.class );
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

    public static class Zor9 extends AppCompatActivity {


        zorKelimeler.zor9Kelimeler words = new zorKelimeler.zor9Kelimeler();


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate( savedInstanceState );
            setContentView( R.layout.activity_game_zor );

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

        public void endGame() {
            //oyun bittiğinde düğmeleri devre dışı bırakır.
            input_edittext.setEnabled( false );
            btnInsert.setEnabled( false );


            finish();
            //Buraya Yeni Bulmacalar Gelecek Oyun Bittikten Sonra
            Intent intent = new Intent( getApplicationContext(), Zor10.class );
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

    public static class Zor10 extends AppCompatActivity {


        zorKelimeler.zor10Kelimeler words = new zorKelimeler.zor10Kelimeler();


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate( savedInstanceState );
            setContentView( R.layout.activity_game_zor );

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


        public void endGame() {
            //oyun bittiğinde düğmeleri devre dışı bırakır.
            input_edittext.setEnabled( false );
            btnInsert.setEnabled( false );


            finish();
            //Buraya Yeni Bulmacalar Gelecek Oyun Bittikten Sonra
            Intent intent = new Intent( getApplicationContext(), MainActivity.class );
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
}