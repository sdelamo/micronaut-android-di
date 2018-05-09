package io.micronaut.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton // <1>
public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    @Inject
    BooksFetcher booksFetcher;

    private List<Book> bookList;

    private TextView textViewMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewMessage = findViewById(R.id.textViewMessage);
        init();
    }

    void init() {
        if ( booksFetcher != null ) {
            booksFetcher.fetchBooks(books -> {
                setBookList(books);
                logBooks();
            });
        } else {
            Log.w(TAG, "Book Fetcher dependency not injected");
            textViewMessage.setText(R.string.bookfetcher_injected);
        }
    }

    void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    void logBooks() {
        if ( bookList != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Books Fetched #");
            sb.append(bookList.size());
            sb.append("\n");
            for ( Book book : bookList ) {
                sb.append("Book ");
                sb.append(book.getTitle());
                sb.append("\n");
            }
            Log.i(TAG, sb.toString());
            textViewMessage.setText(sb.toString());
        }
    }
}
