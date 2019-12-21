package com.coinomi.core.coins;

import com.coinomi.core.coins.families.BitFamily;
import com.coinomi.core.PartnersInfoData;
import com.coinomi.core.coins.nxt.Constants;

/**
 * @author dalijolijo
 */
public class BitsendMain extends BitFamily implements PartnersInfoData {
    private BitsendMain() {
        id = "bitsend.main";

        addressHeader = 102;
        p2shHeader = 5;
        acceptableAddressCodes = new int[] { addressHeader, p2shHeader };
        spendableCoinbaseDepth = 100;
        dumpedPrivateKeyHeader = 128;

        name = "Bitsend";
        symbol = "BSD";
        uriScheme = "bitsend";
        bip44Index = 91;
        unitExponent = 8;
        feeValue = value(100000);
        minNonDust = value(1000); // 0.00001 BSD mininput
        //softDustLimit = value(100000); // 0.001 LTC
        softDustLimit = value(100000); // 0.001 BSD
        softDustPolicy = SoftDustPolicy.BASE_FEE_FOR_EACH_SOFT_DUST_TXO;
        signedMessageHeader = toBytes("Bitsend Signed Message:\n");
    }

    private static BitsendMain instance = new BitsendMain();
    public static synchronized CoinType get() {
        return instance;
    }

    @Override
    public String getPartnerUrl() {
        return Constants.PARTNERS_URI_BSD;
    }
}
