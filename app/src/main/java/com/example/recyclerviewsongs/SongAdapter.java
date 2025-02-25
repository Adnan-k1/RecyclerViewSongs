package com.example.recyclerviewsongs;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.util.Log;
import com.bumptech.glide.Glide;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.SongViewHolder> {
    private List<Song> songList;

    public SongAdapter(List<Song> songList) {
        this.songList = songList;
    }

    @NonNull
    @Override
    public SongViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_song, parent, false);
        return new SongViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SongViewHolder holder, int position) {
        Song song = songList.get(position);
        holder.tvTitle.setText(song.getTitle());
        holder.tvArtist.setText(song.getArtist());

        Glide.with(holder.itemView.getContext())
                .load(song.getImageResource())
                .into(holder.ivAlbum);

        holder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), SongDetailActivity.class);
            intent.putExtra("title", song.getTitle());
            intent.putExtra("artist", song.getArtist());
            intent.putExtra("imageResource", song.getImageResource());
            intent.putExtra("meaning", song.getMeaning());
            intent.putExtra("audioResource", song.getAudioResource());

            Log.d("SongAdapter", "Mengirim audioResource: " + song.getAudioResource());
            view.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return songList.size();
    }

    public static class SongViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle, tvArtist;
        ImageView ivAlbum;

        public SongViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvArtist = itemView.findViewById(R.id.tvArtist);
            ivAlbum = itemView.findViewById(R.id.ivAlbum);
        }
    }
}
