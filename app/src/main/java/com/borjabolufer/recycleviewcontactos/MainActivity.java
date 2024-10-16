package com.borjabolufer.recycleviewcontactos;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.borjabolufer.recycleviewcontactos.models.Contact;

import java.util.List;

public class MainActivity extends AppCompatActivity implements IContactoListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        List<Contact> contacts = ContactParser.parse(this);

        ContactAdapter adapter = new ContactAdapter(contacts,this);

        recyclerView.setAdapter(adapter);
        Log.d(getClass().getSimpleName(), contacts.toString());
    }

    @Override
    public void onContactoSeleccionado(Contact contact) {
        Toast.makeText(this, contact.getEmail() , Toast.LENGTH_SHORT).show();
    }
}