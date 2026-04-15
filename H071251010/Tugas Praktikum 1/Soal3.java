import java.util.Scanner;

public class Soal3 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan password: ");
        String password = input.nextLine();

        if (password.isEmpty()) {
            System.out.println("Password tidak boleh kosong");
            return;
        }

        boolean adaBesar = false;
        boolean adaKecil = false;
        boolean adaAngka = false;

        int i = 0;

        while (i < password.length()) {

            char p = password.charAt(i);

            if (Character.isUpperCase(p)) {
                adaBesar = true;
            }

            if (Character.isLowerCase(p)) {
                adaKecil = true;
            }

            if (Character.isDigit(p)) {
                adaAngka = true;
            }

            i++;
        }

        if (password.length() >= 8 && adaBesar && adaKecil && adaAngka) {
            System.out.println("Password valid");
        } else {
            System.out.println("Password tidak valid");
        }
    }
}