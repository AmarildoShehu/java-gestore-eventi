package MusicEvents;

import java.time.LocalDate;

public class Event {
    private String title;
    private LocalDate date;
    private int totalSeats;
    private int bookedSeats;

    public Event(String title, LocalDate date, int totalSeats) {
        if(date.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("L'evento è già passato.");
        }
        if (totalSeats <= 0) {
            throw new IllegalArgumentException("Non ci sono abbastanza posti disponibili.");
        }
        this.title = title;
        this.date = date;
        this.totalSeats = totalSeats;
        this.bookedSeats = 0;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        if (date.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("L'evento è già passato.");
        }
        this.date = date;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public int getBookedSeats() {
        return bookedSeats;
    }


    public void book(int seats) {
        if (date.isBefore(LocalDate.now())) {
            throw new IllegalStateException("L'evento è già passato.");
        }
        if (bookedSeats + seats > totalSeats) {
            throw new IllegalStateException("Non ci sono abbastanza posti disponibili.");
        }
        bookedSeats += seats;
    }

    public void cancel(int seats) {
        if (date.isBefore(LocalDate.now())) {
            throw new IllegalStateException("L'evento è già passato.");
        }
        if (bookedSeats - seats < 0) {
            throw new IllegalStateException("Non ci sono piu prenotazioni cancellabili.");
        }
        bookedSeats -= seats;
    }

    @Override
    public String toString() {
        return date + " - " + title;
    }
}
