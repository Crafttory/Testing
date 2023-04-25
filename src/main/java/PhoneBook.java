import org.jetbrains.annotations.NotNull;

import java.util.*;
public class PhoneBook {

    public Map<String, List<Contact>> phoneBook = new HashMap<>();

    public void addGroup(String name) {
        if (name != null && name.length() >= 1) {
            phoneBook.put(name, new ArrayList<>());
        }

    }

    public void addContactInGroup(String @NotNull [] groupName, Contact contact) {
        for (String s : groupName) {
            if (!phoneBook.containsKey(s)) {
                System.out.println("Такой группы не существует");
            } else {
                List<Contact> contacts = phoneBook.get(s);
                if(contact != null) {
                    contacts.add(contact);
                }
            }
        }
    }
    public void printPhoneBook() {
        System.out.println(phoneBook.toString());
    }


    public String search(String nameGroup) {
        if (phoneBook.containsKey(nameGroup)) {
            return phoneBook.get(nameGroup).toString();
        } else {
            return null;
        }
    }
    public Optional<Contact> searchPhoneNumber(String number) {
        return phoneBook.values()
                .stream()
                .flatMap(List::stream)
                .filter(s -> number.contains(s.getPhoneNumber()))
                .findFirst();
    }
    @Override
    public String toString() {
        return "Phonebook " + phoneBook.toString();
    }

}