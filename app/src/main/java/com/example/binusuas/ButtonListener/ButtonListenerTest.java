package com.example.binusuas.ButtonListener;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.binusuas.R;

import org.w3c.dom.Text;

public class ButtonListenerTest extends AppCompatActivity {

    Button btnTest;
    TextView txtTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_listener_test);

        btnTest = findViewById(R.id.btnTest);
        txtTest = findViewById(R.id.txtTest);

        btnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtTest.setVisibility(View.VISIBLE);
            }
        });

    }
}