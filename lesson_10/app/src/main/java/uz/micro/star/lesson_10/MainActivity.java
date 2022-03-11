package uz.micro.star.lesson_10;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    int a=0;
    TextView t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t= findViewById(R.id.textview);
        findViewById(R.id.btn).setOnClickListener(view -> {
//            t.setText((++a) + "");
            startActivity(new Intent(this,SecondActivity.class));
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.manin_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.settings: {
                Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.language: {
                Toast.makeText(this, "Language", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.something: {
                Toast.makeText(this, "something", Toast.LENGTH_SHORT).show();
                break;
            }
        }
        return true;
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("MY_KEY",a);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        a=savedInstanceState.getInt("MY_KEY",0);
        t.setText(a+"");
    }
}