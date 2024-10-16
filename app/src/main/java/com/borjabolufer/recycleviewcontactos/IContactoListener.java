package com.borjabolufer.recycleviewcontactos;

import com.borjabolufer.recycleviewcontactos.models.Contact;

/**
 * La interfaz {@code IContactoListener} define un contrato para manejar eventos de selección de contactos.
 *
 * Esta interfaz debe ser implementada por cualquier clase que quiera recibir notificaciones cuando un
 * contacto haya sido seleccionado en la lista.
 */
public interface IContactoListener {

    /**
     * Método que se llama cuando un contacto ha sido seleccionado.
     *
     * @param contact El contacto que ha sido seleccionado.
     */
    public void onContactoSeleccionado(Contact contact);
}