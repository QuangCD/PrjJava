package employeemanager;

import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeList {

    ArrayList<Employee> list = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public void AddAnEmployee() {
        String id = "", format = "^[S|s][E|e]\\d{6}$";
        boolean match = false;
        do {
            System.out.print("Enter code: ");
        try {
                id = sc.nextLine().trim();
                match = id.matches(format);
                if (match == false) {
                    System.out.println("The format of SE------, '-' stands for a digit");
                }
                for (int i = 0; i < list.size(); i++) {
                    if (id.equalsIgnoreCase(list.get(i).getCode())) {
                        match = false;
                        throw new Exception();
                    }
                }
            } catch (Exception e) {
                System.out.println("Dublicate code!!!");
            }
        } while (match != true);
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter address: ");
        String address = sc.nextLine();
        double salary = 0, allowance = 0;
        do {
            try {
                System.out.print("Enter salary: ");
                salary = Double.parseDouble(sc.nextLine());
                if (salary <= 0) {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Please enter a number(Salary > 0)!!!");
            }
        } while (salary <= 0);
        do {
            try {
                System.out.print("Enter allowance: ");
                allowance = Double.parseDouble(sc.nextLine());
                if (allowance <= 0) {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Please enter a number(Allowance > 0)!!!");
            }
        } while (allowance <= 0);
        Employee e = new Employee(id, name, address, salary, allowance);
        list.add(e);
    }

    public void DeleteAnEmployee(String id) {
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            if (id.equalsIgnoreCase(list.get(i).getCode())) {
                list.remove(i);
                count++;
            }
        }
        if (count > 0) {
            System.out.println("Deleted");
        } else {
            System.out.println("Code isn't exist");
        }
    }

    public void sortListByTotalWages() {

        try {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getTotalWages() > list.get(i + 1).getTotalWages()) {
                    String code = list.get(i + 1).getCode();
                    String name = list.get(i + 1).getName();
                    String address = list.get(i + 1).getAddress();
                    double salary = list.get(i + 1).getSalary();
                    double allowance = list.get(i + 1).getAllowance();
                    double totalwages = list.get(i + 1).getTotalWages();
                    list.get(i + 1).setCode(list.get(i).getCode());
                    list.get(i + 1).setName(list.get(i).getName());
                    list.get(i + 1).setAddress(list.get(i).getAddress());
                    list.get(i + 1).setSalary(list.get(i).getSalary());
                    list.get(i + 1).setAllowance(list.get(i).getAllowance());
                    list.get(i + 1).setTotalWages(list.get(i).getTotalWages());
                    list.get(i).setCode(code);
                    list.get(i).setName(name);
                    list.get(i).setAddress(address);
                    list.get(i).setSalary(salary);
                    list.get(i).setAllowance(allowance);
                    list.get(i).setTotalWages(totalwages);
                }
            }
        } catch (Exception e) {
        }
    }

    public void ShowAllTotalWages() {
        for (int i = 0; i < list.size(); i++) {
            list.get(i).ShowInfor();
        }
    }

    public void ShowMaxTotalWages() {
        double max = list.get(0).getTotalWages();
        int index = 0;
        for (int i = 1; i < list.size(); i++) {
            if (max < list.get(i).getTotalWages()) {
                max = list.get(i).getTotalWages();
                index = i;
            }
        }
        list.get(index).ShowInfor();
    }
}
