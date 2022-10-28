package com.mycompany.dentistofficesystem;

import java.util.ArrayList;

public class Patient {

    String name;
    int id;
    String phoneNumber;
    int owedBalance;
    int payedBalance;
    String email;
    ArrayList<Appointment> appointmentArrayList = new ArrayList<Appointment>();

    public Patient(String name, int id, String phoneNumber, int owedBalance, int payedBalance, String email)
    {
        this.name = name;
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.owedBalance = owedBalance;
        this.payedBalance = payedBalance;
        ArrayList<Appointment> appointmentArrayList = new ArrayList<Appointment>();
        ArrayList<workDays> workDaysArrayList = new ArrayList<workDays>();

        if(email.isEmpty() )
        {
            this.email = "No Email";
        }
        else
        {
            this.email = email;
        }
    }
    public Patient()
    {

    }

}
