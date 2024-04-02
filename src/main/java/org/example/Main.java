package org.example;

import com.google.gson.Gson;
import org.example.domain.Person;

public class Main {
    public static void main(String[] args) {

        Person p1 = new Person("Ivan", "Ivanov", 30);
        Person p2 = new Person("Ivan", "Ivanov", 30);
        Person p3 = new Person("vasiliy", "Vasilyev", 35);
        System.out.println(p1);
        System.out.println(p3);
        System.out.println(p1.equals(p2));
        System.out.println(p1.equals(p3));


        // Сериализуем в  JSON

        String result = serializeObjectToJSON(p1);

        // Десериализуем JSON в объект
        Person person = deSerializeObjectFromJSON(result);

        System.out.println(p1.equals(person));

    }

    private static Person deSerializeObjectFromJSON(String jsonStr) {
        Gson gson = new Gson();
        Person person =gson.fromJson(jsonStr, Person.class);
        System.out.println(person);
        return person;
    }

    private static String serializeObjectToJSON(Person person) {
        Gson gson = new Gson();
        String json = gson.toJson(person);
        System.out.println(json);

        return json;
    }
}