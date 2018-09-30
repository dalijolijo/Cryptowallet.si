package com.coinomi.wallet.tasks;

import android.os.AsyncTask;

public abstract class GenericTask<T> extends AsyncTask<Integer, Void, T> {

    private HttpRequestsFactory.Response<T> response;

    public GenericTask(HttpRequestsFactory.Response<T> response) {
        this.response = response;
    }

    @Override
    protected T doInBackground(Integer...params) {
        return processData();
    }

    @Override
    protected void onPostExecute(T t) {
        if (response != null) {
            response.onSuccess(t);
        }
    }

    protected abstract T processData();
}
