public class FindFibonacciByCycle {

    public static Long getNumberFibonacci(long n){
        long fibCur = 0;
        long fibNext = 1;
        long sum = 0;
        for (int i = 0; i < n-1; i++) {
            sum = fibNext + fibCur;
            fibCur = fibNext;
            fibNext = sum;
        }
        return sum;
    }
}
