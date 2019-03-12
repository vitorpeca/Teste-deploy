package hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    MongoConnection mongoConnection = new MongoConnection();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name, @RequestParam(value = "idade", defaultValue = "0") int idade) {
 //       mongoConnection.iniciandoConnection(name, idade);
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name), idade);
    }
}