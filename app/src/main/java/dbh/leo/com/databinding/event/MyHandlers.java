package dbh.leo.com.databinding.event;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;

/**
 * binding events
 * Created by lulei on 2016/4/27.
 */
public class MyHandlers {
    private static final String TAG = "MyHandlers";

    public void onClickListener(View view) {
        String str = (String) view.getTag();
        if (!TextUtils.isEmpty(str)) {
            Log.d(TAG, str);
        }
    }
}
