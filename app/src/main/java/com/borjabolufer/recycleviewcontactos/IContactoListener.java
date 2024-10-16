package com.borjabolufer.recycleviewcontactos;

import android.location.GnssAntennaInfo;

import com.borjabolufer.recycleviewcontactos.models.Contact;

public interface IContactoListener{
    public void onContactoSeleccionado(Contact contact);
}
