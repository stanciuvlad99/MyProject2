package ro.mycode.controllers;

import ro.mycode.models.Enrolment;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ControlEnrolment {
    private ArrayList<Enrolment> enrolments;
    final String FINAL_URL="C:\\mycode\\OOP\\Incapsularea\\MyProject4\\src\\ro\\mycode\\data\\enrolment.txt";

    public ControlEnrolment(){
        this.enrolments=new ArrayList<>();
        load();
    }

    public void load(){
        try {
            File file=new File(FINAL_URL);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()){
                String text=scanner.nextLine();
                Enrolment enrolment = new Enrolment(text);
                this.enrolments.add(enrolment);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //todo: functie ce afiseaza toate concursurile
    public void read(){
        for (int i=0; i<enrolments.size(); i++){
            System.out.println(enrolments.get(i).descriere());
        }
    }

    //todo: functie ce returneaza o lista de inscireri, primeste owner id ca parametru
    public ArrayList<Enrolment> InscrieriConcurs(int ownerId){
        ArrayList<Enrolment> list = new ArrayList<>();
        for (int i=0; i<enrolments.size(); i++){
            if (enrolments.get(i).getOwnerId()==ownerId){
                list.add(enrolments.get(i));
            }
        }
        return list;
    }

    //todo: functie ce returneaza un id valid
    public int nextId(){
        if (enrolments.size()==0){
            return -1;
        }
        return enrolments.get(enrolments.size()-1).getId()+1;
    }

    //todo: functie ce adauga inscriere in baza de date, primeste constructor ca parametru
    public void add(Enrolment enrolment){
        this.enrolments.add(enrolment);
    }

    //todo: functie ce returneaza inscriere, primeste constructori competition id si owner id
    public Enrolment findByCompetitionIdOwnerId(int competitionId, int ownerId){
        for (int i=0 ; i<enrolments.size(); i++){
            if (enrolments.get(i).getCompetitionId()==competitionId && enrolments.get(i).getOwnerId()==ownerId){
                return enrolments.get(i);
            }
        }
        return null;
    }

    //todo: functie ce elimina o insciere din lista, primeste constructor ca parametru
    public void delete(Enrolment enrolment){
        this.enrolments.remove(enrolment);
    }

    //functie ce returneaza frecvenat concursurilor
    public int[] frecvenata(){
        int []frecventa=new int[1000];
        for (int i=0; i<enrolments.size(); i++){
            frecventa[enrolments.get(i).getOwnerId()]++;
        }
        return frecventa;
    }

    public int pozitieMaximaConcurs(int []vector){
        int max=vector[0];
        int pozitieMax=0;

        for (int i=0; i< vector.length; i++){
            if (max<vector[i]){
                max=vector[i];
                pozitieMax=i;
            }
        }
        return pozitieMax;
    }

    public int idCealMaiFrecventatConcurs(){
        return pozitieMaximaConcurs(frecvenata());
    }
}
