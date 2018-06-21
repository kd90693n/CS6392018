package com.example.kevin.asynctaskproject;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        new birthImage().execute("https://raw.githubusercontent.com/kd90693n/CS6392018/master/3.png");

    }


    public class birthImage extends AsyncTask<String, Void, Bitmap> {

        ImageView imgView = (ImageView) findViewById(R.id.imageView);

        @Override
        protected Bitmap doInBackground(String... params) {

            String imgURL = params[0];

            Bitmap bitmap = null;
            try {
                URL url = new URL(imgURL);
                HttpURLConnection con = (HttpURLConnection)url.openConnection();
                if(con.getResponseCode() != 200){
                    throw new Exception("Failed to connect");
                }
                InputStream is = con.getInputStream();
                bitmap = BitmapFactory.decodeStream(is);
                is.close();
            } catch (Exception e){
                Log.e("Image", "Failed to Load Image", e);
                Log.e("Error", e.getMessage());
            }

            return bitmap;

        }

        protected void onPostExecute(Bitmap bitmap) {
            imgView.setImageBitmap(bitmap);
        }
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
        }

        return super.onOptionsItemSelected(item);
    }

}
