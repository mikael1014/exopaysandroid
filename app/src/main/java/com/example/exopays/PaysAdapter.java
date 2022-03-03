package com.example.exopays;

import android.content.Intent;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.exopays.model.Pays;

import java.util.List;

public class PaysAdapter extends RecyclerView.Adapter<PaysAdapter.PaysViewHolder> {
    private final List<Pays> listpays;
    private int setSelectedItemPosition;

    public PaysAdapter(List<Pays> listpays) {
        this.listpays = listpays;
    }

    @NonNull
    @Override
    public PaysViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_pays, parent, false);
        return new PaysViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PaysViewHolder holder, int position) {
        Pays pays = listpays.get(position);
//        holder.tvId.setText(pays.getId());
        holder.tvContinent.setText(pays.getContinent());
        holder.tvNom.setText(pays.getNom());
//        holder.tvNombre_habitants.setText(pays.getNombre_habitants());
 //       holder.tvDateSuperficie.setText(pays.getSuperficie());


        //        holder.tvIdSelected.setText(pays.getId());
//        holder.tvContinentSelected.setText(pays.getContinent());
//        holder.tvNomSelected.setText(pays.getNom());
//        holder.tvNombre_habitantsSelected.setText(pays.getNombre_habitants());
        //       holder.tvDateSuperficieSelected.setText(pays.getSuperficie());

        holder.itemView.setOnClickListener(view -> {
//            Toast.makeText(view.getContext(), "Pays: " + pays.getNom(), Toast.LENGTH_SHORT)
//                    .show();

            Intent intent = new Intent(view.getContext() ,SelectedPaysActivity.class);
            intent.putExtra("selectedPays",pays);
//            intent.putExtra("editMode", 1);


            view.getContext().startActivity(intent);
        });
        holder.itemView.setOnLongClickListener(view -> {
            setSelectedItemPosition(position);
            return false;
        });
    }

    private void setSelectedItemPosition(int position) {
        this.setSelectedItemPosition = position;
    }

    public int getSetSelectedItemPosition() {
        return setSelectedItemPosition;
    }

    @Override
    public int getItemCount() {
        return listpays.size();
    }

    public static class PaysViewHolder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener {
        public TextView tvId;
        public TextView tvContinent;
        public TextView tvNom;
        public TextView tvNombre_habitants;
        public TextView tvDateSuperficie;

//        public TextView tvIdSelected;
//        public TextView tvContinentSelected;
//        public TextView tvNomSelected;
//        public TextView tvNombre_habitantsSelected;
//        public TextView tvDateSuperficieSelected;

        public PaysViewHolder(@NonNull View itemView) {
            super(itemView);
            tvId = itemView.findViewById(R.id.txtVId);
            tvContinent = itemView.findViewById(R.id.txtVContinent);
            tvNom = itemView.findViewById(R.id.txtVNom);
            tvNombre_habitants = itemView.findViewById(R.id.txtNombreHabitants);
            tvDateSuperficie = itemView.findViewById(R.id.txtVSuperficie);
//
//            tvIdSelected = itemView.findViewById(R.id.selectedTextId);
//            tvContinentSelected = itemView.findViewById(R.id.selectedTextContinent);
//            tvNomSelected = itemView.findViewById(R.id.selectedTextNom);
//            tvNombre_habitantsSelected = itemView.findViewById(R.id.selectedTextNombreHabitants);
//            tvDateSuperficieSelected = itemView.findViewById(R.id.selectedTextSuperficie);

            itemView.setOnCreateContextMenuListener(this);
        }

        @Override
        public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
            contextMenu.setHeaderTitle("Option");
            contextMenu.add(Menu.NONE, R.string.menu_item_editer, Menu.NONE, "Editer");
            contextMenu.add(Menu.NONE, R.string.menu_item_delete, Menu.NONE, "Supprimer");

        }


    }
}
