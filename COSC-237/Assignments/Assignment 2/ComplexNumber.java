//ComplexNumber Class
//Romerico David
//Julian Halsey
//Michael Reifer


import java.util.Scanner;

public class ComplexNumber {
    private double real; 
    private double imag; 

    public ComplexNumber() {
        real = 0;
        imag = 0;
    }

    public ComplexNumber(double a, double b) {
        real = a;
        imag = b;
    }

    public void print() {
        System.out.printf("(%.2f, %.2f)", real, imag);
    }

    public void read() {
        Scanner input = new Scanner(System.in);
        real = getDouble(input, "Enter complex number (real imaginary): ");
        imag = getDouble(input, "");
    }

    public double getReal() {
        return real;
    }

    public double getImaginary() {
        return imag;
    }

    public boolean equals(ComplexNumber c) {
        return real == c.real && imag == c.imag;
    }

    public void copy(ComplexNumber c) {
        real = c.real;
        imag = c.imag;
    }

    public ComplexNumber getCopy() {
        return new ComplexNumber(real, imag);
    }

    public String toString() {
        return String.format("(%.2f, %.2f)", real, imag);
    }

    public ComplexNumber add(ComplexNumber c) {
        return new ComplexNumber(real + c.real, imag + c.imag);

    }

    public ComplexNumber subtract(ComplexNumber c) {
        return new ComplexNumber(real - c.real, imag - c.imag);

    }

    public ComplexNumber multiply(ComplexNumber c) {
        return new ComplexNumber((real * c.real - imag * c.imag), (real * c.imag + imag * c.real));

    }

    public ComplexNumber divide(ComplexNumber c) {
        return new ComplexNumber(((real * c.real + imag * c.imag) / (Math.pow(c.real, 2) + Math.pow(c.imag, 2))),
                ((imag * c.real - real * c.imag) / (Math.pow(c.real, 2) + Math.pow(c.imag, 2))));
    }

    public double cAbs() {
        return Math.sqrt(Math.pow(real, 2) + Math.pow(imag, 2));
    }

    private double getDouble(Scanner input, String prompt) {
        System.out.print(prompt);
        while (!input.hasNextDouble()) {
            input.next(); // Consume unwanted input type
            System.out.print("Not a Double! Try again!\n");
            System.out.print(prompt);
        }
        return input.nextDouble();
    }

}
