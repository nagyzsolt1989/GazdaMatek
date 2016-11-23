package com.example.zsolti.gazdamatek;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;
import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;
import java.util.ArrayList;


public class MainActivity extends ListActivity{

    //LIST OF ARRAY STRINGS WHICH WILL SERVE AS LIST ITEMS
    static ArrayList<Parcel> parcelListItems = new ArrayList<Parcel>();;

    //DEFINING A STRING ADAPTER WHICH WILL HANDLE THE DATA OF THE LISTVIEW
    ParcelAdapter adapter;

    //LISTVIEW TO DISPLAY LIST
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //parcelListItems.add(new Parcel("Elso", "nagy", "0.0"));

        Intent intent = getIntent();
        if(getIntent().hasExtra("parcel name")) {
            String temp1 = intent.getStringExtra("parcel name");
            String temp2 = intent.getStringExtra("parcel area");
            String temp3 = intent.getStringExtra("parcel plant");

            Parcel tempparcel = new Parcel(temp1, temp2, temp3);
            parcelListItems.add(tempparcel);
        }

        if(parcelListItems.size() > 0) {
            listView = (ListView) findViewById( android.R.id.list );
            //adapter = new ParcelAdapter(this, parcelListItems);
            listView.setAdapter(new ParcelAdapter(this, parcelListItems));
            //listView.setAdapter(adapter);
            //adapter.notifyDataSetChanged();
        }

/*
        parcelListItems.add("elso");
        adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, parcelListItems);


        Intent intent = getIntent();

        parcelListItems.add(intent.getStringExtra("parcel_name")) ;
        String parcel_area = intent.getStringExtra("parcel_area");
        String parcel_description = intent.getStringExtra("parcel_description");
        if(adapter != null)
        {
            adapter.notifyDataSetChanged();
            setListAdapter(adapter);
        }

*/
        //ADD NEW PARCEL SUB BUTTON

        FloatingActionButton actionAddLand = new FloatingActionButton(getBaseContext());

        actionAddLand.setTitle(getString(R.string.action_addland));
        actionAddLand.setColorNormalResId(R.color.darkgreen);
        actionAddLand.setIcon(R.drawable.icon_add_new_parcel_white);

        actionAddLand.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,CreateParcel.class);
                startActivityForResult(i, 1);
            }
        });

        //ADD NEW INCOME SUB BUTTON

        FloatingActionButton actionAddIncome = new FloatingActionButton(getBaseContext());

        actionAddIncome.setTitle(getString(R.string.action_addincome));
        actionAddIncome.setIcon(R.drawable.icon_add_new_income_white);
        actionAddIncome.setColorNormalResId(R.color.darkgreen);

        actionAddIncome.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Add new Income button clicked", Toast.LENGTH_SHORT).show();
            }
        });

        //ADD NEW OUTCOME SUB BUTTON

        FloatingActionButton actionAddOutcome = new FloatingActionButton(getBaseContext());

        actionAddOutcome.setTitle(getString(R.string.action_addoutcome));
        actionAddOutcome.setIcon(R.drawable.icon_add_new_outcome_white);
        actionAddOutcome.setColorNormalResId(R.color.darkgreen);

        actionAddOutcome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Add new Outcome button clicked", Toast.LENGTH_SHORT).show();
            }
        });

        //MAIN FLOATING ACTION BUTTON

        final FloatingActionsMenu menuMultipleActions = (FloatingActionsMenu) findViewById(R.id.main_fab);

        menuMultipleActions.addButton(actionAddLand);
        menuMultipleActions.addButton(actionAddIncome);
        menuMultipleActions.addButton(actionAddOutcome);

        //DIM BACKGROUND WHEN FLOATING ACTION MENU EXPANDED

        final View dimmedBackground = findViewById(R.id.dimmedBackground);

        menuMultipleActions.setOnFloatingActionsMenuUpdateListener(new FloatingActionsMenu.OnFloatingActionsMenuUpdateListener() {
            @Override
            public void onMenuExpanded()
            {
                dimmedBackground.setVisibility(View.VISIBLE);
            }

            @Override
            public void onMenuCollapsed()
            {
                dimmedBackground.setVisibility(View.GONE);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
/*
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch(requestCode) {
            case (1) : {
                if (resultCode == MainActivity.RESULT_OK) {
                    // TODO Extract the data returned from the child Activity.
                }
                break;
            }
        }
    }
*/
    public static ArrayList getParcelListItems(){
        return parcelListItems;
    }
}
