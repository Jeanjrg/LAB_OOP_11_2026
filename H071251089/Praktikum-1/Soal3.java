import java.util.Scanner;

public class Soal3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String pass = input.nextLine();

        boolean adaHurufBesar = false;
        boolean adaHurufKecil = false;
        boolean adaAngka = false;

        for (int i = 0; i < pass.length(); i++) {
            char pw = pass.charAt(i);

            if (Character.isUpperCase(pw)) {
                adaHurufBesar = true;
            } else if (Character.isLowerCase(pw)) {
                adaHurufKecil = true;
            } else if (Character.isDigit(pw)) {
                adaAngka = true;
            }
        }

        if (pass.length() >= 8 && adaHurufBesar && adaHurufKecil && adaAngka) {
            System.out.println("Password valid");
        } else {
            System.out.println("Password tidak valid");
        }

        input.close();
    }
}