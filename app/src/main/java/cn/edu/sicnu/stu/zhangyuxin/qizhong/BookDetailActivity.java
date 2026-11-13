package cn.edu.sicnu.stu.zhangyuxin.qizhong;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

/**
 * 第 2 个 Activity：显示被选中书籍的完整信息。
 */
public class BookDetailActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detail);
        setTitle(getString(R.string.title_detail));
        if (getActionBar() != null) {
            getActionBar().setDisplayHomeAsUpEnabled(true);
        }

        Book book = readBook();
        if (book == null) {
            finish();
            return;
        }
        showBook(book);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("deprecation")
    private Book readBook() {
        Intent intent = getIntent();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            return intent.getSerializableExtra(MainActivity.EXTRA_BOOK, Book.class);
        }
        return (Book) intent.getSerializableExtra(MainActivity.EXTRA_BOOK);
    }

    private void showBook(Book book) {
        TextView title = findViewById(R.id.tvTitle);
        TextView author = findViewById(R.id.tvAuthor);
        TextView publisher = findViewById(R.id.tvPublisher);
        TextView year = findViewById(R.id.tvYear);
        TextView isbn = findViewById(R.id.tvIsbn);
        TextView price = findViewById(R.id.tvPrice);
        TextView intro = findViewById(R.id.tvIntro);

        title.setText(book.getTitle());
        author.setText("作者：" + book.getAuthor());
        publisher.setText(book.getPublisher());
        year.setText(book.getYear() + " 年");
        isbn.setText(book.getIsbn());
        price.setText(book.getPriceText());
        intro.setText(book.getIntro());
    }
}
