package app.kiran.siddhivinayak_ent;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import app.kiran.siddhivinayak_ent.common.AppManager;
import app.kiran.siddhivinayak_ent.common.PrefConst;
import app.kiran.siddhivinayak_ent.common.PrefManager;

public class MyApplication extends Application {

    private static AppManager appManager;
    private static Context context;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private PrefManager prefManager;

    public static AppManager getAppManager() {
        if (appManager == null) {
            appManager = AppManager.getInstance(getAppContext());
        }
        return appManager;
    }

    public static Context getAppContext() {
        return context;
    }
    public static void setAppManager(AppManager am) {
        appManager = am;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        if (context == null){
            context = getApplicationContext();
        }
        initBasic();
    }

    public void initBasic(){
        if (appManager == null){
            appManager = AppManager.getInstance(getApplicationContext());
        }
        if (sharedPreferences == null){
            sharedPreferences = getApplicationContext().getSharedPreferences(PrefConst.PREF_FILE, MODE_PRIVATE);
        }
        if (editor==null){
            editor = sharedPreferences.edit();
        }
        if (prefManager == null){
            prefManager = new PrefManager(sharedPreferences, editor);
        }
        appManager.setPrefManager(prefManager);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }
}
