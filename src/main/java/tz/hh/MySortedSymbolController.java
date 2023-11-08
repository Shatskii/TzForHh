package tz.hh;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.stream.IntStream;


@RestController
@RequestMapping("/sorted")
public class MySortedSymbolController {
    @GetMapping
    public Map<Character, Integer> sortedLine(@RequestParam String line) {
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = line.toCharArray();
        for (char c : chars) {
            int count = (int) IntStream.range(0, chars.length).mapToObj(i -> chars[i]).filter(x -> x.equals(c)).count();
            map.put(c, count);
        }
        Map<Character, Integer> mapFinal = new LinkedHashMap<>();
        List<Map.Entry<Character, Integer>> list = new ArrayList(map.entrySet());
        list.sort(Map.Entry.comparingByValue(Collections.reverseOrder()));
        for (Map.Entry<Character, Integer> e : list) {
            mapFinal.put(e.getKey(), e.getValue());
        }
        return mapFinal;
    }
}
