package haodtph27524.fpoly.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import haodtph27524.fpoly.lab1.bai2.bai2;
import haodtph27524.fpoly.lab1.bai3.bai3;
import haodtph27524.fpoly.lab1.bai4.bai4;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button bai1,bai2,bai3,bai4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bai1 = findViewById(R.id.bai1);
        bai2 = findViewById(R.id.bai2);
        bai3 = findViewById(R.id.bai3);
        bai4 = findViewById(R.id.bai4);

        bai1.setOnClickListener(this);
        bai2.setOnClickListener(this);
        bai3.setOnClickListener(this);
        bai4.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bai1:
                startActivity(new Intent(MainActivity.this, bai1.class));
                break;
            case R.id.bai2:
                startActivity(new Intent(MainActivity.this, haodtph27524.fpoly.lab1.bai2.bai2.class));
                break;
            case R.id.bai3:
                startActivity(new Intent(MainActivity.this, haodtph27524.fpoly.lab1.bai3.bai3.class));
                break;
            case R.id.bai4:
                startActivity(new Intent(MainActivity.this, haodtph27524.fpoly.lab1.bai4.bai4.class));
                break;
        }
    }
}