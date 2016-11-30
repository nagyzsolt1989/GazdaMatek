package com.example.zsolti.gazdamatek;

import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements OnLandChangedListener
{

    NavigationView navigationView = null;
    Toolbar toolbar = null;

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
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if(parcelListItems.size() > 0) {
            listView = (ListView) findViewById( android.R.id.list );
            //adapter = new ParcelAdapter(this, parcelListItems);
            listView.setAdapter(new ParcelAdapter(this, parcelListItems));
            //listView.setAdapter(adapter);
            //adapter.notifyDataSetChanged();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);

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

        //MAIN FLOATING ACTION BUTTON

        final FloatingActionsMenu menuMultipleActions = (FloatingActionsMenu) findViewById(R.id.main_fab);

        //ADD NEW PARCEL SUB BUTTON

        FloatingActionButton actionAddLand = new FloatingActionButton(getBaseContext());

        actionAddLand.setTitle(getString(R.string.action_addland));
        actionAddLand.setColorNormalResId(R.color.darkgreen);
        actionAddLand.setIcon(R.drawable.icon_add_new_parcel_white);

        actionAddLand.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                menuMultipleActions.collapse();
                EditLand editland = EditLand.newInstance();
                editland.show(getFragmentManager(), "Edit land");
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

            }
        });

        //ADD SUB BUTTONS TO MAIN MAIN FLOATING ACTION BUTTON

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

    public static ArrayList getParcelListItems(){
        return parcelListItems;
    }

    //RECREATE ACTIVITY WHEN DATA IS CHANGED
    @Override
    public void changeLandParameters(String name, String area, String plant) {
        Parcel tempparcel = new Parcel(name, area, plant);
        parcelListItems.add(tempparcel);
        this.recreate();
    }
}
