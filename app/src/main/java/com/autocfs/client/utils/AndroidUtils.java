package com.autocfs.client.utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

public class AndroidUtils {

    public static void replaceFragment(FragmentManager manager, int containerId, Fragment fragment) {
        manager.beginTransaction()
                .replace(containerId, fragment)
                .commit();
    }


}
