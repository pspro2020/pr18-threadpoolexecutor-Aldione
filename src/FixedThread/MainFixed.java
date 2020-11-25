package FixedThread;

import ScriptPotencial.Potencial;

public class MainFixed {

    public static void main(String[] args) {

        Potencial potencial;
        FixedThread fixedThread = new FixedThread();

        for (int i = 0; i < 10; i++) {
            try {
                potencial = new Potencial(i);
                Thread.sleep(200);
                fixedThread.executeFixed(potencial);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        try {
            fixedThread.shutDownFixed();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
