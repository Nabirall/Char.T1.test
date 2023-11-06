package com.example.CharFormat.service;


import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service
public class CountRepeatedService {

    public Map<Character, Integer> getCharsCount(String input) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < input.length(); i++) {
            if (!map.containsKey(input.charAt(i))) {
                map.put(input.charAt(i), 1);
            } else {
                map.put(input.charAt(i), map.get(input.charAt(i)) + 1);
            }
        }
        return map;
    }
}
