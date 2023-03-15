package ro.mycode.controllers;

import ro.mycode.models.Competition;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ControlCompetition {
    private ArrayList<Competition> competitions;
    private final String FINAL_URL="C:\\mycode\\OOP\\Incapsularea\\MyProject4\\src\\ro\\mycode\\data\\competition.txt";

    public ControlCompetition(){
        this.competitions=new ArrayList<>();
        load();
    }

    public void load() {
        try {
            File file = new File(FINAL_URL);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()){
                String text=scanner.nextLine();
                Competition competition = new Competition(text);
                this.competitions.add(competition);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //todo: functie ce afiseaza toate concursurile
    public void read(){
        for (int i=0; i<competitions.size(); i++){
            System.out.println(competitions.get(i).descriere());
        }
    }

    //functie ce returneaza concursul, primeste competiton id ca parametru
    public Competition findById(int competitionId){
        for (int i=0; i<competitions.size(); i++){
            if (competitions.get(i).getId()==competitionId){
                return competitions.get(i);
            }
        }
        return null;
    }

    //todo: functie ce returneaza cuncurs, primeste nume ca parametru
    public Competition findByName(String name){
        for (int i=0; i<competitions.size(); i++){
            if (competitions.get(i).getName().equals(name)){
                return competitions.get(i);
            }
        }
        return null;
    }

    //todo: functie ce elimina un concurs din baza de date, primeste constructor ca parametru
    public void delete(Competition competition){
        this.competitions.remove(competition);
    }
}
