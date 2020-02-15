package org.openjfx;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.swing.text.TableView;
import java.util.ArrayList;
import java.util.List;

public class Register {

    // oppretter et array av personer.
    public ObservableList<Person> personRegister = FXCollections.observableArrayList();

    // metode som legger til personer i arrayet.
    public void registrerPerson(Person enPerson){
        personRegister.add(enPerson);
    }
}
