package com.example.projectappmob;

import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.ColorStateListDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class CalendarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        Intent intent = getIntent();



        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.BottomNavBar);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(1);
        menuItem.setChecked(true);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_home:
                        Intent intent1 = new Intent(CalendarActivity.this, MainActivity.class);
                        startActivity(intent1);
                        break;
                    case R.id.action_calendar:
                        break;
                    case R.id.action_more:
                        Intent intent3 = new Intent(CalendarActivity.this, MoreActivity.class);
                        startActivity(intent3);
                        break;
                    case R.id.action_user:
                        Intent intent4 = new Intent(CalendarActivity.this, UserActivity.class);
                        startActivity(intent4);
                        break;
                }
                return false;
            }
        });
    }
}