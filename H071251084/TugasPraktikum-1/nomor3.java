import java.util.Scanner;

public class nomor3 {
    public static void main(String[] args) {
        Scanner dezz = new Scanner(System.in);

        System.out.print("Masukkan password: ");
        String password = dezz.nextLine();

        boolean panjangPassword = password.length() >= 8;
        boolean hurufBesar = false;
        boolean hurufKecil = false;
        boolean angka = false;

        for (int i = 0; i < password.length(); i++){
            char c = password.charAt(i);
            if (Character.isUpperCase(c)) {
                hurufBesar = true;
            } else if (Character.isLowerCase(c)) {
                hurufKecil = true;
            } else if (Character.isDigit(c)) {
                angka = true;
            }
        }

        if (panjangPassword && hurufBesar && hurufKecil && angka) {
            System.out.println("Password Valid");
        }else {
            System.out.println("Password tidak valid");
        }
    }
}