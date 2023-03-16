package ro.mycode.controllers;

import ro.mycode.models.Owner;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ControlOwner {
    private ArrayList<Owner> owners;
    private final String FINLA_URL="C:\\mycode\\OOP\\Incapsularea\\MyProject4\\src\\ro\\mycode\\data\\owner.txt";

    public ControlOwner() {
        this.owners = new ArrayList<>();
        load();
    }

    private void load(){
        try {
            File file = new File(FINLA_URL);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()){
                String text=scanner.nextLine();
                Owner owner = new Owner(text);
                this.owners.add(owner);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    //todo: functie ce afiseasa toti concurent
    public void read() {
        for (int i = 0; i < owners.size(); i++) {
            System.out.println(owners.get(i).descriere());
        }
    }

    //todo: functie ce returneaza concurent, primeste firstName si lastName ca parametri
    public Owner findByFirstNameLastName(String lastName, String firstName){
        for (int i=0; i<owners.size(); i++){
            if (owners.get(i).getFirstName().equals(firstName) && owners.get(i).getLastName().equals(lastName)){
                return owners.get(i);
            }
        }
        return null;
    }

    //todo: functie ce returneaza un id valid
    public int nextId(){
        if (owners.size() == 0){
            return -1;
        }
        return owners.get(owners.size()-1).getId()+1;
    }

    //todo: functie ce adauga in lista un concurent, primeste constructor ca parametru
    public void add(Owner owner){
        this.owners.add(owner);
    }

    //todo: functie ce elimina un concurent, primeste constructor ca paeametru
    public void removeOwner(Owner owner){
        this.owners.remove(owner);
    }

    //todo: functie ce returneaza un concurent, primeste parametri email si parola
    public Owner findByEmailPassword(String email, String password){
        for (int i=0; i<owners.size(); i++){
            if (owners.get(i).getEmail().equals(email) && owners.get(i).getPassword().equals(password)){
                return owners.get(i);
            }
        }
        return null;
    }

    //todo: functie ce returneaza toti concurentii
    public String toSave(){
        String save="";
        for (int i=0; i<owners.size(); i++){
            save+=owners.get(i).toSave()+"\n";
        }
        return save;
    }

    //todo: functie ce salveaza fisier text owner
    public void save(){
        try {
            File file = new File(FINLA_URL);
            FileWriter fileWriter = new FileWriter(file);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.print(toSave());
            printWriter.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
