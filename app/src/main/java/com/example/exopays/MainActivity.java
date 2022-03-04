package com.example.exopays;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.exopays.activity.EditPaysActivity;
import com.example.exopays.adapter.PaysAdapter;
import com.example.exopays.model.Pays;
import com.example.exopays.services.Config;
import com.example.exopays.services.PaysService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private PaysService paysService;
    private PaysAdapter paysAdapter;
    private List<Pays> listePays = new ArrayList<>();
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        paysAdapter= new PaysAdapter(listePays);
        recyclerView.setAdapter(paysAdapter);
        paysService = Config.getApiClient().create(PaysService.class);
        paysService.getListePays().enqueue(new Callback<List<Pays>>() {
            @Override
            public void onResponse(Call<List<Pays>> call, Response<List<Pays>> response) {
                Log.i("Response", response.code()+"");
                if (response.isSuccessful()) {
                    listePays=response.body();
                    paysAdapter= new PaysAdapter(listePays);
                    recyclerView.setAdapter(paysAdapter);
                }
            }

            @Override
            public void onFailure(Call<List<Pays>> call, Throwable t) {
                t.printStackTrace();
            }
        });

    }

//    @Override
//    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
//        super.onCreateContextMenu(menu, v, menuInfo);
//        MenuInflater menuInflater = getMenuInflater();
//        menuInflater.inflate(R.menu.menu_contextuel, menu);
//        menu.setHeaderTitle("Select Options");
//
//    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
       int position =paysAdapter.getSetSelectedItemPosition();
       Pays pays = listePays.get(position);
       switch (item.getItemId()){
           case R.string.menu_item_editer:
               Intent intent = new Intent(this , EditPaysActivity.class);
               intent.putExtra("selectedPays",pays);

               intent.putExtra("editMode", 1);


               startActivity(intent);
               break;
           case R.string.menu_item_delete:

               new AlertDialog.Builder(this)
                       .setTitle("Suppression")
                       .setMessage("Voulez-vous supprimer ?")
                       .setPositiveButton(android.R.string.yes, (dialogInterface, i) ->  Toast.makeText(this, "Supprimer "+ pays.getNom(),Toast.LENGTH_SHORT).show())
                       .setNegativeButton(android.R.string.no, (dialogInterface, i) -> Log.i("Click Non", "Nope"))
                       .setIcon(android.R.drawable.ic_dialog_alert)
                       .show();

               break;
       }
        return super.onContextItemSelected(item);
    }

    //MENU

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.my_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                Toast.makeText(this, "Item 1 clické", Toast.LENGTH_SHORT).show();
                break;
            case R.id.Item2:
                Toast.makeText(this, "Item 2 clické", Toast.LENGTH_SHORT).show();
                break;
            case R.id.Item3:
                Toast.makeText(this, "Item 3 clické", Toast.LENGTH_SHORT).show();
                break;
            case R.id.submenu1:
                Toast.makeText(this, "Sous menu 1 clické", Toast.LENGTH_SHORT).show();
                break;
            case R.id.submenu2:
                Toast.makeText(this, "Sous menu 2 clické", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }


}