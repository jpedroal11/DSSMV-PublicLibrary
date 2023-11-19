package com.example.dssmv_1211066_1210939;

import DTO.CreateLibraryBookRequestDTO;
import DTO.LibraryDTO;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import model.CreateLibraryBookRequest;
import model.Library;
import model.LibraryBook;
import service.RequestService;

public class EditStockActivity extends AppCompatActivity {

    private String libraryBookIsbn;
    private String libraryId;
    private String exceptionMessage = "";
    private boolean exception = false;
    private boolean isValid1 = true;
    private boolean isValid2 = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_stock);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        Button updateStockButton = (Button) findViewById(R.id.updateStockButton);

        Intent i = getIntent();
        libraryBookIsbn = i.getStringExtra("libraryBookIsbn");
        libraryId = i.getStringExtra("libraryId");


        getLibraryBookFromWS(EditStockActivity.this, libraryBookIsbn);


        updateStockButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText stockInsertView = findViewById(R.id.updateStockInsertViewText);

                int stock = Integer.parseInt(stockInsertView.getText().toString());



                stock = Integer.parseInt(stockInsertView.getText().toString());
                if (stock < 0) {
                    Toast.makeText(EditStockActivity.this, "Verifique que o stock não é negativo", Toast.LENGTH_SHORT).show();
                    isValid1 = false;
                }else {
                    if (stock != (int) stock) {
                        Toast.makeText(EditStockActivity.this, "Verifique que o stock é um número inteiro válido", Toast.LENGTH_SHORT).show();
                        isValid2 = false;
                    }else{
                        isValid1 = true;
                        isValid2 = true;
                    }
                }

                if (isValid1 == true && isValid2 == true) {
                    CreateLibraryBookRequestDTO createLibraryBookRequestDTO = new CreateLibraryBookRequestDTO(stock);
                    putLibraryBookStock2WS(libraryBookIsbn, createLibraryBookRequestDTO);
                    Toast.makeText(EditStockActivity.this, "Book´s Stock updated successfully", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(EditStockActivity.this, LibraryBookActivity.class);
                    i.putExtra("libraryId", libraryId);
                    startActivity(i);
                }
            }
        });
    }

    private void getLibraryBookFromWS(Activity activity, String libraryBookIsbn) {
        new Thread() {
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {}
                });
                CreateLibraryBookRequest createLibraryBookRequest= RequestService.getLibraryBook(activity, libraryId,libraryBookIsbn);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        EditText updateStockInsertViewText = findViewById(R.id.updateStockInsertViewText);
                        updateStockInsertViewText.setText(String.valueOf(createLibraryBookRequest.getStock()));

                    }
                });
            }
        }.start();
    }

    private void putLibraryBookStock2WS(String libraryBookIsbn, CreateLibraryBookRequestDTO createLibraryBookRequestDTO) {
        new Thread() {
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {}
                });
                RequestService.updateLibraryBookStock(libraryId, libraryBookIsbn, createLibraryBookRequestDTO,EditStockActivity.this);
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
            Toast.makeText(EditStockActivity.this,exceptionMessage,Toast.LENGTH_SHORT).show();
        }
    }
    }



