package com.coinomi.core.coins;

import com.coinomi.core.coins.families.BitFamily;

/**
 * @author dalijolijo
 */
public class BitsendMain extends BitFamily {
    private BitsendMain() {
        id = "bitsend.main";

        addressHeader = 3;
        p2shHeader = 125;
        acceptableAddressCodes = new int[] { addressHeader, p2shHeader };
        spendableCoinbaseDepth = 100;
        dumpedPrivateKeyHeader = 128;

        name = "Bitsend";
        symbol = "BSD";
        uriScheme = "bitsend";
        bip44Index = 160;
        unitExponent = 8;
        feeValue = value(100000);
        minNonDust = value(1000); // 0.00001 BSD mininput
        //softDustLimit = value(100000); // 0.001 LTC
        softDustLimit = value(55000); // 0.00055 BSD
        softDustPolicy = SoftDustPolicy.BASE_FEE_FOR_EACH_SOFT_DUST_TXO;
        signedMessageHeader = toBytes("BitSend Signed Message:\n");
    }

    private static BitsendMain instance = new BitsendMain();
    public static synchronized CoinType get() {
        return instance;
    }
}
