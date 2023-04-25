import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PhoneBook phoneBook = new PhoneBook();
    public static Contact contact = null;

    public static void main(String[] args) throws IOException {

        while (true) {
            System.out.println("""
                    1. Создать новую группу:\s
                    2. Создать новый контакт:\s
                    3. Вывести список контактов\s
                    4. Поиск контакта
                    0. Завершить программу""");
             String input = bufferedReader.readLine();
            if (input.equals("0")) {
                break;
            }
            switch (input) {
                case "1":
                    while (true) {
                        System.out.println("Введите название группы или введите 0 чтобы вернуться назад :");
                        String groupName = bufferedReader.readLine();
                        if (groupName.equals("0")) {
                            break;
                        } else {
                            phoneBook.addGroup(groupName);
                        }
                    }
                    break;
                case "2":
                    create();
                    break;
                case "3":
                    phoneBook.printPhoneBook();

                    break;
                case "4":
                    System.out.println("Введите номер телефона контакта :");
                    String search = bufferedReader.readLine();
                    System.out.println(phoneBook.searchPhoneNumber(search));
                    break;

            }
        }

    }

    public static void create() throws IOException {
        while (true) {
            System.out.println("Введите имя контакта(Не менее 2 символов) или введите 0 чтобы вернуться назад :");
            String name = bufferedReader.readLine();
            if (name.equals("0")) {
                break;
            }
            System.out.println("Введите номер телефона(Не менее 5 цифр) :");
            String number = bufferedReader.readLine();
            if (number.equals("0")) {
                break;
            }
            if (name.length() < 1 || number.length() < 5) {
                System.out.println("Слишком короткое имя или номер телефона");
                break;
            }
                contact = new Contact(name, number);

            System.out.println("В какую группу добавить?");
            String[] groupName = bufferedReader.readLine().split(" ");
            System.out.println(Arrays.toString(groupName));
            phoneBook.addContactInGroup(groupName, contact);
        }
    }

}