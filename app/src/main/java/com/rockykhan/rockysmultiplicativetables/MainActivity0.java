package com.rockykhan.rockysmultiplicativetables;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity0 extends AppCompatActivity {

    Button btn_ok, btn_custom;
    Spinner spinner;
    String table = "";
    String heading;
//    String[] array = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"};
    Integer[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
    Intent intent;
    Boolean isFirstSelection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main0);

        btn_ok = findViewById(R.id.btn_ok);
        btn_custom = findViewById(R.id.btn_custom);
        spinner = findViewById(R.id.spinner);

        isFirstSelection = true;

        ArrayAdapter<Integer> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, arr);

        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long l) {

                if (isFirstSelection){
                    isFirstSelection = false;
                }else {

                    int num = pos;
                    table = "";

                    for (int i = 0; i < 20; i++) {
                        table += num + "  x  " + (i + 1) + "  =  " + num * (i + 1);
                        table += "\n";
                    }

                    heading = "Table of " + num + " till 20";

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {

                    if (table.equals("")){

                        Toast.makeText(MainActivity0.this, "Please select a valid number", Toast.LENGTH_SHORT).show();

                    }else {

                        intent = new Intent(getApplicationContext(), TableActivity.class);
                        intent.putExtra(MainActivity.tbl, table);
                        intent.putExtra(MainActivity.head, heading);
                        startActivity(intent);

                    }

                }catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(MainActivity0.this, "Some error occurred. Please try again", Toast.LENGTH_SHORT).show();
                }

            }
        });

        btn_custom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent customIntent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(customIntent);
            }
        });

    }


    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(MainActivity0.this)
                .setTitle("Exit")
                .setMessage("Are you sure you want to Exit?")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        MainActivity0.super.onBackPressed();
                    }
                })
                .setNegativeButton(android.R.string.no, null)
                .setIcon(R.drawable.warning)
                .show();
    }

}