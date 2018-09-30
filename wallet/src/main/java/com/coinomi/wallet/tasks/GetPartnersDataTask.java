package com.coinomi.wallet.tasks;

import com.coinomi.wallet.Constants;
import com.google.gson.reflect.TypeToken;

import java.util.List;

public class GetPartnersDataTask extends GenericTask<List<GetPartnersDataTask.PartnerData>> {

    public GetPartnersDataTask(HttpRequestsFactory.Response<List<PartnerData>> response) {
        super(response);
    }

    @Override
    protected List<PartnerData> processData() {
        return HttpRequestsFactory.createGetRequest(Constants.PARTNERS_URI, new TypeToken<List<PartnerData>>(){}.getType());
    }

    public class PartnerData {
        public String imageUrl;
        public String link;
    }
}
