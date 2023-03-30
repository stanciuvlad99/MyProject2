package ro.mycode;

import ro.mycode.controllers.*;
import ro.mycode.models.*;
import ro.mycode.view.ViewAdmin;
import ro.mycode.view.ViewLogin;
import ro.mycode.view.ViewOwner;

public class Main {
    public static void main(String[] args) {

        ViewLogin viewLogin = new ViewLogin();
        System.out.println(viewLogin);

//        ControlPet controlPet = new ControlPet();
//        controlPet.add(new Pet("10,10,10,Norvegiana de padure,Thor"));
//        controlPet.save();

//        ControlOwner controlOwner = new ControlOwner();
//        controlOwner.add(new Owner("9,Stefanescu,Elena,33,elena.stefanescu@example.com,Elena456!"));
//        controlOwner.save();

//        ControlAdmin controlAdmin = new ControlAdmin();
//        controlAdmin.add(new Admin("9,dan.badea@example.com,Dan456#,Badea,Dan"));
//        controlAdmin.save();

//        ControlEnrolment controlEnrolment = new ControlEnrolment();
//        controlEnrolment.add(new Enrolment("10,10,10"));
//        controlEnrolment.save();

//        ControlCompetition controlCompetition = new ControlCompetition();
//        controlCompetition.add(new Competition("10,Cat Beauty Contest,Birmingham-Tokyo-Japonia"));
//        controlCompetition.save();
    }
}