package com.azero.sampleapp.widget;

import android.util.Log;

import com.azero.sdk.AzeroManager;
import com.azero.sdk.impl.SpeechRecognizer.AbsSpeechRecognizer;


/**
 * Created by weijianqiang
 * On 2021/6/25
 * Description:
 */
public class UIListenerImpl implements IUIListener {
    private static final String TAG = "UIListenerImpl";
    
    @Override
    public void onWakeUp() {
        Log.d(TAG, "onWakeUp: ");
    }

    @Override
    public void onRecordStart() {
        Log.d(TAG, "onRecordStart: ");
    }

    @Override
    public void onRecording(int volume, String asrText) {
        Log.d(TAG, "onRecording: ");
    }

    @Override
    public void onRecordStop() {
        Log.d(TAG, "onRecordStop: ");
    }

    @Override
    public void onRecognizeStart() {
        Log.d(TAG, "onRecognizeStart: ");
    }

    @Override
    public void onRecognizeEnd() {
        Log.d(TAG, "onRecognizeEnd: ");
    }
}
