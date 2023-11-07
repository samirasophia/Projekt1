package org.example;
import java.util.Scanner;
public class Passwordchecker {

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            String password = Passwordeingabe();
            int laenge = password.length();
            String[] usedPasswords = new String[1];
            usedPasswords[0] = "meow";
            int i = 1;

            do {
                eingabe(laenge, password, usedPasswords);
                usedPasswords[i] = password;
                i++;
            } while (!prüfer(laenge, password, usedPasswords));

            System.out.println("gutes Passwort bro");
        }

        private static boolean grossbuchstaben(String password) {
            if (password.matches(".*[A-Z].*") && password.length() >= 8) {
                return true;
            } else {
                return false;
            }
        }
   public static boolean kleinbuchstaben(String password) {
        if (password.matches(".*[A-Z].*") && password.length() >= 8) {
            return true;
        } else {
            return false;
        }
    }

        public static boolean Ziffern(String password) {
            for (int i = 0; i < password.length(); i++) {
                if (Character.isDigit(password.charAt(i))) {
                    return true;
                }
            }
            return false;
        }

        public static boolean prüfer(int laenge, String password, String usedPasswords[]) {
            return Zeichenlaenge(laenge) && Ziffern(password) && grossbuchstaben(password) && kleinbuchstaben(password);
        }

        public static void eingabe(int laenge, String password, String usedPasswords[]) {
            if (!Zeichenlaenge(laenge)) {
                while (laenge < 8) {
                    System.out.println("invalid, chose a longer one");
                    password = Passwordeingabe();
                    laenge = password.length();
                }
                System.out.println("genug zeichen");
            }

            if (!Ziffern(password)) {
                while (!Ziffern(password)) {
                    System.out.println("invalid, chose a new one with digits");
                    password = Passwordeingabe();
                }
                System.out.println("Ziffern");
            }

            if (!kleinbuchstaben(password)) {
                while (!kleinbuchstaben(password)) {
                    System.out.println("invalid, chose a new one with lower case letters");
                    password = Passwordeingabe();
                }
                System.out.println("hat kleinbuchstaben");
            }

            if (!grossbuchstaben(password)) {
                while (!grossbuchstaben(password)) {
                    System.out.println("invalid, chose a new one with upper case letters");
                    password = Passwordeingabe();
                }
                System.out.println("hat grossbuchstaben");
            }

            if (checkPassword(password, usedPasswords)) {
                System.out.println("wurde noch nicht benutzt");
            } else {
                while (!checkPassword(password, usedPasswords)) {
                    System.out.println("invalid, chose a new one with upper case letters");
                    password = Passwordeingabe();
                }
                System.out.println("wurde noch nicht benutzt");
            }
        }

        public static void pruefer(String password, int laenge) {
            grossbuchstaben(password);
            kleinbuchstaben(password);
            Ziffern(password);
            Zeichenlaenge(laenge);
        }

        public static boolean checkPassword(String password, String usedPasswords[]) {
            for (String usedPassword : usedPasswords) {
                if (usedPassword.equals(password)) {
                    System.out.println("Passwort wurde bereits benutzt.");
                    return false;
                }
            }
            return true;
        }

        public static boolean Zeichenlaenge(int laenge) {
            return laenge >= 8;
        }

        public static String Passwordeingabe() {
            Scanner sc = new Scanner(System.in);
            System.out.println("Passwort eingeben: ");
            return sc.nextLine();
        }
    }

