package com.pud.ipud2;

import android.Manifest;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class IpudActivity extends AppCompatActivity {

    private static final int EXTERNAL_STORAGE_REQUEST_CODE = 123;
    public boolean saveAs(int resSoundId) {
        byte[] buffer = null;
        InputStream fIn = getBaseContext().getResources().openRawResource(resSoundId);
        int size = 0;

        try {
            size = fIn.available();
            buffer = new byte[size];
            fIn.read(buffer);
            fIn.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            return false;
        }

        String path = Environment.getExternalStorageDirectory().getAbsolutePath()+"/yourapp/temp/";
        String filename = getResources().getResourceEntryName(resSoundId) + ".mp3";

        boolean exists = (new File(path)).exists();
        if (!exists) {
            new File(path).mkdirs();
        }

        FileOutputStream save;
        try {
            save = new FileOutputStream(path + filename);
            save.write(buffer);
            save.flush();
            save.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            return false;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            return false;
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ipud);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED || ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE}, EXTERNAL_STORAGE_REQUEST_CODE);
        } else {
            createDirectory();
        }


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
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);

        sendIntent.setType("audio/mp3");
        String resourceScheme = "res";

        saveAs(resourceId);
        String path = Environment.getExternalStorageDirectory().getAbsolutePath()+"/yourapp/temp/";
        String filename = getResources().getResourceEntryName(resourceId) + ".mp3";

        Uri uri1 = Uri.parse(path + filename);
        sendIntent.putExtra(Intent.EXTRA_STREAM,uri1 );
        startActivity(sendIntent);
    }

    private void createDirectory() {
        String path = Environment.getExternalStorageDirectory().getAbsolutePath()+"/yourapp/temp/";

        boolean exists = (new File(path)).exists();
        if (!exists) {
            new File(path).mkdirs();
        }

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
