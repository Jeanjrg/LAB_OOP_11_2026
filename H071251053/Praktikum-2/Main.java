public class Main {
    
    public static void main(String[] args) {
        penjualMakanan penjualMakanan1 = new penjualMakanan("Penjual Kerupuk", "Kerupuk Putih", 2000, 50);
        penjualMakanan penjualMakanan2 = new penjualMakanan("Warteg Dermawan", "Ikan Bakar", 15000, 3);

        penjualMakanan1.cekStatus();
        penjualMakanan2.cekStatus();

        penjualMakanan1.titipJualan(penjualMakanan2);
        
        penjualMakanan1.cekStatus();
        penjualMakanan2.cekStatus();
    }
}
