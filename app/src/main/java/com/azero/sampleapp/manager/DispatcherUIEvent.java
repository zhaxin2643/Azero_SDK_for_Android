package com.azero.sampleapp.manager;

import com.azero.sampleapp.widget.IUIListener;
import com.azero.sdk.util.log;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by weijianqiang
 * On 2021/6/25
 * Description:
 */
public class DispatcherUIEvent {
    private static DispatcherUIEvent mDispatcherUIEvent;

    private CopyOnWriteArrayList<IUIListener> iuiListenerList;

    private boolean isAlreadStop;
    private DispatcherUIEvent(){
        iuiListenerList = AzeroUiManager.getInstance().getUiListenerList();
    }

    public static DispatcherUIEvent getInstance(){
        if (mDispatcherUIEvent == null){
            synchronized (DispatcherUIEvent.class){
                if (mDispatcherUIEvent == null){
                    mDispatcherUIEvent = new DispatcherUIEvent();
                }
            }
        }
        return mDispatcherUIEvent;
    }


    public void dispatchWakeUpEvent(){
        log.d("dispatchWakeUpEvent:"+iuiListenerList.size());
        for (IUIListener listener:iuiListenerList){
            listener.onWakeUp();
        }
    }

    public void dispatchRecordStartEvent(){
        log.d("dispatchRecordStartEvent:"+iuiListenerList.size());
        isAlreadStop = false;
        for (IUIListener listener:iuiListenerList){
            listener.onRecordStart();
        }
    }

    /**
     * 正在录音是调用此接口
     * @param volume 音量大小
     * @param asrText 流式识别文本
     */
    public void dispatchRecordingEvent(int volume,String asrText){
        //优化结束以后依然调用dispatchRecordingEvent
        log.d("dispatchRecordingEvent:"+iuiListenerList.size());
        if (! isAlreadStop){
            for (IUIListener listener:iuiListenerList){
                listener.onRecording(volume,asrText);
            }
        }
    }

    /**
     * 停止灌输数据时调用此接口，如检测到vad后端点。
     */
    public void dispatchRecordStopEvent(){
        isAlreadStop = true;
        for (IUIListener listener:iuiListenerList){
            listener.onRecordStop();
        }
    }

    /**
     * 开始进行语义的识别
     */
    public void dispatchRecognizeStartEvent(){
        for (IUIListener listener:iuiListenerList){
            listener.onRecognizeStart();
        }
    }

    /**
     * 语义识别结束
     */
    void dispatchRecognizeEndEvent(){
        for (IUIListener listener:iuiListenerList){
            listener.onRecognizeEnd();
        }
    }

}
