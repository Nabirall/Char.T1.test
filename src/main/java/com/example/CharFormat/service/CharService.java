package com.example.CharFormat.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class CharService {
    private final CountRepeatedService countRepeatedService;
    private final SortAndFormatRepeatedService sortAndFormatRepeatedService;


    public Map<Character, Integer> getCharacterSortedByQuantity(String input) {
        Map<Character, Integer> map = countRepeatedService.getCharsCount(input);
        return sortAndFormatRepeatedService.sortAndFormatResult(map);
    }
}
