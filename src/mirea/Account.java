package mirea;

public class Account {
    private String INN;
    private String name;

    public Account(String INN, String name) {
        this.INN = INN;
        this.name = name;
    }

    public String get_INN() {
        return INN;
    }

    public String getName() {
        return name;
    }

    public void test_INN(String inn) throws Verification_INN {
        if (inn.length() != 10)
            throw new Verification_INN(this);
    }

    public static void main(String[] args) {
        Account client = new Account("1232324344556679870", "Берков  А.Н.");
        try {
            client.test_INN(client.get_INN());
            System.out.println("ИНН клиента " + client.getName() + " действителен.");
        } catch (Verification_INN e) {
            System.out.println(e.getMessage());
            ;
        }

        Account client1 = new Account("1234567890", "Урунов Т.З.");
        try {
            client1.test_INN(client1.get_INN());
            System.out.println("ИНН клиента " + client1.getName() + " действителен.");
        } catch (Verification_INN e) {
            System.out.println(e.getMessage());
            ;
        }

        Account client2 = new Account("5641", "Саидов Ф.А.");
        try {
            client2.test_INN(client2.get_INN());
            System.out.println("ИНН клиента " + client2.getName() + " действителен.");
        } catch (Verification_INN e) {
            System.out.println(e.getMessage());
        }
    }
}