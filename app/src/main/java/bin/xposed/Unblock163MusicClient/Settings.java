package bin.xposed.Unblock163MusicClient;

import java.lang.ref.WeakReference;

import de.robv.android.xposed.XSharedPreferences;

public class Settings {
    private static WeakReference<XSharedPreferences> xSharedPreferences = new WeakReference<>(null);

    private static XSharedPreferences getModuleSharedPreferences() {
        XSharedPreferences preferences = xSharedPreferences.get();
        if (preferences == null) {
            preferences = new XSharedPreferences(BuildConfig.APPLICATION_ID);
            preferences.makeWorldReadable();
            xSharedPreferences = new WeakReference<>(preferences);
        } else {
            preferences.reload();
        }
        return preferences;
    }


    public static boolean isUnblockEnabled() {
        return getModuleSharedPreferences().getBoolean("UNBLOCK", false);
    }

    public static boolean isOverseaModeEnabled() {
        return getModuleSharedPreferences().getBoolean("OVERSEA_MODE", false);
    }

    public static boolean isConfirmDislikeEnabled() {
        return getModuleSharedPreferences().getBoolean("DISLIKE_CONFIRM", false);
    }

    public static boolean isPreventGrayEnabled() {
        return getModuleSharedPreferences().getBoolean("PREVENT_GRAY", false);
    }

    static String getDnsServer() {
        return "219.141.140.10";
    }

}
