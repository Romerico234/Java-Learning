public class Employee extends Person {
    private double payRate;
    private double hoursWorked;
    private String department;

    public final int HOURS = 40;
    public final double OVERTIME = 1.5;

    public Employee() {
        super();
        payRate = 0;
        hoursWorked = 0;
        department = "";
    }

    public Employee(String first, String last, double pay, double hrs, String dept) {
        super(first, last);
        payRate = pay;
        hoursWorked = hrs;
        department = dept;
    }

    public String toString() {
        return String.format("The wages for %s, %s from the %s department are: $%5.2f.", getLastName(), getFirstName(), department,
                calculatePay());
    }

    public void print() {
        System.out.printf("The employee %s from the %s department worked %.1f hours with a pay rate of $%.2f. The wages for %s %s are $%5.2f\n", super.toString(), department, hoursWorked, payRate, getFirstName(), getLastName(), calculatePay());
    }

    public double calculatePay() {
        return (hoursWorked > HOURS) ? (HOURS * payRate + (hoursWorked - HOURS) * payRate * OVERTIME)
                : hoursWorked * payRate;
    }

    public void setAll(String first, String last, double pay, double hrs, String dept) {
        super.set(first, last);
        payRate = pay;
        hoursWorked = hrs;
        department = dept;
    }

    public double getPayRate() {
        return payRate;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public String getDepartment() {
        return department;
    }

    public boolean equals(Object o) {
        if (o instanceof Employee) {
            Employee e = (Employee) o;
            return super.equals(e) && payRate == e.payRate && hoursWorked == e.hoursWorked && department.equals(e.department);
        }

        return false;
    }

    public void copy(Employee e) {
        super.copy(e);
        payRate = e.payRate;
        hoursWorked = e.hoursWorked;
        department = e.department;

    }

    public Employee getCopy() {
        return new Employee(getFirstName(), getLastName(), payRate, hoursWorked, department);
    }

}
