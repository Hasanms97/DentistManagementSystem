package com.mycompany.dentistofficesystem;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.lang.System.Logger.Level;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Logger;

/*
 * @author Hassan Mohammad Kamel Al-Shannag
 * @Student ID:142579
 */
public class Server {
    
    public static void main(String[] args) throws IOException {
        
        try
        {
            //---------------->Initializeing Server Socket<----------------
            ServerSocket serverSocketl=new ServerSocket (4422);
            Socket Clil=serverSocketl.accept();
            
            //---------------->Output<----------------
            DataOutputStream output=new DataOutputStream(Clil.getOutputStream());
            
            //---------------->Input<----------------
            DataInputStream input =new DataInputStream(Clil.getInputStream());
            
            
            
            
            
            
        ArrayList<Doctor> doctors = new ArrayList<Doctor>();
        ArrayList<Patient> patients = new ArrayList<Patient>();


        // Create a Scanner object
        Scanner myObj1 = new Scanner(System.in);
        Scanner myObj2 = new Scanner(System.in);
            
            
        output.writeUTF("Chose one of the following, enter -1 to exit:\n");
        output.writeUTF("①.Add Doctor    ②.Add Patient       ③.Print all doctors\n\n");
        output.writeUTF("⓸.Print all Patients    ⓹.Add working days and hours        ⓺.Add appointment for patient\n\n");
        output.writeUTF("⓻.Edit Dr work Schedule       ⓼.Manage visitation      ⑨.View visit details\n\n");
        

        
        
        
        int chose = 0;


        do
        {
            chose = input.readInt();


//            do
//            {
//                if(chose < 1 || chose > 9)
//                {
//                     output.writeUTF("Please enter a valid choice");
//                }
//                else
//                {
//                    break;
//                }
//            } while(chose >= 1 && chose <= 9);

            switch (chose)
            {
                case 1:


                    output.writeUTF("―――――――――――――――――――――");
                    output.writeUTF("Enter Dr name:");
                    String doctorName = input.readUTF();
                    
                    Doctor d1 = new Doctor(doctorName);
                    doctors.add(d1);

                    output.writeUTF("⭆⭆⭆Doctor successfully added⭅⭅⭅");
                    output.writeUTF("╍ ╍ ╍ ╍ ╍ ╍ ╍ ╍ ╍ ╍ ╍ ╍ ╍ ╍ ╍ ╍ ╍ ╍ ╍ ╍ ╍ ╍ ╍ ╍");

                    break;


                case 2:


                    int counter = 0;
                    output.writeUTF("―――――――――――――――――――――");
                    output.writeUTF("Enter Patient name:");
                    String patientName = input.readUTF();
                    output.writeUTF("―――――――――――――――――――――");

                    output.writeUTF("Enter Patient phone number:");
                    String patientPhoneNumber = input.readUTF();
                    output.writeUTF("―――――――――――――――――――――");

                    output.writeUTF("Enter Patient email:");
                    String patientEmail = input.readUTF();
                    output.writeUTF("―――――――――――――――――――――");


                    Patient p1 = new Patient(patientName,counter,patientPhoneNumber,0,0,patientEmail);
                    patients.add(p1);
                    counter++;
                    
                    
                    output.writeUTF("⭆⭆⭆Patient successfully added⭅⭅⭅");
                    output.writeUTF("╍ ╍ ╍ ╍ ╍ ╍ ╍ ╍ ╍ ╍ ╍ ╍ ╍ ╍ ╍ ╍ ╍ ╍ ╍ ╍ ╍ ╍ ╍ ╍");

                    break;


                case 3:

                    int doctorSize = doctors.size();
                    output.writeInt(doctorSize);
                    if(doctors.size() == 0)
                    {
                        output.writeUTF("No Doctors added");
                    }
                    else
                    {
                        output.writeUTF("――――――――――――――――――――――――――――――――――――――――――");
                        for(int x = 0; x < doctors.size() ;x++)
                        {
                            output.writeUTF((x+1) + ") " + doctors.get(x).name);
                            
                            int ref1 = doctors.get(x).workDaysArrayList.size();
                            output.writeInt(ref1);
                            for(int z = 0; z < doctors.get(x).workDaysArrayList.size() ;z++)
                            {
                                int ref2 = doctors.get(x).workDaysArrayList.get(z).appointmentArrayList.size();
                                output.writeInt(ref2);
                                for(int y = 0; y < doctors.get(x).workDaysArrayList.get(z).appointmentArrayList.size() ;y++)
                                {

                                    output.writeUTF("   Appointment no." + (y+1));
                                    output.writeUTF("   Patient name:" + doctors.get(x).workDaysArrayList.get(z).appointmentArrayList.get(y).p.name);
                                    output.writeUTF("   Start ----> " + doctors.get(x).workDaysArrayList.get(z).appointmentArrayList.get(y).start.format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm"))
                                            + "   END ----> " + doctors.get(x).workDaysArrayList.get(z).appointmentArrayList.get(y).end.format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm")));
                                }
                            }
                        }
                    }


                    break;


                case 4:
                    
                    int patientSize = patients.size();
                    output.writeInt(patientSize);
                    if(patients.size() == 0)
                    {
                        output.writeUTF("No patients added");
                    }
                    else
                    {
                        for(int x = 0; x < patients.size() ;x++)
                        {
                            output.writeUTF("Patient no.:" + patients.get(x).id);
                            output.writeUTF("Patient name:" + patients.get(x).name);
                            output.writeUTF("Patient phone number:" + patients.get(x).phoneNumber);
                            output.writeUTF("Patient owed balance:" + patients.get(x).owedBalance);
                            output.writeUTF("Patient payed balance:" + patients.get(x).payedBalance);
                            output.writeUTF("Patient email:" + patients.get(x).email);
                            output.writeUTF("Patient appointments:");
                            int ref1 = patients.get(x).appointmentArrayList.size();
                            output.writeInt(ref1);
                            if(patients.get(x).appointmentArrayList.size() == 0)
                            {
                                output.writeUTF("No appointment");
                            }
                            else
                            {
                                int ref2 = patients.get(x).appointmentArrayList.size();
                                output.writeInt(ref2);
                                for(int z = 0; z < patients.get(x).appointmentArrayList.size();z++)
                                {
                                    output.writeUTF("Doctor name:" + patients.get(x).appointmentArrayList.get(z).d.name);
                                    output.writeUTF("Appointment no." + (z+1));
                                    output.writeUTF("Payed amount:" + patients.get(x).appointmentArrayList.get(z).p.payedBalance);
                                    
                                    Boolean b1;
                                    if(patients.get(x).appointmentArrayList.get(z).description == null)
                                    {
                                        b1 = true;
                                    }
                                    else
                                    {
                                        b1 = false;
                                    }
                                    output.writeBoolean(b1);
                                    if(b1 == true)
                                    {
                                        output.writeUTF("visitation description: No description");
                                    }
                                    else
                                    {
                                        output.writeUTF("visitation description: " + patients.get(x).appointmentArrayList.get(z).description);
                                    }
                                    
                                    
                                    
                                    
                                    
                                    
                                    
//                                    String ref3 = patients.get(x).appointmentArrayList.get(z).description;
//                                    output.writeUTF(ref3);
//                                    
//                                    if(patients.get(x).appointmentArrayList.get(z).description == null)
//                                    {
//                                        output.writeUTF("visitation description: No description");
//                                    }
//                                    else
//                                    {
                                        //output.writeUTF("visitation description: " + patients.get(x).appointmentArrayList.get(z).description);
//                                    }
                                    output.writeUTF("Start ----> " + patients.get(x).appointmentArrayList.get(z).start.format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm")) + "   ");
                                    output.writeUTF("End ----> " + patients.get(x).appointmentArrayList.get(z).end.format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm")));

                                }
                            }
                            output.writeUTF("――――――――――――――――――――――――――――――――――――――――――");
                        }
                    }
                    output.writeUTF("――――――――――――――――――――――――――――――――――――――――――");


                    break;


                case 5:

                    doctorSize = doctors.size();
                    output.writeInt(doctorSize);
                    if(doctors.size() == 0)
                    {
                        output.writeUTF("No doctors added");
                    }
                    else
                    {
                        output.writeUTF("Chose a doctor to add working day and hour:");

                        for(int x = 0; x < doctors.size() ;x++)
                        {
                            output.writeUTF((x+1) + "." + doctors.get(x).name);
                        }



                        int drChose = input.readInt();
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");


                        try {

                            output.writeUTF("Enter date and time start:");
                            String start = input.readUTF();
                            LocalDateTime startDateAndTime = LocalDateTime.parse(start, formatter);


                            output.writeUTF("Enter date and time end:");
                            String end = input.readUTF();
                            LocalDateTime endDateAndTime = LocalDateTime.parse(end, formatter);


                            workDays w = new workDays(startDateAndTime,endDateAndTime);
                            doctors.get(drChose-1).workDaysArrayList.add(w);
                            output.writeUTF("⭆⭆⭆Working day and hour successfully added⭅⭅⭅");
                            output.writeUTF("╍ ╍ ╍ ╍ ╍ ╍ ╍ ╍ ╍ ╍ ╍ ╍ ╍ ╍ ╍ ╍ ╍ ╍ ╍ ╍ ╍ ╍ ╍ ╍");
                        }
                        catch(Exception e) {
                            output.writeUTF("Please enter valid Info.");
                            output.writeUTF("Hint: Date format as following  dd/MM/yyyy HH:mm");
                        }
                    }

                    break;

                case 6:

                    patientSize = patients.size();
                    output.writeInt(patientSize);
                    if(patients.size() == 0)
                    {
                        output.writeUTF("Patients are not available");
                        break;
                    }
                    else
                    {
                        output.writeUTF("Select one of the following patients from the list");
                        for(int x = 0; x < patients.size() ;x++)
                        {
                            output.writeUTF((x+1) + ") " + patients.get(x).name);
                        }
                        int selectedPatient = input.readInt();
                        doctorSize = doctors.size();
                        output.writeInt(doctorSize);
                        if(doctors.size() == 0)
                        {
                            output.writeUTF("Doctors are not available");
                            break;
                        }
                        else
                        {
                            output.writeUTF("Select one of the following doctors from the list:");
                            for(int x = 0; x < doctors.size() ;x++)
                            {
                                output.writeUTF((x+1) + ") Dr." + doctors.get(x).name);
                            }
                        }
                        int selectedDoctor = input.readInt();
                        int ref1 = doctors.get(selectedDoctor-1).workDaysArrayList.size();
                        output.writeInt(ref1);
                        if(doctors.get(selectedDoctor-1).workDaysArrayList.size() == 0)
                        {
                            output.writeUTF("Working days are not available");
                            break;
                        }
                        else
                        {
                            output.writeUTF("Select on of the Working days from the list:");
                            int ref2 = doctors.get(selectedDoctor-1).workDaysArrayList.size();
                        output.writeInt(ref1);
                            for(int x = 0; x < doctors.get(selectedDoctor-1).workDaysArrayList.size() ;x++)
                            {
                                output.writeUTF((x+1) + ") Starts ----> " + doctors.get(selectedDoctor-1).workDaysArrayList.get(x).start.format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm"))
                                        + "   Ends ----> " + doctors.get(selectedDoctor-1).workDaysArrayList.get(x).end.format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm")));
                            }

                        }
                        int selectedWorkDay = input.readInt();
                        try
                        {
                            DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
                            output.writeUTF("Enter date and time start:");
                            String start = input.readUTF();
                            LocalDateTime startDateAndTime = LocalDateTime.parse(start, formatter1);

                            output.writeUTF("Enter date and time end:");
                            String end = input.readUTF();
                            LocalDateTime endDateAndTime = LocalDateTime.parse(end, formatter1);

                            //Calculating the duration between (start date and time) and (end date and time).
                            long minutes = ChronoUnit.MINUTES.between(startDateAndTime, endDateAndTime);

                            boolean flag = false;
                            //Check station number 1
                            long ref4 = minutes;
                            output.writeLong(minutes);
                            
                            String startRef1 = doctors.get(selectedDoctor-1).workDaysArrayList.get(selectedWorkDay-1).start.format(formatter1);
                                output.writeUTF(startRef1);
                                
                            String endRef1 = doctors.get(selectedDoctor-1).workDaysArrayList.get(selectedWorkDay-1).end.format(formatter1);
                                output.writeUTF(endRef1);
                                
                            if(minutes < 30)
                            {
                                output.writeUTF("Appointment duration is less than 30 minutes.");
                                flag = true;
                                break;
                            }
                            else if(endDateAndTime.isAfter(doctors.get(selectedDoctor-1).workDaysArrayList.get(selectedWorkDay-1).end) == true)
                            {
                                output.writeUTF("Appointment is not within the working day hours of the doctor.");
                                flag = true;
                                break;
                            }
                            else if(startDateAndTime.isBefore(doctors.get(selectedDoctor-1).workDaysArrayList.get(selectedWorkDay-1).start) == true)
                            {
                                output.writeUTF("Appointment is not within the working day hours of the doctor.");
                                flag = true;
                                break;
                            }


                            //Check station number 2
                            int ref3 = doctors.get(selectedDoctor - 1).workDaysArrayList.get(selectedWorkDay-1).appointmentArrayList.size();
                            output.writeInt(ref3);
                            for (int x = 0; x < doctors.get(selectedDoctor - 1).workDaysArrayList.get(selectedWorkDay-1).appointmentArrayList.size(); x++) {

                                String startRef2 = doctors.get(selectedDoctor - 1).workDaysArrayList.get(selectedWorkDay-1).appointmentArrayList.get(x).start.format(formatter1);
                                output.writeUTF(startRef2);
                                
                                String endRef2 = doctors.get(selectedDoctor - 1).workDaysArrayList.get(selectedWorkDay-1).appointmentArrayList.get(x).end.format(formatter1);
                                output.writeUTF(endRef2);
                                
                                if (endDateAndTime.isAfter(doctors.get(selectedDoctor - 1).workDaysArrayList.get(selectedWorkDay-1).appointmentArrayList.get(x).start) && endDateAndTime.isBefore(doctors.get(selectedDoctor - 1).workDaysArrayList.get(selectedWorkDay-1).appointmentArrayList.get(x).end)) {
                                    flag = true;
                                    output.writeUTF("Appointment chosen is within another appointment, Please chose another appointment");
                                    break;
                                }
                                else if (startDateAndTime.isAfter(doctors.get(selectedDoctor - 1).workDaysArrayList.get(selectedWorkDay-1).appointmentArrayList.get(x).start) && startDateAndTime.isBefore(doctors.get(selectedDoctor - 1).workDaysArrayList.get(selectedWorkDay-1).appointmentArrayList.get(x).end)) {
                                    flag = true;
                                    output.writeUTF("Appointment chosen is within another appointment, Please chose another appointment");
                                    break;
                                }
                                else if (endDateAndTime.isEqual(doctors.get(selectedDoctor - 1).workDaysArrayList.get(selectedWorkDay-1).appointmentArrayList.get(x).end) && startDateAndTime.isEqual(doctors.get(selectedDoctor - 1).workDaysArrayList.get(selectedWorkDay-1).appointmentArrayList.get(x).start)) {
                                    flag = true;
                                    output.writeUTF("Appointment chosen is within another appointment, Please chose another appointment");
                                    break;
                                }
                            }
                            
                            if(flag == false)
                            {
                                Appointment a = new Appointment(startDateAndTime,endDateAndTime,doctors.get(selectedDoctor-1),patients.get(selectedPatient-1),doctors.get(selectedDoctor-1).workDaysArrayList.get(selectedWorkDay-1));
                                doctors.get(selectedDoctor-1).workDaysArrayList.get(selectedWorkDay-1).appointmentArrayList.add(a);
                                patients.get(selectedPatient-1).appointmentArrayList.add(a);
                                output.writeUTF("⭆⭆⭆Appointment successfully added⭅⭅⭅");
                                output.writeUTF("╍ ╍ ╍ ╍ ╍ ╍ ╍ ╍ ╍ ╍ ╍ ╍ ╍ ╍ ╍ ╍ ╍ ╍ ╍ ╍ ╍ ╍ ╍ ╍");

                            }



                        }
                        catch(Exception e)
                        {
                            output.writeUTF("Please enter valid Info.");
                            output.writeUTF("Hint: Date format as following  dd/MM/yyyy HH:mm");
                        }
                    }



                    break;
                    
                case 7:


                    
                    Scanner scan = new Scanner(System.in);
                    DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
                    int ref1 = doctors.size();
                    output.writeInt(ref1);
                    if(doctors.size() == 0)
                    {
                        output.writeUTF("Doctors are not available");
                        break;
                    }
                    else
                    {
                        output.writeUTF("Select one of the following doctors from the list:");
                        for(int x = 0; x < doctors.size() ;x++)
                        {
                            output.writeUTF((x+1) + ". " + doctors.get(x).name);
                        }
                    }
                    int doctorSelection = input.readInt();

                    int ref2 = doctors.get(doctorSelection-1).workDaysArrayList.size();
                    output.writeInt(ref2);
                    if(doctors.get(doctorSelection-1).workDaysArrayList.size() == 0)
                    {
                        output.writeUTF("Doctors work day not available");
                        break;
                    }
                    else
                    {
                        output.writeUTF("Chose one of the following options:");
                        output.writeUTF("①.Delete whole work schedule    ②.Delete a specific day");
                    }
                    int optionSelection = input.readInt();
                    

                    if(optionSelection == 2) {

                            output.writeUTF("Select one of the following Work days from the list:");
                            for (int x = 0; x < doctors.get(doctorSelection - 1).workDaysArrayList.size(); x++) {
                                output.writeUTF((x + 1) + ") Starts ----> " + doctors.get(doctorSelection - 1).workDaysArrayList.get(x).start.format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm"))
                                        + "   Ends ----> " + doctors.get(doctorSelection - 1).workDaysArrayList.get(x).end.format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm")));
                            }

                            int workDaySelection = input.readInt();

                            output.writeUTF("Affected patients after deleting work day schedule:");
                            int ref3 = doctors.get(doctorSelection - 1).workDaysArrayList.get(workDaySelection - 1).appointmentArrayList.size();
                            output.writeInt(ref3);
                            for (int x = 0; x < doctors.get(doctorSelection - 1).workDaysArrayList.get(workDaySelection - 1).appointmentArrayList.size(); x++) {
                                output.writeUTF("Appointment no." + (x + 1));
                                output.writeUTF("Patient name: " + doctors.get(doctorSelection-1).workDaysArrayList.get(x).appointmentArrayList.get(x).p.name);
                                output.writeUTF("Start:");
                                output.writeUTF(doctors.get(doctorSelection - 1).workDaysArrayList.get(workDaySelection - 1).appointmentArrayList.get(x).start.format(formatter1));
                                output.writeUTF("End:");
                                output.writeUTF(doctors.get(doctorSelection - 1).workDaysArrayList.get(workDaySelection - 1).appointmentArrayList.get(x).end.format(formatter1));
                            }
                            doctors.get(doctorSelection - 1).workDaysArrayList.get(workDaySelection-1).appointmentArrayList.clear();
                            doctors.get(doctorSelection - 1).workDaysArrayList.remove(workDaySelection - 1);
                            output.writeUTF("⭆⭆⭆Work schedule successfully deleted⭅⭅⭅");
                            output.writeUTF("╍ ╍ ╍ ╍ ╍ ╍ ╍ ╍ ╍ ╍ ╍ ╍ ╍ ╍ ╍ ╍ ╍ ╍ ╍ ╍ ╍ ╍ ╍ ╍");
                    }
                    else if(optionSelection == 1)
                    {
                        output.writeUTF("Affected patients after deleting work schedule:\n");
                        int ref4 = doctors.get(doctorSelection-1).workDaysArrayList.size();
                        output.writeInt(ref4);
                        for(int x = 0; x < doctors.get(doctorSelection-1).workDaysArrayList.size() ;x++)
                        {
                            int ref5 = doctors.get(doctorSelection-1).workDaysArrayList.get(x).appointmentArrayList.size();
                            output.writeInt(ref5);
                            for(int z = 0; z < doctors.get(doctorSelection-1).workDaysArrayList.get(x).appointmentArrayList.size() ;z++)
                            {
                                output.writeUTF("――――――――――――――――――――――――――――――――――――――――――");
                                output.writeUTF("Appointment no." + (z + 1));
                                output.writeUTF("Patient name: " + doctors.get(doctorSelection-1).workDaysArrayList.get(x).appointmentArrayList.get(z).p.name);
                                output.writeUTF("Start:");
                                output.writeUTF(doctors.get(doctorSelection - 1).workDaysArrayList.get(x).appointmentArrayList.get(z).start.format(formatter1));
                                output.writeUTF("End:");
                                output.writeUTF(doctors.get(doctorSelection - 1).workDaysArrayList.get(x).appointmentArrayList.get(z).end.format(formatter1));
                            }
                        }
                        output.writeUTF("――――――――――――――――――――――――――――――――――――――――――");
                        doctors.get(doctorSelection-1).workDaysArrayList.clear();
                        doctors.get(doctorSelection-1).appointmentArrayList.clear();
                        output.writeUTF("⭆⭆⭆Work schedule successfully deleted⭅⭅⭅");
                        output.writeUTF("╍ ╍ ╍ ╍ ╍ ╍ ╍ ╍ ╍ ╍ ╍ ╍ ╍ ╍ ╍ ╍ ╍ ╍ ╍ ╍ ╍ ╍ ╍ ╍");
                    }

                    break;


                case 8:
                    patientSize = patients.size();
                    output.writeInt(patientSize);
                    if(patients.size() == 0)
                    {
                        output.writeUTF("Patients are not available");
                        break;
                    }
                    else
                    {
                        output.writeUTF("Select one of the following patients:");

                        for(int x = 0; x < patients.size() ;x++)
                        {
                            output.writeUTF("ID(" + x + ") " + patients.get(x).name);
                        }
                    }

                    int patientSelection = input.readInt();
                    
                    ref1 = patients.get(patientSelection).appointmentArrayList.size();
                    output.writeInt(ref1);
                    if(patients.get(patientSelection).appointmentArrayList.size() == 0)
                    {
                        output.writeUTF("Appointments are not available");
                        break;
                    }
                    else
                    {
                        output.writeUTF("Select one of the following visitation:");
                        for(int x = 0; x < patients.get(patientSelection).appointmentArrayList.size() ;x++)
                        {
                            output.writeUTF("Appointment no." + (x+1));
                            output.writeUTF("Dr." + patients.get(patientSelection).appointmentArrayList.get(x).d.name);
                            output.writeUTF((x+1) + ") Starts ----> " + patients.get(patientSelection).appointmentArrayList.get(x).start.format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm"))
                                    + "   Ends ----> " +  patients.get(patientSelection).appointmentArrayList.get(x).end.format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm")));
                        }

                        int visitationSelection = input.readInt();

                        output.writeUTF("Enter visitation description:");
                        String visitationDescription = input.readUTF();

                        output.writeUTF("Enter visitation cost:");
                        int visitationCost = input.readInt();

                        output.writeUTF("Enter visitation payed balance:");
                        int visitationPayedBalance = input.readInt();


                        patients.get(patientSelection).appointmentArrayList.get(visitationSelection-1).description = visitationDescription;
                        patients.get(patientSelection).appointmentArrayList.get(visitationSelection-1).cost = visitationCost;
                        patients.get(patientSelection).owedBalance += visitationCost;
                        patients.get(patientSelection).payedBalance += visitationPayedBalance;
                    }


                    break;

                case 9:
                    patientSize = patients.size();
                    output.writeInt(patientSize);
                    
                    if(patients.size() == 0)
                    {
                        output.writeUTF("Patient are not available");
                        break;
                    }
                    else
                    {
                        output.writeUTF("Select one of the following patients");
                        for(int x = 0; x < patients.size() ;x++)
                        {
                            output.writeUTF("ID: " + x + patients.get(x).name);
                        }
                    }
                    int selectedpatient = input.readInt();
                    
                    ref1 = patients.get(selectedpatient).appointmentArrayList.size();
                    output.writeInt(ref1);
                    if(patients.get(selectedpatient).appointmentArrayList.size() == 0)
                    {
                        output.writeUTF("Appointments are not available");
                        break;
                    }
                    else
                    {
                        output.writeUTF("Select one of the following visitation:");

                        for(int x = 0; x < patients.get(selectedpatient).appointmentArrayList.size() ;x++)
                        {
                            output.writeUTF((x+1) + ") " + "Start ----> " + patients.get(selectedpatient).appointmentArrayList.get(x).start.format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm"))
                                    + "END ----> " + patients.get(selectedpatient).appointmentArrayList.get(x).end.format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm")));
                        }

                        int selectedVisitation = input.readInt();



                        output.writeUTF("Visitation details.");
                        output.writeUTF("Dr Name:" + patients.get(selectedpatient).appointmentArrayList.get(selectedVisitation-1).d.name);
                        output.writeUTF("Visit description:" + patients.get(selectedpatient).appointmentArrayList.get(selectedVisitation-1).description);
                        output.writeUTF("Visit charge:" + patients.get(selectedpatient).appointmentArrayList.get(selectedVisitation-1).cost);
                        output.writeUTF("Start ----> " + patients.get(selectedpatient).appointmentArrayList.get(selectedVisitation-1).start.format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm"))
                                + " END ----> " + patients.get(selectedpatient).appointmentArrayList.get(selectedVisitation-1).end.format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm")));
                    }



                    break;


            }//end of switch case statement


        }while(chose != -1);

            

        }
        catch(IOException ex)
        {
              Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE,null,ex);
        }
        
        
    }
    
}
