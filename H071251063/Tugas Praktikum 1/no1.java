
import java.util.Scanner;
public class no1 {
    public static String hurufKapital(String kalimat) {
        String[] kata = kalimat.split(" ");
        String hasil = "";

        for (String a : kata) {
            hasil += Character.toUpperCase(a.charAt(0)) + a.substring(1).toLowerCase() + " ";
        }

        return hasil.trim();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan Judul Film: ");
        String teks = input.nextLine();

        System.out.println("Output: " + hurufKapital(teks));
    }
}

