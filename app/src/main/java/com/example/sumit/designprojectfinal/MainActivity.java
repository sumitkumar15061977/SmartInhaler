package com.example.sumit.designprojectfinal;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {


    String[] value = new String[]{
            "Add Information",
            "On Bluetooth"
    };
    String selectedText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button peakflow = (Button)findViewById(R.id.peakflow);
    }

    public void add(View view){
        AlertDialog.Builder alertdialogbuilder = new AlertDialog.Builder(MainActivity.this);


        alertdialogbuilder.setTitle("Choose option");

        alertdialogbuilder.setItems(value, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                selectedText = Arrays.asList(value).get(which);

                //   textview.setText(selectedText);
                if (selectedText == "Add Information"){

                   addInfo();

                }else{

                   withBluetooth();

                }

            }
        });

        AlertDialog dialog = alertdialogbuilder.create();

        dialog.show();

    }

    public void addInfo(){
        Intent i = new Intent(this, Addinfo.class);
        startActivity(i);
    }

    public void withBluetooth(){
        Intent i = new Intent(this, bluetoothw.class);
        startActivity(i);
    }

    public void air_quality(View view){
        Intent i = new Intent(this, AirQuality.class);
        startActivity(i);
    }

    public void showgraph(View view){
        Intent i = new Intent(this, Graph.class);
        startActivity(i);
    }

}
