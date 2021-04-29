package employeemanager;
public class Employee {

    private String code;
    private String name;
    private String address;
    private double salary;
    private double allowance;
    private double totalWages;

    public Employee(String code, String name, String address, double salary, double allowance) {
        this.code = code;
        this.name = name;
        this.address = address;
        this.salary = salary;
        this.allowance = allowance;
        this.totalWages = this.salary + this.allowance;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public double getSalary() {
        return salary;
    }

    public double getAllowance() {
        return allowance;
    }

    public void setTotalWages(double totalWages) {
        this.totalWages = totalWages;
    }

    public double getTotalWages() {
        return (totalWages);
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setAllowance(double allowance) {
        this.allowance = allowance;
    }

    public void ShowInfor() {
        System.out.println("-----------------------------");
        System.out.println("Code: " + code);
        System.out.println("Name: " + name);
        System.out.println("Address: " + address);
        System.out.println("Salary: " + salary);
        System.out.println("Allowance: " + allowance);
        System.out.println("Total wages: " + (totalWages));
        System.out.println("-----------------------------");
    }
}
