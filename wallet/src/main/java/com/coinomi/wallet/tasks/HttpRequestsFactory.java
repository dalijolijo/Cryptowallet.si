package com.coinomi.wallet.tasks;

import android.util.Log;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;

@SuppressWarnings("WeakerAccess")
public class HttpRequestsFactory {

    public interface Response<T> {
        void onSuccess(T data);
    }

    private static final int TIMEOUT = 10000; // in milli seconds

    private static <T> T createGetRequest(String url, Class<T> classType) {
        return createGetRequest(url, (Type) classType);
    }

    public static <T> T createGetRequest(String url, Type type) {
        T response = null;
        HttpURLConnection c = null;

        try {
            URL u = new URL(url);
            c = (HttpURLConnection) u.openConnection();
            c.setRequestMethod("GET");
            c.setRequestProperty("Content-length", "0");
            c.setUseCaches(false);
            c.setAllowUserInteraction(false);
            c.setConnectTimeout(TIMEOUT);
            c.setReadTimeout(TIMEOUT);
            c.connect();
            int status = c.getResponseCode();
            Log.d("REQUEST =>", ": response=> status: " + status);
            switch (status) {
                case 200:
                case 201:
                    response = new Gson().fromJson(new InputStreamReader(c.getInputStream()), type);
                    break;
            }
        } catch (IOException ex) {
            Log.e("REQUEST =>" + url, "Error: ", ex);
        } finally {
            if (c != null) {
                try {
                    c.disconnect();
                } catch (Exception ignored) {
                }
            }
        }
        return response;
    }
}
