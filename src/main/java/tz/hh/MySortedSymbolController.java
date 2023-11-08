package tz.hh;


import org.springframework.stereotype.Controller;
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
    public String sortedLine(@RequestParam String line) {
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = line.toCharArray();
        for (char c : chars) {
            int count = (int) IntStream.range(0, chars.length).mapToObj(i -> chars[i]).filter(x -> x.equals(c)).count();
            map.put(c, count);
        }
        List<Map.Entry<Character, Integer>> list = new ArrayList(map.entrySet());
        list.sort(Map.Entry.comparingByValue(Collections.reverseOrder()));
        return convertMapToString(list);
    }

    private static String convertMapToString(List<Map.Entry<Character, Integer>> list) {
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<Character, Integer> e : list) {
            builder.append("\"" + e.getKey() + "\"" + ": " + e.getValue()).append(",");
        }
        builder.deleteCharAt(builder.length()-1);
        return builder.toString();
    }

}
