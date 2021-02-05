package com.udogan;

import java.util.ArrayList;

public class Team<T extends Player> {
    private String name;
    int played =0;
    int won = 0;
    int lost =0;
    int tied = 0;

    private ArrayList<T> members = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean addplayer(T player){
        if (members.contains(player)){
            System.out.println(player.getName() + " is already on this team");
            return false;
        }else{
            members.add(player);
            System.out.println(player.getName() + " picked for team");
            return true;
        }
    }

    public int numberOfPlayers(){
        return this.members.size();
    }

    public void matchResult(Team<T> opponent, int ourScore, int theirScore){
        String message;
        if (ourScore >  theirScore) {
            won++;
            message = " beat ";
        }else if (ourScore < theirScore) {
            lost++;
            message = " lost to ";
        }else {
            tied++;
            message = " drew with ";
        }
        played++;
        if (opponent != null) {
            opponent.matchResult(null, theirScore, ourScore);
        }
    }

    public int ranking(){
        return (won * 2) + tied;
    }
}
