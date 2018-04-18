package com.github.daniel97111.view;

import com.github.daniel97111.controller.FileSafeController;
import com.github.daniel97111.model.PasswordEntry;
import com.github.daniel97111.model.PasswordSafe;
import org.apache.commons.io.FileUtils;
import org.beryx.textio.TextIO;
import org.beryx.textio.TextIoFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ViewController {
    TextIO io = TextIoFactory.getTextIO();

    public static void main(String[] args) {
        FileSafeController fileSafe = new FileSafeController();
        PasswordSafe passwordSafe = fileSafe.init("src/main/resources/new-pass-keeper-file.pwm");

        Scanner sc = new Scanner(System.in);
        System.out.println("Login:");
        String login = sc.next();
        while (!login.equals("login12")) {
            System.out.println("try again ! ");
            login = sc.next();
        }
        System.out.println("Password:");
        String pass = sc.next();
        while (!pass.equals("password12")) {
            System.out.println("try again ! ");
            pass = sc.next();
        }

        System.out.println("1) Add user\n2) Remove user\n3) Show user\n0) Close");
        int firstCommend = sc.nextInt();

        while (!(firstCommend == 0)) {
            while (!(firstCommend == 0 || firstCommend == 1 || firstCommend == 2 || firstCommend == 3)) {
                System.out.println("nie ma takiej opcji");
                firstCommend = sc.nextInt();
            }
            if (firstCommend == 1) {
                System.out.println("Add your account details: \n->Service\n->Login\n->Password ");
                PasswordEntry entry = new PasswordEntry(0, sc.next(), sc.next(), sc.next());
                entry = passwordSafe.addEntries(entry.getService(), entry.getLogin(), entry.getPassword());

                fileSafe.saveToFile(Arrays.asList(entry), true);
                System.out.println("next step ");
                firstCommend = sc.nextInt();
            }
            if (firstCommend == 2) {
                System.out.println("Give user ID to remove: ");
                passwordSafe.removeEntries(sc.nextInt());
                fileSafe.saveToFile(new ArrayList<>(passwordSafe.all()), false);
                System.out.println("next step ");
                firstCommend = sc.nextInt();
            }
            if (firstCommend == 3) {
                System.out.println("Give the name of the service:");
                System.out.println(passwordSafe.show(sc.next()));
                firstCommend = sc.nextInt();
            }
        }
        System.out.println("-END-");
    }
}
