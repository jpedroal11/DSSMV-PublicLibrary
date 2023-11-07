package com.example.dssmv_1211066_1210939;
import android.os.Bundle;
import android.widget.SearchView;
import androidx.appcompat.app.AppCompatActivity;



import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import model.Library;
import service.RequestService;

public class BooksActivity extends AppCompatActivity {

    private EditText searchEditText;
    private Button searchButton;

   Library Library = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.books_activity);

        // Initialize the references to the EditText and the Search button
        searchEditText = findViewById(R.id.searchView);
        searchButton = findViewById(R.id.buttonSearch);

        // Set an OnClickListener for the Search button
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String searchQuery = searchEditText.getText().toString();
                if (searchQuery.length()>0) {

                }
            }
        });

    }
    /*private void getLibraryBook(String urlStr){

        new Thread(){
            public void run(){
                try {

                    Library = RequestService.getLibraryBook(urlStr);


                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            adapter.setItems(Library.getBooks());
                            adapter.notifyDataSetChanged();

                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }*/



}




