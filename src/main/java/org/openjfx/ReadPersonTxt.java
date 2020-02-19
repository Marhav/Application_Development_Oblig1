package org.openjfx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ReadPersonTxt implements ReadPerson{


    public List<Person> load(Path path) throws IOException {

        ObservableList<Person> list = FXCollections.observableArrayList();

        try(BufferedReader reader = Files.newBufferedReader(Paths.get(String.valueOf(path)))){
            String line;

            while((line=reader.readLine()) != null){
                list.add(ParsePerson.parsePerson(line));
            }
        }
        return list;
    }
}
