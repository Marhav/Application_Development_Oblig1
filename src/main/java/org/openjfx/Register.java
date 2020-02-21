package org.openjfx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

class Register implements Serializable {

    // oppretter et array av personer.
    transient ObservableList<Person> personRegister = FXCollections.observableArrayList();

    // metode som legger til personer i arrayet.
    void registrerPerson(Person enPerson){
        personRegister.add(enPerson);
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();
        s.writeObject(new ArrayList<>(personRegister));
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        List<Person> list = (List<Person>) s.readObject();
        personRegister = FXCollections.observableArrayList();
        personRegister.addAll(list);
    }
}
