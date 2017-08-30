package com.razvanbalasa.leagueproteammanager;

import android.graphics.Bitmap;

/**
 * Created by PC#54 on 24-Aug-17.
 */

public class Player {
    private String favLane, name, specAbility;
    private int saltLvl;
    Bitmap portrait;
    String color;
    String color2;

    public Player(String name, String favLane, String specAbility, int saltLvl, Bitmap portrait, String color, String color2) {
        this.name = name;
        this.favLane = favLane;
        this.specAbility = specAbility;
        this.saltLvl = saltLvl;
        this.portrait = portrait;
        this.color = color;
        this.color2 = color2;
    }

    public String getName() {
        return name;
    }

    public String getFavLane() {
        return favLane;
    }

    public String getSpecAbility() {
        return specAbility;
    }

    public Bitmap getPortrait() {
        return portrait;
    }

    public int getSaltLvl() {
        return saltLvl;
    }

    public String getColor() {
        return  color;
    }

    public  String getColor2() {
        return  color2;
    }

    public void setName(String name) {
         this.name = name;
    }

}
