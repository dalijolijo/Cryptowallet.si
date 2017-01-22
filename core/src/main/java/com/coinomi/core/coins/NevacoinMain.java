package com.coinomi.core.coins;

import com.coinomi.core.coins.families.PeerFamily;

/**
 * @author John L. Jegutanis
 */
public class NevacoinMain extends PeerFamily {
    private NevacoinMain() {
        id = "nevacoin.main";

        addressHeader = 53;
        p2shHeader = 5;
        acceptableAddressCodes = new int[] { addressHeader, p2shHeader };
        spendableCoinbaseDepth = 25;
        dumpedPrivateKeyHeader = 177;

        name = "Nevacoin";
        symbol = "NEVA";
        uriScheme = "nevacoin";
        bip44Index = 10;
        unitExponent = 8;
        feeValue = value(100); // 0.000001 NEVA
        minNonDust = value(1);
        softDustLimit = value(1000000); // 0.01 BLK
        softDustPolicy = SoftDustPolicy.AT_LEAST_BASE_FEE_IF_SOFT_DUST_TXO_PRESENT;
        signedMessageHeader = toBytes("NevaCoin Signed Message:\n");
    }

    private static NevacoinMain instance = new NevacoinMain();
    public static synchronized CoinType get() {
        return instance;
    }
}
