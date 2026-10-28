package com.pluralsight;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class PayrollCalculatorApp {


    //!Creating main method
    public static void main(String[] args) {

        //?Creating Scanner
        Scanner input = new Scanner(System.in);


        //*Asking what file they want to enter
        System.out.println("Enter the name of the file to process: ");

        String fileName = input.nextLine().trim();

        System.out.println("Enter the name of the payroll file to create: ");
        String outputFile = input.nextLine().trim();

        //?Try catch to get any errors
        try
        {
            //* created buffer and file reader to access the file
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            BufferedWriter bW = new BufferedWriter(new FileWriter(outputFile, true));
            //?Creating a loop to go through all employee info
            String employeeData;
            while ((employeeData = br.readLine()) != null  ) {

                //*Split the employeeInfo into each part
                String[] employeeInfo = employeeData.split("\\|");


                //*assigning the info to there part
                int employeeId = Integer.parseInt(employeeInfo[0]);
                String employeeName = employeeInfo[1];
                double hoursWorked = Double.parseDouble(employeeInfo[2]);
                double employeePayRate = Double.parseDouble(employeeInfo[3]);


                //!Creating an Employee with the info
                Employee employee = new Employee(employeeId, employeeName, hoursWorked, employeePayRate);


                //*Displaying the employee info
                System.out.print("Employee Info\n");
                System.out.printf("Employee ID: %d\n", employeeId);
                System.out.printf("Employee Name: %s\n", employeeName);
//            System.out.printf("Hours Worked: %.2f\n", hoursWorked);
//            System.out.printf("Employee Pay Rate: %.2f\n", employeePayRate);
                System.out.printf("Employee Gross pay %.2f\n\n", employee.getGrossPay());

                String writtenLine = String.format(
                        "%s|%s|%.2f\n",
                        employeeId,
                        employeeName,
                        employee.getGrossPay()
                );
                bW.write(writtenLine);

            }
            bW.close();
            br.close();


            //!Catching the errors
        } catch (Exception e) {
            System.out.println(e.getMessage());

            System.out.println("Error reading employees.csv");
        }


    }








//        if (fileName.equals("employees.csv")) {
//            employees();
//        }else {
//            addEmployees();
//        }

//        boolean menuApp = true;
//        while (menuApp) {
//            int command = displayMenu(input);
//
//            switch (command) {
//                case 1 -> Employees();
//                case 2 -> AddEmployees();
//                case 3 -> menuApp = false;
//            }
//        }


//    }

    //!Gathering employees from the file
//    public static void employees(){
//        //?Try catch to get any errors
//        //* created buffer and file reader to access the file
//        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/employees.csv")))
//        {
//
//            //?Creating a loop to go through all employee info
//            String employeeData;
//            while ((employeeData = br.readLine()) != null  ) {
//
//                //*Split the employeeInfo into each part
//                String[] employeeInfo = employeeData.split("\\|");
//
//
//                //*assigning the info to there part
//                int employeeId = Integer.parseInt(employeeInfo[0]);
//                String employeeName = employeeInfo[1];
//                double hoursWorked = Double.parseDouble(employeeInfo[2]);
//                double employeePayRate = Double.parseDouble(employeeInfo[3]);
//
//
//                //!Creating an Employee with the info
//                Employee employee = new Employee(employeeId, employeeName, hoursWorked, employeePayRate);
//
//
//                //*Displaying the employee info
//                System.out.print("Employee Info\n");
//                System.out.printf("Employee ID: %d\n", employeeId);
//                System.out.printf("Employee Name: %s\n", employeeName);
////            System.out.printf("Hours Worked: %.2f\n", hoursWorked);
////            System.out.printf("Employee Pay Rate: %.2f\n", employeePayRate);
//                System.out.printf("Employee Gross pay %.2f\n\n", employee.getGrossPay());
//
//            }
//
//            //!Catching the errors
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//
//            System.out.println("Error reading employees.csv");
//        }
//

//    }
//
//    //!Adding new employees
//    public static void addEmployees(){
//
//        Scanner sc = new Scanner(System.in);
//        //? Creating BufferWriter to be able to write in the file
//        System.out.println("Enter the name of the payroll file to create: ");
//        String outputFile = sc.nextLine().trim();
//
//        try (BufferedWriter bW = new BufferedWriter(new FileWriter(outputFile, true))){
//
//
//            //*Asking for employee info
//            String addEmployee = "yes";
//            while(addEmployee.equalsIgnoreCase("Yes")){
//
//                //?Creating Scanner
//                Scanner input = new Scanner(System.in);
//
//                System.out.print("Enter employee info Ex id|name|gross pay: ");
//
//                String employeeData;
//                bW.write( employeeData = input.nextLine());
//                bW.newLine();
//
//                //*Split the employeeInfo into each part
//                String[] employeeInfo = employeeData.split("\\|");
//
//
//                //*assigning the info to there part
//                int employeeId = Integer.parseInt(employeeInfo[0]);
//                String employeeName = employeeInfo[1];
//                double grossPay = Double.parseDouble(employeeInfo[2]);
//
//                System.out.println("Would you like to add other employee: ");
//
//                addEmployee = input.nextLine();
//
//
//            }






//        } catch (Exception e) {
//            System.out.println("Error: " + e.getMessage());;
//        }

//
//    }
//
//    //!Creating  the menu
//    public static int displayMenu(Scanner sC) {
//
//
//        System.out.println("What do you want to do?\n");
//
//        System.out.println(" 1 - List all Employees\n");
//
//        System.out.println(" 2 - Add Employee\n");
//
//        System.out.println(" 3 - Quit\n");
//
//        System.out.println("Enter your command: ");
//
//
//        //*To catch our command
//        return sC.nextInt();
//    }



}
