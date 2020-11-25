package ScriptPotencial;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Potencial implements Runnable{

    private final int number;

    public Potencial(int number){
        this.number = number;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            double potencial = Math.pow(number, i);
            System.out.printf("%s - %s: %d ^ %d = %.0f\n", DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM).format(LocalTime.now()), Thread.currentThread().getName(), number, i, potencial);
        }
    }
}
