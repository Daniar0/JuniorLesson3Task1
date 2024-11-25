import java.io.*;

public class SerializationDemo {
    public static void serializePerson(Person person, String fileName) {
        try
            (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))){
           out.writeObject(person);
            System.out.println("Обьект успешно сериализован в файл " + fileName);

        }catch(Exception e) {
            e.printStackTrace();
        }
    }
    public static Person deserializePerson(String fileName) {
        try
                (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
            return (Person)
                    in.readObject();
        }catch(Exception e) {
            e.printStackTrace();
        }
        return null;

    }
    public static void main(String[] args) {
        Person person=new Person("Aidar",24);
        String fileName="person.ser";
        serializePerson(person,fileName);
        Person deserializePerson=deserializePerson(fileName);
        System.out.println("Десерилизованный обьект "+deserializePerson);

    }
}
