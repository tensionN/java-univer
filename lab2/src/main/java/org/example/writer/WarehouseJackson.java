package org.example.writer;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import University.Department;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.awt.List;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DepartmentJackson implements Serializer<Department>{

    @Override
    public void serialize(Department dep, String name) throws IOException {
        // TODO Auto-generated method stub
        File file= new File(name);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        StringWriter stringDep = new StringWriter();

        objectMapper.writeValue(stringDep, dep);

        FileWriter fw = new FileWriter(file);
        fw.write(stringDep.toString());
        fw.close();
    }

    @Override
    public void serializeCollection(Collection<Department> objects, String name) throws IOException {
        // TODO Auto-generated method stub
        File file= new File(name);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        StringWriter stringDep = new StringWriter();

        objectMapper.writeValue(stringDep, objects);
        FileWriter fw = new FileWriter(file);
        fw.write(stringDep.toString());
        fw.close();
    }

    @Override
    public Department deserialize(String name) throws IOException {
        File file= new File(name);
        byte[] mapData = Files.readAllBytes(Paths.get(file.toString()));

        ObjectMapper objectMapper = new ObjectMapper();
        Department department = objectMapper.readValue(mapData, Department.class);
        // System.out.println(department.toString());
        return department;
    }

    @Override
    public Collection<Department> deserializeCollection(String name) throws IOException {
        File file= new File(name);
        ObjectMapper mapper = new ObjectMapper();//.registerModule(new Module());
        return mapper.readValue(file,mapper.getTypeFactory().constructCollectionType(Set.class, Department.class));

    }



}