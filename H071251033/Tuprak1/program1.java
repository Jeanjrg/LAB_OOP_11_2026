package H071251033.Tuprak1;

import java.util.Scanner;

public class program1 {

    public static String awalanKapital(String kalimat) {
        String[] kata = kalimat.split(" ");
        String hasil = "";

        for (String k : kata) {
            if (k.length() > 0) {
                hasil += Character.toUpperCase(k.charAt(0)) 
                       + k.substring(1) + " ";
            }
        }
        return hasil.trim();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan Kalimat: ");
        String kalimat = input.nextLine();

        System.out.println("Output: " + awalanKapital(kalimat));
    }
}