package com.github.daniel97111.view;

import com.github.daniel97111.controller.FileSafeController;
import com.github.daniel97111.model.PasswordEntry;
import com.github.daniel97111.model.PasswordSafe;
import org.apache.commons.io.FileUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ViewController {

    public static void main(String[] args) {
        FileSafeController fileSafe = new FileSafeController();
        PasswordSafe passwordSafe = fileSafe.init("src/main/resources/new-pass-keeper-file.pwm");

        Scanner sc = new Scanner(System.in);

        System.out.println("1) Add user\n2) Remove user\n3) Show user\n0) Close");
        int firstCommend = sc.nextInt();

        while (!(firstCommend == 0)) {
            while (!(firstCommend == 0 || firstCommend == 1 || firstCommend == 2 || firstCommend == 3)) {
                System.out.println("nie ma takiej opcji");
                firstCommend = sc.nextInt();
            }
            if (firstCommend == 1) {
                System.out.println("Dodaj dane do swojego serwisu\n->Serwis\n->Login\n->Hasło ");
                PasswordEntry entry = new PasswordEntry(0,sc.next(),sc.next(),sc.next());
                entry = passwordSafe.addEntries(entry.getService(), entry.getLogin(), entry.getPassword());
                fileSafe.saveToFile(Arrays.asList(entry), true);
                System.out.println("next step ");
                firstCommend = sc.nextInt();
            }
            if (firstCommend == 2) {
                System.out.println("Podaj ID które chcesz usunąć ");
                passwordSafe.removeEntries(sc.nextInt());
                fileSafe.saveToFile(new ArrayList<>(passwordSafe.all()), false);
                System.out.println("next step ");
                firstCommend = sc.nextInt();
            }
            if (firstCommend == 3) {
                System.out.println("podaj nz. serwis :");
                System.out.println(passwordSafe.show(sc.next()));
                firstCommend = sc.nextInt();
            }
        }
        System.out.println("-END-");
    }
}
