import java.util.Scanner;

public class TP1_2 {

    public static void main(String[] args) {
        Scanner a = new Scanner(System.in);
        System.out.print("Masukkan tanggal (dd-mm-yy): ");
        String tanggal = a.nextLine();

        String[] x = tanggal.split("-");

        int date = Integer.parseInt(x[0]);
        int month = Integer.parseInt(x[1]);
        int year = Integer.parseInt(x[2]);

        boolean validasi = true; 
        
        if (date < 1 || date > 31) {
            System.out.println("Tanggal tidak valid");
            validasi = false;
        }

        if (month < 1 || month > 12) {
            System.out.println("Bulan tidak valid");
            validasi = false;
        }

        if (year < 0 || year > 99) {
            System.out.println("Tahun tidak valid");
            validasi = false;
        }

        if (validasi) {

            String monthName = "";
            switch (month) {
                case 1: monthName = "Januari"; break;
                case 2: monthName = "Februari"; break;
                case 3: monthName = "Maret"; break;
                case 4: monthName = "April"; break;
                case 5: monthName = "Mei"; break;
                case 6: monthName = "Juni"; break;
                case 7: monthName = "Juli"; break;
                case 8: monthName = "Agustus"; break;
                case 9: monthName = "September"; break;
                case 10: monthName = "Oktober"; break;
                case 11: monthName = "November"; break;
                case 12: monthName = "Desember"; break;
            }

            if (year <= 30) {
                year = 2000 + year;
            } else {
                year = 1900 + year;
            }

            System.out.println(date + " " + monthName + " " + year);
        }
        a.close();
    }
}

