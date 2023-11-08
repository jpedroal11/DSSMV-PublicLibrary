package com.example.dssmv_1211066_1210939;


import adapter.ListViewAdapterLibrary;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import model.Library;
import service.RequestService;

import java.util.ArrayList;
import java.util.List;


public class LibraryActivity extends AppCompatActivity {

    private ListView lv;
    private ProgressBar pdRing;
    private List<Library> librariesList;
    private ListViewAdapterLibrary adapter;
    private ActivityResultLauncher<Intent> someActivityResultLauncher;
    private Button getLibrariesButton;


    /*protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_libraries);


        pdRing = (ProgressBar) findViewById(R.id.progressBar);
        pdRing.setVisibility(ProgressBar.INVISIBLE);
        bookstoresList = new ArrayList<>();
        lv = (ListView) findViewById(R.id.listLibraryView);

        someActivityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if(result.getResultCode() == RESULT_OK){
                            getBookstoresFromWs();
                        }
                    }
                });
        adapter = new ListViewAdapterBookstore(this, bookstoresList);
        lv.setAdapter(adapter);
        registerForContextMenu(lv);

        /lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String name = adapter.getName(i);
                Intent intent = new Intent(LibrariesActivity.this, BookstoreDetailActivity.class);
                someActivityResultLauncher.launch(intent);
            }
        });/
        getLibrariesFromWs();
    }*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        librariesList = new ArrayList<>();
        lv = (ListView) findViewById(R.id.librariesListView);

        getLibrariesButton = (Button) findViewById(R.id.getLibrariesButton);
        getLibrariesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getLibrariesFromWs();
            }
        });

        adapter = new ListViewAdapterLibrary(this, librariesList);
        lv.setAdapter(adapter);
        registerForContextMenu(lv);
    }




    private void getLibrariesFromWs() {
        new Thread() {
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                       //pdRing.setVisibility(ProgressBar.VISIBLE);
                    }
                });
                List<Library> libraryDTOS = RequestService.getLibraries(LibraryActivity.this);
                librariesList.clear();
                if (libraryDTOS == null){
                    return;
                }
                librariesList.addAll(libraryDTOS);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        adapter.notifyDataSetChanged();
                        //pdRing.setVisibility(ProgressBar.GONE);
                    }
                });
            }
        }.start();
    }


}

