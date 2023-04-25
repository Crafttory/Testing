public class Contact {
    protected String name;
    protected String phoneNumber;


    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return "Имя: " + name + "-" + "Номер телефона: " + phoneNumber;
    }
}