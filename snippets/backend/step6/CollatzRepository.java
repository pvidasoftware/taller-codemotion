package collatz;

import java.math.BigInteger;

import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;

@JdbcRepository(dialect = Dialect.POSTGRES)
public abstract class CollatzRepository 
    implements CrudRepository<CollatzEntity, String>{
    
}
