package com.example.a10120225_uts_myself;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class Daily extends AppCompatActivity {

    //10 Juni 2023 - 10120225 - Adi Tata Koswara - IF-6
    DrawerLayout drawerLayout;
    Context context, contextFriend;
    RecyclerView recyclerView, recyclerViewFriend;
    RecyclerView.Adapter recyclerViewAdapter, recyclerViewAdapterFriend;
    RecyclerView.LayoutManager recylerViewLayoutManager,recylerViewLayoutManageFriend;
    String[] subjects = {
            "Bangun tidur", "Olahraga", "Sarapan", "Mandi", "Ngoding", "Main Gitar",
            "Nonton Anime", "Netflix and Chill","Main Game"
    };
    int[] subjectImage ={
            R.drawable.morning,R.drawable.fitness,
            R.drawable.breakfast,R.drawable.shower,
            R.drawable.coding,R.drawable.guitar,
            R.drawable.gundam,R.drawable.netflix,
            R.drawable.videogame
    };
    String[] subjectsName = {
            "Mamat", "Fahmi", "Tri","Abyan","Faris","Adit"
    };
    int[] subjectImageFriend ={
            R.drawable.mamat,R.drawable.fahmi,R.drawable.tri,
            R.drawable.abyan,R.drawable.faris,
            R.drawable.adit
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily);

        context = getApplicationContext();
        recyclerView = findViewById(R.id.recyclerView);
        recylerViewLayoutManager = new LinearLayoutManager(context);
        //context,LinearLayoutManager.HORIZONTAL,false
        recyclerView.setLayoutManager(recylerViewLayoutManager);
        recyclerViewAdapter = new AdapterRecyclerView(subjects, subjectImage,context );
        recyclerView.setAdapter(recyclerViewAdapter);

        contextFriend = getApplicationContext();
        recyclerViewFriend = findViewById(R.id.recyclerViewFriend);
        recylerViewLayoutManageFriend = new LinearLayoutManager(contextFriend,LinearLayoutManager.HORIZONTAL,false);
        //context,LinearLayoutManager.HORIZONTAL,false
        recyclerViewFriend.setLayoutManager(recylerViewLayoutManageFriend);
        recyclerViewAdapterFriend = new com.example.a10120225_uts_myself.AdapterRecyclerViewFriend(subjectsName, subjectImageFriend,contextFriend );
        recyclerViewFriend.setAdapter(recyclerViewAdapterFriend);



        drawerLayout = findViewById(R.id.DrawerLayout);
    }
    public void ClickMenu(View view){
        //Open drawer
        HomeActivity.openDrawer(drawerLayout);

    }
    public void ClickLogo(View view){
        HomeActivity.closeDrawer(drawerLayout);
    }
    public void ClickHome(View view){
        //redirect to home
        HomeActivity.redirectActivity(this,HomeActivity.class);
    }
    public void ClickDaily(View view){
        //recreate
        recreate();
    }

    public void ClickGallery(View view){
        //redirect to gallery
        HomeActivity.redirectActivity(this, com.example.a10120225_uts_myself.Gallery.class);
    }
    public void ClickMusic(View view){
        //redirect to music
        HomeActivity.redirectActivity(this,Music.class);
    }
    public void ClickProfile(View view){
        //redirect to profile
        HomeActivity.redirectActivity(this,Profile.class);
    }
    public void ClickLogout(View view){
        //close
        HomeActivity.logout(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        //close drawer
        HomeActivity.closeDrawer(drawerLayout);
    }
}