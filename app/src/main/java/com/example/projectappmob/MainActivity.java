package com.example.projectappmob;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.solver.widgets.WidgetContainer;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private FirebaseFirestore db;
    private ListView listActivité;
    private List<String> ListActivité = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listActivité = findViewById(R.id.ListActivité);
        String TAG = "User";

        Intent intent = getIntent();

        db = FirebaseFirestore.getInstance();

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.BottomNavBar);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(0);
        menuItem.setChecked(true);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_home:
                        break;
                    case R.id.action_calendar:
                        Intent intent2 = new Intent(MainActivity.this, CalendarActivity.class);
                        startActivity(intent2);
                        break;
                    case R.id.action_more:
                        Intent intent3 = new Intent(MainActivity.this, MoreActivity.class);
                        startActivity(intent3);
                        break;
                    case R.id.action_user:
                        Intent intent4 = new Intent(MainActivity.this, UserActivity.class);
                        startActivity(intent4);
                        break;
                }
                return false;
            }
        });

        //tjs dans le onCCreate

    }
/*
    @Override
    protected void onStart() {
        super.onStart();
        showList();
    }

    private void showList() {
        db.collection("Users").document("drnew7QAOKUdFqiebSxq").collection("Activités").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                ListActivité.clear();

                for (DocumentSnapshot snapshot : value) {
                    ListActivité.add(snapshot.getString("Nom"));
                }


                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_selectable_list_item, ListActivité) {
                    @Override
                    public View getView(int position, View convertView, ViewGroup parent) {
                        View view = super.getView(position, convertView, parent);

                        TextView textView = (TextView) view.findViewById(android.R.id.text1);

                        /*YOUR CHOICE OF COLOR
                        textView.setTextColor(0xFF808080);

                        return view;
                    }
                };

                adapter.notifyDataSetChanged();
                listActivité.setAdapter(adapter);
            }
        });
    }*/

}