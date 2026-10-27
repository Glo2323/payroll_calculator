package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class PayrollCalculatorApp {

    //!Creating main method
    public static void main(String[] args) {

        //?Creating Scanner
        Scanner input = new Scanner(System.in);
        

            //?Try catch to get any errors
            try {

                //* created buffer and file reader to access the file
                BufferedReader br = new BufferedReader(new FileReader("employees.csv"));


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

                    System.out.print("Employee Info\n\n");
                    System.out.printf("Employee ID: %d\n", employeeId);
                    System.out.printf("Employee Name: %s\n", employeeName);
//            System.out.printf("Hours Worked: %.2f\n", hoursWorked);
//            System.out.printf("Employee Pay Rate: %.2f\n", employeePayRate);
                    System.out.printf("Employee Gross pay %.2f\n\n", employee.getGrossPay());
                }

                //!Catching the errors
            } catch (Exception e) {
                System.out.println(e.getMessage());

                System.out.println("Error reading employees.csv");
            }





    }


}
