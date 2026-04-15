
import java.util.Scanner;


public class no2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String[] month = {
            "Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember"
        };
        System.out.println("input tanggal (dd-mm-yy: ");
        String tanggal = input.nextLine();

        String[] bagian = tanggal.split("-");

        int hari = Integer.parseInt(bagian[0]);
        int bulan = Integer.parseInt(bagian[1]);
        int tahun = Integer.parseInt(bagian[2]);
        if (tahun <= 25){
            tahun += 2000;
        } else {
            tahun += 1900;
        }
        System.out.println("output: " + hari + " " + month[bulan-1] + " " + tahun);
    }
    
}
