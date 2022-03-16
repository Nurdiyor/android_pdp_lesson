package uz.micro.star.lesson_12.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.imageview.ShapeableImageView;

import java.util.ArrayList;

import uz.micro.star.lesson_12.R;
import uz.micro.star.lesson_12.models.ContactData;

public class ContactRecycleAdapter extends RecyclerView.Adapter<ContactRecycleAdapter.ContactViewHolder> {
    private final ArrayList<ContactData> data;
    private OnItemClickListener onItemClickListener;

    public ContactRecycleAdapter(ArrayList<ContactData> data) {
        this.data = data;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ContactViewHolder view = new ContactViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contact, parent, false));
        return view;
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
//        holder.number.setText(data.get(position).getName());
        holder.bind(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

   public interface OnItemClickListener {
        void onClick(String name);
    }

    class ContactViewHolder extends RecyclerView.ViewHolder {
        private final ShapeableImageView image;
        private final AppCompatTextView name;
        private final AppCompatTextView number;

        public ContactViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            name = itemView.findViewById(R.id.name);
            number = itemView.findViewById(R.id.number);
        }

        void bind(ContactData contactData) {
            image.setImageResource(contactData.getImage());
            name.setText(contactData.getName());
            number.setText(contactData.getNumber());
            itemView.setOnClickListener(view -> {
                onItemClickListener.onClick(contactData.getName());
            });
        }
    }
}
