package com.example.timebook;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class LessonVideoActivity extends AppCompatActivity {
    private SharedPreferences sharedPreferences;
    private ActionBar actionBar;
    private TextView info_content;
    private int chapter = 0;
    private int position = 0;
    private int[] array_lesDescVideo = {R.string.par1vidDesc,R.string.par2vidDesc,R.string.par3vidDesc,R.string.par4vidDesc,
            R.string.par5vidDesc,R.string.par6vidDesc,R.string.par7vidDesc,R.string.par8vidDesc,R.string.par9vidDesc,R.string.par10vidDesc,
            R.string.par11vidDesc,R.string.par12vidDesc,R.string.par13vidDesc,R.string.par14vidDesc};
    private int[] array_lesVideo = {R.string.par1video,R.string.par2vidDesc,R.string.par3vidDesc,R.string.par4vidDesc,
            R.string.par5vidDesc,R.string.par6vidDesc,R.string.par7vidDesc,R.string.par8vidDesc,R.string.par9vidDesc,R.string.par10vidDesc,
            R.string.par11vidDesc,R.string.par12vidDesc,R.string.par13vidDesc,R.string.par14vidDesc};
    private String [] array_title_video = {"Древнейшие люди","Родовые общины охотников и собирателей","Возникновение искусства и религиозных верований",
            "Возникновение земледелия и скотоводства","Появление неравенства и знати","Государство на берегах Нила","Как жили земледельцы и ремесленники в Египте",
            "Жизнь египетского вельможи","Военные походы фараонов","Религия древних египтян","Искусство древнего Египта","Письменность и знания древних египтян",
            "Древнее Двуречье","Вавилонский царь Хаммурапи и его законы"};

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_lesson_video);

        init();
        reciveIntent();

    }
    private void reciveIntent() {
        Intent i = getIntent();
        if (i != null) {
            chapter = i.getIntExtra("chapter", 0);
            position = i.getIntExtra("position", 0);
            info_content.setText(array_lesDescVideo[position]);
            actionBar.setTitle(array_title_video[position]);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

    }
    private void init(){
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        info_content = findViewById(R.id.tvDescVideo);
//        face1 = Typeface.createFromAsset(this.getAssets(),"fonts/Neucha-Regular.ttf");
//        info_content.setTypeface(face1);
        actionBar = getSupportActionBar();
        String text = sharedPreferences.getString("main_text_size","Средний");
        if(text != null){

            switch (text){
                case "Маленький":
                    info_content.setTextSize(14);
                    break;
                case "Средний":
                    info_content.setTextSize(18);
                    break;
                case "Большой":
                    info_content.setTextSize(24);
                    break;
            }
        }
    }
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return true;
    }
}
