import java.util.Scanner;

public class TP1_1 {
    
    public static void main(String[] args) {
        Scanner a = new Scanner(System.in);
        System.out.print("Masukkan kalimat: ");
        String kalimat = a.nextLine();

        String[] kata = kalimat.split(" ");
        String hasil = "";

        for (int i = 0; i < kata.length; i++) {
            if (kata[i].length() > 0) {
                String hurufAwal = kata[i].substring(0, 1).toUpperCase();
                String sisa = kata[i].substring(1).toLowerCase();
                hasil = hasil + hurufAwal + sisa;
            }

            if (i < kata.length - 1) {
                hasil = hasil + " ";
            }
        }

        System.out.println("Hasil : " + hasil);
        a.close();
    }
}
    