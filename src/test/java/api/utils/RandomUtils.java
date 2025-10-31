package api.utils;

import net.datafaker.Faker;

import java.util.Random;

public class RandomUtils {
    private static final ThreadLocal<Faker> FAKER = ThreadLocal.withInitial(Faker::new);

    public static String getRandomName() {
        return FAKER.get().name().firstName();
    }

    public static String getRandomFullName() {
        return FAKER.get().name().fullName();
    }

    public static String getRandomJob() {
        return FAKER.get().job().title();
    }
}
