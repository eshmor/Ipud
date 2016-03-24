package com.pud.ipud2;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import java.io.IOException;

public class IpudActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ipud);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        final Button thanksButton = (Button) findViewById(R.id.ThanksBtnId);
        thanksButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.thanks);
                mediaPlayer.start(); // no need to call prepare(); create() does that for you
                // Perform action on click
            }
        });

        final Button foodButton = (Button) findViewById(R.id.FoodBtnId);
        foodButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.food);
                mediaPlayer.start(); // no need to call prepare(); create() does that for you
                // Perform action on click
            }
        });






        final Button firePallButton = (Button) findViewById(R.id.firePalllBtnId);
        firePallButton.setOnClickListener(new View.OnClickListener() {
            boolean isPlaying =false;
            final MediaPlayer firePallmediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.firepall);
            public void onClick(View v) {


                if(!isPlaying){
                    firePallmediaPlayer.start();
                    ((Button)v).setText(R.string.stopFirePallTxt);
                    isPlaying = true;
                }else{
                    isPlaying = false;
                    firePallmediaPlayer.stop();
                    ((Button)v).setText(R.string.firePallTxt);
                    try {
                        firePallmediaPlayer.prepare();
                    } catch (IOException e) {
                        Log.e("STOP", e.getMessage());
                    }
                }

            }
        });






        final Button heliButton = (Button) findViewById(R.id.heliBtnId);
        heliButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.heli);
                mediaPlayer.start();            }
        });



        final Button casperButton = (Button) findViewById(R.id.casperBtnId);
        casperButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.cat);
                mediaPlayer.start();            }
        });



        final Button tocButton = (Button) findViewById(R.id.tocBtnId);
        tocButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.toc);
                mediaPlayer.start();            }
        });

        MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.ipud);
        mediaPlayer.start();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_ipud, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
