package lab2;

import com.fasterxml.jackson.xml.XmlMapper;
import lab1.Warehouse;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;


public class XmlSerialize implements Serializer<Warehouse> {
    private XmlMapper mapper;
    public XmlSerialize() {
        mapper = new XmlMapper();
    }

    @Override
    public void writeObject(String fileName, Warehouse object) throws IOException {
        try{
            mapper.writeValue(new File(fileName), object);
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public Warehouse readObject(String fileName) throws IOException {
        try{
            var res = mapper.readValue(Paths.get(fileName).toFile(), Warehouse.class);
            return res;
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
