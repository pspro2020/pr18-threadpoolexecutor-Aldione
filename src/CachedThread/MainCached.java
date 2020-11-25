package CachedThread;


import ScriptPotencial.Potencial;

public class MainCached {

    public static void main(String[] args) {

        Potencial potencial;
        CachedThread cachedThread = new CachedThread();

        for (int i = 0; i < 10; i++) {
            try {
                potencial = new Potencial(i);
                Thread.sleep(200);
                cachedThread.executeCached(potencial);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        try {
            cachedThread.shutDownCached();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
