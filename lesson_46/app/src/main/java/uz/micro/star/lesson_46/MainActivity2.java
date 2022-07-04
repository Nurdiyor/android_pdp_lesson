package uz.micro.star.lesson_46;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class MainActivity2 extends AppCompatActivity {
    private final int REQUEST_CODE = 156;
    private TextView textView;
    private final BroadcastReceiver receiver = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {
            Bundle bundle = intent.getExtras();
            if (bundle != null) {
                int resultCode = bundle.getInt(DownloadService.RESULT);
                if (resultCode == 0) {
                    int progress = bundle.getInt(DownloadService.PROGRESS);
                    Log.d("OOOO", "progress: " + progress);
                } else if (resultCode == 1) {
                    String path = bundle.getString(DownloadService.FILEPATH);
                    Toast.makeText(MainActivity2.this,
                            "Download complete. Download URI: " + path,
                            Toast.LENGTH_LONG).show();
                    textView.setText("Download done");
                    Intent mIntent = new Intent(MainActivity2.this, MusicService.class);
                    Log.d("OOOO", "onReceive: " + path);
                    mIntent.putExtra("MUSIC_PATH", path);
                    startService(mIntent);
                } else {
                    Toast.makeText(MainActivity2.this, "Download failed",
                            Toast.LENGTH_LONG).show();
                    textView.setText("Download failed");
                }
            }
        }
    };


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textView = findViewById(R.id.status);
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE}, REQUEST_CODE);
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(receiver, new IntentFilter(
                DownloadService.NOTIFICATION));
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(receiver);
    }

    public void onClick(View view) {

        Intent intent = new Intent(this, DownloadService.class);
        // add infos for the service which file to download and where to store
        intent.putExtra(DownloadService.FILENAME, "music");
        intent.putExtra(DownloadService.URL,
                "https://ds2.cdn2.mzmdl.com/music/20170830/Daddy_Yankee_Luis_Fonsi_-_Despacito_47828386.mp3");
        startService(intent);
        textView.setText("Service started");
    }
}