package dbh.leo.com.databinding;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import dbh.leo.com.databinding.databinding.ActivityMainBinding;
import dbh.leo.com.databinding.entity.ObservableUser;
import dbh.leo.com.databinding.entity.User;

/**
 * 1.Binding Data
 * 2.Binding Events
 */
public class MainActivity extends AppCompatActivity {

    private User user;
    private ObservableUser observableUser;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);


        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
//        user = new User("Test", 28);
        observableUser = new ObservableUser("observableUser", 82);
        activityMainBinding.setObservableUser(observableUser);

        updateInfo();
    }

    /**
     * 更新用户信息
     */
    private void updateInfo() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                observableUser.setAge(828);
                observableUser.setName("DingShenYunChu");

            }
        }).start();
    }

    /**
     * 按钮点击事件
     *
     * @param view
     */
    public void btnUpdate(View view) {
//        String str = (String) view.getTag();
        String info = observableUser.getName() + "--->" + observableUser.getAge();
        if (!TextUtils.isEmpty(info)) {
            Toast.makeText(this, info, Toast.LENGTH_SHORT).show();
        }
    }

}
