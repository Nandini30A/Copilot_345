package com.nandini.randomnum;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/")
public class RandomController {

    private final SecureRandom random = new SecureRandom();

    @GetMapping("")
    public String home() {
        return "<html>\n" +
                "  <head><title>Random Number Generator</title></head>\n" +
                "  <body>\n" +
                "    <h1>Random Number Generator</h1>\n" +
                "    <p>Use <code>/api/random?min=1&max=100</code> to get a JSON response.</p>\n" +
                "  </body>\n" +
                "</html>";
    }

    @GetMapping("api/random")
    public Map<String, Object> random(
            @RequestParam(name = "min", defaultValue = "0") int min,
            @RequestParam(name = "max", defaultValue = "100") int max) {
        if (min > max) {
            int tmp = min; min = max; max = tmp; // swap to ensure range
        }
        int bound = max - min + 1;
        int value = min + (Math.abs(random.nextInt()) % bound);
        Map<String, Object> result = new HashMap<>();
        result.put("value", value);
        result.put("min", min);
        result.put("max", max);
        return result;
    }
}
