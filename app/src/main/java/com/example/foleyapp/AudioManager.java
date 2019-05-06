package com.example.foleyapp;

import android.content.Context;
import android.media.SoundPool;
import android.util.Log;

import java.util.HashMap;
import java.util.Map;

class AudioManager implements SoundPool.OnLoadCompleteListener {
    private Map<Sound, Integer> soundIds;
    private SoundPool soundPool;
    private int loadId;
    private boolean ready;

    AudioManager(Context context) {
        soundIds = new HashMap<>();
        soundPool = new SoundPool(5, android.media.AudioManager.STREAM_MUSIC, 0);
        soundPool.setOnLoadCompleteListener(this);

        soundPool.load(context, R.raw.bee, 0);
        soundPool.load(context, R.raw.can, 0);
        soundPool.load(context, R.raw.cat, 0);
        soundPool.load(context, R.raw.cough, 0);
        soundPool.load(context, R.raw.cow, 0);
        soundPool.load(context, R.raw.engine, 0);
        soundPool.load(context, R.raw.frog, 0);
        soundPool.load(context, R.raw.hammering, 0);
        soundPool.load(context, R.raw.hello, 0);
        soundPool.load(context, R.raw.pig, 0);
        soundPool.load(context, R.raw.sigh, 0);
        soundPool.load(context, R.raw.velcro, 0);
    }

    @Override
    public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {
        this.ready = status == 0;

        Sound sound = Sound.values()[loadId++];
        Log.i("AudioManager", "loaded sound: " + sound);
        soundIds.put(sound, sampleId);
    }

    boolean isReady() {
        return ready;
    }

    void play(Sound sound) {
        Integer id = soundIds.get(sound);
        assert id != null;
        soundPool.play(id, 1, 1, 1, 0, 1);
    }
}

