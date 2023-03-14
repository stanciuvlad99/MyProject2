package ro.mycode.controllers;

import ro.mycode.models.Owner;

import java.io.File;
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


    //todo: functie ce afiseasa toti stapanii
    public void read() {
        for (int i = 0; i < owners.size(); i++) {
            System.out.println(owners.get(i).descriere());
        }
    }
}
