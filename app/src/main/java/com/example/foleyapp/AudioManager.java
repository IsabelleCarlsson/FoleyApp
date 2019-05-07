package com.example.foleyapp;

import android.content.Context;
import android.media.SoundPool;

class AudioManager implements SoundPool.OnLoadCompleteListener {
    private Context context;
    private SoundPool soundPool;

    AudioManager(Context context) {
        this.context = context;
        soundPool = new SoundPool(5, android.media.AudioManager.STREAM_MUSIC, 0);
        soundPool.setOnLoadCompleteListener(this);
    }

    @Override
    public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {
        boolean ready = status == 0;
        if (ready) {
            soundPool.play(sampleId, 1, 1, 1, 0, 1);
        }
    }

    void play(Sound sound) {
        int sampleId;
        switch (sound) {
            case BEE:
                sampleId = R.raw.bee;
                break;
            case CAN:
                sampleId = R.raw.can;
                break;
            case CAT:
                sampleId = R.raw.cat;
                break;
            case COUGH:
                sampleId = R.raw.cough;
                break;
            case COW:
                sampleId = R.raw.cow;
                break;
            case ENGINE:
                sampleId = R.raw.engine;
                break;
            case FROG:
                sampleId = R.raw.frog;
                break;
            case HAMMERING:
                sampleId = R.raw.hammering;
                break;
            case HELLO:
                sampleId = R.raw.hello;
                break;
            case PIG:
                sampleId = R.raw.pig;
                break;
            case SIGH:
                sampleId = R.raw.sigh;
                break;
            case VELCRO:
                sampleId = R.raw.velcro;
                break;
            default:
                sampleId = 0;
        }
        soundPool.load(context, sampleId, 0);
    }
}

