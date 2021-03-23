package com.imooc.activitylifecycle;

import android.app.Activity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;


public class DialogActivity extends Activity {


    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_dialog);

        WindowManager m = getWindowManager();
        Display d = m.getDefaultDisplay(); // 为获取屏幕宽、高
        WindowManager.LayoutParams p = getWindow().getAttributes();
        p.height = (int) (d.getHeight() * 0.6); // 高度设置为屏幕的0.3
        p.width = (int) (d.getWidth() * 0.7); // 宽度设置为屏幕的0.7
        getWindow().setAttributes(p);

        Button btn=(Button)findViewById(R.id.btnFinish);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogActivity.this.finish();
            }
        });

    }

}
