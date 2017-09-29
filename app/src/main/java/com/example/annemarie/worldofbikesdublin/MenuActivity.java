package com.example.annemarie.worldofbikesdublin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }
        setContentView(R.layout.activity_menu);
        TextView tv = (TextView) findViewById(R.id.text_view);

        // Long presses on TextView tv invoke Context Menu
        registerForContextMenu(tv);

    }

    // Create Options Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.top_menu, menu);
        return true;
    }

    // Process clicks on Options Menu items
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.buttonLogout:
                Toast.makeText(getApplicationContext(), "you've been logged out",
                        Toast.LENGTH_SHORT).show();
                return true;

            default:
                return false;
        }
    }

    // Create Context Menu
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);
    }

    // Process clicks on Context Menu Items
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.help_guide:
                Toast.makeText(getApplicationContext(), "ContextMenu Shown",
                        Toast.LENGTH_SHORT).show();
                return true;
            case R.id.no_idea:
                Toast.makeText(getApplicationContext(), "Are you completely lost?",
                        Toast.LENGTH_SHORT).show();
                return true;
            default:
                return false;
        }
    }



}