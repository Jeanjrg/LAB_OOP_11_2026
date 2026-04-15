package H071251033.Tuprak2;

public class Main {
    public static void main(String[] args) {

        Mood happy = new Mood("Positif", 8);
        Mood sad = new Mood("Sedih", 6);

        Person p1 = new Person("Rina", 60, happy);
        Person p2 = new Person("Doni", 40, sad);

        p1.showStatus();
        p2.showStatus();

        p1.giveSupport(p2);

        p2.showStatus();
    }
}