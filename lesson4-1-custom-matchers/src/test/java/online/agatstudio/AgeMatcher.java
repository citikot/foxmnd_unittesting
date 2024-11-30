package online.agatstudio;

import online.agatstudio.domain.Person;
import org.mockito.ArgumentMatcher;

public class AgeMatcher implements ArgumentMatcher<Person> {

    private int ageStart;
    private int ageEnd;

    public AgeMatcher(int ageStart, int ageEnd) {
        this.ageStart = ageStart;
        this.ageEnd = ageEnd;
    }

    @Override
    public boolean matches(Person person) {
        return person.getAge() >= ageStart && person.getAge() <= ageEnd;
    }

    public int getAgeStart() {
        return ageStart;
    }

    public void setAgeStart(int ageStart) {
        this.ageStart = ageStart;
    }

    public int getAgeEnd() {
        return ageEnd;
    }

    public void setAgeEnd(int ageEnd) {
        this.ageEnd = ageEnd;
    }
}
