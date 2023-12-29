import java.util.Scanner;

public class Fraction{
    private int num;
    private int denom;

    public Fraction(){
        num = 0;
        denom = 1;
    }

    public Fraction(int n){
        num = n;
        denom = 1;
    }

    public Fraction(int n, int d){
        num = n;
        denom = d;
    }

    public void setNum(int n){
        num = n;
    }

    public void setDenom(int d){
        denom = d != 0 ? d : 1;
    }

    public void setFraction(int n, int d){
        num = n;
        denom = d != 0 ? d : 1;
    }

    public int getNumerator(){
        return num;
    }

    public int getDenominator(){
        return denom;
    }

    public void read(){
        Scanner in = new Scanner(System.in);
        num = getInt(in, "Enter numerator value: ");
        denom = getInt(in, "Enter denominator value");
        while (denom == 0){
           System.out.println("ERROR"); 
           denom = getInt(in, "Enter denominator value");
        }
    }

    public void print(){
        System.out.println(num + "/" +denom);
    }

    public String toString(){
        return num + "/" + denom;
    }

    public double convertToDecimal(){
        return (double)num/denom;
    }

    public boolean equals(Fraction f){
        return num == f.num && denom == f.denom;
    }

    public void copy(Fraction f){
        num = f.num;
        denom = f.denom;
    }

    public Fraction getCopy(){
        return new Fraction(num, denom);
    }

    public void simplify(){
        num = greatestCommonDiv(num, denom);
        denom = greatestCommonDiv(num, denom);
    }

    public Fraction add(Fraction f){
        Fraction sum = new Fraction((num * f.denom + denom * f.num), denom * f.denom);
        sum.simplify();
        return sum;
    }

    private int getInt(Scanner input, String prompt) { //helper method for read()
        System.out.print(prompt);
        while (!input.hasNextInt()) {
            input.next(); 
            System.out.print("Not an Integer! Try again!\n");
            System.out.print(prompt);
        }
        return input.nextInt();
    }

    private int greatestCommonDiv(int n, int d){ //helper method for simplify()
        return 0;
    }

}


