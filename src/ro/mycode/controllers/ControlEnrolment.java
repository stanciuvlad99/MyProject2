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
}
