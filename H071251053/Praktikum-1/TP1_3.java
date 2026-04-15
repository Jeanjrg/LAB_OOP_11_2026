import java.util.Scanner;

public class TP1_3 {
    
    public static void main(String[] args) {
        Scanner a = new Scanner(System.in);
        System.out.print("Masukkan password: ");
        String password = a.nextLine();

        boolean panjang = password.length() >= 8;
        boolean hurufBesar = false;
        boolean hurufkecil = false;
        boolean angka = false;

        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);

            if (Character.isUpperCase(c)) {
                hurufBesar = true;
            } else if (Character.isLowerCase(c)) {
                hurufkecil = true;
            } else if (Character.isDigit(c)) {
                angka = true;
            }
        }

        if (panjang && hurufBesar && hurufkecil && angka) {
            System.out.println("Password valid");
        } else {
            System.out.println("Password tidak valid");
        }
        a.close();
    }
}
