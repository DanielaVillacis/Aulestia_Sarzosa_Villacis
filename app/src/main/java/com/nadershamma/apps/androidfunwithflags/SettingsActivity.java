package com.nadershamma.apps.androidfunwithflags;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class SettingsActivity extends AppCompatActivity{
    private Button button_CerrarSesion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        button_CerrarSesion = findViewById(R.id.buttonCerrarSesion);
        button_CerrarSesion.setOnClickListener(new View.OnClickListener(){
                                                   @Override
                                                   public void onClick(View view) {
                                                       Intent intent = new Intent(SettingsActivity.this, login_activity.class);

                                                       startActivity(intent);
                                                   }
                                               }
        );
    }

}
