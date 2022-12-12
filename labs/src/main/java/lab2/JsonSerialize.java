package lab2;

import com.fasterxml.jackson.databind.ObjectMapper;
import lab1.Warehouse;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

public class JsonSerialize implements Serializer<Warehouse> {
    private ObjectMapper objectMapper;

    public JsonSerialize() {
        objectMapper = new ObjectMapper();
    }

    @Override
    public void writeObject(String fileName, Warehouse object) throws IOException {
        try {
            objectMapper.writeValue(new File(fileName), object);
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public Warehouse readObject(String fileName) throws IOException {
        try{
            var res = objectMapper.readValue(Paths.get(fileName).toFile(), Warehouse.class);
            return res;
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
