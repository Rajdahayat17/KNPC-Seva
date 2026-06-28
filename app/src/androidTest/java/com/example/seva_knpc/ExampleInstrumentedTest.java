package com.example.seva_knpc;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Object InstrumentationRegistry = null;
        byte[] appContext = InstrumentationRegistry.toString().getBytes();
        assertEquals("com.example.seva_knpc", String.valueOf(appContext.getClass()));
    }

    private void assertEquals(String s, String packageName) {

    }
}