import java.util.Scanner;

public class Soal1 {

    public static String kapitalAwal(String kalimat) {

        String[] kata = kalimat.split(" ");
        String hasil = "";

        int i = 0;

        while (i < kata.length) {

            String k = kata[i].toLowerCase();

            char awal = Character.toUpperCase(k.charAt(0));

            String sisa = k.substring(1);

            hasil = hasil + awal + sisa;

            if (i < kata.length - 1) {
                hasil = hasil + " ";
            }

            i++;
        }

        return hasil;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan Judul Film: ");
        String teks = input.nextLine();

        String hasil = kapitalAwal(teks);

        System.out.println("Hasil: " + hasil);
    }
}