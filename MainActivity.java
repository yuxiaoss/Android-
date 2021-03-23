package com.imooc.activitylifecycle;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public static final String BUTTON_TITLE = "button_title";
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        Log.d(TAG, "onCreate: ");


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
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 999 && resultCode == RESULT_OK) {
            //setTitle("前一个页面回来了");
            setTitle(data.getStringExtra("imooc"));
        }
    }

    private void initViews() {
        findViewById(R.id.buttonActivity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                //===============第一种=================================
                //intent.putExtra(BUTTON_TITLE,getString(R.string.imooc_title));
                //startActivity(intent);

                //==============第二种=================================
                Bundle bundle = new Bundle();
                bundle.putString(BUTTON_TITLE, getString(R.string.imooc_title));
                intent.putExtra(BUTTON_TITLE, bundle);
                startActivity(intent);
               // startActivityForResult(intent, 999);

                //==============第三种=================================
                //intent.putExtra(BUTTON_TITLE, new User());
                //startActivity(intent);
            }
        });

        findViewById(R.id.buttonDialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("你好")
                        .setMessage("我帅吗？")
                        .setNegativeButton("你好帅的", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .setPositiveButton("呵呵哒", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .create()
                        .show();
            }
        });

        findViewById(R.id.buttonDialogActivity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, DialogActivity.class));
            }
        });
    }
}
