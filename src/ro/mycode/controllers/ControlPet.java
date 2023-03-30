package ro.mycode.controllers;

import ro.mycode.models.Pet;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
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

    //todo: functie ce fiseaza toate animalel
    public void read(){
        for (int i=0; i<pets.size(); i++){
            System.out.println(pets.get(i).descriere());
        }
    }

    //todo: functie ce returneaz lista cu animale, primeste owner id ca parametru
    public ArrayList<Pet> animaleProprii(int ownerId){
        ArrayList<Pet> lista = new ArrayList<>();
        for (int i=0; i<pets.size(); i++){
            if (pets.get(i).getOwnerId()==ownerId){
                lista.add(pets.get(i));
            }
        }
        return lista;
    }

    //todo: functie ce returnaza un animale, primeste pet id ca parametru
    public Pet findById(int petId){
        for (int i=0; i<pets.size(); i++){
            if (pets.get(i).getId()==petId) {
                return pets.get(i);
            }
        }
        return null;
    }

    //todo: functie ce returneaza animal, primeste ca parametru pet name si pet race
    public Pet findByNameRace(String petName, String petRace){
        for (int i=0; i<pets.size(); i++){
            if (pets.get(i).getName().equals(petName) && pets.get(i).getRace().equals(petRace)){
                return pets.get(i);
            }
        }
        return null;
    }

    //todo: functie ce returneaza un id valabil
    public int nextId(){
        if (pets.size()==0){
            return -1;
        }
        return pets.get(pets.size()-1).getId()+1;
    }

    //todo: functie ce adauga un animal in baza de date, primeste constructor ca parametru
    public void add(Pet pet){
        pets.add(pet);
    }

    //todo:functie ce returneaza animal, primeste nume ca parametru
    public Pet findByName(String name){
        for (int i=0; i<pets.size(); i++){
            if (pets.get(i).getName().equals(name)){
                return pets.get(i);
            }
        }
        return null;
    }

    //todo: functie ce returneaza animal, primeste ca parametri nume si owner id
    public Pet findByNameOwnerID(String name, int ownerId){
        for (int i=0; i<pets.size(); i++){
            if (pets.get(i).getName().equals(name) && pets.get(i).getOwnerId()==ownerId){
                return pets.get(i);
            }
        }
        return null;
    }

    //todo: funtie ce elimina un animal din lista, primeste construcor ca parametru
    public void removeAnimal(Pet pet){
        pets.remove(pet);
    }

    //todo: functie ce face update unui animal, primeste constrctor ca parametru
    public void update(Pet pet) {
        Pet update = findByName(pet.getName());
        if (pet.getRace().equals("") == false) {
            update.setRace(pet.getRace());
        }
        if ((pet.getAge() == 0) == false) {
            update.setAge(pet.getAge());
        }
    }

    //todo: functie ce returneaza toate animalel
    public String toSave(){
        int i=0;
        String pets="";
        for (i=0; i<this.pets.size()-1; i++){
            pets+=this.pets.get(i).toSave()+"\n";
        }
        pets+=this.pets.get(i).toSave();
        return pets;
    }

    //todo: functie ce salveaza fisier text pets
    public void save(){
        try {
            File file = new File(FINAL_URL);
            FileWriter fileWriter = new FileWriter(file);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.print(this.toSave());
            printWriter.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
