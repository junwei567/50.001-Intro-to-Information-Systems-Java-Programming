package com.example.norman_lee.comicapp;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    EditText editTextComicNo;
    Button buttonGetComic;
    TextView textViewTitle;
    ImageView imageViewComic;

    String comicNo;
    public static final String TAG = "Logcat";
    final String ERROR_NO_NETWORK = "No Network";
    final String ERROR_NOT_VALID = "Comic No Not Valid";
    final String ERROR_MALFORMED_URL = "Malformed URL";
    final String ERROR_BAD_JSON = "Bad JSON Response";
    final String ERROR_HTTPS_ERROR = "HTTPS Error";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextComicNo = findViewById(R.id.editTextComicNo);
        buttonGetComic = findViewById(R.id.buttonGetComic);
        textViewTitle = findViewById(R.id.textViewTitle);
        imageViewComic = findViewById(R.id.imageViewComic);

        buttonGetComic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (editTextComicNo.getText().toString().equals("")) {
                    Log.i("PLEASE","It is empty");
                    Toast.makeText( MainActivity.this, "Please enter a number", Toast.LENGTH_LONG).show();
                } else {
                    GetComic runner = new GetComic();
                    String comicNo = editTextComicNo.getText().toString();
                    runner.execute(comicNo);
                }
            }
        });
    }
    class GetComic extends AsyncTask<String, String, Bitmap> {
        @Override
        protected Bitmap doInBackground(String... s) {
            publishProgress("Getting comic... ");
            Bitmap bitmap = null;
            try {
                String imagestr = Utils.getImageURLFromXkcdApi(s[0]);
                URL url = new URL(imagestr);
//                bitmap = getBitmapFromString(url);
                bitmap = Utils.getBitmap(url);

            } catch ( IOException ex) {
                ex.printStackTrace();
            } catch ( JSONException ex) {
                ex.printStackTrace();
            }
            return bitmap;
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
            int count = values.length;
            for (int i = 0; i < count; i++) {
                publishProgress( String.valueOf((i / (float) count ) * 100) );
            }
            textViewTitle.setText(values[0]);
        }
        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            imageViewComic.setImageBitmap(bitmap);
        }
    }

    private Bitmap getBitmapFromString (String url) {
        byte[] decodedString = Base64.decode(url, Base64.DEFAULT);
        Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
        return decodedByte;
    }


}
