package cn.edu.sicnu.stu.zhangyuxin.qizhong;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * 书籍列表适配器：把 Book 对象绑定到 item_book 布局上。
 */
public class BookAdapter extends BaseAdapter {

    private final LayoutInflater inflater;
    private final List<Book> books;

    public BookAdapter(Context context, List<Book> books) {
        this.inflater = LayoutInflater.from(context);
        this.books = books;
    }

    @Override
    public int getCount() {
        return books.size();
    }

    @Override
    public Book getItem(int position) {
        return books.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_book, parent, false);
            holder = new ViewHolder();
            holder.title = convertView.findViewById(R.id.tvTitle);
            holder.meta = convertView.findViewById(R.id.tvMeta);
            holder.price = convertView.findViewById(R.id.tvPrice);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Book book = getItem(position);
        holder.title.setText(book.getTitle());
        holder.meta.setText(book.getAuthor() + " · " + book.getPublisher());
        holder.price.setText(book.getPriceText());
        return convertView;
    }

    private static class ViewHolder {
        TextView title;
        TextView meta;
        TextView price;
    }
}
