package com.borjabolufer.recycleviewcontactos;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.borjabolufer.recycleviewcontactos.R;
import com.borjabolufer.recycleviewcontactos.models.Contact;

import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactRecycleView> {
    private final List<Contact> contacts;
    private final IContactoListener listener;

    public ContactAdapter(List<Contact> contacts, IContactoListener listener) {
        this.contacts = contacts;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ContactRecycleView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem_contact, parent, false);
        return new ContactRecycleView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactRecycleView holder, int position) {
        holder.bind(contacts.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public static class ContactRecycleView extends RecyclerView.ViewHolder {
        public TextView tvFullName, tvPhone;

        public ContactRecycleView(@NonNull View itemView) {
            super(itemView);
            tvFullName = itemView.findViewById(R.id.tvFullName);
            tvPhone = itemView.findViewById(R.id.tvPhone);
        }

        public void bind(final Contact contact, final IContactoListener listener) {
            String fullName = contact.getName() + " " + contact.getFirstSurname() + " " + contact.getSecondSurname();
            tvFullName.setText(fullName);
            tvPhone.setText(contact.getPhone1());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onContactoSeleccionado(contact);
                }
            });
        }
    }
}