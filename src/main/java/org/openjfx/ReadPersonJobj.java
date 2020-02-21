package org.openjfx;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ReadPersonJobj implements ReadPerson{

    @Override
    public List<Person> load(Path path) throws IOException {
        ObservableList<Person> list = FXCollections.observableArrayList();

        try (InputStream in = Files.newInputStream(path);
             ObjectInputStream oin = new ObjectInputStream(in)) {

            List<Person> inList = (List<Person>) oin.readObject();
            System.out.println(inList);
            list.addAll(inList);
            return list;
        } catch (ClassNotFoundException e) {
            System.err.println("ReadPersonJobj ClassNotFound ERROR");
            e.printStackTrace();
            return null;
        }
    }
}
