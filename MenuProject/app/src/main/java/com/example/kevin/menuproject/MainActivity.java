package com.example.kevin.menuproject;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        */
    }

    public void viewNewActivity(View view) {
        Intent intent = new Intent(this, NewActivity.class);
        String message = "Hello, Kevin Delgado";
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    public void composeMmsMessage(View view) {
        String message = "Kevin Delgado";
        final Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("smsto:" + Uri.encode("6465415542")));
        intent.putExtra("sms_body", message);
        startActivity(intent);
    }

    public void callPhone(View view) {
        final Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + Uri.encode("6465415542")));
        startActivity(intent);
    }

    public void visitWebsite(View view) {
        final Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://www.rightstufanime.com/"));
        startActivity(intent);
    }

    public void viewMapLoc(View view) {
        String geoUri = "geo:40.8191336,-73.9270853";
        Uri geo = Uri.parse(geoUri);
        final Intent intent = new Intent(Intent.ACTION_VIEW, geo);
        startActivity(intent);
    }

    public void shareMessage(View view) {
        final Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT, "Kevin Delgado");
        intent.putExtra(Intent.EXTRA_TEXT, "MenuProject");
        startActivity(Intent.createChooser(intent,"Share the love"));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
        } if (id == R.id.action_help) {
        Intent intent = new Intent(this, HelpActivity.class);
        String message = "Welcome to the Help Center";
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

        return super.onOptionsItemSelected(item);
    }
}
