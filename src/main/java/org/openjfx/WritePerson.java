package org.openjfx;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public interface WritePerson {

    public abstract void writeFile(List<Person> objects, Path path) throws IOException;
}
