package com.gaurav.gsmusic.data.remote

import com.gaurav.gsmusic.data.entity.Song
import com.gaurav.gsmusic.other.Constants.SONG_COLLECTION
import kotlinx.coroutines.tasks.await
import com.google.firebase.firestore.FirebaseFirestore

class MusicDatabase {
    private val dbFirestore = FirebaseFirestore.getInstance()
    private val songCollection = dbFirestore.collection(SONG_COLLECTION)

    suspend fun getAllSongs(): List<Song> {
        return try {
            songCollection.get().await().toObjects(Song::class.java)
        } catch (exception: Exception) {
            emptyList()
        }
    }
}