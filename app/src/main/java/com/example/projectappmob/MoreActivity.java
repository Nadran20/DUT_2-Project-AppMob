package com.example.projectappmob;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

import io.perfmark.Tag;

public class MoreActivity extends AppCompatActivity {
    private FirebaseFirestore db;
    private String TAG = "console";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more);

        Intent intent = getIntent();

        db = FirebaseFirestore.getInstance();

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.BottomNavBar);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(2);
        menuItem.setChecked(true);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_home:
                        Intent intent1 = new Intent(MoreActivity.this, MainActivity.class);
                        startActivity(intent1);
                        break;
                    case R.id.action_calendar:
                        Intent intent2 = new Intent(MoreActivity.this, CalendarActivity.class);
                        startActivity(intent2);
                        break;
                    case R.id.action_more:
                        break;
                    case R.id.action_user:
                        Intent intent4 = new Intent(MoreActivity.this, UserActivity.class);
                        startActivity(intent4);
                        break;
                }
                return false;
            }
        });


    }

    public void ajouterActivité(View view){

        createActivity();
        TextView TextResult = findViewById(R.id.textResult);
        EditText editTextName = (EditText) findViewById(R.id.InputName);
        editTextName.setText("");
        EditText editTextLieu = (EditText) findViewById(R.id.InputLieu);
        editTextLieu.setText("");
        EditText editTextDesc = (EditText) findViewById(R.id.InputDescription);
        editTextDesc.setText("");

        Log.d(TAG, "On passe ici ma zoulette");
    }

    private void createActivity() {
        EditText editTextName = (EditText) findViewById(R.id.InputName);
        EditText editTextLieu = (EditText) findViewById(R.id.InputLieu);
        EditText editTextDescription = (EditText) findViewById(R.id.InputDescription);

        String Name = editTextName.getText().toString();
        String Lieu = editTextLieu.getText().toString();
        String Description = editTextDescription.getText().toString();

        Map<String, Object> data = new HashMap<>();
        data.put("Name", Name);
        data.put("Lieu", Lieu);
        data.put("Description", Description);

        Log.d(TAG, "On passe ici ma couille");

        db.collection("Users").document("drnew7QAOKUdFqiebSxq").collection("Activités")
                .add(data)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {

                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d(TAG, "Donnée bien ajouter dans le document");
                        TextView TextResult = findViewById(R.id.textResult);
                        TextResult.setText("Activité ajouter !");
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.d(TAG, "Erreur dans l'ajout de donnée");
                        TextView TextResult = findViewById(R.id.textResult);
                        TextResult.setText("Erreur de l'ajout de l'activité !");
                    }
                });

    }

}