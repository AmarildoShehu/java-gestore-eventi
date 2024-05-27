package MusicEvents;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input per il nuovo evento
        System.out.print("Inserisci il titolo dell'evento: ");
        String title = scanner.nextLine();

        LocalDate date = null;
        while (date == null) {
            System.out.print("Inserisci la data dell'evento (YYYY-MM-DD): ");
            try {
                date = LocalDate.parse(scanner.nextLine());
                if (date.isBefore(LocalDate.now())) {
                    System.err.println("La data inserita è già passata. Riprova: ");
                    date = null;
                }
            } catch (DateTimeException e) {
                System.err.println("Formato data invalida. Riprova: ");
            }
        }

        int totalSeats = 0;
        while (totalSeats <= 0) {
            System.out.print("Inserisci il numero di posti totali: ");
            try {
                totalSeats = Integer.parseInt(scanner.nextLine());
                if (totalSeats <= 0) {
                    System.err.println("Il numero deve essere positivo. Riprova: ");
                }
            } catch (NumberFormatException e) {
                System.err.println("Numero non valido. Riprova: ");
            }
        }

        // Creazione istanza evento
        Event event = null;
        try {
            event = new Event(title, date, totalSeats);
            System.out.println("Evento creato: " + event);
        } catch (IllegalArgumentException e) {
            System.err.println("Errore nella creazione dell'evento: " + e.getMessage());
            System.exit(1);
        }

        // Prenotazione posto
        System.out.print("Vuoi prenotare dei posti? (si/no): ");
        if (scanner.next().equalsIgnoreCase("si")) {
            boolean bookingSuccessful = false;
            while (!bookingSuccessful) {
                System.out.print("Inserisci il numero di posti che vuoi prenotare: ");
                try {
                    int seatsToBook = Integer.parseInt(scanner.nextLine());
                    event.book(seatsToBook);
                    System.out.println("Posti prenotati con successo.");
                    bookingSuccessful = true;
                } catch (IllegalStateException | NumberFormatException e) {
                    System.err.println("Errore nella prenotazione dei posti: " + e.getMessage() + ". Riprova.");
                }
            }
        }

        printSeatsInfo(event);

        // Cancellazione prenotazione
        System.out.print("Vuoi cancellare dei posti? (si/no): ");
        if (scanner.next().equalsIgnoreCase("si")) {
            boolean cancelSuccessful = false;
            while (!cancelSuccessful) {
                System.out.print("Inserisci il numero di posti che vuoi cancellare: ");
                try {
                    int seatsToCancel = Integer.parseInt(scanner.nextLine());
                    event.cancel(seatsToCancel);
                    System.out.println("Posti cancellati con successo.");
                    cancelSuccessful = true;
                } catch (IllegalStateException | NumberFormatException e) {
                    System.err.println("Errore nella cancellazione dei posti: " + e.getMessage() + ". Riprova.");
                }
            }
        }

        printSeatsInfo(event);
        scanner.close();
    }

    // Mostro i posti prenotati e quelli ancora disponibili
    private static void printSeatsInfo(Event event) {
        int bookedSeats = event.getBookedSeats();
        int availableSeats = event.getTotalSeats() - bookedSeats;
        System.out.println("Posti prenotati: " + bookedSeats);
        System.out.println("Posti ancora disponibili: " + availableSeats);
    }
}
