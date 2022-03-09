package com.example.exopays.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


import com.example.exopays.MainActivity;
import com.example.exopays.R;
import com.example.exopays.model.Pays;
import com.example.exopays.services.PaysService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditPaysActivity extends AppCompatActivity {
    private EditText editTextId, editTextContinent, editTextNom, editTextNombreHabitants, editTextSuperficie;
    private PaysService paysService;

//    setTitle("Edit");
//
//    int editMode = getIntent().getIntExtra("editMode", 0);
//
//        if(editMode !=0)
//
//    {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_pays);
        Pays pays = (Pays) getIntent().getSerializableExtra("selectedPays");
        editTextId = findViewById(R.id.editTextId);
        editTextContinent = findViewById(R.id.editTextContinent);
        editTextNom = findViewById(R.id.editTextNom);
        editTextNombreHabitants = findViewById(R.id.editTextNombreHabitants);
        editTextSuperficie = findViewById(R.id.editTextSuperficie);

        editTextId.setText(String.valueOf(pays.getId()));
        editTextContinent.setText(pays.getContinent());
        editTextNom.setText(pays.getNom());
        editTextNombreHabitants.setText(String.valueOf(pays.getNombreHabitants()));
        editTextSuperficie.setText(String.valueOf(pays.getSuperficie()));
    }


        public void enregisterPays (View view){
        Pays pays = new Pays();
        pays.setContinent(editTextContinent.getText().toString());
        pays.setNom(editTextNom.getText().toString());
        pays.setNombreHabitants(Long.parseLong(editTextNombreHabitants.getText().toString()));
        pays.setSuperficie(Long.parseLong(editTextContinent.getText().toString()));


        paysService.savePays(pays).enqueue(new Callback<Pays>() {

            @Override
            public void onResponse(Call<Pays> call, Response<Pays> response) {
                if (response.isSuccessful()) {
//                    Intent intent = new Intent(getBaseContext(), MainActivity.class);
//                    startActivity(intent);
                    Pays newPays = response.body();
                    Intent intent = new Intent(getBaseContext(), MainActivity.class);
                    intent.putExtra("newPays", newPays);
                    setResult(response.code(), intent);

                    finish();
                } else {
                    Log.e("Error code", String.valueOf(response.code()));
                    Toast.makeText(getBaseContext(), response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Pays> call, Throwable t) {
                t.printStackTrace();
                Toast.makeText(getBaseContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        }

}