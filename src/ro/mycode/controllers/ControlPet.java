package ro.mycode.controllers;

import ro.mycode.models.Pet;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ControlPet {
    private ArrayList<Pet> pets;
    final String FINAL_URL="C:\\mycode\\OOP\\Incapsularea\\MyProject4\\src\\ro\\mycode\\data\\pet.txt";

    public ControlPet(){
        this.pets=new ArrayList<>();
        load();
    }

    private void load(){
        try {
            File file = new File(FINAL_URL);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()){
                String text=scanner.nextLine();
                Pet pet = new Pet(text);
                this.pets.add(pet);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //functie ce fiseaza toate animalel
    public void read(){
        for (int i=0; i<pets.size(); i++){
            System.out.println(pets.get(i).descriere());
        }
    }
}
