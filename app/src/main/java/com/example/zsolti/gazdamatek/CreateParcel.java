package com.example.zsolti.gazdamatek;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class CreateParcel extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_parcel);

        FloatingActionButton saveParcel = (FloatingActionButton) findViewById(R.id.createParcel);
        saveParcel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Tábla Mentve", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        FloatingActionButton discardParcel = (FloatingActionButton) findViewById(R.id.discardParcel);
        discardParcel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Tábla Eldobva", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }

}
