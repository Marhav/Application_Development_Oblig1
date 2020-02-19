package org.openjfx;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class WritePersonJobj implements WritePerson{

    @Override
    public void writeFile(List<Person> objects, Path path) throws IOException {
        try (OutputStream os = Files.newOutputStream(path);
             ObjectOutputStream out = new ObjectOutputStream(os))
        {
            out.writeObject(objects);
        }
    }
}
