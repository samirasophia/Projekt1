package org.example;

import java.util.Scanner;

public class Projekt1 {
    public static void main(String[] args) {


        String password = Passwordeingabe();
        int laenge = password.length();
        int i = 0;
        String [] usedPasswords = new String[i];
        usedPasswords[i] = "meow";
        // 8 Zeichen lang
        do { eingabe(laenge, password, usedPasswords);
            usedPasswords[i] = password;
        i++;
        }
        while(!prüfer(laenge, password, usedPasswords));
        System.out.println("gutes Passwort bro");

    }


    public static boolean grossbuchstaben(String password) {

        for (int i = 0; i < password.length() - 1; i++) {

            if (Character.isUpperCase(password.charAt(i)))
                return true;
        }
        return false;
    }


    public static boolean kleinbuchstaben(String password) {
        for (int i = 0; i < password.length() - 1; i++) {

            if (Character.isLowerCase(password.charAt(i))) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }


    public static String Passwordeingabe() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Gib ein Passwort ein");
        String Password = sc.nextLine();
        return Password;
    }

    public static boolean Zeichenlaenge(int laenge) {

        if (laenge >= 8) {
            return true;
        } else {
            return false;
        }

    }

    public static boolean Ziffern(String password) {
        for (int i = 0; i < password.length() - 1; i++) {

            if (Character.isDigit(password.charAt(i))) {
                return true;
            }}
                return false;
            }


    public static boolean Sonderzeichen(String password) {
        for (int i = 0; i < password.length() - 1; i++) {

            boolean containsSpecialChars = password.matches(".*[@#$%&+].*");
            if (!containsSpecialChars) {
                return true;
            }
              else {
                return false;
              }
        }
        return false;
    }



public static boolean prüfer (int laenge, String password, String usedPasswords []){
    if (Zeichenlaenge(laenge)&&Ziffern(password)&&grossbuchstaben(password)&&kleinbuchstaben(password)){
        return true;
    } else {
        return false;
    }
    }

public static void eingabe (int laenge, String password, String usedPasswords[]){
    if (Zeichenlaenge(laenge)) {
        System.out.println("mehr als 8 zeichen");
    } else {
        while (laenge < 8) {
            System.out.println("invalid, choose a longer one");

            password = Passwordeingabe();
            laenge = password.length();
        }
        System.out.println("genug zeichen");
    }
    //Ziffern prüfen
    if (Ziffern(password)){
        System.out.println("mehr als 8 zeichen");
    } else {
        while (Ziffern(password) == false) {
            System.out.println("invalid, choose a new one with digits");

            password = Passwordeingabe();

        }
        System.out.println("Ziffern");
    }
//kleinbuchstaben
    if (kleinbuchstaben(password)) {
        System.out.println("enthält kleinbuchstaben");
    } else {
        while (kleinbuchstaben(password) == false) {
            System.out.println("invalid, choose a new one with lower case letters");
            password = Passwordeingabe();
        }
        System.out.println("hat kleinbuchstaben");
    }
    // Grossbuchstaben
    if (grossbuchstaben(password)) {
        System.out.println("enthält grossbuchstaben");
    } else {
        while (grossbuchstaben(password) == false) {
            System.out.println("invalid, choose a new one with upper case letters");
            password = Passwordeingabe();
        }
        System.out.println("hat grossbuchstaben");
    }
    if (checkPassword(password, usedPasswords)) {
        System.out.println("wurde noch nicht benutzt");
    } else {
            while (checkPassword(password, usedPasswords) == false) {
                System.out.println("invalid, choose a new one with upper case letters");
                password = Passwordeingabe();
        }
            System.out.println("wurde noch nicht benutz");
    }
    if (Sonderzeichen(password)) {
        System.out.println("wurde noch nicht benutzt");
    } else {
        while (checkPassword(password, usedPasswords) == false) {
            System.out.println("invalid, choose one with a special char");
            password = Passwordeingabe();
        }
        System.out.println("hat Sonderzeichen");
    }
}
public static void pruefer (String password, int laenge){
        grossbuchstaben(password);
        kleinbuchstaben(password);
        Ziffern(password);
        Zeichenlaenge(laenge);
    Sonderzeichen(password);
}

   public static boolean checkPassword(String password, String usedPasswords[]) {
        if (usedPasswords.equals(password)) {
            System.out.println("Passwort wurde bereits benutzt.");
            return false;
        }

        return true;
}}




