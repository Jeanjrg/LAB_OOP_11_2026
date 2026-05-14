package TP7.Soal2;

import java.util.Random;

public class DataProcessor {

    Random random = new Random();

    public int process(String fileName) throws InterruptedException {

        int waktuProses = (random.nextInt(1501) + 500);

        Thread.sleep(waktuProses);

        return random.nextInt(900) + 100;
    }
}