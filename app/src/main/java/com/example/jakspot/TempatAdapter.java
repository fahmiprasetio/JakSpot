package com.example.jakspot;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TempatAdapter extends RecyclerView.Adapter<TempatAdapter.TempatViewHolder> {

    private List<Tempat> tempatList;

    public TempatAdapter(List<Tempat> tempatList) {
        this.tempatList = tempatList;
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


        // ⬇⬇ Tambahkan ini untuk buka halaman detail saat card ditekan
        holder.itemView.setOnClickListener(v -> {
            android.content.Context context = v.getContext();
            android.content.Intent intent = new android.content.Intent(context, DetailActivity.class);
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

        public TempatViewHolder(View itemView) {
            super(itemView);
            imageTempat = itemView.findViewById(R.id.imageTempat);
            textNama = itemView.findViewById(R.id.textNama);
            textLokasi = itemView.findViewById(R.id.textLokasi);
        }
    }
}
