import java.time.LocalTime;
import java.time.temporal.ChronoField;
import java.util.concurrent.ForkJoinPool;

public class Main {

    public static void main(String[] args) {
        final long numberFibonacci = 50;

        //System.out.println("Num of cores: "  + Runtime.getRuntime().availableProcessors());

        ForkJoinPool pool = new ForkJoinPool();
        long timeStart = System.nanoTime();
        long forkJoinFibonacci = pool.invoke(new ForkJoinFibonacci(numberFibonacci));
        long timeEnd = System.nanoTime();
        System.out.println("ForkJoinPool " + numberFibonacci +
                "th number of Fibonacci: " + forkJoinFibonacci);
        System.out.println("ForkJoinPool time calculated of " + numberFibonacci +
                "th number of Fibonacci: " + ((timeEnd - timeStart)/1000000L) + " ms");
        System.out.println();

        timeStart = System.nanoTime();
        forkJoinFibonacci = FindFibonacciByCycle.getNumberFibonacci(numberFibonacci);
        timeEnd = System.nanoTime();
        System.out.println("Calculated by cycle " + numberFibonacci +
                "th number of Fibonacci: " + forkJoinFibonacci);
        System.out.println("Calculated by cycle time calculated of " + numberFibonacci +
                "th number of Fibonacci: " + ((timeEnd - timeStart)/1000L) + " micro sec");

    }

}
