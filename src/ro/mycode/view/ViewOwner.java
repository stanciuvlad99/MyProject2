package ro.mycode.view;

import java.util.Scanner;

public class ViewOwner {


    public ViewOwner() {

    }

    private void menu() {

    }

    private void play() {
        menu();
        boolean running = true;
        while (running) {
            Scanner scanner = new Scanner(System.in);
            int alegere = Integer.parseInt(scanner.nextLine());
            switch (alegere) {
                case 1:
                    break;
                default:
                    break;
            }
        }
    }
    
}
