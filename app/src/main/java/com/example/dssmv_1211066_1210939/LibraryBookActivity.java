package com.example.dssmv_1211066_1210939;

import DTO.LibraryBookDTO;
import adapter.ListViewAdapterLibrary;
import adapter.ListViewAdapterLibraryBook;
import android.content.Intent;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import model.Library;
import model.LibraryBook;
import service.RequestService;

import java.util.ArrayList;
import java.util.List;

public class LibraryBookActivity extends AppCompatActivity {

    private ListView lv;
    private List<LibraryBook> libraryBooksList;
    private List<LibraryBook> libraryBookDTOS;
    private ListViewAdapterLibraryBook adapter;
    private String libraryId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library_book);

        getLibraryBooksFromWs();

        Intent intent = getIntent();
        libraryId = intent.getStringExtra("libraryId");

        lv = findViewById(R.id.libraryBooksListView);
        libraryBooksList = new ArrayList<>();

        adapter = new ListViewAdapterLibraryBook(this, libraryBooksList);
        lv.setAdapter(adapter);


    }

    private void getLibraryBooksFromWs() {
        new Thread() {
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                    }
                });
                libraryBookDTOS = RequestService.getLibraryBooks(LibraryBookActivity.this, libraryId);
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