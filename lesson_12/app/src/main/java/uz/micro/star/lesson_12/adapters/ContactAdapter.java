package uz.micro.star.lesson_12.adapters;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import androidx.appcompat.widget.AppCompatTextView;

import com.google.android.material.imageview.ShapeableImageView;

import java.util.ArrayList;

import uz.micro.star.lesson_12.R;
import uz.micro.star.lesson_12.models.ContactData;

public class ContactAdapter extends BaseAdapter {
    private final ArrayList<ContactData> data;

    public ContactAdapter(ArrayList<ContactData> data) {
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public ContactData getItem(int index) {
        return data.get(index);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int index, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_contact, viewGroup, false);
        ShapeableImageView image = view.findViewById(R.id.image);
        AppCompatTextView name = view.findViewById(R.id.name);
        AppCompatTextView number = view.findViewById(R.id.number);
        ContactData contactData = getItem(index);
        view.findViewById(R.id.back).setBackgroundColor(Color.parseColor("#000000"));
        image.setImageResource(contactData.getImage());
        name.setText(contactData.getName());
        number.setText(contactData.getNumber());
        return view;
    }
}
