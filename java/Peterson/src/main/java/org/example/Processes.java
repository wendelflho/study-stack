package org.example;

public record Processes(
        Peterson peterson,
        Integer processId,
        Integer timeToSleep
) implements Runnable {

    public void firstProcess() {
        while (true) {
            peterson.getFlag()[0] = Boolean.TRUE;
            peterson.setTurn(1);
            while (peterson.getFlag()[1] && peterson.getTurn() == 1) {
                // busy wait
                peterson.getFlag()[0] = Boolean.FALSE;
            }
        }
    }

    public void secondProcess() {
        while (true) {
            peterson.getFlag()[1] = Boolean.TRUE;
            peterson.setTurn(0);
            while (peterson.getFlag()[0] && peterson.getTurn() == 0) {
                // busy wait
                peterson.getFlag()[1] = Boolean.FALSE;
            }
        }
    }

    @Override
    public void run() {
        while (true) {
            peterson.enterCritical(processId);
            System.out.println("Process " + processId + " is in critical section");
            try {
                Thread.sleep(timeToSleep);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            peterson.leaveCritical(processId);
        }
    }
}
