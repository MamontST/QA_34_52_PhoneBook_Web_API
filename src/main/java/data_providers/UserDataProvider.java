package data_providers;

import dto.UserLombok;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UserDataProvider {
    @DataProvider
    public Iterator<UserLombok> dataProviderWrongPasswordOrEmail() {
        List<UserLombok> userList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(
                new FileReader("src/test/resources/wrong_email_password.csv"))) {
            String line = br.readLine();
            while (line != null) {
                String[] splitLine = line.split(",");
                userList.add(UserLombok.builder()
                        .username(splitLine[0])
                        .password(splitLine[1])
                        .build());
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return userList.listIterator();
    }
}
