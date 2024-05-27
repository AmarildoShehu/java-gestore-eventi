package MusicEvents;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Inserisci il titolo dell'evento: ");
        String title = scanner.nextLine();

        LocalDate date = null;
        while (date == null) {
            System.out.print("Inserisci la data dell'evento (YYYY-MM-DD): ");
            try {
                date = LocalDate.parse(scanner.nextLine());
            } catch (DateTimeException e) {
                System.err.println("Formato data invalida. Riprova: ");
            }
        }

        int totalSeats = 0;
        while (totalSeats <= 0) {
            System.out.print("Inserisci quanti posti vui prenotare : ");
            try {
                totalSeats = Integer.parseInt(scanner.nextLine());
                if (totalSeats <= 0 ) {
                    System.err.println("Il numero deve essere positivo, Riprova : ");
                }
            } catch (NumberFormatException e ) {
                System.err.println("Numero non valido, Riprova: ");
            }
        }


        scanner.close();
    }
}
