package com.example.timebook;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.timebook.databinding.ActivityMainBinding;

public class LesTxtActivity extends AppCompatActivity {
    private SharedPreferences sharedPreferences;
    private ActionBar actionBar;
    private TextView info_content;
    private WebView webView;
    private int chapter = 0;
    private int position = 0;

    ActivityMainBinding binding;
    private int[] array_lesTxt = {R.string.par1txt,R.string.par2txt,R.string.par3txt,R.string.par4txt,
            R.string.par5txt,R.string.par6txt,R.string.par7txt,R.string.par8txt,R.string.par9txt,R.string.par10txt,
            R.string.par11txt,R.string.par12txt,R.string.par13txt,R.string.par14txt};
    private String [] array_title_lestxt = {"Древнейшие люди","Родовые общины охотников и собирателей","Возникновение искусства и религиозных верований",
            "Возникновение земледелия и скотоводства","Появление неравенства и знати","Государство на берегах Нила","Как жили земледельцы и ремесленники в Египте",
            "Жизнь египетского вельможи","Военные походы фараонов","Религия древних египтян","Искусство древнего Египта","Письменность и знания древних египтян",
            "Древнее Двуречье","Вавилонский царь Хаммурапи и его законы"};
    private String [] array_video = {"<iframe width=\"1864\" height=\"801\" src=\"https://www.youtube.com/embed/pY0wAb53NGs?list=PLmKJy6AbeKqXtiKa0uCsJ5j1cm9U2obWI\" title=\"&quot;Первобытные собиратели и охотники. §1 Древнейшие люди&quot;, История древнего мира 5 класс, Вигасин.\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>",
    "<iframe width=\"1864\" height=\"801\" src=\"https://www.youtube.com/embed/193dock1d14?list=PLmKJy6AbeKqXtiKa0uCsJ5j1cm9U2obWI\" title=\"§2 &quot;Родовые общины охотников и собирателей&quot;, История древнего мира 5 класс, Вигасин.\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>",
    "<iframe width=\"1864\" height=\"801\" src=\"https://www.youtube.com/embed/o6mJNWFXVW4?list=PLmKJy6AbeKqXtiKa0uCsJ5j1cm9U2obWI\" title=\"§3 &quot;Возникновение искусства и религиозных верований&quot;, История древнего мира 5 класс, Вигасин\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>",
    "<iframe width=\"902\" height=\"516\" src=\"https://www.youtube.com/embed/PP7d2H9Uzyg?list=PLmKJy6AbeKqXtiKa0uCsJ5j1cm9U2obWI\" title=\"§4 &quot;Возникновение земледелия и скотоводства&quot;, История древнего мира 5 класс, Вигасин.\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>",
    "<iframe width=\"902\" height=\"516\" src=\"https://www.youtube.com/embed/6xdYD7kbz80?list=PLmKJy6AbeKqXtiKa0uCsJ5j1cm9U2obWI\" title=\"§5 &quot;Появление неравенства и знати&quot;, История Древнего мира 5 класс, Вигасин.\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>",
    "<iframe width=\"902\" height=\"516\" src=\"https://www.youtube.com/embed/LEarlesPg6c?list=PLmKJy6AbeKqXtiKa0uCsJ5j1cm9U2obWI\" title=\"§6 &quot;Государство на берегах Нила&quot;, История Древнего мира 5 класс, Вигасин.\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>",
    "<iframe width=\"902\" height=\"516\" src=\"https://www.youtube.com/embed/C8HkwmgdoUQ?list=PLmKJy6AbeKqXtiKa0uCsJ5j1cm9U2obWI\" title=\"§7 &quot;Как жили земледельцы и ремесленники в Египте&quot;, История древнего мира 5 класс, Вигасин.\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>",
    "<iframe width=\"902\" height=\"516\" src=\"https://www.youtube.com/embed/sAUr0d5NfwM?list=PLmKJy6AbeKqXtiKa0uCsJ5j1cm9U2obWI\" title=\"§8 &quot;Жизнь египетского вельможи&quot;, История древнего мира 5 класс, Вигасин\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>",
    "<iframe width=\"902\" height=\"516\" src=\"https://www.youtube.com/embed/RI6f0QSZhas?list=PLmKJy6AbeKqXtiKa0uCsJ5j1cm9U2obWI\" title=\"§9 &quot;Военные походы фараонов&quot;, История древнего мира 5 класс, Вигасин.\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>",
    "<iframe width=\"902\" height=\"516\" src=\"https://www.youtube.com/embed/1lFkw-Azgjo?list=PLmKJy6AbeKqXtiKa0uCsJ5j1cm9U2obWI\" title=\"§10 &quot;Религия древних египтян&quot;, История древнего мира 5 класс, Вигасин\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>",
    "<iframe width=\"902\" height=\"516\" src=\"https://www.youtube.com/embed/ST3A4ww8L5I?list=PLmKJy6AbeKqXtiKa0uCsJ5j1cm9U2obWI\" title=\"§11 &quot;Искусство древнего Египта&quot;, История древнего мира 5 класс, Вигасин\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>",
    "<iframe width=\"902\" height=\"516\" src=\"https://www.youtube.com/embed/yI36LTmZs8k?list=PLmKJy6AbeKqXtiKa0uCsJ5j1cm9U2obWI\" title=\"§12 &quot;Письменность и знания древних египтян&quot;, История древнего мира 5 класс, Вигасин.\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>",
    "<iframe width=\"902\" height=\"516\" src=\"https://www.youtube.com/embed/zc6oTjE0gMc?list=PLmKJy6AbeKqXtiKa0uCsJ5j1cm9U2obWI\" title=\"§13 &quot;Древнее Двуречье&quot;, История древнего мира 5 класс, Вигасин\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>",
    "<iframe width=\"902\" height=\"516\" src=\"https://www.youtube.com/embed/S4jiNshHjYc?list=PLmKJy6AbeKqXtiKa0uCsJ5j1cm9U2obWI\" title=\"§14 &quot;Вавилонский царь Хаммурапи и его законы&quot;, История древнего мира 5 класс, Вигасин\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>"};

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_lesson_text);

        init();
        reciveIntent();


    }
    private void reciveIntent() {
        Intent i = getIntent();
        if (i != null) {

            chapter = i.getIntExtra("chapter", 0);
            position = i.getIntExtra("position", 0);
//            info_content.setText(array_lesTxt[position]);
//            actionBar.setTitle(array_title_lestxt[position]);
//            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        switch (chapter) {
            case 0:
                info_content.setText(array_lesTxt[position]);
                actionBar.setTitle(array_title_lestxt[position]);
                actionBar.setDisplayHomeAsUpEnabled(true);
//                webView.setWebViewClient(array_video[position]);
//                webView.loadData(video,"text/html","utf-8");
//                webView.getSettings().setJavaScriptEnabled(true);
//                webView.setWebChromeClient(new WebChromeClient());
                break;
        }
    }
    private void init(){
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        info_content = findViewById(R.id.tvDescription);
        webView = findViewById(R.id.webVideo);
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
