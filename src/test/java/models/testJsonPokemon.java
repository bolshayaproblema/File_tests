package models;

import java.util.List;

public class testJsonPokemon {
    private String name;
    private  Integer weight;
    private  String talents;
    private  String view;
    private List<pokemonEvolution> evolution;

    public List<pokemonEvolution> getEvolution() {
        return evolution;
    }
    public String getName(){
        return name;
    }

    public Integer getWeight(){
        return weight;
    }
    public String getTalents(){
        return talents;
    }
    public String getView(){
        return  view;
    }
}
