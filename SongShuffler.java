package com.anand;

import java.util.Random;
public class SongShuffler {
    // Array is used to store the songs
    private String[] playlist;
    // This variable is used to keep track of pending songs
    private int pendingLotEndPoint;
    // Creating an object Random to generating random numbers
    private Random random = new Random();

    // constructor to initialize the playlist and pending Lot
    public SongShuffler(String[] playlist){
        this.playlist = playlist;
        // initially all songs are unplayed so it will outside of array for now
        this.pendingLotEndPoint = playlist.length;
    }
    public String playRandomSong()
    {
        int songToReturnIdx;
        String songToReturn;
        // This will return an index from 0 to (pendingLotEndPoint -1)
        // 0 to (PLEP-1) ---> Pending Lot --- it will keep shrinking.
        // (PLEP-1) to playlist.length ---> Played songs --- it will keep growing.
        songToReturnIdx = random.nextInt(pendingLotEndPoint);
        songToReturn = playlist[songToReturnIdx];

        // putting to song to the rear end so that
        swap(songToReturnIdx, pendingLotEndPoint-1);
        // Shring the index pool from where it want to run our index generator
        pendingLotEndPoint --;

        if(pendingLotEndPoint == 0)
        {
            pendingLotEndPoint = playlist.length;
        }
        // return the song id which is to be played next
        return songToReturn;

    }
    private void swap(int i, int j)
    {
        if(i == j)
            return;
        String temp = playlist[i];
        playlist[i] = playlist[j];
        playlist[j] = temp;
    }

    public static void main(String[] args) {
        String[] songs = {"Bahubali", "DardeDisco","Vande-Maatram", "Beautiful"};
        SongShuffler songShuffler = new SongShuffler(songs);

        System.out.println("Iteration 1 :");
        System.out.println("Next song : "+ songShuffler.playRandomSong());
        System.out.println("Next song : "+ songShuffler.playRandomSong());
        System.out.println("Next song : "+ songShuffler.playRandomSong());
        System.out.println("Next song : "+ songShuffler.playRandomSong());

        System.out.println("\nIteration 2 :");
        System.out.println("Next song : "+ songShuffler.playRandomSong());
        System.out.println("Next song : "+ songShuffler.playRandomSong());
        System.out.println("Next song : "+ songShuffler.playRandomSong());
        System.out.println("Next song : "+ songShuffler.playRandomSong());

    }
}
