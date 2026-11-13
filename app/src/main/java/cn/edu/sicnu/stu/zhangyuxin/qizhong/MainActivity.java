package cn.edu.sicnu.stu.zhangyuxin.qizhong;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 第 1 个 Activity：在代码中创建书籍对象数组，按价格由低到高排序后用列表显示，
 * 单击某本书启动第 2 个 Activity 显示该书完整信息。
 */
public class MainActivity extends Activity {

    public static final String EXTRA_BOOK = "extra_book";

    private final List<Book> books = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 第一个 Activity 的标题：姓名 + 学号
        setTitle(getString(R.string.title_main));

        createBooks();
        sortByPriceAsc();

        TextView summary = findViewById(R.id.tvSummary);
        summary.setText("共 " + books.size() + " 本 · 按价格由低到高排序");

        ListView listView = findViewById(R.id.listBooks);
        listView.setAdapter(new BookAdapter(this, books));
        listView.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(MainActivity.this, BookDetailActivity.class);
            intent.putExtra(EXTRA_BOOK, books.get(position));
            startActivity(intent);
        });
    }

    /** 在代码里新建多个书籍对象并放入数组（此处使用 List 保存）。 */
    private void createBooks() {
        books.add(new Book("Android移动应用开发", "李刚", "人民邮电出版社", 59.00, 2021,
                "978-7-115-56561-3",
                "从 Android 基础组件讲起，系统介绍 Activity、布局、数据存储、"
                        + "网络与服务等移动应用开发核心技术，并配有大量工程案例。"));

        books.add(new Book("算法导论（第3版）", "Thomas H. Cormen", "机械工业出版社",
                128.00, 2013, "978-7-111-40701-0",
                "算法领域的经典教材，全面介绍排序、图算法、动态规划、"
                        + "NP 完全性等主题，兼顾理论证明与工程实现。"));

        books.add(new Book("数据结构（C语言版）", "严蔚敏", "清华大学出版社", 45.00, 2018,
                "978-7-302-14751-0",
                "国内高校广泛使用的数据结构教材，讲解线性表、栈、队列、树、"
                        + "图等结构及其基本操作的 C 语言实现。"));

        books.add(new Book("Java编程思想（第4版）", "Bruce Eckel",
                "机械工业出版社", 108.00, 2007, "978-7-111-21382-6",
                "深入讲解 Java 面向对象、集合、泛型、并发与 IO 等知识，"
                        + "是 Java 学习者常用的进阶读物。"));

        books.add(new Book("第一行代码：Android（第3版）", "郭霖", "人民邮电出版社",
                79.00, 2020, "978-7-115-53182-7",
                "以实战为主线讲解 Android 开发，涵盖四大组件、UI、数据持久化、"
                        + "多媒体与网络编程等内容。"));

        books.add(new Book("计算机网络：自顶向下方法", "James F. Kurose",
                "机械工业出版社", 89.00, 2018, "978-7-111-59971-5",
                "采用自顶向下的方式讲解应用层、传输层、网络层与链路层，"
                        + "强调 Internet 工作原理与协议设计思想。"));
    }

    /** 对数组中的书籍按价格从低到高排序。 */
    private void sortByPriceAsc() {
        Collections.sort(books, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return Double.compare(o1.getPrice(), o2.getPrice());
            }
        });
    }
}
