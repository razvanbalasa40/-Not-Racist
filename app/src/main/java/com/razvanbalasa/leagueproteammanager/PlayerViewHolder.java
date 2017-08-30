package com.razvanbalasa.leagueproteammanager;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by PC#54 on 28-Aug-17.
 */

public class PlayerViewHolder extends RecyclerView.ViewHolder {
    ImageView playerPicture;
    TextView playerName;
    TextView favLane;
    TextView specAbility;
    LinearLayout layout_background;

    public PlayerViewHolder(View v) {
        super(v);
        playerName = v.findViewById(R.id.player_name);
        playerPicture = v.findViewById(R.id.player_picture);
        favLane = v.findViewById(R.id.fav_lane);
        specAbility = v.findViewById(R.id.spec_ability);
        layout_background = v.findViewById(R.id.layout_background);
        playerPicture.setScaleType(ImageView.ScaleType.FIT_XY);
    }

    public void updatePlayer(String name, Bitmap picture, String lane, String ability, String color, String color2) {
        playerName.setText(name);
        playerName.setBackgroundColor(Color.parseColor(color2));
        playerPicture.setImageBitmap(picture);
        favLane.setText(lane);
        specAbility.setText(ability);
        layout_background.setBackgroundColor(Color.parseColor(color));
    }
}
