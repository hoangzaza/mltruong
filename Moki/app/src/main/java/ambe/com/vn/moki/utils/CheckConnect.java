package ambe.com.vn.moki.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by AMBE on 20/06/2017.
 */

public class CheckConnect {
    public static boolean isNetworkConnected(Context context) {
        boolean isConnectedWifi = false;
        boolean isConnectedMobile = false;
        ConnectivityManager cn = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo[] networkInfos = cn.getAllNetworkInfo();
        for (NetworkInfo ni : networkInfos) {
            if (ni.getTypeName().equalsIgnoreCase("WIFI"))
                if (ni.isConnected())
                    isConnectedWifi = true;
            if (ni.getTypeName().equalsIgnoreCase("MOBILE"))
                if (ni.isConnected())
                    isConnectedMobile = true;

        }

        return isConnectedMobile || isConnectedWifi;
    }
}
