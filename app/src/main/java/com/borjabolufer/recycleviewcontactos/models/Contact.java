package com.borjabolufer.recycleviewcontactos.models;

/**
 * La clase {@code Contact} representa un contacto con información personal y de contacto.
 * Contiene el nombre, apellidos, teléfonos y correo electrónico de una persona.
 */
public class Contact {

    private final String name;
    private final String firstSurname;
    private final String secondSurname;
    private final String phone1;
    private final String phone2;
    private final String email;

    /**
     * Constructor que inicializa un objeto {@code Contact} con la información proporcionada.
     *
     * @param name El nombre del contacto.
     * @param firstSurname El primer apellido del contacto.
     * @param secondSurname El segundo apellido del contacto.
     * @param phone1 El primer número de teléfono del contacto.
     * @param phone2 El segundo número de teléfono del contacto.
     * @param email La dirección de correo electrónico del contacto.
     */
    public Contact(String name, String firstSurname, String secondSurname, String phone1, String phone2, String email) {
        this.name = name;
        this.firstSurname = firstSurname;
        this.secondSurname = secondSurname;
        this.phone1 = phone1;
        this.phone2 = phone2;
        this.email = email;
    }

    /**
     * Obtiene el nombre del contacto.
     *
     * @return El nombre del contacto.
     */
    public String getName() {
        return name;
    }

    /**
     * Obtiene el primer apellido del contacto.
     *
     * @return El primer apellido del contacto.
     */
    public String getFirstSurname() {
        return firstSurname;
    }

    /**
     * Obtiene el segundo apellido del contacto.
     *
     * @return El segundo apellido del contacto.
     */
    public String getSecondSurname() {
        return secondSurname;
    }

    /**
     * Obtiene el primer número de teléfono del contacto.
     *
     * @return El primer número de teléfono del contacto.
     */
    public String getPhone1() {
        return phone1;
    }

    /**
     * Obtiene el segundo número de teléfono del contacto.
     *
     * @return El segundo número de teléfono del contacto.
     */
    public String getPhone2() {
        return phone2;
    }

    /**
     * Obtiene la dirección de correo electrónico del contacto.
     *
     * @return El correo electrónico del contacto.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Devuelve una representación en cadena del contacto, que incluye su nombre, apellidos, teléfonos y correo electrónico.
     *
     * @return Una cadena que representa el objeto {@code Contact}.
     */
    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", firstSurname='" + firstSurname + '\'' +
                ", secondSurname='" + secondSurname + '\'' +
                ", phone1='" + phone1 + '\'' +
                ", phone2='" + phone2 + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}