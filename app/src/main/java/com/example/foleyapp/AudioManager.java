package com.example.foleyapp;

import android.content.Context;
import android.media.SoundPool;

class AudioManager {
    private SoundPool soundPool;
    private int sampleId;
    private boolean loadedOkay;

    AudioManager(Context context) {
        soundPool = new SoundPool(5, android.media.AudioManager.STREAM_MUSIC, 0);
        soundPool.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
            @Override
            public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {
                loadedOkay = status == 0;
                if (loadedOkay) {
                    AudioManager.this.sampleId = sampleId;
                }
            }
        });
        soundPool.load(context, R.raw.bee, 0);
    }

    void play(Sound sound) {
        if (!loadedOkay) return;

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

        soundPool.play(sampleId, 1, 1, 1, 0, 1);
    }

    void resume() {
        soundPool.autoResume();
    }
    void pause() {
        soundPool.autoPause();
    }
}

