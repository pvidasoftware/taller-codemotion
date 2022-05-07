package collatz;

import java.math.BigInteger;
import java.util.Map;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller("/api")
public class CollatzController {
    
    CollatzService collatzService;

    public CollatzController(CollatzService collatzService) {
        this.collatzService = collatzService;
    }

    @Get("{bi}")
    Map<String,Object> calculate(BigInteger bi){
        System.out.println(bi.toString());
        return Map.of("bi", bi, "counter", collatzService.count(bi));
    }

}
