package lab2;

import lab1.Warehouse;

import java.io.*;
import java.util.List;

public class TxtSerialize implements Serializer<Warehouse> {
    @Override
    public void writeObject(String fileName, Warehouse object) throws IOException {
        try(FileWriter fos = new FileWriter(fileName)){
            fos.write(object.toString());
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public Warehouse readObject(String fileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        StringBuilder sb = new StringBuilder();
        String line = br.readLine();

        while (line != null) {
            sb.append(line);
            sb.append(System.lineSeparator());
            line = br.readLine();
        }
        String objectLine = sb.toString();
        return Warehouse.toObject(objectLine);
    }
}
