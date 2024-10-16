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

/**
 * El adaptador {@code ContactAdapter} es una clase que gestiona la visualización de una lista de contactos
 * dentro de un {@link RecyclerView}. Cada contacto es representado por una vista de elemento de lista que muestra
 * su nombre completo y número de teléfono.
 *
 * Este adaptador también maneja los eventos de selección de contactos a través de la interfaz {@link IContactoListener}.
 */
public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactRecycleView> {

    private final List<Contact> contacts;
    private final IContactoListener listener;

    /**
     * Constructor del adaptador que recibe una lista de contactos y un listener para manejar la interacción con ellos.
     *
     * @param contacts La lista de contactos que se mostrará en el RecyclerView.
     * @param listener El listener que responderá a los eventos de selección de un contacto.
     */
    public ContactAdapter(List<Contact> contacts, IContactoListener listener) {
        this.contacts = contacts;
        this.listener = listener;
    }

    /**
     * Crea una nueva vista de elemento de contacto cuando no hay suficientes vistas reutilizables disponibles.
     *
     * @param parent El ViewGroup al que la nueva vista se añadirá después de ser enlazada.
     * @param viewType El tipo de la nueva vista (no se utiliza en este caso específico).
     * @return Un nuevo ViewHolder que contiene la vista de contacto inflada.
     */
    @NonNull
    @Override
    public ContactRecycleView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem_contact, parent, false);
        return new ContactRecycleView(view);
    }

    /**
     * Enlaza la información de un contacto a un ViewHolder existente para ser visualizada en la lista.
     *
     * @param holder El ViewHolder que contendrá los datos del contacto.
     * @param position La posición del contacto en la lista de contactos.
     */
    @Override
    public void onBindViewHolder(@NonNull ContactRecycleView holder, int position) {
        holder.bind(contacts.get(position), listener);
    }

    /**
     * Devuelve el número total de contactos en la lista.
     *
     * @return El tamaño de la lista de contactos.
     */
    @Override
    public int getItemCount() {
        return contacts.size();
    }

    /**
     * La clase {@code ContactRecycleView} es un ViewHolder que contiene las vistas para mostrar la información
     * de un contacto individual en el RecyclerView.
     */
    public static class ContactRecycleView extends RecyclerView.ViewHolder {

        public TextView tvFullName, tvPhone;

        /**
         * Constructor del ViewHolder. Inicializa las vistas para mostrar el nombre completo y el teléfono del contacto.
         *
         * @param itemView La vista individual del contacto.
         */
        public ContactRecycleView(@NonNull View itemView) {
            super(itemView);
            tvFullName = itemView.findViewById(R.id.tvFullName);
            tvPhone = itemView.findViewById(R.id.tvPhone);
        }

        /**
         * Vincula los datos de un contacto a las vistas del ViewHolder, y configura el listener para manejar
         * los clics en el contacto.
         *
         * @param contact El contacto cuyos datos se van a mostrar.
         * @param listener El listener que manejará los clics en el contacto.
         */
        public void bind(final Contact contact, final IContactoListener listener) {
            // Construye el nombre completo del contacto y lo muestra en la TextView
            String fullName = contact.getName() + " " + contact.getFirstSurname() + " " + contact.getSecondSurname();
            tvFullName.setText(fullName);

            // Muestra el primer número de teléfono del contacto
            tvPhone.setText(contact.getPhone1());

            // Configura el listener para manejar el clic en el contacto
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onContactoSeleccionado(contact);
                }
            });
        }
    }
}