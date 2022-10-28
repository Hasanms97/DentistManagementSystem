package com.mycompany.dentistofficesystem;
import java.util.ArrayList;

public class Doctor {


    String name;
    int age;
    ArrayList<workDays> workDaysArrayList = new ArrayList<workDays>();
    ArrayList<Appointment> appointmentArrayList = new ArrayList<Appointment>();

    public Doctor(String name)
    {
        this.name = name;
    }
    public Doctor()
    {

    }
}
