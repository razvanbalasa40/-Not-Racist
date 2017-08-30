package com.razvanbalasa.leagueproteammanager;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Bitmap bitmap;
    private Player player;
    public static List<Player> players = new ArrayList<>();
    public static MyAdapter myAdapter;
    private RecyclerView recyclerView;
    public static int item;
    public static List<String> lanes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.gridview);

        int numberOfColumns = 2;

        lanes.add("Top");
        lanes.add("Jungle");
        lanes.add("Mid");
        lanes.add("A.D. Carry");
        lanes.add("Support");

        recyclerView.setLayoutManager(new GridLayoutManager(this, numberOfColumns));
        myAdapter = new MyAdapter(players);
        recyclerView.setAdapter(myAdapter);

        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.dyrus);
        player = new Player("''Dyrus''", lanes.get(0), "Snowball", 0, bitmap, "#4185f2", "#619cf9");
        players.add(player);

        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.daimondprox);
        player = new Player("''Diamondprox''", lanes.get(1), "Awarness", 0, bitmap, "#f20e4b", "#ff3d71");
        players.add(player);

        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.faker);
        player = new Player("''Faker''", lanes.get(2), "FAKER", 0, bitmap, "#07bc2b", "#46e266");
        players.add(player);

        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.doublelift);
        player = new Player("''Doublelift''", lanes.get(3), "Mechanics", 0, bitmap, "#eaff0c", "#d8e549");
        players.add(player);

        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.meiko);
        player = new Player("''Meiko''", lanes.get(4), "Tank", 0, bitmap, "#ff7d0c", "#f29646");
        players.add(player);

        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.meiko);
        player = new Player("''Fufu''", lanes.get(4), "Tank", 0, bitmap, "#ff7d0c", "#f29646");
        players.add(player);
        Toast.makeText(this, "Munca 1", Toast.LENGTH_SHORT).show();

        myAdapter.setPlayers(players);

        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(getApplicationContext(), recyclerView ,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        item = position;
                        Intent intent = new Intent((view.getContext()), PlayerEdit.class);
                        startActivityForResult(intent, 0);
                    }

                    @Override public void onLongItemClick(View view, int position) {
                        Toast.makeText(getApplicationContext(), players.get(position).getName(), Toast.LENGTH_LONG).show();

                    }
                })
        );
    }

}
