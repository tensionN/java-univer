package lab2;

import java.io.IOException;

public interface Serializer<T> {
    void writeObject(String fileName, T object) throws IOException;
    T readObject(String fileName) throws IOException;
}
