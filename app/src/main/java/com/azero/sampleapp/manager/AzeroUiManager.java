package com.azero.sampleapp.manager;

import com.azero.sampleapp.widget.IUIListener;

import java.util.concurrent.CopyOnWriteArrayList;

public class AzeroUiManager {
    private static volatile AzeroUiManager instance;
    private CopyOnWriteArrayList<IUIListener> mUiListenerList;

    private AzeroUiManager(){}

    public static AzeroUiManager getInstance() {
        if (instance == null) {
            synchronized (AzeroUiManager.class) {
                if (instance == null) {
                    instance = new AzeroUiManager();
                }
            }
        }
        return instance;
    }

    /**
     * 注册UI回调接口
     * @return
     */
    public CopyOnWriteArrayList<IUIListener> getUiListenerList(){
        if (mUiListenerList == null){
            mUiListenerList = new CopyOnWriteArrayList<>();
        }
        return mUiListenerList;
    }

    /**
     * 注册UI回调接口
     * @param iuiListener UI回调
     */
    public void registerUIListener(IUIListener iuiListener){
        if (iuiListener != null && !getUiListenerList().contains(iuiListener)){
            getUiListenerList().add(iuiListener);
        }
    }

    /**
     * 删除UI回调接口
     * @param iuiListener UI回调
     */
    public void unRegisterUIListener(IUIListener iuiListener){
        if (iuiListener != null && getUiListenerList().contains(iuiListener)){
            getUiListenerList().remove(iuiListener);
        }
    }
}
