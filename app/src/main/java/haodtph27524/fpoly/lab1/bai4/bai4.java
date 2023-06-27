package haodtph27524.fpoly.lab1.bai4;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import haodtph27524.fpoly.lab1.R;

public class bai4 extends AppCompatActivity implements View.OnClickListener {
    private EditText edtTime;
    private Button btnRun;
    private TextView tvResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai4);
        edtTime = findViewById(R.id.edt_Time);
        btnRun = findViewById(R.id.btnRun);
        tvResult = findViewById(R.id.tvResult);
        btnRun.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnRun:
                AsyncTaskRunner asyncTaskRunner = new AsyncTaskRunner(this, tvResult, edtTime);
                String sleepTime = edtTime.getText().toString();
                asyncTaskRunner.execute(sleepTime);
                break;
        }
    }
}