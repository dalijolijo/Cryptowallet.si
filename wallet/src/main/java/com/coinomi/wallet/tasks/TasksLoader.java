package com.coinomi.wallet.tasks;

import java.util.List;

public enum TasksLoader {
    INSTANCE;

    public void loadPartnersData(HttpRequestsFactory.Response<List<GetPartnersDataTask.PartnerData>> responseListener, String uri) {
        new GetPartnersDataTask(responseListener, uri).execute(0);
    }
}
