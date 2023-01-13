package com.nadershamma.apps.androidfunwithflags;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;



public class MainActivityAux extends AppCompatActivity {

        private Button button_DeleteUser;
        private Button button_EditUser;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_settings);
            Toolbar toolbar = findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);


            button_EditUser = findViewById(R.id.buttonStart);
            button_EditUser.setOnClickListener(new View.OnClickListener(){
                                                       @Override
                                                       public void onClick(View view) {
                                                           Intent intent = new Intent(MainActivityAux.this, MainActivity.class);

                                                           startActivity(intent);
                                                       }
                                                   }
            );
        }

}