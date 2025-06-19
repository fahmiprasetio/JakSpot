package com.example.jakspot;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TempatAdapter extends RecyclerView.Adapter<TempatAdapter.TempatViewHolder> {

    private List<Tempat> tempatList;
    private Context context;
    private DbHelper dbHelper;

    public TempatAdapter(Context context, List<Tempat> tempatList) {
        this.tempatList = tempatList;
        this.context = context;
        this.dbHelper = new DbHelper(context);
    }

    @Override
    public TempatViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tempat, parent, false);
        return new TempatViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TempatViewHolder holder, int position) {
        Tempat tempat = tempatList.get(position);
        holder.imageTempat.setImageResource(tempat.getGambar());
        holder.textNama.setText(tempat.getNama());
        holder.textLokasi.setText(tempat.getLokasi());

        boolean isFav = dbHelper.isFavorited(tempat.getNama());
        holder.btnFavorite.setImageResource(isFav ? R.drawable.ic_favorite_filled : R.drawable.ic_favorite_border);

        holder.btnFavorite.setOnClickListener(v -> {
            if (dbHelper.isFavorited(tempat.getNama())) {
                dbHelper.removeFavorite(tempat.getNama());
                holder.btnFavorite.setImageResource(R.drawable.ic_favorite_border);
            } else {
                dbHelper.addFavorite(tempat);
                holder.btnFavorite.setImageResource(R.drawable.ic_favorite_filled);
            }
        });

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra("nama", tempat.getNama());
            intent.putExtra("lokasi", tempat.getLokasi());
            intent.putExtra("lat", tempat.getLatitude());
            intent.putExtra("lng", tempat.getLongitude());
            intent.putExtra("gambar", tempat.getGambar());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return tempatList.size();
    }

    public static class TempatViewHolder extends RecyclerView.ViewHolder {
        ImageView imageTempat;
        TextView textNama, textLokasi;
        ImageButton btnFavorite;

        public TempatViewHolder(View itemView) {
            super(itemView);
            imageTempat = itemView.findViewById(R.id.imageTempat);
            textNama = itemView.findViewById(R.id.textNama);
            textLokasi = itemView.findViewById(R.id.textLokasi);
            btnFavorite = itemView.findViewById(R.id.btn_favorite);
        }
    }
}
