package com.coinomi.core.coins;

import com.coinomi.core.coins.families.BitFamily;
import com.coinomi.core.PartnersInfoData;
import com.coinomi.core.coins.nxt.Constants;

/**
 * @author dalijolijo
 */
public class BitcloudMain extends BitFamily implements PartnersInfoData {
    private BitcloudMain() {
        id = "bitcloud.main";

        addressHeader = 25;
        p2shHeader = 5;
        acceptableAddressCodes = new int[] { addressHeader, p2shHeader };
        spendableCoinbaseDepth = 100;
        dumpedPrivateKeyHeader = 128;

        name = "Bitcloud";
        symbol = "BTDX";
        uriScheme = "bitcloud";
        bip44Index = 218;
        unitExponent = 8;
        feeValue = value(100000);
        minNonDust = value(1000); // 0.00001 BTDX mininput
        //softDustLimit = value(100000); // 0.001 LTC
        softDustLimit = value(100000); // 0.001 BTDX
        softDustPolicy = SoftDustPolicy.BASE_FEE_FOR_EACH_SOFT_DUST_TXO;
        signedMessageHeader = toBytes("Diamond Signed Message:\n");
    }

    private static BitcloudMain instance = new BitcloudMain();
    public static synchronized CoinType get() {
        return instance;
    }
    @Override
    public String getPartnerUrl() {
        return Constants.PARTNERS_URI_MEC;
    }
}
