public class User {
    int id;
    String name;
    int age;
}

class Customer extends User {

}

class Biz {

    public void doProcess() {
        Customer customer = new Customer();
    }

}
