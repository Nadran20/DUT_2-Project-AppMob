package com.example.projectappmob;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.auth.User;

import java.util.HashMap;
import java.util.Map;

public class ModifActivity extends AppCompatActivity {
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modif);

        Intent intent = getIntent();

        db = FirebaseFirestore.getInstance();
    }

    public void ModifierInfo(View view){
        Modif();
        Intent intent = new Intent(this, UserActivity.class);
        startActivity(intent);
    }

    private void Modif() {
        EditText editTextName = (EditText) findViewById(R.id.InputName);
        EditText editTextPrénom = (EditText) findViewById(R.id.InputPrénom);
        EditText editTextMail = (EditText) findViewById(R.id.InputMail);

        String Name = editTextName.getText().toString();
        String Prénom = editTextPrénom.getText().toString();
        String Mail = editTextMail.getText().toString();


        Map<String, Object> data = new HashMap<>();
        if(Name != ""|| Name == null)
            data.put("Nom", Name);
        if(Prénom != ""|| Prénom == null)
            data.put("Prénom", Prénom);
        if(Mail != "" || Mail == null)
            data.put("mail", Mail);

        db.collection("Users").document("drnew7QAOKUdFqiebSxq").update(data)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(getApplicationContext(), "Information modifier", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}