import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class ForkJoinFibonacci extends RecursiveTask<Long> {
    private volatile long number;
    private static final long numberOfThreads = Runtime.getRuntime().availableProcessors()*10L;

    public ForkJoinFibonacci(long number) {
        this.number = number;
    }

    public long getNumber() {
        return number;
    }

    @Override
    protected Long compute() {
        long n = number;
        if (n <= numberOfThreads) {
            number = FindFibonacciByCycle.getNumberFibonacci(n);
        } else {
            ForkJoinFibonacci fibCurrent = new ForkJoinFibonacci(n - 1);
            ForkJoinFibonacci fibPrevious = new ForkJoinFibonacci(n - 2);
            ForkJoinTask.invokeAll(fibCurrent, fibPrevious);
            number = fibCurrent.getNumber() + fibPrevious.getNumber();
        }
        return  number;
    }
}

