package com.example.recyclerviewsongs;

public class Song {
    private String title;
    private String artist;
    private int imageResource;
    private String meaning; // Tambahkan makna lagu

    private int audioResource;

    public Song(String title, String artist, int imageResource, String meaning, int audioResource) {
        this.title = title;
        this.artist = artist;
        this.imageResource = imageResource;
        this.meaning = meaning;
        this.audioResource = audioResource;
    }

    public int getAudioResource() {
        return audioResource;
    }
    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public int getImageResource() {
        return imageResource;
    }

    public String getMeaning() {
        return meaning;
    }
}
