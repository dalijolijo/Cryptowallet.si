package com.coinomi.core.coins;

import com.coinomi.core.coins.families.PeerFamily;

/**
 * @author John L. Jegutanis
 */
public class AquariuscoinMain extends PeerFamily {
    private AquariuscoinMain() {
        id = "aquariuscoin.main";

        addressHeader = 23;
        p2shHeader = 5;
        acceptableAddressCodes = new int[] { addressHeader, p2shHeader };
        spendableCoinbaseDepth = 20;
        dumpedPrivateKeyHeader = 151;

        name = "Aquariuscoin";
        symbol = "ARCO";
        uriScheme = "aquariuscoin";
        bip44Index = 10;
        unitExponent = 8;
        feeValue = value(10000); // 0.0001 ARCO
        minNonDust = value(1);
        softDustLimit = value(1000000); // 0.01 ARCO
        softDustPolicy = SoftDustPolicy.AT_LEAST_BASE_FEE_IF_SOFT_DUST_TXO_PRESENT;
        signedMessageHeader = toBytes("AquariusCoin Signed Message:\n");
    }

    private static AquariuscoinMain instance = new AquariuscoinMain();
    public static synchronized CoinType get() {
        return instance;
    }
}
