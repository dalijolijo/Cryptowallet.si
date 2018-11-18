package com.coinomi.wallet.tasks;

import java.util.List;

public enum TasksLoader {
    INSTANCE;

    private GenericTask<List<GetPartnersDataTask.PartnerData>> partnersTask;

    public void loadPartnersData(HttpRequestsFactory.Response<List<GetPartnersDataTask.PartnerData>> responseListener) {
        partnersTask = new GetPartnersDataTask(responseListener);
        partnersTask.execute(0);
    }
}
