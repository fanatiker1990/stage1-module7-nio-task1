package com.epam.mjc.nio;
import java.io.*;
public class FileReader {

    public Profile getDataFromFile(File file) {
        String name = null;
        String email = null;
        Integer age = null;
        Long phone = null;
        String line;
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
            while (bufferedReader.ready()) {
                line = bufferedReader.readLine();
                if (line.contains("Name")) {
                    String[] strings = line.split(" ");
                    name = strings[1];
                } else if (line.contains("Age")) {
                    String[] strings = line.split(" ");
                    age = Integer.parseInt(strings[1]);
                } else if (line.contains("Email")) {
                    String[] strings = line.split(" ");
                    email = strings[1];
                } else if (line.contains("Phone")) {
                    String[] strings = line.split(" ");
                    phone = Long.parseLong(strings[1]);
                }
            }
        } catch (IOException e) {
            throw new FileNonExistException();
        }
        return new Profile(name, age, email, phone);
    }
}
