package com.example.zsolti.gazdamatek;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class CreateParcel extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_parcel);

        final EditText parcel_name = (EditText) findViewById(R.id.editParcelName);
        final EditText parcel_area = (EditText) findViewById(R.id.editParcelArea);
        final EditText parcel_plant = (EditText) findViewById(R.id.editParcelDesc);

        FloatingActionButton saveParcel = (FloatingActionButton) findViewById(R.id.createParcel);
        saveParcel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "parcel_name", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                //Save inputs into strings

                String parcel_name_value = parcel_name.getText().toString();
                String parcel_area_value = parcel_area.getText().toString();
                String parcel_plant_value = parcel_plant.getText().toString();

                //Pass Parcal information to MainActivity
                if (parcel_name != null && parcel_area != null)
                {
                    Intent sendParcelInfo = new Intent(CreateParcel.this, MainActivity.class);
                    //Intent sendParcelInfo = new Intent();
                    sendParcelInfo.putExtra("parcel name", parcel_name_value);
                    sendParcelInfo.putExtra("parcel area", parcel_area_value);
                    sendParcelInfo.putExtra("parcel plant", parcel_plant_value);
                    setResult(MainActivity.RESULT_OK, sendParcelInfo);
                    startActivity(sendParcelInfo);
                    //finish();
                }
            }
        });


        FloatingActionButton discardParcel = (FloatingActionButton) findViewById(R.id.discardParcel);
        discardParcel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

}
