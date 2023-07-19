package com.azero.sampleapp.widget;

/**
 * Created by weijianqiang
 * On 2021/6/23
 * Description:
 */
public interface IUIListener {

    /**
     * 语音唤醒回调
     */
    void onWakeUp();

    /**
     * 唤醒后，检测到有效录音会向azero云端灌输数据，开始灌输数据时此接口回调
     */
    void onRecordStart();

    /**
     * 正在录音是调用此接口
     * @param volume 音量大小
     * @param asrText 流式识别文本
     */
    void onRecording(int volume,String asrText);

    /**
     * 停止灌输数据时调用此接口，如检测到vad后端点。
     */
    void onRecordStop();

    /**
     * 开始进行语义的识别
     */
    void onRecognizeStart();

    /**
     * 语义识别结束
     */
    void onRecognizeEnd();
}
