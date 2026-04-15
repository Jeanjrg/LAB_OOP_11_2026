package TP2;

public class Elemen {
    String jenisElemen;
    int basePower = 20;

    public int getPower() {
        if (jenisElemen.equalsIgnoreCase("Halilintar")) {
            return basePower + 10;
        } 
        else if (jenisElemen.equalsIgnoreCase("Topan")) {
            return basePower + 5;
        } 
        else if (jenisElemen.equalsIgnoreCase("Gempa")) {
            return basePower + 2;
        }
        return basePower;
    }
}