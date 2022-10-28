package com.mycompany.dentistofficesystem;


import java.time.LocalDateTime;

public class Appointment {
    LocalDateTime start;
    LocalDateTime end;
    String description;
    int cost;
    Doctor d = new Doctor();
    Patient p = new Patient();
    workDays w = new workDays();
    Appointment(LocalDateTime start, LocalDateTime end, Doctor d, Patient p, workDays w)
    {
        this.start = start;
        this.end = end;
        this.d = d;
        this.p = p;
        this.w = w;
    }
    Appointment(String description, int cost)
    {
        this.description = description;
        this.cost = cost;
    }
}
