
import java.util.Scanner;

public class no3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("masukkan password: ");
        String pass = input.nextLine();

        boolean adahurufbesar = false;
        boolean adahurufkecil = false;
        boolean adaangka = false;

        if (pass.length() >= 8) {
            for (char c : pass.toCharArray()){
                if (Character.isUpperCase(c)) adahurufbesar = true;
                else if (Character.isLowerCase(c)) adahurufkecil = true;
                else if (Character.isDigit(c)) adaangka = true;
            }
            if (adahurufbesar && adahurufkecil && adaangka) {
                System.out.println("password valid");
            } else {
                System.out.println("password tidak valid");
            }
        } else {
            System.out.println("password tidak valid");
        }
    }
}
