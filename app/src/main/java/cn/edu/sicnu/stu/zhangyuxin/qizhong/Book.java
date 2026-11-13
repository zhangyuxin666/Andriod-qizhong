package cn.edu.sicnu.stu.zhangyuxin.qizhong;

import java.io.Serializable;
import java.util.Locale;

/**
 * 书籍实体类：封装书名、作者、出版社、价格等属性。
 */
public class Book implements Serializable {

    private static final long serialVersionUID = 1L;

    private final String title;
    private final String author;
    private final String publisher;
    private final double price;
    private final int year;
    private final String isbn;
    private final String intro;

    public Book(String title, String author, String publisher, double price,
                int year, String isbn, String intro) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.price = price;
        this.year = year;
        this.isbn = isbn;
        this.intro = intro;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public double getPrice() {
        return price;
    }

    public int getYear() {
        return year;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getIntro() {
        return intro;
    }

    /** 价格统一格式化为两位小数，例如 45.00。 */
    public String getPriceText() {
        return String.format(Locale.CHINA, "¥%.2f", price);
    }
}
