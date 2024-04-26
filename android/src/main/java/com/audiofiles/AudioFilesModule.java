package com.audiofiles;

import androidx.annotation.NonNull;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.module.annotations.ReactModule;

@ReactModule(name = AudioFilesModule.NAME)
public class AudioFilesModule extends ReactContextBaseJavaModule {
  public static final String NAME = "AudioFiles";
  private final Context context;

  public AudioFilesModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.context = reactContext;
  }

  @Override
  @NonNull
  public String getName() {
    return NAME;
  }

  @ReactMethod
  public void getAudioFiles(Promise promise) {
    ContentResolver contentResolver = context.getContentResolver();
      Uri uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
      String[] projection = {
          MediaStore.Audio.Media._ID,
          MediaStore.Audio.Media.TITLE,
          MediaStore.Audio.Media.ARTIST,
          MediaStore.Audio.Media.ALBUM,
          MediaStore.Audio.Media.DURATION,
          MediaStore.Audio.Media.DATA,
          MediaStore.Audio.Media.SIZE,
          MediaStore.Audio.Media.DATE_ADDED,
          MediaStore.Audio.Media.ALBUM_ID
      };
      Cursor cursor = contentResolver.query(uri, projection, null, null, null);
      if (cursor != null) {
        WritableArray audioList = Arguments.createArray();
        while (cursor.moveToNext()) {
          String id = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media._ID));
          String title = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.TITLE));
          String artist = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ARTIST));
          String album = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ALBUM));
          int duration = cursor.getInt(cursor.getColumnIndex(MediaStore.Audio.Media.DURATION));
          String audioUrl = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DATA));
          String size = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.SIZE));
          String addedDate = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DATE_ADDED));
          audioUrl = "file://" + audioUrl;

          String albumId = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ALBUM_ID));
          Uri imageUrl = Uri.parse("content://media/external/audio/albumart/" + albumId);

          WritableMap audioMap = Arguments.createMap();
          audioMap.putString("id", id);
          audioMap.putString("title", title);
          audioMap.putString("artist", artist);
          audioMap.putString("album", album);
          audioMap.putInt("duration", duration);
          audioMap.putString("audioUrl", audioUrl);
          audioMap.putString("size", size);
          audioMap.putString("addedDate", addedDate);
          audioMap.putString("imageUrl", imageUrl.toString());
          audioList.pushMap(audioMap);
      }
      cursor.close();
      promise.resolve(audioList);
    }else {
      promise.reject("FETCH_FAILED", "Failed to fetch audio files");
    }
  }
}
