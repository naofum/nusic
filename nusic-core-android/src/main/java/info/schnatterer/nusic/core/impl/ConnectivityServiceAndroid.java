/**
 * Copyright (C) 2013 Johannes Schnatterer
 *
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 *
 * This file is part of nusic.
 *
 * nusic is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * nusic is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with nusic.  If not, see <http://www.gnu.org/licenses/>.
 */
package info.schnatterer.nusic.core.impl;

import info.schnatterer.nusic.core.ConnectivityService;
import info.schnatterer.nusic.core.PreferencesService;

import javax.inject.Inject;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Provides access to information about the internet connection via android's
 * APIs.
 * 
 * @author schnatterer
 *
 */
public class ConnectivityServiceAndroid implements ConnectivityService {
    @Inject
    private PreferencesService preferencesService;
    @Inject
    private Context context;

    @Override
    public boolean isOnline() {
        boolean state = false;
        final boolean isOnlyOnWifi = preferencesService.isUseOnlyWifi();

        /* Monitor network connections */
        final ConnectivityManager connectivityManager = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);

        /* Wi-Fi connection */
        final NetworkInfo wifiNetwork = connectivityManager
                .getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        if (wifiNetwork != null) {
            state = wifiNetwork.isConnectedOrConnecting();
        }

        /* Mobile data connection */
        final NetworkInfo mobileNetwork = connectivityManager
                .getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        if (mobileNetwork != null) {
            if (!isOnlyOnWifi) {
                state = mobileNetwork.isConnectedOrConnecting();
            }
        }

        /* Other networks */
        final NetworkInfo activeNetwork = connectivityManager
                .getActiveNetworkInfo();
        if (activeNetwork != null) {
            if (!isOnlyOnWifi) {
                state = activeNetwork.isConnectedOrConnecting();
            }
        }

        return state;
    }
}
