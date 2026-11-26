package com.pud.ipud2;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import androidx.core.content.FileProvider;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

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
                int resourceId = R.raw.thanks;
                MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), resourceId);
                mediaPlayer.start(); // no need to call prepare(); create() does that for you
                // Perform action on click


            }
        });

        final Button pudalachButton = (Button) findViewById(R.id.PudalachBtnId);
        pudalachButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int resourceId = R.raw.pudalach;
                MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), resourceId);
                mediaPlayer.start(); // no need to call prepare(); create() does that for you
                // Perform action on click


            }
        });
        //PudalachBtnId

        thanksButton.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                int resourceId = R.raw.thanks;
                shareSound(resourceId);
                return false;
            }
        });


        final Button foodButton = (Button) findViewById(R.id.FoodBtnId);
        foodButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int resourceId = R.raw.food;
                MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), resourceId);
                mediaPlayer.start(); // no need to call prepare(); create() does that for you
                // Perform action on click

            }
        });


        foodButton.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                int resourceId = R.raw.food;
                shareSound(resourceId);
                return false;
            }
        });


        final Button pleaseButton = (Button) findViewById(R.id.PleaseBtnId);
        pleaseButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int resourceId = R.raw.please;
                MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), resourceId);
                mediaPlayer.start(); // no need to call prepare(); create() does that for you
                // Perform action on click

            }
        });


        pleaseButton.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                int resourceId = R.raw.please;
                shareSound(resourceId);
                return false;
            }
        });



        final Button firePallButton = (Button) findViewById(R.id.firePalllBtnId);

        firePallButton.setOnClickListener(new View.OnClickListener() {
            boolean isPlaying =false;
            int resourceId = R.raw.firepall;
            final MediaPlayer firePallmediaPlayer = MediaPlayer.create(getApplicationContext(), resourceId);
            public void onClick(View v) {


                if(!isPlaying){
                    firePallmediaPlayer.start();
                    ((Button)v).setText(R.string.stopFirePallTxt);
                    isPlaying = true;
                }else{
                    isPlaying = false;
                    firePallmediaPlayer.stop();
                    ((Button)v).setText("עמוד האש");
                    try {
                        firePallmediaPlayer.prepare();
                    } catch (IOException e) {
                        Log.e("STOP", e.getMessage());
                    }
                }

            }
        });


        firePallButton.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                int resourceId = R.raw.firepall;
                shareSound(resourceId);
                return false;
            }
        });



        final Button heliButton = (Button) findViewById(R.id.heliBtnId);
        heliButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int resourceId = R.raw.heli;
                MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), resourceId);
                mediaPlayer.start();

            }
        });


        heliButton.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                int resourceId = R.raw.heli;
                shareSound(resourceId);
                return false;
            }
        });


        final Button casperButton = (Button) findViewById(R.id.casperBtnId);
        casperButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int resourceId = R.raw.cat;
                MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), resourceId);
                mediaPlayer.start();

            }
        });

        casperButton.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                int resourceId = R.raw.cat;
                shareSound(resourceId);
                return false;
            }
        });


        final Button tocButton = (Button) findViewById(R.id.tocBtnId);
        tocButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int resourceId = R.raw.toc;
                MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), resourceId);
                mediaPlayer.start();

            }
        });

        tocButton.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                int resourceId = R.raw.toc;
                shareSound(resourceId);
                return false;
            }
        });

        final Button meatLessButton = (Button) findViewById(R.id.MeatLessBtnId);
        meatLessButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int resourceId = R.raw.meatless;
                MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), resourceId);
                mediaPlayer.start();

            }
        });

        meatLessButton.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                int resourceId = R.raw.meatless;
                shareSound(resourceId);
                return false;
            }
        });


        MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.ipud);
        mediaPlayer.start();
    }

    private void shareSound(int resourceId) {
        File shareDirectory = new File(getCacheDir(), "shared_audio");
        if (!shareDirectory.exists() && !shareDirectory.mkdirs()) {
            Toast.makeText(this, R.string.share_failed, Toast.LENGTH_SHORT).show();
            return;
        }

        File audioFile = new File(
                shareDirectory, getResources().getResourceEntryName(resourceId) + ".mp3");
        try (InputStream input = getResources().openRawResource(resourceId);
             FileOutputStream output = new FileOutputStream(audioFile)) {
            byte[] buffer = new byte[8192];
            int bytesRead;
            while ((bytesRead = input.read(buffer)) != -1) {
                output.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            Log.e("IpudActivity", "Unable to prepare audio for sharing", e);
            Toast.makeText(this, R.string.share_failed, Toast.LENGTH_SHORT).show();
            return;
        }

        Uri audioUri = FileProvider.getUriForFile(
                this, getPackageName() + ".fileprovider", audioFile);
        Intent sendIntent = new Intent(Intent.ACTION_SEND);
        sendIntent.setType("audio/mpeg");
        sendIntent.putExtra(Intent.EXTRA_STREAM, audioUri);
        sendIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        startActivity(Intent.createChooser(sendIntent, null));
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
