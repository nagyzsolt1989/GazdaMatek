package com.example.zsolti.gazdamatek;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Zsolti on 2016.11.24..
 */

public class EditLand extends DialogFragment implements View.OnClickListener
{

    private View mView;
    private Button saveParcel, discardParcel;
    private OnLandChangedListener communicator;
    private EditText parcel_name, parcel_area, parcel_plant;
    private String parcel_name_value, parcel_area_value, parcel_plant_value;

    static EditLand newInstance() {
        return new EditLand();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        mView = inflater.inflate(R.layout.edit_land, container, false);

        communicator = (OnLandChangedListener) getActivity();

        parcel_name = (EditText) mView.findViewById(R.id.editParcelName);
        parcel_area = (EditText) mView.findViewById(R.id.editParcelArea);
        parcel_plant = (EditText) mView.findViewById(R.id.editParcelDesc);

        saveParcel = (Button) mView.findViewById(R.id.createParcel);
        saveParcel.setOnClickListener(this);
        discardParcel = (Button) mView.findViewById(R.id.discardParcel);
        discardParcel.setOnClickListener(this);

        return mView;
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){

            case R.id.createParcel:

                //SAVE INPUTS INTO STRINGS
                if (parcel_name != null && parcel_area != null && parcel_plant != null) {
                    parcel_name_value = parcel_name.getText().toString();
                    parcel_area_value = parcel_area.getText().toString();
                    parcel_plant_value = parcel_plant.getText().toString();
                }

                //PASS PARCEL INFORMATION TO MAINACTIVITY WITH ONLANDCHANGEDLISTENER INTERFACE
                communicator.changeLandParameters(parcel_name_value, parcel_area_value, parcel_plant_value);

                dismiss();

                break;

            case R.id.discardParcel:

                dismiss();
                break;

            default:
                break;
        }
    }

}
