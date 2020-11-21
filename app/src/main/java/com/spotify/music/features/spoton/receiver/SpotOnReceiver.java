package com.spotify.music.features.spoton.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.KeyEvent;

public class SpotOnReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent startPlayAppleMusic = new Intent().setClassName("com.apple.android.music", "com.apple.android.music.player.MediaPlaybackService");
        startPlayAppleMusic.setAction(Intent.ACTION_MEDIA_BUTTON);
        KeyEvent keyEvent = new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_MEDIA_PLAY);
        startPlayAppleMusic.putExtra(Intent.EXTRA_KEY_EVENT, keyEvent);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            context.startForegroundService(startPlayAppleMusic);
        } else {
            context.startService(startPlayAppleMusic);
        }
    }
}
