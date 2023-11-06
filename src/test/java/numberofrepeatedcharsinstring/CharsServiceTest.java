package numberofrepeatedcharsinstring;


import com.example.CharFormat.service.CharService;
import com.example.CharFormat.service.CountRepeatedService;
import com.example.CharFormat.service.SortAndFormatRepeatedService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

class CharsServiceTest {

    @Mock
    private CountRepeatedService countRepeatedService;

    @Mock
    private SortAndFormatRepeatedService sortAndFormatRepeatedService;

    @InjectMocks
    private CharService charService;

    @BeforeEach
    void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void assertThatGetCharsSortedByQuantityWorksFine() {
        String phrase = "hello";

        Map<Character, Integer> charsToQuantity = new HashMap<>();
        charsToQuantity.put('h', 1);
        charsToQuantity.put('e', 1);
        charsToQuantity.put('l', 2);
        charsToQuantity.put('o', 1);

        Mockito.when(countRepeatedService.getCharsCount(phrase)).thenReturn(charsToQuantity);
        Mockito.when(sortAndFormatRepeatedService.sortAndFormatResult(charsToQuantity)).thenReturn(new LinkedHashMap<>(charsToQuantity));

        Map<Character, Integer> sortedCharsByQuantity = charService.getCharacterSortedByQuantity(phrase);

        Assertions.assertEquals(4, charsToQuantity.size());

        Assertions.assertEquals(2, sortedCharsByQuantity.get('l'));
        Assertions.assertEquals(1, sortedCharsByQuantity.get('h'));
        Assertions.assertEquals(1, sortedCharsByQuantity.get('e'));
        Assertions.assertEquals(1, sortedCharsByQuantity.get('o'));
    }
}
