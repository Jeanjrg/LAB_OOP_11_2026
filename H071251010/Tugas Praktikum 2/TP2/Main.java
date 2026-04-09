package TP2;

public class Main {
    public static void main(String[] args) {

        Boboiboy b1 = new Boboiboy("Halilintar", "Halilintar", 25, "Petir Kilat", "Serangan Cepat", 50);
        Boboiboy b2 = new Boboiboy("Gempa", "Gempa", 20, "Hentakan Tanah", "Defense Tinggi", 50);
        Boboiboy b3 = new Boboiboy("Topan", "Topan", 22, "Angin Puting", "Mengganggu musuh", 50);

        b1.checkStatus();
        pembatas();

        b2.checkStatus();
        pembatas();

        b3.checkStatus();
        pembatas();

        b1.gunakanSkill(b2);
        b2.checkStatus();
        pembatas();

        b2.gunakanSkill(b3);
        b3.checkStatus();
        pembatas();

        b3.gunakanSkill(b1);
        b1.checkStatus();
        pembatas();
    }

    public static void pembatas() {
        System.out.println("===============================");
    }
}