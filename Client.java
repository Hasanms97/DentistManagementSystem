package com.mycompany.dentistofficesystem;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * @author Hassan Mohammad Kamel Al-Shannag
 * @Student ID:142579
 */
public class Client {
    
    public static void main(String[] args) {
                try
        {
            //---------------->Initializeing Client Socket<----------------
            Socket clientSocket = new Socket("localhost",4422);
            
            //---------------->Input<----------------
            DataInputStream input = new DataInputStream(clientSocket.getInputStream()); 
            
            //---------------->Output<----------------
            DataOutputStream output = new DataOutputStream(clientSocket.getOutputStream());

            
            
            
            
            ArrayList<Doctor> doctors = new ArrayList<Doctor>();
        ArrayList<Patient> patients = new ArrayList<Patient>();


        // Create a Scanner object
        Scanner myObj1 = new Scanner(System.in);
        Scanner myObj2 = new Scanner(System.in);
            
            
        System.out.println(input.readUTF());
        System.out.println(input.readUTF());
        System.out.println(input.readUTF());
        System.out.println(input.readUTF());
        

        
        
        
        int chose = 0;


        do
        {
            chose = myObj1.nextInt();
            output.writeInt(chose);


//            do
//            {
//                if(chose < 1 || chose > 9)
//                {
//                    System.out.println("Please enter a valid choice");
//                }
//                else
//                {
//                    break;
//                }
//            } while(chose >= 1 && chose <= 9);

            switch (chose)
            {
                case 1:


                    System.out.println(input.readUTF());
                    System.out.println(input.readUTF());
                    
                    String doctorName = myObj2.nextLine();
                    output.writeUTF(doctorName);
                    
                    System.out.println(input.readUTF());
                    System.out.println(input.readUTF());

                    break;


                case 2:



                    System.out.println(input.readUTF());
                    System.out.println(input.readUTF());
                    String patientName = myObj2.nextLine();
                    output.writeUTF(patientName);
                    System.out.println(input.readUTF());

                    System.out.println(input.readUTF());
                    String patientPhoneNumber = myObj2.nextLine();
                    output.writeUTF(patientPhoneNumber);
                    System.out.println(input.readUTF());

                    System.out.println(input.readUTF());
                    String patientEmail = myObj2.nextLine();
                    output.writeUTF(patientEmail);
                    System.out.println(input.readUTF());


                    System.out.println(input.readUTF());
                    System.out.println(input.readUTF());

                    break;


                case 3:
                    
                    int doctorSize = input.readInt();
                    if(doctorSize == 0)
                    {
                        System.out.println(input.readUTF());
                    }
                    else
                    {
                        System.out.println(input.readUTF());
                        for(int x = 0; x < doctorSize ;x++)
                        {
                            System.out.println(input.readUTF());
                            int ref1 = input.readInt();
                            for(int z = 0; z < ref1 ;z++)
                            {
                                int ref2 = input.readInt();
                                for(int y = 0; y < ref2 ;y++)
                                {

                                    System.out.println(input.readUTF());
                                    System.out.println(input.readUTF());
                                    System.out.println(input.readUTF());
                                }
                            }
                        }
                    }


                    break;


                case 4:
                    
                    int patientSize = input.readInt();
                    if(patientSize == 0)
                    {
                        System.out.println(input.readUTF());
                    }
                    else
                    {
                        for(int x = 0; x < patientSize ;x++)
                        {
                            System.out.println(input.readUTF());
                            System.out.println(input.readUTF());
                            System.out.println(input.readUTF());
                            System.out.println(input.readUTF());
                            System.out.println(input.readUTF());
                            System.out.println(input.readUTF());
                            System.out.println(input.readUTF());
                            int ref1 = input.readInt();
                            if(ref1 == 0)
                            {
                                System.out.println(input.readUTF());
                            }
                            else
                            {
                                int ref2 = input.readInt();
                                for(int z = 0; z < ref2;z++)
                                {
                                    System.out.println(input.readUTF());
                                    System.out.println(input.readUTF());
                                    System.out.println(input.readUTF());
                                    
                                    Boolean b1 = input.readBoolean();
                                    if(b1 == true)
                                    {
                                        System.out.println(input.readUTF());
                                    }
                                    else
                                    {
                                        System.out.println(input.readUTF());
                                    }
                                    
//                                    String ref3 = input.readUTF();
//                                    if(ref3 == null)
//                                    {
//                                        System.out.println(input.readUTF());
//                                    }
//                                    else
////                                    {
//                                        System.out.println(input.readUTF());
////                                    }
                                    System.out.println(input.readUTF());
                                    System.out.println(input.readUTF());

                                }
                            }
                            System.out.println(input.readUTF());
                        }
                    }
                    System.out.println(input.readUTF());


                    break;


                case 5:

                    doctorSize = input.readInt();
                    if(doctorSize == 0)
                    {
                        System.out.println(input.readUTF());
                    }
                    else
                    {
                        System.out.println(input.readUTF());

                        for(int x = 0; x < doctorSize ;x++)
                        {
                            System.out.println(input.readUTF());
                        }



                        int drChose = myObj1.nextInt();
                        output.writeInt(drChose);
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");


                        try {

                            System.out.println(input.readUTF());
                            String start = myObj2.nextLine();
                            output.writeUTF(start);
                            LocalDateTime startDateAndTime = LocalDateTime.parse(start, formatter);

                    
                            System.out.println(input.readUTF());
                            String end = myObj2.nextLine();
                            output.writeUTF(end);
                            LocalDateTime endDateAndTime = LocalDateTime.parse(end, formatter);


                            workDays w = new workDays(startDateAndTime,endDateAndTime);
                            doctors.get(drChose-1).workDaysArrayList.add(w);
                            System.out.println(input.readUTF());
                            System.out.println(input.readUTF());
                        }
                        catch(Exception e) {
                            System.out.println(input.readUTF());
                            System.out.println(input.readUTF());
                        }
                    }

                    break;

                case 6:

                    patientSize = input.readInt();
                    if(patientSize == 0)
                    {
                        System.out.println(input.readUTF());
                        break;
                    }
                    else
                    {
                        System.out.println(input.readUTF());
                        for(int x = 0; x < patientSize ;x++)
                        {
                            System.out.println(input.readUTF());
                        }
                        int selectedPatient = myObj1.nextInt();
                        output.writeInt(selectedPatient);
                        doctorSize = input.readInt();
                        if(doctorSize == 0)
                        {
                            System.out.println(input.readUTF());
                            break;
                        }
                        else
                        {
                            System.out.println(input.readUTF());
                            for(int x = 0; x < doctorSize ;x++)
                            {
                                System.out.println(input.readUTF());
                            }
                        }
                        int selectedDoctor = myObj1.nextInt();
                        output.writeInt(selectedDoctor);
                        //////
                        int ref1 = input.readInt();
                        if(ref1 == 0)
                        {
                            System.out.println(input.readUTF());
                            break;
                        }
                        else
                        {
                            System.out.println(input.readUTF());
                            int ref2 = input.readInt();
                            for(int x = 0; x < ref2 ;x++)
                            {
                                System.out.println(input.readUTF());
                            }

                        }
                        int selectedWorkDay = myObj1.nextInt();
                        output.writeInt(selectedWorkDay);
                        try
                        {
                            DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
                            System.out.println(input.readUTF());
                            String start = myObj2.nextLine();
                            output.writeUTF(start);
                            LocalDateTime startDateAndTime = LocalDateTime.parse(start, formatter1);

                            System.out.println(input.readUTF());
                            String end = myObj2.nextLine();
                            output.writeUTF(end);
                            LocalDateTime endDateAndTime = LocalDateTime.parse(end, formatter1);


                            boolean flag = false;
                            //Check station number 1
                            long ref4 = input.readLong();
                            
                            LocalDateTime startRef1 = LocalDateTime.parse(input.readUTF(), formatter1);
                            LocalDateTime endRef1 = LocalDateTime.parse(input.readUTF(), formatter1);
                                
                            if(ref4 < 30)
                            {
                                System.out.println(input.readUTF());
                                flag = true;
                                break;
                            }
                            else if(endDateAndTime.isAfter(endRef1) == true)
                            {
                                System.out.println(input.readUTF());
                                flag = true;
                                break;
                            }
                            else if(startDateAndTime.isBefore(startRef1) == true)
                            {
                                System.out.println(input.readUTF());
                                flag = true;
                                break;
                            }

                            //Check station number 2
                            int ref3 = input.readInt();
                            for (int x = 0; x < ref3; x++) {
                                
                                LocalDateTime startRef2 = LocalDateTime.parse(input.readUTF(), formatter1);
                                LocalDateTime endRef2 = LocalDateTime.parse(input.readUTF(), formatter1);
                                
                                if (endDateAndTime.isAfter(startRef2) && endDateAndTime.isBefore(endRef2)) {
                                    flag = true;
                                    System.out.println(input.readUTF());
                                    break;
                                }
                                else if (startDateAndTime.isAfter(startRef2) && startDateAndTime.isBefore(endRef2)) {
                                    flag = true;
                                    System.out.println(input.readUTF());
                                    break;
                                }
                                else if (endDateAndTime.isEqual(endRef2) && startDateAndTime.isEqual(startRef2)) {
                                    flag = true;
                                    System.out.println(input.readUTF());
                                    break;
                                }
                            }
                            if(flag == false)
                            {
                                System.out.println(input.readUTF());
                                System.out.println(input.readUTF());
                            }


                        }
                        catch(Exception e)
                        {
                            System.out.println(input.readUTF());
                            System.out.println(input.readUTF());
                        }
                    }



                    break;
                    
                    case 7:


                    Scanner scan = new Scanner(System.in);
                    DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
                    doctorSize = input.readInt();
                    if(doctorSize == 0)
                    {
                        System.out.println(input.readUTF());
                        break;
                    }
                    else
                    {
                        System.out.println(input.readUTF());
                        for(int x = 0; x < doctorSize ;x++)
                        {
                            System.out.println(input.readUTF());
                        }
                    }
                    int doctorSelection = scan.nextInt();
                    output.writeInt(doctorSelection);

                    int ref1 = input.readInt();
                    if(ref1 == 0)
                    {
                        System.out.println(input.readUTF());
                        break;
                    }
                    else
                    {
                        System.out.println(input.readUTF());
                        System.out.println(input.readUTF());
                    }
                    int optionSelection = scan.nextInt();
                    output.writeInt(optionSelection);

                    if(optionSelection == 2) {

                            System.out.println(input.readUTF());
                            for (int x = 0; x < ref1; x++) {
                                System.out.println(input.readUTF());
                                        
                            }

                            int workDaySelection = myObj1.nextInt();
                            output.writeInt(workDaySelection);
                            
                            int ref2 = input.readInt();
                            System.out.println(input.readUTF());
                            for (int x = 0; x < ref2; x++) {
                                System.out.println(input.readUTF());
                                System.out.println(input.readUTF());
                                System.out.println(input.readUTF());
                                System.out.println(input.readUTF());
                                System.out.println(input.readUTF());
                                System.out.println(input.readUTF());
                            }
                            System.out.println(input.readUTF());
                            System.out.println(input.readUTF());
                    }
                    else if(optionSelection == 1)
                    {
                        System.out.println(input.readUTF());
                        int ref3 = input.readInt();
                        for(int x = 0; x < ref3 ;x++)
                        {
                            int ref4 = input.readInt();
                            for(int z = 0; z < ref4 ;z++)
                            {
                                System.out.println(input.readUTF());
                                System.out.println(input.readUTF());
                                System.out.println(input.readUTF());
                                System.out.println(input.readUTF());
                                System.out.println(input.readUTF());
                                System.out.println(input.readUTF());
                                System.out.println(input.readUTF());
                            }
                        }
                        System.out.println(input.readUTF());
                        
                        System.out.println(input.readUTF());
                        System.out.println(input.readUTF());
                    }

                    break;


                case 8:
                    patientSize = input.readInt();
                    if(patientSize == 0)
                    {
                        System.out.println(input.readUTF());
                        break;
                    }
                    else
                    {
                        System.out.println(input.readUTF());

                        for(int x = 0; x < patientSize ;x++)
                        {
                            System.out.println(input.readUTF());
                        }
                    }

                    int patientSelection = myObj1.nextInt();                    
                    output.writeInt(patientSelection);

                    ref1 = input.readInt();
                    if(ref1 == 0)
                    {
                        System.out.println(input.readUTF());
                        break;
                    }
                    else
                    {
                        System.out.println(input.readUTF());
                        for(int x = 0; x < ref1 ;x++)
                        {
                            System.out.println(input.readUTF());
                            System.out.println(input.readUTF());
                            System.out.println(input.readUTF());
                                    
                        }

                        int visitationSelection = myObj1.nextInt();
                        output.writeInt(visitationSelection);

                        System.out.println(input.readUTF());
                        String visitationDescription = myObj2.nextLine();
                        output.writeUTF(visitationDescription);

                        System.out.println(input.readUTF());
                        int visitationCost = myObj1.nextInt();
                        output.writeInt(visitationCost);

                        System.out.println(input.readUTF());
                        int visitationPayedBalance = myObj1.nextInt();
                        output.writeInt(visitationPayedBalance);
                    }


                    break;

                case 9:
                    
                    patientSize = input.readInt();
                    if(patientSize == 0)
                    {
                        System.out.println(input.readUTF());
                        break;
                    }
                    else
                    {
                        System.out.println(input.readUTF());
                        for(int x = 0; x < patientSize ;x++)
                        {
                            System.out.println(input.readUTF());
                        }
                    }
                    int selectedpatient = myObj1.nextInt();
                    output.writeInt(selectedpatient);
                    
                    ref1 = input.readInt();
                    if(ref1 == 0)
                    {
                        System.out.println(input.readUTF());
                        break;
                    }
                    else
                    {
                        System.out.println(input.readUTF());

                        for(int x = 0; x < ref1 ;x++)
                        {
                            System.out.println(input.readUTF());
                                 
                        }

                        int selectedVisitation = myObj1.nextInt();
                        output.writeInt(selectedVisitation);



                        System.out.println(input.readUTF());
                        System.out.println(input.readUTF());
                        System.out.println(input.readUTF());
                        System.out.println(input.readUTF());
                        System.out.println(input.readUTF());
                                
                    }



                    break;


            }//end of switch case statement


        }while(chose != -1);
            
        }
        catch (IOException ex)
        {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
}
