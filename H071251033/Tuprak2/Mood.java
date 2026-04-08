package H071251033.Tuprak2;

class Mood {
    String type;
    int level;

    Mood() {
        type = "Netral";
        level = 0;
    }

    Mood(String type, int level) {
        this.type = type;
        this.level = level;
    }

    void showMood() {
        System.out.println("Mood: " + type + " | Level: " + level);
    }
}