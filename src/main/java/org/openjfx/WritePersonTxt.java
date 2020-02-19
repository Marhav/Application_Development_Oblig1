package org.openjfx;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class WritePersonTxt implements WritePerson{

    @Override
    public void writeFile(List<Person> objects, Path path) throws IOException {
        String formattedObjects = PersonFormater.formatPeople(objects);
        Files.write(path, formattedObjects.getBytes());
    }
}
