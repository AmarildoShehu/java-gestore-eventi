package MusicEvents;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Concert extends Event{
    private LocalTime time;
    private BigDecimal price;

    public Concert(String title, LocalDate date, int totalSeats, LocalTime time,BigDecimal price) {
        super(title, date, totalSeats);
        this.time = time;
        this.price = price;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    // Formato data e tempo
    public String getFormattedDateTime() {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        return getDate().format(dateFormatter) + " " + time.format(timeFormatter);
    }

    // Formatazzzione prezzo
    public String getFormattedPrice() {
        return price.setScale(2, BigDecimal.ROUND_HALF_UP).toString() + "€";
    }

    @Override
    public String toString() {
        return getFormattedDateTime() + " - " + getTitle() + " - " + getFormattedPrice();
    }

}
