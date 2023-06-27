package haodtph27524.fpoly.lab1.bai3;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import java.io.BufferedReader;

import haodtph27524.fpoly.lab1.R;

public class bai3 extends AppCompatActivity implements View.OnClickListener, Listener {
    private TextView tvMessage;
    private Button btnLoad;
    private ImageView imgLoad;

    public static final String IMAGE_URL = "https://thumbs.dreamstime.com/b/bot-do-android-23439860.jpg";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai3);
        tvMessage = findViewById(R.id.tvMessage);
        btnLoad = findViewById(R.id.btn_load);
        imgLoad = findViewById(R.id.imgLoad);
        btnLoad.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_load:
                new  LoadImageTask(this,this).execute(IMAGE_URL);
                break;
        }
    }

    @Override
    public void onImageLoaded(Bitmap bitmap) {
        imgLoad.setImageBitmap(bitmap);
        tvMessage.setText("Image Downloaded");
    }

    @Override
    public void onError() {
        tvMessage.setText("Error dowload image");
    }
}