package online.agatstudio;

import online.agatstudio.domain.Person;
import online.agatstudio.domain.PersonService;
import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

class TestAgeMatchesRange {

    @Test
    void testAgeInRange() {
        // Создаем mock
        PersonService mockService = mock(PersonService.class);

        // Вызов метода с объектом Person, у которого age = 25
        mockService.process(new Person(25));

        // Проверяем, что метод был вызван с возрастом, входящим в диапазон 20-30
        verify(mockService).process(argThat(new AgeMatcher(20, 30)));
    }

    @Test
    void testAgeNotInRange() {
        // Создаем mock
        PersonService mockService = mock(PersonService.class);

        // Вызов метода с объектом Person, у которого age = 35
        mockService.process(new Person(35));

        // Проверяем, что метод не был вызван с возрастом, входящим в диапазон 20-30
        verify(mockService, never()).process(argThat(new AgeMatcher(20, 30)));
    }


}
