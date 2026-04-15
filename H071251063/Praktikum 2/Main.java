public class Main {
    public static void main(String[] args) {
        
        Topping t1 = new Topping("jelly", 5000);
        Topping t2 = new Topping("cheese foam", 7000);

        Teazzi minum1 = new Teazzi("Teazzi Brown Sugar", 15000, t1);
        Teazzi minum2 = new Teazzi("Teazzi Matcha", 14000, t2);

        minum1.tampilInfo();
        minum2.tampilInfo();

        // Interaksi antar objek
        minum1.bandingkan(minum2);
    }
}