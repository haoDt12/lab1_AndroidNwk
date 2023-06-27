package haodtph27524.fpoly.lab1.bai2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import haodtph27524.fpoly.lab1.R;

public class bai2_1 extends AppCompatActivity implements View.OnClickListener {
    private Button btnLoad;
    private ImageView imgLoad;
    private ProgressDialog progressDialog;
    private String url = "https://thumbs.dreamstime.com/b/bot-do-android-23439860.jpg";
    private Bitmap bitmap = null;
    private TextView tvMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai21);

        imgLoad = findViewById(R.id.imgLoad);
        btnLoad = findViewById(R.id.btn_load);
        tvMessage = findViewById(R.id.tvMessage);
        btnLoad.setOnClickListener(this);
    }

    private Handler messageHandler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            Bundle bundle = msg.getData();
            String message = bundle.getString("message");
            tvMessage.setText(message);
            imgLoad.setImageBitmap(bitmap);
            progressDialog.dismiss();
        }
    };

    @Override
    public void onClick(View view) {
        progressDialog = ProgressDialog.show(bai2_1.this,"","Downloading ... ");
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                bitmap = dowloadBitmap(url);
                Message msg = messageHandler.obtainMessage();
                Bundle bundle = new Bundle();
                String threadMessage = "Image downloading";
                bundle.putString("message",threadMessage);
                msg.setData(bundle);
                messageHandler.sendMessage(msg);
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }

    private Bitmap dowloadBitmap(String link){
        try {
            URL url = new URL(link);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.connect();
            InputStream inputStream = connection.getInputStream();
            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
            return bitmap;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}