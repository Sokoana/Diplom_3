package elements;

import org.apache.commons.lang3.RandomStringUtils;

public class Users {
    private String email;
    private String password;
    private String name;

    public Users(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
    }

    public String getEmail() {
        return email;
    }



    public String getPassword() {
        return password;
    }



    public String getName() {
        return name;
    }



    public static Users randomDataUser() {
        final String email = RandomStringUtils.randomAlphabetic(8) + "@yandex.ru".toLowerCase();
        final String password = RandomStringUtils.randomAlphabetic(10).toLowerCase();
        final String name = RandomStringUtils.randomAlphabetic(11);
        return new Users(email, password, name);
    }
}
