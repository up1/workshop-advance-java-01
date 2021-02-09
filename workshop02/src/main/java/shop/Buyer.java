package shop;

import java.util.ArrayList;
import java.util.List;

public class Buyer {
    private String firstName;
    private String lastName;

    public void requestToBuy() {
        // 1. Create basket
        Basket basket = new Basket();
        // 2. Add book to basket
        Book book1 = new Book("Potter 1", 8);
        Book book2 = new Book("Potter 2", 8);
        Book book3 = new BookBuilder().chooseBook("Potter 3").build();
        basket.addBook(book1);
        basket.addBook(book2);
        basket.addBook(book3);
        // 3. Checkout
        // TODO :: checkout process
        Checkout checkout = new Checkout();
        checkout.process(basket);

        // Check netPrice = 24, discountPrice 24 - 10%
    }
}

class Checkout {
    public void process(Basket basket) {
        int netPrice = PriceCalculator.get(basket);
        int maxDiscount = DiscountCalculator.get(basket, netPrice);
        int totalPrice = netPrice - maxDiscount;

        basket.setNetPrice(netPrice);
        basket.setDiscountPrice(maxDiscount);

        // TODO
    }
}

class PriceCalculator {

    public static int get(Basket basket) {
        // Logic
        int price = 0;
        for (Item item : basket.getBooks()) {
            price += item.getPrice();
        }
        return price;
    }
}

class DiscountCalculator {

    public static int get(Basket basket, int netPrice) {
        // Logic
        double discount = 0;
        List<Item> items = basket.getBooks();
        if(items.size() == 2) {
            discount = (double)netPrice - ( (double)netPrice * 5 / 100 );
        }
        if(items.size() == 3) {
            discount = (double)netPrice - ( (double)netPrice * 10 / 100 );
        }
        return (int)(discount * 100);
    }
}
// POJO :: Plain Old Java Object
class Item {
    private Book book;
    private int qty;

    public Item() {
    }

    public Item(Book book, int qty) {
        this.book = book;
        this.qty = qty;
    }

    public boolean isSame(String name) {
        return name.equals(book.getName());
    }

    public void increaseQty() {
        qty++;
    }

    public int getPrice() {
        return book.getPrice() * getQty();
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}

class Basket {
    private List<Item> books = new ArrayList<>();
    private int netPrice;
    private int discountPrice;

    public void addBook(Book book) {
        // TODO : BigO(n)
        boolean isExisted = false;
        for (Item item : books) {
            // Existing
            if(item.isSame(book.getName())) {
                item.increaseQty();
                isExisted = true;
                break;
            }
        }
        if(!isExisted) {
            Item newItem = new Item(book, 1);
            books.add(newItem);
        }
    }

    public List<Item> getBooks() {
        return books;
    }

    public int getNetPrice() {
        return netPrice * 100;
    }

    public void setNetPrice(int netPrice) {
        this.netPrice = netPrice;
    }

    public int getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(int discountPrice) {
        this.discountPrice = discountPrice;
    }
}

class BookBuilder {
    private Book book;

    public BookBuilder() {
        book = new Book();
    }

    public BookBuilder chooseBook(String name) {
        book.setName(name);
        book.setPrice(8);
        return this;
    }

    public Book build() {
        return book;
    }
}

class Book {
    private String name;
    private int price;

    public Book() {
    }

    public Book(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
