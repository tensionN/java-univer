package lab2;


import lab1.Warehouse;
import lab1.WarehouseBuilderImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        Warehouse war1 = new WarehouseBuilderImpl()
                .setAddress("Bukovinska_3")
                .setCity("Chernivtsi")
                .setCountry("Ukraine")
                .build();

        Warehouse war2 = new Warehouse();

        //--------------TXT--------------------------------
        System.out.println("TXT");
        Serializer<Warehouse>ser = new TxtSerialize();
        String fileName = "D:\\java-univer\\labs\\Warehouse.txt";
        ser.writeObject(fileName, war1);
        war2 = ser.readObject(fileName);
        System.out.println(war2);
        //--------------JSON--------------------------------
        System.out.println("JSON");
        ser = new JsonSerialize();
        fileName = "D:\\java-univer\\labs\\Warehouse.json";
        ser.writeObject(fileName, war1);
        war2 = new Warehouse();
        war2 = ser.readObject(fileName);
        System.out.println(war2);
        //--------------XML--------------------------------
        System.out.println("XML");
        ser = new XmlSerialize();
        fileName = "D:\\java-univer\\labs\\Warehouse.xml";
        ser.writeObject(fileName, war1);
        war2 = new Warehouse();
        war2 = ser.readObject(fileName);
        System.out.println(war2);
    }
}