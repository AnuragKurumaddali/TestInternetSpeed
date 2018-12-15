package com.raj.internetspeed;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.List;

public class MainActivity extends Activity {

    TextView tv_Speed;
    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_Speed = findViewById(R.id.tv_Speed);
        handler = new Handler();
        handler.postDelayed(updateTimerThread,100);
    }

    private Runnable updateTimerThread = new Runnable()
    {
        public void run()
        {
            getData();
            //write here whaterver you want to repeat
            handler.postDelayed(this, 1000);
        }
    };

    public void getData() {
        List<Long> allData;

        allData = RetrieveData.findData();

        Long mDownload, mUpload;

        mDownload = allData.get(0);
        mUpload = allData.get(1);

        DecimalFormat f = new DecimalFormat("##.###");

        Log.e("aaa","Downloaded speed = "+f.format(mDownload/ 1048576.0));
        Log.e("aaa","uploaded speed = "+f.format(mUpload/ 1048576.0));
    }
}
