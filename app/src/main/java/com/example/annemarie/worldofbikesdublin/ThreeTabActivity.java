package com.example.annemarie.worldofbikesdublin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.provider.ContactsContract;
import android.widget.TabHost;

public class ThreeTabActivity extends TabActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources res = getResources(); // Resource object to get Drawables
        TabHost tabHost = getTabHost();  // The activity TabHost
        TabHost.TabSpec spec;  // Reusable TabSpec for each tab
        Intent intent;  // Reusable Intent for each tab

// Create an Intent to launch an Activity for the tab (to be reused)
        intent = new Intent().setClass(this, MapActivity.class);

// Initialize a TabSpec for each tab and add it to the TabHost
        spec = tabHost.newTabSpec("map").setIndicator("Map",
                res.getDrawable(R.drawable.ic_tab_map))
                .setContent(intent);
        tabHost.addTab(spec);

// Do the same for the other tabs
        intent = new Intent().setClass(this, PhotoActivity.class);
        spec = tabHost.newTabSpec("photos").setIndicator("Photos",
                res.getDrawable(R.drawable.ic_tab_photo))
                .setContent(intent);
        tabHost.addTab(spec);

        intent = new Intent().setClass(this, GalleryActivity.class);
        spec = tabHost.newTabSpec("gallery").setIndicator("Gallery",
                res.getDrawable(R.drawable.ic_tab_gallery))
                .setContent(intent);
        tabHost.addTab(spec);

        tabHost.setCurrentTab(2);
    }
}








