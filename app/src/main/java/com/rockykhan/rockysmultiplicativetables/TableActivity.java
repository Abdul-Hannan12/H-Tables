package com.rockykhan.rockysmultiplicativetables;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class TableActivity extends AppCompatActivity {

    TextView heading;
    TextView table;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);

        heading = findViewById(R.id.heading);
        table = findViewById(R.id.table);

        Intent intent = getIntent();
        String Mtable = intent.getStringExtra(MainActivity.tbl);
        String Head = intent.getStringExtra(MainActivity.head);
        heading.setText(Head);
        table.setText(Mtable);
    }

    @Override
    public void onBackPressed() {
        Intent backIntent = new Intent(getApplicationContext(), MainActivity0.class);
        startActivity(backIntent);
        finishAffinity();
    }
}
