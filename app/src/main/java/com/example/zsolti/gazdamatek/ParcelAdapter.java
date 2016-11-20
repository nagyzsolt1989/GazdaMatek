package com.example.zsolti.gazdamatek;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Zsolti on 2016.11.18..
 * A CustomAdapter to display parcel information in a ListView
 */

public class ParcelAdapter extends BaseAdapter {

    //DECLARE VARIABLES
    ArrayList<Parcel> list;
    Context context;
    Parcel tempparcel;

    //CONSTRUCTOR
    public ParcelAdapter(Context c, ArrayList parcellist)
    {
        context = c;
        list = parcellist;
    }

    //OVERRIDE ADAPTER'S FUNCTION
    @Override
    public int getCount()
    {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    //DEPENDS UPON DATA SIZE CALLED FOR EACH ROW? CREATE EACH LISTVIEW ROW
    public View getView(int position, View view, ViewGroup viewgroup)
    {

        // LAYOUT INFLATER TO CALL EXTERNAL XML LAYOUT
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        //ROW CONTAINS A REF TO PARCEL_LIST_ROW'S RELATIVELAYOUT
        View row = inflater.inflate(R.layout.parcel_list_row, viewgroup, false);

        //SET THE MINIMUM HEIGHT OF EACH ROW
        row.setMinimumHeight(250);

        TextView title = (TextView) row.findViewById(R.id.TextView1);
        ImageView area_icon = (ImageView) row.findViewById(R.id.imageView1);
        TextView area_value = (TextView) row.findViewById(R.id.textView2);
        TextView area_unit = (TextView) row.findViewById(R.id.textView3);
        ImageView plant_icon = (ImageView) row.findViewById(R.id.imageView2);
        TextView plant = (TextView) row.findViewById(R.id.textView4);
        ImageView money_icon = (ImageView) row.findViewById(R.id.imageView3);
        TextView money_value = (TextView) row.findViewById(R.id.textView5);
        TextView money_currency = (TextView) row.findViewById(R.id.textView6);

        Parcel temp = list.get(position);

        title.setText(temp.getName());
        area_icon.setImageResource(R.drawable.icon_add_new_parcel);
        area_value.setText(temp.getArea());
        area_unit.setText("ha");
        plant_icon.setImageResource(R.drawable.ic_local_florist_black_18dp);
        plant.setText(temp.getPlant());
        money_icon.setImageResource(R.drawable.icon_money_balance);
        money_value.setText("0.0");
        money_currency.setText("Ft");

        return row;
    }
}
