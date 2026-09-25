package screenshots;
import com.github.javafaker.Faker;
public class FakerData {
    private static final Faker faker = new Faker();
    private static final int MIN_SALARY = 10_000, MAX_SALARY = 500_000;
    private static final int MIN_AGE = 8, MAX_AGE = 100;
    public static String[] arrayData() {
        return new String[]{faker.name().firstName(), faker.name().lastName(),
            faker.internet().emailAddress(), String.valueOf(faker.random().nextInt(MIN_AGE, MAX_AGE)),
            String.valueOf(faker.random().nextInt(MIN_SALARY, MAX_SALARY)), faker.commerce().department()};
    }
}
