package ro.mycode.controllers;

import ro.mycode.models.Competition;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
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

    //todo: functie ce returneaza concursul, primeste competiton id ca parametru
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
    public void removeCompetition(Competition competition){
        this.competitions.remove(competition);
    }

    //todo: functie ce returneaza un id valid
    public int nextId(){
        if (competitions.size()==0){
            return -1;
        }
        return competitions.get(competitions.size()-1).getId()+1;
    }

    //todo: functie ce adauga in lista un concurs, primeste constructor ca parametru
    public void add(Competition competition){
        this.competitions.add(competition);
    }


    //todo: functie ce face update numelui, primeste constructor ca parametru
    public void updateName(Competition competition){
        Competition update=findById(competition.getId());
        if (competition.getName().equals("")==false){
            update.setName(competition.getName());
        }
    }

    //todo: functie ce face update locatiei si id-ului unui concurs, prineste constructor ca parametru
    public void updateLocationId(Competition competition){
        Competition update=findByName(competition.getName());
        if (competition.getName().equals("")==false){
            update.setName(competition.getName());
        }
        if (competition.getLocation().equals("")==false){
            update.setLocation(competition.getLocation());
        }
    }

    //todo: functeie ce returneaza toate concursurile
    public String toSave(){
        int i=0;
        String save="";
        for (i=0; i<competitions.size()-1; i++){
            save+=competitions.get(i).toSave()+"\n";
        }
        save+=competitions.get(i).toSave();
        return save;
    }

    public void save() {
        try {
            File file = new File(FINAL_URL);
            FileWriter fileWriter = new FileWriter(file);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.print(toSave());
            printWriter.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
