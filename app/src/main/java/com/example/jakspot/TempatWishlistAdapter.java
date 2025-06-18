// === TempatWishlistAdapter.java ===
package com.example.jakspot;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TempatWishlistAdapter extends RecyclerView.Adapter<TempatWishlistAdapter.TempatViewHolder> {

    private List<Tempat> tempatList;
    private Context context;
    private DbHelper dbHelper;

    public TempatWishlistAdapter(Context context, List<Tempat> tempatList) {
        this.tempatList = tempatList;
        this.context = context;
        this.dbHelper = new DbHelper(context);
    }

    @NonNull
    @Override
    public TempatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tempat_wishlist, parent, false);
        return new TempatViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TempatViewHolder holder, int position) {
        Tempat tempat = tempatList.get(position);
        holder.imageTempat.setImageResource(tempat.getGambar());
        holder.textNama.setText(tempat.getNama());
        holder.textLokasi.setText(tempat.getLokasi());

        holder.btnFavorite.setImageResource(R.drawable.ic_favorite_filled);
        holder.btnFavorite.setOnClickListener(v -> {
            dbHelper.removeFavorite(tempat.getNama());
            tempatList.remove(position);
            notifyItemRemoved(position);
            notifyItemRangeChanged(position, tempatList.size());
        });

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra("nama", tempat.getNama());
            intent.putExtra("lokasi", tempat.getLokasi());
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


// === MODIFIKASI TempatAdapter.java ===
// Tambahkan ini ke dalam onCreateViewHolder untuk mendeteksi layout berbeda
// Gunakan ini jika Anda ingin satu adapter mendukung banyak layout:
// Gantilah:
// View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tempat, parent, false);
// Dengan:
// int layoutId = (context instanceof WishlistActivity)
//     ? R.layout.item_tempat_wishlist
//     : R.layout.item_tempat;
// View view = LayoutInflater.from(parent.getContext()).inflate(layoutId, parent, false);
