// This program is broken down into three parts: The first collects the information from the customer, the second one communicates with the server and stores information on the server and the last updates the status of the session to let the mobile service provider know whether the request was successful or not

//Each instance of this class represents the process associated with retrieving the information belonging to a single user

//With more time, more checks such as those that make sure that all of the requuested information is in the right format could be implemented

import java.util.*;
import java.io.*;

public class task2 {

 //Instance variables store information in the "server". They can be invoked anytime to get relevant user information
 private static String email;
 private static String username;
 private static String phoneno;
 private static boolean requestsuccessful;
 public static void main(String[] args) {

  //Read USSD code
  Scanner scanner = new Scanner(System.in);
  // Type of USSD
  System.out.println("Enter USSD dial code");
  String ussd = scanner.nextLine();
  // Ask for email
  System.out.println("Please enter email");
  String em = scanner.nextLine();
  // Ask for username
  System.out.println("Please enter username");
  String user = scanner.nextLine();
  //Ask for phone number
  System.out.println("Please enter phone number");
  String number = scanner.nextLine();

  //Fetch right request, then register user. Other kinds of requests would ideally be included in this if else block 
  if (ussd.equals("*144#")) {
   registeruser(em, user, number);
   System.out.println("Registration is successful!");
  } else { System.out.println("Registration is unsuccessful! System only supports *144# requests"); }
  //if an error outside the system occurs, use false instead to update status of the session. For the sake of this simple example we will assume that the request is successful 
  updatemobileserviceprovider(true);
 }

 public static void registeruser(String emailaddress, String name, String phonenumber) {
  email = emailaddress;
  username = name;
  phoneno = phonenumber;
 }
 public static void updatemobileserviceprovider(boolean success) {
  requestsuccessful = success;

 }
}