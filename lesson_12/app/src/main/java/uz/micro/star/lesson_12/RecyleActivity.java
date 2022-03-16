package uz.micro.star.lesson_12;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;

import uz.micro.star.lesson_12.adapters.ContactRecycleAdapter;
import uz.micro.star.lesson_12.models.ContactData;

public class RecyleActivity extends AppCompatActivity {
    private ArrayList<ContactData> data;
    private ContactRecycleAdapter adapter;
    private RecyclerView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyle);
        listView = findViewById(R.id.list);
        addData();
        adapter=new ContactRecycleAdapter(data);
//        listView.setLayoutManager(new LinearLayoutManager(this));
//        listView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.HORIZONTAL,true));
//        listView.setLayoutManager(new StaggeredGridLayoutManager(2,LinearLayoutManager.HORIZONTAL));
        listView.setLayoutManager(new GridLayoutManager(this,3));
        listView.setAdapter(adapter);
        adapter.setOnItemClickListener(new ContactRecycleAdapter.OnItemClickListener() {
            @Override
            public void onClick(String name) {
                Toast.makeText(RecyleActivity.this, name, Toast.LENGTH_SHORT).show();
            }
        });
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