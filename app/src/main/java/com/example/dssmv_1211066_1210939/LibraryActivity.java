package com.example.dssmv_1211066_1210939;


import DTO.LibraryDTO;
import adapter.ListViewAdapterLibrary;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;
import androidx.activity.ComponentActivity;
import androidx.activity.result.ActivityResultLauncher;
import android.os.Bundle;
import helper.CustomToast;
import helper.Utils;
import model.Library;
import service.RequestService;
import java.util.ArrayList;
import java.util.List;

import static handler.JsonHandler.serializeLibraryDTO2Json;


public class LibraryActivity extends ComponentActivity implements AdapterView.OnItemClickListener {

    private ListView lv;
    private List<Library> librariesList;
    private List<Library> libraryDTOS;
    private ListViewAdapterLibrary adapter;
    private ActivityResultLauncher<Intent> someActivityResultLauncher;
    private String exceptionMessage = "";
    private boolean exception = false;
    private String libraryId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        librariesList = new ArrayList<>();
        lv = (ListView) findViewById(R.id.librariesListView);
        getLibrariesFromWs();

        adapter = new ListViewAdapterLibrary(this, librariesList);
        lv.setAdapter(adapter);
        registerForContextMenu(lv);


        Button createLibraryButton = (Button)findViewById(R.id.createLibraryButton);
        createLibraryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCreateLibraryActivity();
            }
        });

        Button refreshButton = (Button)findViewById(R.id.refreshButton); //FALTA TESTAR
        refreshButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getLibrariesFromWs();
            }
        });

        lv.setOnItemClickListener(this::onItemClick);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id){ //Mostra os details de cada Library
        StringBuilder sb = new StringBuilder();
        sb.append("Name: ").append(libraryDTOS.get(position).getName()).append("\n");
        sb.append("Address: ").append(libraryDTOS.get(position).getAddress()).append("\n");
        sb.append("Open: ").append(libraryDTOS.get(position).getOpen()).append("\n");
        sb.append("Open Days: ").append(libraryDTOS.get(position).getOpenDays()).append("\n");
        sb.append("Open Statement: ").append(libraryDTOS.get(position).getOpenStatement()).append("\n");
        sb.append("Open Time: ").append(libraryDTOS.get(position).getOpenTime()).append("\n");
        sb.append("Close Time: ").append(libraryDTOS.get(position).getCloseTime()).append("\n");
        String libraryDetailsText = sb.toString();
        CustomToast.makeText(getApplicationContext(), libraryDetailsText, Toast.LENGTH_LONG).show();
    }

    private void getLibrariesFromWs() {
        new Thread() {
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                    }
                });
                libraryDTOS = RequestService.getLibraries(LibraryActivity.this);
                librariesList.clear();
                if (libraryDTOS == null){
                    return;
                }
                librariesList.addAll(libraryDTOS);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        adapter.notifyDataSetChanged();
                    }
                });
            }
        }.start();
    }

    private void deleteLibrary2WS(String id) {
        new Thread() {
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {}
                });

                RequestService.deleteLibrary(id, LibraryActivity.this);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        checkOperationResult();
                    }
                });
            }
        }.start();
    }

    private void checkOperationResult(){
        if(exception == false) {
            Intent intent = new Intent();
            setResult(Activity.RESULT_OK, intent);
            finish();
        }else{
            Toast.makeText(LibraryActivity.this,exceptionMessage,Toast.LENGTH_SHORT).show();
        }
    }

    @SuppressLint("ResourceType")
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo)
    {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.layout.menu_library, menu);
        menu.setHeaderTitle("Select The Action");
    }

    public void openCreateLibraryActivity() {
        Intent intent = new Intent(this, CreateLibraryActivity.class);
        startActivity(intent);
    }


    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int position = info.position;
        Library library = (Library) lv.getItemAtPosition(position);
        libraryId = library.getId();

        switch (item.getItemId()) {
            case R.id.edit:
                Toast.makeText(getApplicationContext(),"Edit mode",Toast.LENGTH_SHORT).show();
                Intent i = new Intent(LibraryActivity.this, EditLibraryActivity.class);
                i.putExtra("libraryId", libraryId);
                startActivity(i);
                return true;
            case R.id.delete:
                deleteLibrary2WS(libraryId);
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }


}

