package howdy;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class restController {

    private static final String template = "Howdy, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/restgreeting")
    public Greeting restgreeting(@RequestParam(value = "name", defaultValue = "Wirl") String name) {
        //ID increases by one every request:
        return new Greeting(counter.incrementAndGet(),
            String.format(template, name));
    }
}