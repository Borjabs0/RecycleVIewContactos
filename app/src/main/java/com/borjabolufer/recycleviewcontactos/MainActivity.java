package com.borjabolufer.recycleviewcontactos;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.borjabolufer.recycleviewcontactos.models.Contact;

import java.util.List;

/**
 * La clase {@code MainActivity} es la actividad principal de la aplicación que muestra una lista de contactos
 * en un {@link RecyclerView}. Implementa la interfaz {@link IContactoListener} para manejar la interacción
 * con los contactos seleccionados.
 */
public class MainActivity extends AppCompatActivity implements IContactoListener {

    /**
     * Método llamado cuando se crea la actividad. Configura el RecyclerView con un adaptador y un
     * layout manager para mostrar los contactos.
     *
     * @param savedInstanceState Si la actividad se ha reiniciado previamente, este parámetro contiene los datos más recientes guardados.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Configura el RecyclerView y el adaptador
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Obtiene la lista de contactos a través del ContactParser
        List<Contact> contacts = ContactParser.parse(this);

        // Configura el adaptador para el RecyclerView
        ContactAdapter adapter = new ContactAdapter(contacts, this);
        recyclerView.setAdapter(adapter);

        // Registra la lista de contactos en el log para depuración
        Log.d(getClass().getSimpleName(), contacts.toString());
    }

    /**
     * Método implementado de {@link IContactoListener}, llamado cuando un contacto ha sido seleccionado.
     * Muestra un mensaje Toast con el correo electrónico del contacto seleccionado.
     *
     * @param contact El contacto que ha sido seleccionado.
     */
    @Override
    public void onContactoSeleccionado(Contact contact) {
        // Muestra el correo electrónico del contacto en un Toast
        Toast.makeText(this, contact.getEmail(), Toast.LENGTH_SHORT).show();
    }
}