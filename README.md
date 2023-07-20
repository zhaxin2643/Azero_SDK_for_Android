1.原始录音需求保存可以查看：
BasexRecord类，打开下面注释即可
//FileUtils.writeFile(data,"/sdcard/basexdata.pcm",true);

2.查看asr录音：
OpenDenoiseManager类，打开下面注释即可
//FileUtils.writeFile(data,"/sdcard/asrdata.pcm",true);

3.现在的程序是直接跑在开发板上面的，详见MyApplication类注释，如果需要使用在手机上测试使用SystemRecord即可：
//手机使用下面这个SystemRecord
//AudioInputManager audioInputManager = new AudioInputManager(this, new SystemRecord());
//开发板使用下面这个BasexRecord
AudioInputManager audioInputManager = new AudioInputManager(this, new BasexRecord());


