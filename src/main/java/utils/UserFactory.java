package utils;

import dto.UserLombok;
import net.datafaker.Faker;

public class UserFactory {
    static Faker faker = new Faker();

    //    public static void main(String[] args) {
//        String firstName = faker.name().firstName();
//        System.out.println(firstName);
//        String lastName = faker.name().lastName();
//        System.out.println(lastName);
//        String email = faker.internet().emailAddress();
//        System.out.println(email);
//    }
    public static UserLombok positiveUser() {
        UserLombok user = UserLombok.builder()
                .username(faker.internet().emailAddress())
                .password(PropertiesReader.getProperty("base.properties", "password_for_registration"))
                .build();
        return user;
    }

    public static UserLombok positiveLoginUser() {
        UserLombok user = UserLombok.builder()
                .username(PropertiesReader.getProperty("base.properties", "email_for_login"))
                .password(PropertiesReader.getProperty("base.properties", "password_for_login"))
                .build();
        return user;
    }

}
