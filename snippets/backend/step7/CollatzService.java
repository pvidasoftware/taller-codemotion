package collatz;

import java.math.BigInteger;
import java.util.Optional;

import jakarta.inject.Singleton;

@Singleton
public class CollatzService {

    int count( BigInteger n){
        int count = 0;
        while (!n.equals(BigInteger.ONE)) {
            if (n.mod(new BigInteger("2")) == BigInteger.ZERO) {
                n = n.divide(new BigInteger("2"));
            } else {
                n = n.multiply(new BigInteger("3"));
                n = n.add(new BigInteger("1"));
            }
            count++;
        }
        return count;
    }

}
