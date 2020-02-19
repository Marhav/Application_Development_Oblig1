package org.openjfx;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ReadPersonJobj implements ReadPerson{

    @Override
    public List<Person> load(Path path) throws IOException {
        try (InputStream in = Files.newInputStream(path);
             ObjectInputStream oin = new ObjectInputStream(in)) {

            List<Person> list = (List<Person>) oin.readObject(); // kan kastes til Person
            System.out.println(list);
            return list;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
