import java.util.Scanner;

public class nomor1 {
    public static void main(String[] args) {
        Scanner dezz = new Scanner(System.in);

        System.out.println("Masukkan Judul Film : ");
        String judulfilm = dezz.nextLine();

        String[] kataperkata = judulfilm.split(" ");

        String hasil = "";

        for (String kata : kataperkata) {
            if (kata.length() > 0) {
                String kataBaru = kata.substring(0, 1).toUpperCase() + kata.substring(1).toLowerCase();
                hasil += kataBaru + " ";
            }
        }
        
        System.out.println(hasil.trim());
    }
}

