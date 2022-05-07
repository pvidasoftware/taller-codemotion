package collatz;

import java.math.BigInteger;
import java.util.Optional;

import jakarta.inject.Singleton;

@Singleton
public class CollatzService {
    
    CollatzRepository collatzRepository;

    public CollatzService(collatz.CollatzRepository collatzRepository) {
        this.collatzRepository = collatzRepository;
    }
    

    int count( BigInteger n){

        Optional<CollatzEntity> optional = collatzRepository.findById(n);

        if( optional.isPresent() ){
            return optional.get().getCounter();
        }

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

        CollatzEntity entity = new CollatzEntity();
        entity.setId(n);
        entity.setCounter(count);
        collatzRepository.save(entity);

        return count;
    }

}
