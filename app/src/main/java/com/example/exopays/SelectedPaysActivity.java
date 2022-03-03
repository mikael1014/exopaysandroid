package com.example.exopays;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.example.exopays.model.Pays;

public class SelectedPaysActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_pays);
        setTitle("Selected");
        // int viewMode = getIntent().getIntExtra("viewMode", 0);

        //  if (viewMode != 0)
        {
            Pays pays = (Pays) getIntent().getSerializableExtra("selectedPays");
            TextView textViewId = findViewById(R.id.editTextId);
            TextView textViewContinent = findViewById(R.id.editTextContinent);
            TextView textViewNom = findViewById(R.id.editTextNom);
            TextView textViewNombreHabitants = findViewById(R.id.editTextNombreHabitants);
            TextView textViewSuperficie = findViewById(R.id.editTextSuperficie);
            textViewId.setText(String.valueOf(pays.getId()));
            textViewContinent.setText(pays.getContinent());
            textViewNom.setText(pays.getNom());
            textViewNombreHabitants.setText(String.valueOf(pays.getNombre_habitants()));
            textViewSuperficie.setText(String.valueOf(pays.getSuperficie()));
        }
    }
}