package com.example.dssmv_1211066_1210939;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {

    private Button buttonLibrary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menuactivity);

        buttonLibrary = (Button) findViewById(R.id.buttonLibrary);
        buttonLibrary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLibraryActivity();
            }
        });
    }

    public void openLibraryActivity() {
        Intent intent = new Intent(this, LibraryActivity.class);
        startActivity(intent);
    }
}