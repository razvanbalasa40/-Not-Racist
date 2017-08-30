package com.razvanbalasa.leagueproteammanager;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by PC#54 on 28-Aug-17.
 */

public class MyAdapter extends RecyclerView.Adapter{

    private List<Player> players;

    public MyAdapter(List<Player> players) {
        this.players = players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
        notifyDataSetChanged();
    }

    public void getPlayers(List<Player> players) {
        players = this.players;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                      int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        RecyclerView.ViewHolder viewHolder = null;
        View v = layoutInflater.inflate(R.layout.player, parent, false);
        viewHolder = new PlayerViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Player player = players.get(position);
        PlayerViewHolder viewHolder = (PlayerViewHolder) holder;
        viewHolder.updatePlayer(player.getName(), player.getPortrait(), player.getFavLane(),
                player.getSpecAbility(), player.getColor(), player.getColor2());
    }

    @Override
    public int getItemCount() {
        return players.size();
    }
}
