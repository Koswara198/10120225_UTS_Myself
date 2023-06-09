package com.example.a10120225_uts_myself;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Gallery extends AppCompatActivity {
    //10 Juni 2023 - 10120225 - Adi Tata Koswara - IF-6
    Context contextGallery;
    RecyclerView recyclerViewGallery;
    RecyclerView.Adapter recyclerViewAdapterGallery;
    RecyclerView.LayoutManager recylerViewLayoutManagerGallery;
    String[] subjectsGallery = {
            "", "", "","","",""
    };
    int[] subjectImageGallery={

            R.drawable.adi,R.drawable.adi1,
            R.drawable.adi2,R.drawable.adi3,R.drawable.adi4,R.drawable.adi5

    };
    DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_gallery);
        contextGallery = getApplicationContext();
        recyclerViewGallery = findViewById(R.id.recyclerViewGallery);
        recylerViewLayoutManagerGallery = new GridLayoutManager( contextGallery, 2);
        //context,LinearLayoutManager.HORIZONTAL,false
        recyclerViewGallery.setLayoutManager(recylerViewLayoutManagerGallery);
        recyclerViewAdapterGallery = new AdapterRecyclerViewGallery(subjectsGallery, subjectImageGallery,contextGallery );
        recyclerViewGallery.setAdapter(recyclerViewAdapterGallery);
        //ass
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
    public void ClickGallery(View view){
        //recreate
        recreate();
    }

    public void ClickDaily(View view){
        //redirect to gallery
        HomeActivity.redirectActivity(this,Daily.class);
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