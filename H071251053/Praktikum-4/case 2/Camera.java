    class Camera extends Product{
    int resolution;
    String lensType;

    public Camera(String brand, int seriesNumber, double price, int resolution, String lensType) {
        super(brand, seriesNumber, price);
        this.resolution = resolution;
        this.lensType = lensType;
    }

    void displayInfoCamera() {
        System.out.println("Brand: " + brand);
        System.out.println("Serial Number: " + seriesNumber);
        System.out.println("Price: $" + price);
        System.out.println("Detail: Resolution " + resolution + "MP");
        System.out.println("Lens " + lensType);
    }
}
