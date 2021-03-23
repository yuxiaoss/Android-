package com.imooc.activitylifecycle;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    private static final String TAG = "SecondActivity";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_second);

        Log.d(TAG, "onCreate: ");

        final Button button = (Button) findViewById(R.id.buttonFinish);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("imooc", "imooc+慕课网");
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        if (getIntent() != null) {
            // String buttonTitle = getIntent().getStringExtra(MainActivity.BUTTON_TITLE);
            Bundle bundle = getIntent().getBundleExtra(MainActivity.BUTTON_TITLE);
            if (bundle != null) {
                String buttonTitle = bundle.getString(MainActivity.BUTTON_TITLE);
                button.setText(buttonTitle);
            }
            /*第三种
            User user=(User) (getIntent().getSerializableExtra(MainActivity.BUTTON_TITLE));
            button.setText(user.title);*/
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart: ");
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Log.d(TAG, "onBackPressed: ");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstanceState: ");
    }

}
