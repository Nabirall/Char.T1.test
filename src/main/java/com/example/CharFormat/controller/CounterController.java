package com.example.CharFormat.controller;

import com.example.CharFormat.service.CharService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/")
public class CounterController {
private final CharService charService;


@GetMapping("count/")
public ResponseEntity<Map<Character, Integer>> getResult(String input) {

    Map<Character, Integer> map = charService.getCharacterSortedByQuantity(input);
    return ResponseEntity.ok(map);
}
}

