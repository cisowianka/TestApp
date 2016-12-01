package com.example.user.testapp;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONObject;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class FullscreenActivity extends AppCompatActivity {
    /**
     * Whether or not the system UI should be auto-hidden after
     * {@link #AUTO_HIDE_DELAY_MILLIS} milliseconds.
     */
    private static final boolean AUTO_HIDE = true;

    /**
     * If {@link #AUTO_HIDE} is set, the number of milliseconds to wait after
     * user interaction before hiding the system UI.
     */
    private static final int AUTO_HIDE_DELAY_MILLIS = 3000;

    /**
     * Some older devices needs a small delay between UI widget updates
     * and a change of the status and navigation bar.
     */
    private static final int UI_ANIMATION_DELAY = 300;
    private final Handler mHideHandler = new Handler();
    private View mContentView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_fullscreen);

        Button button = (Button) findViewById(R.id.button1);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.e("+++++", "+++ ON CREATE +++");


                RequestParams params = new RequestParams();
                params.put("key", "value");
                params.put("more", "data");
//                client.get("http://www.google.com", params, new TextHttpResponseHandler() {
//                            @Override
//                            public void onSuccess(int statusCode, Header[] headers, String res) {
//                                // called when response HTTP status is "200 OK"
//                            }
//
//                            @Override
//                            public void onFailure(int statusCode, Header[] headers, String res, Throwable t) {
//                                // called when response HTTP status is "4XX" (eg. 401, 403, 404)
//                            }
//                        }
//                );


                Log.e("+++++", "+++ request +++");

                AsyncHttpClient client = new AsyncHttpClient();

                client.get("http://192.168.103.100:8080/MeetProxy/services/appointment", params, new AsyncHttpResponseHandler() {
                    // When the response returned by REST has Http response code '200'
                    @Override
                    public void onSuccess(String response) {

                        try {
                            // JSON Object
                            Log.e("+++++", "+++ sucess  +++" + response);

                        } catch (Exception e) {
                            // TODO Auto-generated catch block
                            Log.e("+++++", "+++ failure catch +++" + e);

                        }
                    }

                    // When the response returned by REST has Http response code other than '200'
                    @Override
                    public void onFailure(int statusCode, Throwable error,
                                          String content) {
                        Log.e(statusCode + "+++++", "+++ failure  +++" + content);
                    }
                });
            }


        });


    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

    }


    private class HttpRequestTask extends AsyncTask<Void, Void, Object> {
        @Override
        protected Object doInBackground(Void... params) {
            try {
                final String url = "http://rest-service.guides.spring.io/greeting";

            } catch (Exception e) {
                Log.e("MainActivity", e.getMessage(), e);
            }

            return null;
        }

        @Override
        protected void onPostExecute(Object greeting) {

        }

    }

}
