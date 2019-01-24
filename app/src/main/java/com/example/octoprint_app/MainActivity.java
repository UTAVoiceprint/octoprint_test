package com.example.octoprint_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button connect_button = findViewById(R.id.connect_button);

        connect_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView response_textView = findViewById(R.id.response_textView);

                response_textView.setText("CONNECTED");
            }
        });
    }
}
