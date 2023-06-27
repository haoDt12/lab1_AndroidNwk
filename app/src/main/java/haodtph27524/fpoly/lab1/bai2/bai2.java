package haodtph27524.fpoly.lab1.bai2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import haodtph27524.fpoly.lab1.R;

public class bai2 extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai2);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(bai2.this, bai2_1.class));
                finish();
            }
        },SPLASH_TIME_OUT);

    }
}