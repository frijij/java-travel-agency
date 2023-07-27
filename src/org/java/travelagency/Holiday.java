package org.java.travelagency;

import java.time.LocalDate;
import java.time.Period;

public class Holiday {
    // ATTRIBUTI: destinazione, data inizio, data fine
private String destination;
private LocalDate startOfHoliday;
private LocalDate endOfHoliday;

    // COSTRUTTORI
/*
Quando viene creata una nuova Vacanza vanno effettuati dei controlli:
- destinazione, data inizio e data fine non possono essere null
- la data inizio non può essere già passata
- la data fine non può essere prima della data inizio
Se fallisce la validazione vanno sollevate opportune eccezioni
 */

    public Holiday(String destination, LocalDate startOfHoliday, LocalDate endOfHoliday) throws RuntimeException{
        if (destination == null || destination.isEmpty()) {
            throw new RuntimeException("destination cannot be null or empty");
        }

        if (startOfHoliday == null || startOfHoliday.isBefore(LocalDate.now())) {
            throw new RuntimeException("Holiday cannot start before the current date");
        }

        if (endOfHoliday == null || endOfHoliday.isBefore(startOfHoliday)){
            throw new RuntimeException("Holiday cannot end before the starting date");
        }

        this.destination = destination;
        this.startOfHoliday = startOfHoliday;
        this.endOfHoliday = endOfHoliday;
    }

    //GETTER E SETTER


    //METODI
    // metodo per calcolare la durata in giorni della vacanza
public int getHolidayDuration (){
    Period holidayDuration= Period.between(startOfHoliday,endOfHoliday);
    return holidayDuration.getDays();
}
}
