package com.mycompany.dentistofficesystem;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class workDays {
    LocalDateTime start;
    LocalDateTime end;
    ArrayList<Appointment> appointmentArrayList = new ArrayList<Appointment>();

    workDays(LocalDateTime start, LocalDateTime end) {
        this.start = start;
        this.end = end;
    }
    workDays()
    {

    }
}
