package com.example.sumit.designprojectfinal;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AirQuality extends AppCompatActivity {

    DatabaseHelper myDb;
    EditText editItem1;
    Button btnAddData;
    Button btnviewAll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_air_quality);
        myDb = new DatabaseHelper(this);


        editItem1 = (EditText)findViewById(R.id.aip1);
        btnAddData = (Button)findViewById(R.id.aclick);
        btnviewAll = (Button)findViewById(R.id.abtn2);

        AddData();
        viewAll();

    }


    public  void AddData() {
        btnAddData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = myDb.insertData1(editItem1.getText().toString());
                        if( isInserted==true )
                            Toast.makeText(AirQuality.this,"Data Saved", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(AirQuality.this,"Data not saved", Toast.LENGTH_LONG).show();
                    }
                }
        );
    }


    public void viewAll() {
        btnviewAll.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor res = myDb.getAllData1();
                        if(res.getCount() == 0) {
                            // show message
                            showMessage("Error","Nothing found");
                            return;
                        }

                        StringBuffer buffer = new StringBuffer();
                        while (res.moveToNext()) {
                            buffer.append("Id :"+ res.getString(0)+"\n");
                            buffer.append("Air Quality :"+ res.getString(1)+"\n");
                        }

                        // Show all data
                        showMessage("Data",buffer.toString());
                    }
                }
        );
    }
    public void showMessage(String title, String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }


}
