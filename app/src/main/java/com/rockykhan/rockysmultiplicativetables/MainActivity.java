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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String tbl = "com.rockykhan.rockysmultiplicativetables.table";
    public static final String head = "com.rockykhan.rockysmultiplicativetables.heading";

    EditText number;
    EditText upto;
    Button button;
    String table = "";
    String heading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number = findViewById(R.id.number);
        upto = findViewById(R.id.upto);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    int num = Integer.parseInt(number.getText().toString());
                    int up = Integer.parseInt(upto.getText().toString());
                    for (int i = 0; i < up; i++) {
                        table += num + "  x  " + (i + 1) + "  =  " + num * (i + 1);
                        table += "\n";
                        heading = "Table of " + num + " till " + up;
                    }

                    Intent intent = new Intent(view.getContext(), TableActivity.class);
                    intent.putExtra(tbl, table);
                    intent.putExtra(head, heading);
                    startActivity(intent);
                }catch (Exception e){
                    e.printStackTrace();
                    Toast.makeText(MainActivity.this, "Please fill both the numbers first", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
