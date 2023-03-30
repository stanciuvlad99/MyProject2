package ro.mycode.view;

import ro.mycode.controllers.ControlCompetition;
import ro.mycode.controllers.ControlOwner;
import ro.mycode.controllers.ControlPet;
import ro.mycode.models.Admin;
import ro.mycode.models.Competition;
import ro.mycode.models.Owner;
import ro.mycode.models.Pet;

import java.util.ArrayList;
import java.util.Scanner;

public class ViewAdmin {
    private Admin admin;
    private ControlPet controlPet;
    private ControlOwner controlOwner;
    private ControlCompetition controlCompetition;

    public ViewAdmin(Admin admin) {
        this.admin=admin;
        this.controlPet=new ControlPet();
        this.controlCompetition = new ControlCompetition();
        this.controlOwner = new ControlOwner();
        play();
    }

    public void menu() {
        System.out.println("Bine ai venit, " + admin.getLastName() + " " + admin.getFirstName() + "!");
        System.out.println();
        System.out.println("Apasati tasta 1 pentru a vedea toti concurentii");
        System.out.println("Apasati tasta 2 pentru a dauga un concurent in baza de date");
        System.out.println("Apasati tasta 3 pentru a elimina un concurent din baza de date");
        System.out.println("Apasati tasta 4 pentru a vededa toate concursurile");
        System.out.println("Apasati tasta 5 pentru a adauga un concurs in basa de date");
        System.out.println("Apasati tsata 6 pentru a elimina un concurs din baza de date");
        System.out.println("Apasati tasta 7 pentru a face update unui concurs");
        System.out.println("Apasati tasta 8 pentru a vedea animalele unui concurent");
    }

    public void play() {
        menu();
        boolean running = true;
        while (running) {
            Scanner scanner = new Scanner(System.in);
            int alegere = Integer.parseInt(scanner.nextLine());
            switch (alegere) {
                case 1:
                    afisareConcurenti();
                    break;
                case 2:
                    adaugareConcurent();
                    break;
                case 3:
                    eliminareConcurent();
                    break;
                case 4:
                    afisareConcursuri();
                    break;
                case 5:
                    adaugareConcurs();
                    break;
                case 6:
                    eliminareCncurs();
                    break;
                case 7:updateConcurs();
                break;
                case 8:animaleConcurent();
                break;
                default:
                    break;
            }
        }
    }

    private void afisareConcurenti() {
        controlOwner.read();
    }

    public void adaugareConcurent() {
        System.out.println("Introduceti numele de familie");
        Scanner scanner = new Scanner(System.in);
        String firstName = scanner.nextLine();
        System.out.println("Introduceti prenumele");
        String lastName = scanner.nextLine();
        Owner owner = controlOwner.findByFirstNameLastName(firstName, lastName);
        if (owner == null) {
            System.out.println("Introduceti varsta concurentului");
            int age = Integer.parseInt(scanner.nextLine());
            System.out.println("Introduceti adresa de mail");
            String email = scanner.nextLine();
            System.out.println("Introduceti parola");
            String paswword = scanner.nextLine();
            Owner owner1 = new Owner(controlOwner.nextId(), firstName, lastName, age, email, paswword);
            controlOwner.add(owner1);
            System.out.println("Concurentul a fost adagat in baza de date");
        } else {
            System.out.println(lastName + lastName + " exiata deja in baza de date");
        }
    }

    private void eliminareConcurent() {
        System.out.println("Introduceti numele de familie al concurentului");
        Scanner scanner = new Scanner(System.in);
        String firstName = scanner.nextLine();
        System.out.println("Introduceti prenumele");
        String lastName = scanner.nextLine();
        Owner owner = controlOwner.findByFirstNameLastName(firstName, lastName);
        if (owner != null) {
            controlOwner.removeOwner(owner);
            System.out.println("Concurentul a fost eliminat din baza de date");
        } else {
            System.out.println(lastName + " " + firstName + " nu exiata in baza de date");
        }
    }

    private void afisareConcursuri() {
        controlCompetition.read();
    }

    public void adaugareConcurs() {
        System.out.println("Introduceti numele concursului");
        Scanner scanner = new Scanner(System.in);
        String numeConcurs = scanner.nextLine();
        Competition competition = controlCompetition.findByName(numeConcurs);
        if (competition == null) {
            System.out.println("Intrododuceti numele locatiei concursului");
            String locatie = scanner.nextLine();
            Competition competition1 = new Competition(controlCompetition.nextId(), numeConcurs, locatie);
            controlCompetition.add(competition1);
            System.out.println("Concursul a fost adaugat in baza de date");
        } else {
            System.out.println(numeConcurs + " exista deja in baza de date");
        }
    }

    public void eliminareCncurs() {
        System.out.println("Introduceti numele concursului");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        Competition competition = controlCompetition.findByName(name);
        if (competition != null) {
            controlCompetition.removeCompetition(competition);
            System.out.println("Concursul a fost eliminat din baza de date");
        } else {
            System.out.println(name + " nu exista in baza de date");
        }
    }

    public void updateConcurs(){
        System.out.println("Introduceti numele concursului");
        Scanner scanner = new Scanner(System.in);
        String numeConcurs = scanner.nextLine();
        Competition competition = controlCompetition.findByName(numeConcurs);
        if (competition!=null){
            System.out.println("Introduceti noul nume al concursului");
            String newName= scanner.nextLine();
            controlCompetition.updateName(new Competition(competition.getId(),newName,competition.getLocation()));
            System.out.println("Introduceti nouwa locatie aconcursului");
            String newLocation=scanner.nextLine();
            System.out.println("Introduceti noul id al concursului");
            int newID=Integer.parseInt(scanner.nextLine());
            controlCompetition.updateLocationId(new Competition(newID,competition.getName(),newLocation));
            System.out.println("Concursului i s-a facut update cu succes");
        }else {
            System.out.println(numeConcurs + " nu exista in baza de date");
        }
    }

    private void animaleConcurent(){
        System.out.println("Introduceti numele de familie al concurentului");
        Scanner scanner = new Scanner(System.in);
        String lastName=scanner.nextLine();
        System.out.println("Introduceti prenumele concurentului");
        String firstName=scanner.nextLine();
        Owner owner = controlOwner.findByFirstNameLastName(lastName,firstName);
        if (owner!=null){
            ArrayList<Pet> pets = controlPet.animaleProprii(owner.getId());
            for (int i=0; i<pets.size(); i++){
                Pet pet = controlPet.findById(pets.get(i).getId());
                System.out.println(pet.descriere());
            }
        }else {
            System.out.println(lastName + " " + firstName + " nu exista in basa de date");
        }
    }
}
