package screenshots;
import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FakerData {
    private static final List<String> names = new ArrayList<>();
    private static final Faker faker = new Faker();
    private static final int MIN_SALARY = 10_000, MAX_SALARY = 500_000;
    private static final int MIN_AGE = 8, MAX_AGE = 100;
    public static String[] arrayData() {
        String name = faker.name().firstName();
        names.add(name);
        return new String[]{name, faker.name().firstName(), faker.internet().emailAddress(),
            String.valueOf(faker.random().nextInt(MIN_AGE, MAX_AGE)), String.valueOf(faker.random().nextInt(MIN_SALARY, MAX_SALARY)),
            faker.commerce().department()};
    }
    public static List<String> getNames() {
        return Collections.unmodifiableList(names);
    }
}
