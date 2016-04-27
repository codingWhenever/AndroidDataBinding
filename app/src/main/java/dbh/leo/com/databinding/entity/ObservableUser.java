package dbh.leo.com.databinding.entity;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

/**
 * Data Object
 * Created by lulei on 2016/4/26.
 */
public class ObservableUser extends BaseObservable {
    public String name;
    public int age;


    public ObservableUser(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(dbh.leo.com.databinding.BR.name);
    }

    @Bindable
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
        notifyPropertyChanged(dbh.leo.com.databinding.BR.age);
    }
}
