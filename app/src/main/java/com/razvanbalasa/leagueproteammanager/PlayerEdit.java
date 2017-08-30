package com.razvanbalasa.leagueproteammanager;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * Created by PC#54 on 29-Aug-17.
 */

public class PlayerEdit extends Activity {

    private ImageView imageView;
    private EditText name;
    private Spinner lane;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player_edit);

        imageView = findViewById(R.id.edit_player_picture);
        name = findViewById(R.id.editable_name);
        lane = findViewById(R.id.editable_lane) ;

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.lanes_array, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        lane.setOnItemSelectedListener(onItemSelectedListener);
        lane.setAdapter(adapter);

        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setImageBitmap(MainActivity.players.get(MainActivity.item).getPortrait());

        name.setText(MainActivity.players.get(MainActivity.item).getName());

        MainActivity.players.get(MainActivity.item).setName(name.getText().toString());

        MainActivity.myAdapter.setPlayers(MainActivity.players);

        if (MainActivity.players.get(MainActivity.item).getFavLane() == MainActivity.lanes.get(0))
            lane.setSelection(0);
        else if (MainActivity.players.get(MainActivity.item).getFavLane() == MainActivity.lanes.get(1))
            lane.setSelection(1);
        else if (MainActivity.players.get(MainActivity.item).getFavLane() == MainActivity.lanes.get(2))
            lane.setSelection(2);
        else if (MainActivity.players.get(MainActivity.item).getFavLane() == MainActivity.lanes.get(3))
            lane.setSelection(3);
        else if (MainActivity.players.get(MainActivity.item).getFavLane() == MainActivity.lanes.get(4))
            lane.setSelection(4);
    }

    private AdapterView.OnItemSelectedListener onItemSelectedListener = new AdapterView.OnItemSelectedListener() {
        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

            ((TextView) parent.getChildAt(0)).setTextColor(Color.WHITE);
            ((TextView) parent.getChildAt(0)).setTextSize(20);
        }

        public void onNothingSelected(AdapterView<?> parent) {

        }
    };
}
