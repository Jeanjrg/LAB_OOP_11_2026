class MobilGoKart {
    String model;
    int kecepatanMaksimal;

    public MobilGoKart(String model, int kecepatanMaksimal) {
        this.model = model;
        this.kecepatanMaksimal = kecepatanMaksimal;
    }

    public void tampilkanInfoMobil() {
        System.out.println("Mobil: " + model + " (Speed: " + kecepatanMaksimal + " km/h)");
    }
}