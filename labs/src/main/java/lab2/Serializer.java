package lab2;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface Serializer<T> {
    void writeObject(String fileName, T object) throws IOException;

    T readObject(String fileName) throws IOException;
}
