package employeemanager;

import java.util.Scanner;
public class EmployeeManager {

    
        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EmployeeList el = new EmployeeList();
        int choose = 0;
        do {
            System.out.println("-----EmployeeManagerSystem-----");
            System.out.println("1.Add an employee");
            System.out.println("2.Show the total wages of each employee");
            System.out.println("3.Show employee information with the largest total wages");
            System.out.println("4.Show the list in ascending order based on total wages");
            System.out.println("5.Remove an employee by code");
            System.out.println("6.Exit");
            try {
                System.out.print("Enter your choose: ");
                choose = Integer.parseInt(sc.nextLine());
                if (choose < 1 || choose > 6) {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Please enter 1 --> 6");
            }
            switch (choose) {
                case 1: {
                    el.AddAnEmployee();
                    break;
                }
                case 2: {
                    el.ShowAllTotalWages();
                    break;
                }
                case 3: {
                    el.ShowMaxTotalWages();
                    break;
                }
                case 4: {
                    el.sortListByTotalWages();
                    el.ShowAllTotalWages();
                    break;
                }
                case 5: {
                    System.out.print("Enter Code: ");
                    String code = sc.nextLine();
                    el.DeleteAnEmployee(code);
                    break;
                }
            }
        } while (choose != 6);
    }

}
