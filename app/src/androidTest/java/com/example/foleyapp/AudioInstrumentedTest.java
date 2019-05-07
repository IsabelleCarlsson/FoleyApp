package com.example.foleyapp;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class AudioInstrumentedTest {
    @Test
    public void audioTest() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        AudioManager audioManager = new AudioManager(appContext);
        audioManager.play(Sound.BEE);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
