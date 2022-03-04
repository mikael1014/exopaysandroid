package com.example.exopays.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.ContentInfo;
import android.widget.TextView;

import com.example.exopays.R;
import com.example.exopays.model.Pays;
import com.example.exopays.services.Config;
import com.example.exopays.services.PaysService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailsPaysActivity extends AppCompatActivity {
    private PaysService paysService;
    TextView id, nom, continent, superficie, nbreHabitant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_pays);
        setTitle("Details");
        // int viewMode = getIntent().getIntExtra("viewMode", 0);

        //  if (viewMode != 0)
        {
            //           Pays pays = (Pays) getIntent().getSerializableExtra("selectedPays");
            paysService = Config.getApiClient().create(PaysService.class);
            long idPays = getIntent().getLongExtra("idPays", 0);
            id = findViewById(R.id.textVId);
            continent = findViewById(R.id.textVContinent);
            nom = findViewById(R.id.textVNom);
            nbreHabitant = findViewById(R.id.textVNombreHabitants);
            superficie = findViewById(R.id.textVSuperficie);
            initDetails("", "", "", "", "");

            paysService.getPaysById(idPays).enqueue(new Callback<Pays>() {
                @Override
                public void onResponse(Call<Pays> call, Response<Pays> response) {
                    if (response.isSuccessful()) {
                        Pays pays = response.body();
                        initDetails(String.valueOf(pays.getId()), pays.getNom(), pays.getContinent(), String.valueOf(pays.getNombreHabitants()), String.valueOf(pays.getSuperficie()));
                    }
                }

                @Override
                public void onFailure(Call<Pays> call, Throwable t) {
                    t.printStackTrace();
                }
            });
//            textViewId.setText(String.valueOf(pays.getId()));
//            textViewContinent.setText(pays.getContinent());
//            textViewNom.setText(pays.getNom());
//            textViewNombreHabitants.setText(String.valueOf(pays.getNombreHabitants()));
//            Log.i("pays habitat", String.valueOf(pays.getNombreHabitants()));
//            textViewSuperficie.setText(String.valueOf(pays.getSuperficie()));


        }
    }

    private void initDetails(String id, String nom, String continent, String
            superficie, String nbreHabitant) {
        this.id.setText(id);
        this.nom.setText(nom);
        this.continent.setText(continent);
        this.superficie.setText(superficie);
        this.nbreHabitant.setText(nbreHabitant);
    }
}