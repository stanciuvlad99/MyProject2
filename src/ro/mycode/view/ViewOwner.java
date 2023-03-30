package ro.mycode.view;

import ro.mycode.controllers.ControlCompetition;
import ro.mycode.controllers.ControlEnrolment;
import ro.mycode.controllers.ControlPet;
import ro.mycode.models.Competition;
import ro.mycode.models.Enrolment;
import ro.mycode.models.Owner;
import ro.mycode.models.Pet;

import java.util.ArrayList;
import java.util.Scanner;

public class ViewOwner {

    private Owner owner;
    private ControlCompetition controlCompetition;
    private ControlEnrolment controlEnrolment;
    private ControlPet controlPet;

    public ViewOwner(Owner owner) {
        this.owner=owner;
        this.controlPet = new ControlPet();
        this.controlEnrolment = new ControlEnrolment();
        this.controlCompetition = new ControlCompetition();
        play();
    }

    private void menu() {
        System.out.println("Bine ai venit, " + owner.getLastName() + " " + owner.getFirstName() + "!");
        System.out.println();
        System.out.println("Apasati tasta 1 pentru a vedea toate consursurile");
        System.out.println("Apasati tasta 2 pentru a vedea concursurile la care suneteti inscris");
        System.out.println("Apasati tasta 3 pentru a va inscrie la un nou curs");
        System.out.println("Aapsati tasta 4 pentru a renunta la un concurs");
        System.out.println("Apasati tasta 5 pentru a vedea toate animalele");
        System.out.println("Apasati tasta 6 pentru a vedea animalele proprii ");
        System.out.println("Apasati tasta 7 pentru a adauga un animal in baza de date");
        System.out.println("Apasati tasta 8 pentru a elimina un animal din baza de date");
        System.out.println("Apasati tasat 9 pentru a face update");
        System.out.println("Apasati tasta 10 pentru a vedea cel mai frecventat curs");
    }

    private void play() {
        menu();
        boolean running = true;
        while (running) {
            Scanner scanner = new Scanner(System.in);
            int alegere = Integer.parseInt(scanner.nextLine());
            switch (alegere) {
                case 1:
                    afisreConcursuri();
                    break;
                case 2:
                    inscrieriConcursuri();
                    break;
                case 3:
                    inscriereConcurs();
                    break;
                case 4:
                    renuntareConcurs();
                    break;
                case 5:
                    afisareAnimale();
                    break;
                case 6:
                    animaleProprii();
                    break;
                case 7:
                    adaugareAnimal();
                    break;
                case 8:
                    eliminareAnimal();
                    break;
                case 9:
                    update();
                    break;
                case 10:concursFrecventat();
                break;
                default:
                    break;
            }
        }
    }

    private void afisreConcursuri() {
        controlCompetition.read();
    }

    private void inscrieriConcursuri() {
        ArrayList<Enrolment> inscrieri = controlEnrolment.InscrieriConcurs(owner.getId());
        for (int i = 0; i < inscrieri.size(); i++) {
            Competition competition = controlCompetition.findById(inscrieri.get(i).getCompetitionId());
            System.out.println(competition.descriere());
        }
    }

    private void inscriereConcurs() {
        System.out.println("Introduceti numele concursului");
        Scanner scanner = new Scanner(System.in);
        String numeConcurs = scanner.nextLine();
        Competition competition = controlCompetition.findByName(numeConcurs);
        if (competition != null) {
            Enrolment enrolment = new Enrolment(controlEnrolment.nextId(), owner.getId(), competition.getId());
            controlEnrolment.add(enrolment);
            System.out.println("V-ati inscris la concurs cu succer");
        } else {
            System.out.println(numeConcurs + " nu exista in baza de date");
        }
    }

    private void renuntareConcurs() {
        System.out.println("Introduceti numele concursului");
        Scanner scanner = new Scanner(System.in);
        String numeConcurs = scanner.nextLine();
        Competition competition = controlCompetition.findByName(numeConcurs);
        if (competition != null) {
            Enrolment enrolment = controlEnrolment.findByCompetitionIdOwnerId(competition.getId(), owner.getId());
            if (enrolment != null) {
                controlEnrolment.delete(enrolment);
                System.out.println("Ati renuntai la concurs");
            } else {
                System.out.println("Nu sunteti incris la concursul" + numeConcurs);
            }
        } else {
            System.out.println(numeConcurs + " nu exista in baza de date");
        }
    }

    private void afisareAnimale() {
        controlPet.read();
    }

    private void animaleProprii() {
        ArrayList<Pet> list = controlPet.animaleProprii(owner.getId());
        for (int i = 0; i < list.size(); i++) {
            Pet pet = controlPet.findById(list.get(i).getId());
            System.out.println(pet.descriere());
        }
    }

    private void adaugareAnimal() {
        System.out.println("Introduceti numele si rasa animaluli");
        Scanner scanner = new Scanner(System.in);
        String petName = scanner.nextLine();
        System.out.println("Introduceti rasa animalului");
        String petRace = scanner.nextLine();
        Pet pet = controlPet.findByNameRace(petName, petRace);
        if (pet == null) {
            System.out.println("Introduceti varsta animalului");
            int age = Integer.parseInt(scanner.nextLine());
            Pet pet1 = new Pet(controlPet.nextId(), owner.getId(), age, petRace, petName);
            controlPet.add(pet1);
            System.out.println("Animalul a fost adugat in baza de date");
        } else {
            System.out.println("Animalul exista in baza de date");
        }
    }

    private void eliminareAnimal() {
        System.out.println("Introduceti numele animalului");
        Scanner scanner = new Scanner(System.in);
        String numeAnimal = scanner.nextLine();
        Pet pet = controlPet.findByName(numeAnimal);
        if (pet != null) {
            Pet pet1 = controlPet.findByNameOwnerID(numeAnimal, owner.getId());
            if (pet1 != null) {
                controlPet.removeAnimal(pet1);
                System.out.println("Animalul a fost eliminat din lista");
            } else {
                System.out.println("Animalul nu va apartine");
            }
        } else {
            System.out.println(numeAnimal + " nu exista in baza de date");
        }
    }

    private void update() {
        System.out.println("Introduceti numele animalului");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        Pet pet = controlPet.findByName(name);
        if (pet != null) {
            Pet pet1 = controlPet.findByNameOwnerID(name, owner.getId());
            if (pet1 != null) {
                System.out.println("Introduceti rasa");
                String race = scanner.nextLine();
                System.out.println("Introduceti varsta");
                int age = Integer.parseInt(scanner.nextLine());
                controlPet.update(new Pet(pet1.getId(), owner.getId(), age,race, pet.getName()));
                System.out.println("Animalului i s-a facut update");
            } else {
                System.out.println("Animalul nu va apartine");
            }
        }else {
            System.out.println(name + " nu exista in baza de date");
        }
    }

    private void concursFrecventat(){
        Competition competition = controlCompetition.findById(controlEnrolment.idCealMaiFrecventatConcurs());
        System.out.println(competition.descriere());
    }

}
