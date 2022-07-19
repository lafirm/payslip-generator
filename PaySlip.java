import java.util.Scanner; //Import Scanner class from java.util package to accept Input from the user
//we can also import the entire package using "java.util.*"
import java.util.Date; //Import Date class from java.util package to use date object
import java.text.SimpleDateFormat; //Import to format date

//A parent class can be public only in it's own java file
class Employee {
    String id, firstName, lastName, email, contactNumber, department;
    double basicPay, houseAllowance, foodAllowance, overTimePay, overTimeHours, totalPay;
}

// AdminEmp is a child class which inherits attributes and methods from parent
// class called Employee
class AdminEmp extends Employee {
    public double calcTotalPay(double basic, double house, double food) {
        /*
         * The Parameters in methods need not to be the same as actual variable names,
         * it can be anything
         */
        totalPay = basic + house + food;
        return totalPay;
    }
}

// FactoryEmp is a child class which inherits attributes and methods from parent
// class called Employee
class FactoryEmp extends Employee {
    public double calcTotalPay(double basic, double OTPay, double OTHours) {
        /*
         * The Parameters in methods need not to be the same as actual variable names,
         * it can be anything
         */
        totalPay = basic + (OTPay * OTHours);
        return totalPay;
    }
}

/* Here, we have created 2 child classes from a parent class to generate a payslip.
we can also generate a payslip without creating child classes and there are variuos methods
to obtain a single output */

public class PaySlip {
    public static void main(String[] args) {
        Scanner keyboardInput = new Scanner(System.in); // instancing Scanner class
        Employee emp = new Employee(); // instancing Employee class
        AdminEmp ad = new AdminEmp(); // instancing AdminEmp class
        FactoryEmp fc = new FactoryEmp(); // instancing FactoryEmp class

        // we created objects from the class to access its attributes and methods

        System.out.println("Enter the Employee ID: "); //to display message in a new line to the user
        emp.id = keyboardInput.next(); // to accept input from the user
        System.out.println("Enter the Employee First Name: ");
        emp.firstName = keyboardInput.next();
        System.out.println("Enter the Employee Last Name: ");
        emp.lastName = keyboardInput.next();
        System.out.println("Enter the Email ID: ");
        emp.email = keyboardInput.next();
        System.out.println("Enter the Contact Number: ");
        emp.contactNumber = keyboardInput.next();
        System.out.println("Enter the Department: ");
        emp.department = keyboardInput.next();

        // This if-else condition is used to execute a set of statements based on
        // certain condition
        // in this case, the department can be either Admin or Factory

        if (emp.department.equalsIgnoreCase("Admin")) {
            System.out.println("Enter the Basic Pay: ");
            emp.basicPay = keyboardInput.nextDouble();
            System.out.println("Enter the Housing Allowance Amount: ");
            emp.houseAllowance = keyboardInput.nextDouble();
            System.out.println("Enter the Food Allowance Amount: ");
            emp.foodAllowance = keyboardInput.nextDouble();
        } else if (emp.department.equalsIgnoreCase("Factory")) {
            System.out.println("Enter the Basic Pay: ");
            emp.basicPay = keyboardInput.nextDouble();
            System.out.println("Enter the Over Time Pay: "); // over time allowance per hour
            emp.overTimePay = keyboardInput.nextDouble();
            System.out.println("Enter the Over Time Worked (Hours): ");
            emp.overTimeHours = keyboardInput.nextDouble();
        } else {
            System.out.println("Invalid Department, Enter either \"Admin\" or \"Factory\" ");
        }

        keyboardInput.close(); // closing the keyboardInput object to avoid resource leak - not mandatory

        // to calculate total pay
        if (emp.department.equalsIgnoreCase("Admin")) {
            ad.totalPay = ad.calcTotalPay(emp.basicPay, emp.houseAllowance, emp.foodAllowance);
            System.out.println("Total Pay of the Employee:  SGD " + ad.totalPay);
        } else if (emp.department.equalsIgnoreCase("Factory")) {
            fc.totalPay = fc.calcTotalPay(emp.basicPay, emp.overTimePay, emp.overTimeHours);
            System.out.println(
                    "Total Pay of the Employee:  SGD " + fc.totalPay);
        }
        System.out.println(""); // to provide a line space between payslip and the previous data
        System.out.println("******************************************************************");
        System.out.println(""); // to provide a line space between payslip and the previous data

        // to generate payslip for admin employee
        if (emp.department.equalsIgnoreCase("Admin")) {
            System.out.println("**ADMIN EMPLOYEE PAYSLIP**");
            // to format date, creating an object from simple date format
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
            Date date = new Date(); // creating an object from date class to use below
            System.out.println("Payslip Generated Date: " + formatter.format(date));
            System.out.println("Employee ID: " + emp.id);
            System.out.println("Employee Name: " + emp.firstName + " " + emp.lastName);
            System.out.println("Department: " + emp.department);
            System.out.println("Basic Pay:  SGD " + emp.basicPay);
            System.out.println("Housing Allowance:  SGD " + emp.houseAllowance);
            System.out.println("Food Allowance:  SGD " + emp.foodAllowance);
            System.out.println("Total Pay:  SGD " + ad.totalPay);
            System.out.println("Payment Method: Bank Account");
            System.out.println("");
            System.out.println("");
            System.out.println("******************************************************************");
        }

        // to generate payslip for factory employee
        else if (emp.department.equalsIgnoreCase("Factory")) {
            System.out.println("**FACTORY EMPLOYEE PAYSLIP**");
            // to format date, creating an object from simple date format
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
            Date date = new Date(); // creating an object from date class to use below
            System.out.println("Payslip Generated Date: " + formatter.format(date));
            System.out.println("Employee ID: " + emp.id);
            System.out.println("Employee Name: " + emp.firstName + " " + emp.lastName);
            System.out.println("Department: " + emp.department);
            System.out.println("Basic Pay:  SGD " + emp.basicPay);
            System.out.println("Total Over Time Pay:  SGD " + (emp.overTimePay * emp.overTimeHours));
            System.out.println("Total Pay:  SGD " + fc.totalPay);
            System.out.println("Payment Method: Bank Account");
            System.out.println("");
            System.out.println("");
            System.out.println("******************************************************************");
        }

    }
}