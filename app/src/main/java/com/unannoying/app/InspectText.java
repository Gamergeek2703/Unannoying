package com.unannoying.app;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class InspectText extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inspect_text);

        // Get the text to be inspected from the fragment
        String text = getIntent().getStringExtra("inspectText");

        // Display the text in a textview
        TextView displayInspectText = findViewById(R.id.inspectText2);

        // Make a request to our api
        RequestQueue queue = Volley.newRequestQueue(this);

        // We cannot use 127.0.0.1:5000/?text= here because that is loopback
        // for the emulator, not the machine running the emulator. 10.0.2.2
        // is an alias for our host loopback (aka 127.0.0.1)
        String url = "http://10.0.2.2:5000/?text=" + text;

        // Request a string response from the provided URL.
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    String classification = response.getString("classification");

                    displayInspectText.setText(classification);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                displayInspectText.setText("Error making request to API");
            }
        });

        // Add the request to the RequestQueue.
        queue.add(request);
    }
}