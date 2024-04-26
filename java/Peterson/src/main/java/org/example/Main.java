package org.example;

public class Main {

    public static void main(String[] args) {
        Peterson peterson = new Peterson();

        Processes firstTask = new Processes(peterson, 0, 1000);
        Processes secondTask = new Processes(peterson, 1, 500);

        Thread firstProcess = new Thread(firstTask);
        Thread secondProcess = new Thread(secondTask);

        firstProcess.start();
        secondProcess.start();

        try {
            firstProcess.join();
            secondProcess.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Finished");
    }
}