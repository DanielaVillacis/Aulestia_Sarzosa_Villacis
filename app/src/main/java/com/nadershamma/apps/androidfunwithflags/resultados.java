package com.nadershamma.apps.androidfunwithflags;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class resultados extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);
    }

    public void Volver(View view){
        Intent intent = new Intent(this,login_activity.class);
        startActivity(intent);
        finish();
    }
}