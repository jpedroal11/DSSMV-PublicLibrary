package com.example.dssmv_1211066_1210939;

import adapter.ListViewAdapterLibrary;
import adapter.ListViewAdapterLibraryBook;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import model.Library;
import service.RequestService;

import java.util.List;

public class LibraryBookActivity extends AppCompatActivity {

    private ListView lv;
    private List<Library> libraryBooksList;
    private List<Library> libraryBookDTOS;

    private ListViewAdapterLibraryBook adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library_book);

        lv = (ListView) findViewById(R.id.libraryBooksListView);
        getLibraryBooksFromWs();
    }

    private void getLibraryBooksFromWs() {
        new Thread() {
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                    }
                });
                //libraryBookDTOS = RequestService.getLibraryBooks(LibraryBookActivity.this, libraryId);
                libraryBooksList.clear();
                if (libraryBookDTOS == null){
                    return;
                }
                libraryBooksList.addAll(libraryBookDTOS);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        adapter.notifyDataSetChanged();
                    }
                });
            }
        }.start();
    }
}