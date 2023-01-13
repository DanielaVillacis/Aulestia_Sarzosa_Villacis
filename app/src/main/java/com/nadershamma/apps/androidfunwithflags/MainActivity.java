package com.nadershamma.apps.androidfunwithflags;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.nadershamma.apps.eventhandlers.PreferenceChangeListener;
import com.nadershamma.apps.lifecyclehelpers.QuizViewModel;

import java.util.Set;

import DatosUser.UserData;
import Entities.User;

public class MainActivity extends AppCompatActivity {
    public static final String CHOICES = "pref_numberOfChoices";
    public static final String REGIONS = "pref_regionsToInclude";
    private boolean deviceIsPhone = true;
    private boolean preferencesChanged = true;
    private MainActivityFragment quizFragment;
    private QuizViewModel quizViewModel;
    private OnSharedPreferenceChangeListener preferencesChangeListener;

    private TextView nombreuser;
    private Button buttonEdit;
    private String cedula;
    private String nombre1;
    private String apellido;
    private String clave;


    private String correo;


    private void setSharedPreferences() {
        // set default values in the app's SharedPreferences
        PreferenceManager.setDefaultValues(this, R.xml.preferences, false);

        // Register a listener for shared preferences changes
        PreferenceManager.getDefaultSharedPreferences(this)
                .registerOnSharedPreferenceChangeListener(preferencesChangeListener);
    }

    private void screenSetUp() {
        if (getScreenSize() == Configuration.SCREENLAYOUT_SIZE_LARGE ||
                getScreenSize() == Configuration.SCREENLAYOUT_SIZE_XLARGE) {
            deviceIsPhone = false;
        }
        if (deviceIsPhone) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.quizViewModel = ViewModelProviders.of(this).get(QuizViewModel.class);
        this.preferencesChangeListener = new PreferenceChangeListener(this);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        this.setSharedPreferences();
        this.screenSetUp();


       cedula = getIntent().getExtras().getString("cedula");
        nombre1 = getIntent().getExtras().getString("nombre1");
        apellido = getIntent().getExtras().getString("apellido");
        correo = getIntent().getExtras().getString("correo");
        clave = getIntent().getExtras().getString("clave");

        nombreuser = findViewById(R.id.textView_nombre);
        String nombre = getIntent().getExtras().getString("nombre");
        nombreuser.setText(nombre);

        buttonEdit = findViewById(R.id.buttonEditUser);
        buttonEdit.setOnClickListener(new View.OnClickListener(){
                                                   @Override
                                                   public void onClick(View view) {
                                                       Intent intent = new Intent(MainActivity.this, RegistrarAuxActivity.class);
                                                       intent.putExtra("cedula", cedula);
                                                       intent.putExtra("nombre1", nombre);
                                                       intent.putExtra("apellido", apellido);
                                                       intent.putExtra("clave", clave);
                                                       intent.putExtra("correo", correo);
                                                       startActivity(intent);
                                                   }
                                               }
        );

    }

    @Override
    protected void onStart() {
        super.onStart();
        if (preferencesChanged) {
            this.quizFragment = (MainActivityFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.quizFragment);
            this.quizViewModel.setGuessRows(PreferenceManager.getDefaultSharedPreferences(this)
                    .getString(CHOICES, null));
            this.quizViewModel.setRegionsSet(PreferenceManager.getDefaultSharedPreferences(this)
                    .getStringSet(REGIONS, null));

            this.quizFragment.resetQuiz();

            preferencesChanged = false;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        String correo = getIntent().getExtras().getString("correo");

        int orientation = getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.menu_main, menu);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent preferencesIntent = new Intent(this, SettingsActivity.class);
        startActivity(preferencesIntent);
        return super.onOptionsItemSelected(item);
    }

    public int getScreenSize() {
        return getResources().getConfiguration().screenLayout &
                Configuration.SCREENLAYOUT_SIZE_MASK;
    }

    public MainActivityFragment getQuizFragment() {
        return this.quizFragment;
    }

    public QuizViewModel getQuizViewModel() {
        return quizViewModel;
    }

    public static String getCHOICES() {
        return CHOICES;
    }

    public static String getREGIONS() {
        return REGIONS;
    }

    public void setPreferencesChanged(boolean preferencesChanged) {
        this.preferencesChanged = preferencesChanged;
    }


}
