package com.example.timebook;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.timebook.Settings.SettingsActivity;
import com.example.timebook.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private ActivityMainBinding binding;
    private DrawerLayout drawer;
    private ListView list;
    private String[] array;
    private ListView listView;
    private ArrayAdapter<String> adapter;
    private Toolbar toolbar;
    private int chapter;
    private List<User> listTemp;

    ListAdapter listAdapter;
    ArrayList<ListData> dataArrayList = new ArrayList<>();
    ListData listData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
//        listView = findViewById(R.id.listView1);
//        list = findViewById(R.id.listView1);
        listTemp = new ArrayList<>();
//        array = getResources().getStringArray(R.array.lessons_array);
//        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,array);
//        list.setAdapter(adapter);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(binding.appBarMain.toolbar);
        drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

//        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
////                User user = listTemp.get(position);
//                Intent intent = new Intent(MainActivity.this,LesTxtActivity.class);
//                intent.putExtra("chapter", chapter);
//                intent.putExtra("position", position);
//                intent.putExtra(Constants.USER_NAME,user.name);
//                intent.putExtra(Constants.USER_IMAGE,user.image_id);
//                startActivity(intent);
//            }
//        });

//        for (int i = 0; i < array_lesTxt.length; i++){
//            listData = new ListData(array_title_lestxt[i]);
//            dataArrayList.add(listData);
//        }
//        listAdapter = new ListAdapter(MainActivity.this,dataArrayList);
//        binding.l.setAdapter(listAdapter);
//        binding.listView1.setClickable(true);
//
//        binding.listView1
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        toolbar.setTitle(R.string.menu_lessons);
        return true;
    }
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.action_settings){
            Intent i = new Intent(MainActivity.this, SettingsActivity.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }


    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
//        if (id == R.id.nav_main){
////            fillArray(R.string.menu_main,R.array.lessons_array,0);
//            Intent intent = new Intent(this,MainActivity.class);
//            startActivity(intent);
////            chapter = 0;
//        }

         if (id == R.id.nav_lessons) {
//             fillArray(R.string.menu_lessons, R.array.lessons_array, 0);
            Intent intent = new Intent(this,LesActivity.class);
            startActivity(intent);
         }

            else if          (id == R.id.nav_profile){
//            fillArray(R.string.menu_profile,R.array.lessons_array,1);
//                toolbar.setTitle(R.string.menu_profile);
             Intent intent = new Intent(this,ProfileActivity.class);
             startActivity(intent);
//            chapter = 1;
         }
        else if (id == R.id.nav_about) {
//            fillArray(R.string.menu_about,R.array.lessons_array,3);
            Intent intent = new Intent(this,AboutActivity.class);
            startActivity(intent);
//            chapter = 3;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
//    private void fillArray(int title,int arraylist,int index){
//        toolbar.setTitle(title);
//        array = getResources().getStringArray(arraylist);
//        adapter.clear();
//        adapter.addAll(array);
//        adapter.notifyDataSetChanged();
//        chapter = index;
//    }
}
