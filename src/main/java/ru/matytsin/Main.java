package ru.matytsin;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {

        try (Reader reader = new FileReader("src/main/resources/foreign_names.csv");
            CSVReader csvReader = new CSVReader(reader, ';') ) {

            SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);


            String[] buffer = new String[5];
            csvReader.readNext();

            Date d = formatter.parse("23.01.2023");

            List<User> users = new LinkedList<>();

            while ((buffer = csvReader.readNext()) != null) {
                //buffer = csvReader.readNext();
                String id =buffer[0];
                String name = buffer[1];
                String gender = buffer[2];
                Date date = formatter.parse(buffer[3]);
                char div = buffer[4].charAt(0);
                Integer salary = Integer.parseInt(buffer[5]);

                User user = new User(id, name, gender, date, div, salary);
                users.add(user);
            }

            users.stream().forEach(System.out::println);
        }
    }
}
