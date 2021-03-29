package com.example.projectappmob;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class UserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        FirebaseFirestore db = FirebaseFirestore.getInstance();

        String TAG = "User";

        Intent intent = getIntent();
        String nom ="";

        db.collection("Users").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                for(DocumentSnapshot snapshot : value){
                    TextView TextNom = findViewById(R.id.textNom);
                    TextNom.setText(snapshot.getString("Nom"));
                    TextView TextPrénom = findViewById(R.id.textPrénom);
                    TextPrénom.setText(snapshot.getString("Prénom"));
                    TextView TextEmail = findViewById(R.id.textMail);
                    TextEmail.setText(snapshot.getString("mail"));
                }
            }
        });

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.BottomNavBar);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(3);
        menuItem.setChecked(true);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_home:
                        Intent intent1 = new Intent(UserActivity.this, MainActivity.class);
                        startActivity(intent1);
                        break;
                    case R.id.action_calendar:
                        Intent intent2 = new Intent(UserActivity.this, CalendarActivity.class);
                        startActivity(intent2);
                        break;
                    case R.id.action_more:
                        Intent intent3 = new Intent(UserActivity.this, MoreActivity.class);
                        startActivity(intent3);
                        break;
                    case R.id.action_user:
                        break;
                }
                return false;
            }
        });
    }

    public void ModifAct(View view) {
        Intent intent = new Intent(this, ModifActivity.class);
        startActivity(intent);
    }
}