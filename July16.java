import java.util.*;

public class July16 {
    public static int countNumbers(int n) {
        List<Integer> primes = sieve((int)Math.sqrt(n) + 1);
        int count = 0;

        for (int p : primes)
            if ((long)p * p * p * p * p * p * p * p <= n)
                count++;

        for (int i = 0; i < primes.size(); i++)
            for (int j = i + 1; j < primes.size(); j++) {
                long val = 1L * primes.get(i) * primes.get(i) * primes.get(j) * primes.get(j);
                if (val <= n) count++;
                else break;
            }

        return count;
    }

    private static List<Integer> sieve(int limit) {
        boolean[] isPrime = new boolean[limit + 1];
        Arrays.fill(isPrime, true); isPrime[0] = isPrime[1] = false;
        for (int i = 2; i * i <= limit; i++)
            if (isPrime[i])
                for (int j = i * i; j <= limit; j += i)
                    isPrime[j] = false;
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= limit; i++)
            if (isPrime[i]) primes.add(i);
        return primes;
    }

    public static void main(String[] args) {
        System.out.println(countNumbers(100));  // Output: 2
        System.out.println(countNumbers(200));  // Output: 3
    }
}
