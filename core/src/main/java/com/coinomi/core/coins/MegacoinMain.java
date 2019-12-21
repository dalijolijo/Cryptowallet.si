package com.coinomi.core.coins;

import com.coinomi.core.coins.families.BitFamily;
import com.coinomi.core.PartnersInfoData;
import com.coinomi.core.coins.nxt.Constants;

/**
 * @author dalijolijo
 */
public class MegacoinMain extends BitFamily implements PartnersInfoData {
    private MegacoinMain() {
        id = "megacoin.main";

        addressHeader = 50;
        p2shHeader = 5;
        acceptableAddressCodes = new int[] { addressHeader, p2shHeader };
        spendableCoinbaseDepth = 100;
        dumpedPrivateKeyHeader = 128;

        name = "Megacoin";
        symbol = "MEC";
        uriScheme = "megacoin";
        bip44Index = 217;
        unitExponent = 8;
        feeValue = value(100000);
        minNonDust = value(1000); // 0.00001 MEC mininput
        //softDustLimit = value(100000); // 0.001 LTC
        softDustLimit = value(100000); //  0.001 MEC
        softDustPolicy = SoftDustPolicy.BASE_FEE_FOR_EACH_SOFT_DUST_TXO;
        signedMessageHeader = toBytes("MegaCoin Signed Message:\n");
    }

    private static MegacoinMain instance = new MegacoinMain();
    public static synchronized CoinType get() {
        return instance;
    }
    @Override
    public String getPartnerUrl() {
        return Constants.PARTNERS_URI_MEC;
    }
}
