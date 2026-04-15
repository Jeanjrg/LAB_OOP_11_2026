package H071251033.Tuprak1;

import java.util.Scanner; 

public class program3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan Password: ");
        String password = input.nextLine();

        boolean panjang = password.length() >= 8;
        boolean hurufBesar = false;
        boolean hurufKecil = false;
        boolean angka = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) hurufBesar = true;
            if (Character.isLowerCase(c)) hurufKecil = true;
            if (Character.isDigit(c)) angka = true;
        }

        if (panjang && hurufBesar && hurufKecil && angka){
            System.out.println("Password valid");
        } else {
            System.out.println("Password tidak valid");
        }
    }
}
