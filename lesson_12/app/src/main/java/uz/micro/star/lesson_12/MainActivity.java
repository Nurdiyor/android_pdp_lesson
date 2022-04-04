package uz.micro.star.lesson_12;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import uz.micro.star.lesson_12.adapters.ContactAdapter;
import uz.micro.star.lesson_12.models.ContactData;

public class MainActivity extends AppCompatActivity {
    private ArrayList<ContactData> data;
    private ContactAdapter adapter;
    private Spinner listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addData();
        listView = findViewById(R.id.listView);
        adapter = new ContactAdapter(data);
        listView.setAdapter(adapter);
        listView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(MainActivity.this, data.get(position).getName(), Toast.LENGTH_SHORT).show();
                Log.d("PPPP", "onItemSelected: "+data.get(position).getName());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
//        listView.setDividerHeight(16);
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(MainActivity.this, data.get(i).getName(), Toast.LENGTH_SHORT).show();
//            }
//        });
    }

    private void addData() {
        data = new ArrayList<>();
        data.add(new ContactData("Azizbek", "+897654", R.drawable.image));
        data.add(new ContactData("Bobur", "+897654", R.drawable.image));
        data.add(new ContactData("Komiljon", "+897654", R.drawable.image));
        data.add(new ContactData("Samandar", "+897654", R.drawable.image));
        data.add(new ContactData("Mustafo", "+897654", R.drawable.image));
        data.add(new ContactData("Sardor", "+897654", R.drawable.image));
        data.add(new ContactData("Nurdiyor", "+897654", R.drawable.image));
        data.add(new ContactData("Azizbek", "+897654", R.drawable.image));
        data.add(new ContactData("Bobur", "+897654", R.drawable.image));
        data.add(new ContactData("Komiljon", "+897654", R.drawable.image));
        data.add(new ContactData("Samandar", "+897654", R.drawable.image));
        data.add(new ContactData("Mustafo", "+897654", R.drawable.image));
        data.add(new ContactData("Sardor", "+897654", R.drawable.image));
        data.add(new ContactData("Nurdiyor", "+897654", R.drawable.image));
        data.add(new ContactData("Azizbek", "+897654", R.drawable.image));
        data.add(new ContactData("Bobur", "+897654", R.drawable.image));
        data.add(new ContactData("Komiljon", "+897654", R.drawable.image));
        data.add(new ContactData("Samandar", "+897654", R.drawable.image));
        data.add(new ContactData("Mustafo", "+897654", R.drawable.image));
        data.add(new ContactData("Sardor", "+897654", R.drawable.image));
        data.add(new ContactData("Nurdiyor", "+897654", R.drawable.image));
    }
}