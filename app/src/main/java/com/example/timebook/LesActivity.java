package com.example.timebook;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.timebook.databinding.ActivityMainBinding;

import java.util.List;

public class LesActivity extends AppCompatActivity {
    private DrawerLayout drawer;
    private ListView list;
    private String[] array;
    private ActivityMainBinding binding;
    private ArrayAdapter<String> adapter;
    private Toolbar toolbar;
    private int chapter;
    private List<User> listTemp;

    //    Context context;
//    String array_title_lestxt [];
//    int array_lesTxt [];
//    LayoutInflater inflater;
//    public  LesActivity (Context ctx, String [] array_title_lestxt){
//        this.context = ctx;
//        this.array_lesTxt = array_lesTxt;
//        this.array_title_lestxt = array_title_lestxt;
//        inflater = LayoutInflater.from(ctx);
//    }

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


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
        list = findViewById(R.id.listView);
        array = getResources().getStringArray(R.array.lessons_array);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, array);
        list.setAdapter(adapter);
//        list.setClickable(true);


//        setSupportActionBar(toolbar);
//        drawer = binding.drawerLayout;
//        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
//                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
//        drawer.addDrawerListener(toggle);
//        toggle.syncState();

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(LesActivity.this, LesTxtActivity.class);
                intent.putExtra("chapter", chapter);
                intent.putExtra("position", position);
                startActivity(intent);
            }
        });
    }

//    @Override
//    public int getCount() {
//        return array_lesTxt.length;
//    }
//
//    @Override
//    public Object getItem(int position) {
//        return null;
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return 0;
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//    convertView = inflater.inflate(R.layout.content_main,null);
//        TextView textView = (TextView) convertView.findViewById(R.id.)
//        return null;
//    }
}