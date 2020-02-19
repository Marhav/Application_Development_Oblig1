package org.openjfx;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public interface ReadPerson {

    public abstract List<Person> load(Path path) throws IOException;
}
