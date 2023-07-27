package org.java.travelagency;

/* Chiediamo all’operatore se vuole inserire una nuova vacanza o uscire.
Se vuole proseguire con l’inserimento va chiesta la destinazione, il giorno, mese e anno di partenza
e il giorno, mese anno di ritorno.
Con questi dati va generata una nuova vacanza e in console verrà stampato un messaggio del tipo:
“Hai prenotato una vacanza di [numero di giorni] giorni a [destinazione] dal [data inizio formattata] al
[data fine formattata]“.
Se la creazione della vacanza genera un errore, il programma non deve interrompersi ma va gestito con
dei messaggi di errore che permettono all’utente di capire cosa è andato storto e di ripetere l’inserimento.
*/

import java.time.LocalDate;
import java.util.Scanner;

public class Agency {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("*****WELCOME TO JAVA TRAVEL AGENCY*****");

        // chiedere se vuole comprare una vacanza o uscire
        // finchè non vuole uscire vuole comprare una vacanza
        boolean exit = false;
        Holiday holiday = null;
        while (!exit) {
            System.out.println("What do you want to do? (1 = book a holiday; 2 = exit): ");
            String choice= scan.nextLine();
            switch (choice){
                case "1":
                    // l'utente inserisce la destinazione e le date della sua vacanza
                    while (holiday == null) {
                        System.out.println("Choose a destination: ");
                        String destination = scan.nextLine();
                        System.out.println("From (yyyy-mm-dd): ");
                        LocalDate startOfHoliday = null;
                        try {
                            startOfHoliday = LocalDate.parse(scan.nextLine());
                        } catch (Exception e) {
                            System.out.println("Invalid date format.");
                        }
                        System.out.println("To (yyyy-mm-dd): ");
                        LocalDate endOfHoliday = null;
                        try {
                            endOfHoliday = LocalDate.parse(scan.nextLine());
                        } catch (Exception e) {
                            System.out.println("Invalid date format.");
                        }
                        try {
                            holiday = new Holiday(destination, startOfHoliday, endOfHoliday);
                        } catch (Exception e){
                            System.out.println("Invalid parameters.");
                            System.out.println(e.getMessage());
                        }
                    }
                    System.out.println(holiday);
                    break;
                case "2":
                    // l'utente decide di uscire
                    exit= true;
                    System.out.println("Bye bye!");
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
    }
}
