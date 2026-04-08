package H071251033.Tuprak2;

class Person {
    String name;
    int wellbeing;
    Mood mood; 

    Person() {
        name = "Unknown";
        wellbeing = 50;
        mood = new Mood();
    }

    Person(String name, int wellbeing, Mood mood) {
        this.name = name;
        this.wellbeing = wellbeing;
        this.mood = mood;
    }

    void giveSupport(Person other) {
        System.out.println(this.name + " memberikan dukungan ke " + other.name);

        if (this.mood.type.equalsIgnoreCase("Positif")) {
            other.wellbeing += 15;
            System.out.println(other.name + "merasa lebih baik");
        } else {
            other.wellbeing += 5;
            System.out.println(other.name + "tetap mendapat sedikit dukungan");
        }
    }

    void showStatus() {
        System.out.println("Nama: " + name);
        System.out.println("Wellbeing: " + wellbeing);
        mood.showMood();
        System.out.println("----------------------");
    }
}