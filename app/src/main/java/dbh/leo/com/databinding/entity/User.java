package dbh.leo.com.databinding.entity;

/**
 * Data Object
 * Created by lulei on 2016/4/26.
 */
public class User {

    private final String name;
    private final int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
