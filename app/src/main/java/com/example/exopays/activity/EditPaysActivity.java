package com.example.exopays.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import com.example.exopays.R;
import com.example.exopays.model.Pays;

public class EditPaysActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_pays);
        setTitle("Edit");
        int editMode = getIntent().getIntExtra("editMode", 0);

        if (editMode != 0) {
            Pays pays = (Pays) getIntent().getSerializableExtra("selectedPays");
            EditText editTextId = findViewById(R.id.textVId);
            EditText editTextContinent = findViewById(R.id.textVContinent);
            EditText editTextNom = findViewById(R.id.textVNom);
            EditText editTextNombreHabitants = findViewById(R.id.textVNombreHabitants);
            EditText editTextSuperficie = findViewById(R.id.textVSuperficie);
            editTextId.setText(String.valueOf(pays.getId()));
            editTextContinent.setText(pays.getContinent());
            editTextNom.setText(pays.getNom());
            editTextNombreHabitants.setText(String.valueOf(pays.getNombreHabitants()));
            editTextSuperficie.setText(String.valueOf(pays.getSuperficie()));
        }
    }
}