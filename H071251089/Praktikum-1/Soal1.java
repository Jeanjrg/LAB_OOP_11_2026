import java.util.Scanner;

public class Soal1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        try {
            System.out.print("Masukkan Judul Film: ");
            String judul = input.nextLine();

            String[] kata = judul.split(" ");
            String hasil = "";

            for (String huruf : kata) {
                String k = huruf;

                String hurufDepan = k.substring(0, 1).toUpperCase();
                String sisaHuruf = k.substring(1).toLowerCase();

                hasil += hurufDepan + sisaHuruf + " ";
            }

            System.out.println(hasil);
        } catch (Exception e){
            System.out.println("Inputan jangan kosong");
        } finally {
            input.close();
        }
    }
}