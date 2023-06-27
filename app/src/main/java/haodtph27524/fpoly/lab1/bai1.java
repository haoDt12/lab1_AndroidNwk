package haodtph27524.fpoly.lab1;

import static haodtph27524.fpoly.lab1.R.id.btn_load;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class bai1 extends AppCompatActivity implements View.OnClickListener {
    private Button btnLoad;
    private ImageView imgAndroid;
    private TextView tvMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai1);
        btnLoad = findViewById(btn_load);
        imgAndroid = findViewById(R.id.image);
        tvMessage = findViewById(R.id.tvMessage);
        btnLoad.setOnClickListener(this);
    }
    private Bitmap loadImageFromNetWork(String link) {
        URL url;
        Bitmap bmp = null;
        try {
            url = new URL(link);
            bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bmp;
    }
    @Override
    public void onClick(View v) {
        final Thread myThread = new Thread(new Runnable() {
            @Override
            public void run() {
                //
                final Bitmap bitmap = loadImageFromNetWork("https://thumbs.dreamstime.com/b/bot-do-android-23439860.jpg");
                imgAndroid.post(new Runnable() {
                    @Override
                    public void run() {
                        tvMessage.setText("Image Dowloaded");
                        imgAndroid.setImageBitmap(bitmap);
                    }
                });
            }
        });
        myThread.start();
    }
}