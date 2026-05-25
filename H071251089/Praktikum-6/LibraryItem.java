public abstract class LibraryItem {
    protected String title;
    protected int itemId;
    protected boolean isBorrowed;

    public LibraryItem(String title, int itemId) {
        this.title = title;
        this.itemId = itemId;
        this.isBorrowed = false;
    }

    public abstract String getDeskripsi();
    public abstract String borrowItem(int days);
    public abstract double calculateFine(int daysLate);

    public String statusReturnItem() {
        isBorrowed = false;
        return this.title + " berhasil dikembalikan";
    }

    public String getTitle() { return title; }
    public int getItemId() { return itemId; }
    public boolean getIsBorrowed() { return isBorrowed ;}
}

class Book extends LibraryItem {
    private String author;

    public Book(String title, int itemId, String author) {
        super(title, itemId);
        this.author = author;
    }

    @Override
    public String getDeskripsi() {
        return "Buku: " + title + " oleh " + author + ", ID: " + itemId;
    }

    @Override
    public String borrowItem(int days) {
        if (days > 14) {
            throw new IllegalArgumentException("Peminjaman maksimal 14 hari");  
        } 

        isBorrowed = true;
        
        System.out.println(getDeskripsi());
        return "Item " + title + " berhasil dipinjam selama " + days + " hari";
    }

    @Override
    public double calculateFine(int daysLate) {
        if (daysLate > 0) {
            return daysLate * 10000;
        }
        return 0;
    }
}

class DVD extends LibraryItem {
    private int duration;

    public DVD(String title, int itemId, int duration) {
        super(title, itemId);
        this.duration = duration;
    }

    @Override
    public String getDeskripsi() {
        return "Buku: " + title + ", Durasi " + duration + " menit, ID: " + itemId;
    }

    @Override
    public String borrowItem(int days) {
        if (days > 7) {
            throw new IllegalArgumentException("Peminjaman maksimal 7 hari");  
        } 

        isBorrowed = true;

        System.out.println(getDeskripsi());
        return "Item " + title + " berhasil dipinjam selama " + days + " hari";
    }

    @Override
    public double calculateFine(int daysLate) {
        if (daysLate > 0) {
            return daysLate * 25000;
        }
        return 0;
    }
}