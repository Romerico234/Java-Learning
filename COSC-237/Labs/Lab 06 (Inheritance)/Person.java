public class Person {
    private String firstName;
    private String lastName;

    public Person() {
        firstName = "";
        lastName = "";
    }

    public Person(String first, String last) {
        firstName = first;
        lastName = last;
    }

    public void set(String first, String last) {
        firstName = first;
        lastName = last;
    }

    public void printLastFirst() {
        System.out.print(lastName + ", " + firstName);
    }

    public void print() {
        System.out.print(firstName + " " + lastName);
    }

    public String toString() {
        return firstName + " " + lastName;
    }

    public boolean equals(Object o) {
        if (o instanceof Person) {
            Person p = (Person) o;
            return firstName.equals(p.firstName) && lastName.equals(p.lastName);
        }
        return false;
    }

    public void copy(Person p) {
        firstName = p.firstName;
        lastName = p.lastName;
    }

    public Person getCopy(Person p) {
        return new Person(firstName, lastName);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}