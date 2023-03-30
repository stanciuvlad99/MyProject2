package ro.mycode.view;

import ro.mycode.controllers.ControlAdmin;
import ro.mycode.controllers.ControlOwner;
import ro.mycode.models.Admin;
import ro.mycode.models.Owner;

import java.util.Scanner;

public class ViewLogin {
    private ControlAdmin controlAdmin;
    private ControlOwner controlOwner;

    public ViewLogin() {
        this.controlAdmin = new ControlAdmin();
        this.controlOwner = new ControlOwner();
        login();
    }

    private void login() {
        System.out.println("Introduceti adresa de mail");
        Scanner scanner = new Scanner(System.in);
        String email = scanner.nextLine();
        System.out.println("Introduceti parola");
        String password = scanner.nextLine();
        Owner owner = controlOwner.findByEmailPassword(email, password);
        Admin admin = controlAdmin.findByEmailPassword(email, password);

        if (owner != null) {
            ViewOwner viewOwner = new ViewOwner(owner);
            System.out.println(viewOwner);
        }
        if (admin != null) {
            ViewAdmin viewAdmin = new ViewAdmin(admin);
            System.out.println(viewAdmin);
        }
        if (owner==null && admin==null){
            System.out.println("ERROR - Adresa de mail sau parola sunt gresite");
        }

    }
}
