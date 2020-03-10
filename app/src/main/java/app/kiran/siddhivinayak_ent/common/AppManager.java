package app.kiran.siddhivinayak_ent.common;

import android.content.Context;

import app.kiran.siddhivinayak_ent.utils.Utils;

public class AppManager {
    private static AppManager appManager;
    private Context context;
    private PrefManager prefManager;
    private Utils utils;

    public AppManager(Context mContext) {
        this.context = mContext;
    }

    public static AppManager getInstance(Context mContext) {
        if (appManager == null) {
            appManager = new AppManager(mContext);
        }
        return appManager;
    }
    public Context getApplicationContext() {
        return this.context;
    }

    public void setPrefManager(PrefManager prefManager) {
        this.prefManager = prefManager;
    }

    public PrefManager getPrefManager() {
        return this.prefManager;
    }


    public void setUtils(Utils utils) {
        this.utils = utils;
    }

    public Utils getUtils() {
        return utils;
    }

}
