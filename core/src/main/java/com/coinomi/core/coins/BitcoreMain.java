package com.coinomi.core.coins;

import com.coinomi.core.coins.families.BitFamily;
import com.coinomi.core.PartnersInfoData;
import com.coinomi.core.coins.nxt.Constants;

/**
 * @author dalijolijo
 */
public class BitcoreMain extends BitFamily implements PartnersInfoData {
    private BitcoreMain() {
        id = "bitcore.main";

        addressHeader = 3;
        p2shHeader = 125;
        acceptableAddressCodes = new int[] { addressHeader, p2shHeader };
        spendableCoinbaseDepth = 100;
        dumpedPrivateKeyHeader = 128;

        name = "Bitcore";
        symbol = "BTX";
        uriScheme = "bitcore";
        bip44Index = 160;
        unitExponent = 8;
        feeValue = value(100000);
        minNonDust = value(1000); // 0.00001 BTX mininput
        //softDustLimit = value(100000); // 0.001 LTC
        softDustLimit = value(55000); // 0.00055 BTX
        softDustPolicy = SoftDustPolicy.BASE_FEE_FOR_EACH_SOFT_DUST_TXO;
        signedMessageHeader = toBytes("BitCore Signed Message:\n");
    }

    private static BitcoreMain instance = new BitcoreMain();
    public static synchronized CoinType get() {
        return instance;
    }

    @Override
    public String getPartnerUrl() {
        return Constants.PARTNERS_URI_BTX;
    }
}
