package com.coinomi.core.coins;

import com.coinomi.core.coins.families.PeerFamily;

/**
 * @author John L. Jegutanis
 */
public class TajcoinMain extends PeerFamily {
    private TajcoinMain() {
        id = "tajcoin.main";

        addressHeader = 65;
        p2shHeader = 5;
        acceptableAddressCodes = new int[] { addressHeader, p2shHeader };
        spendableCoinbaseDepth = 33;
        dumpedPrivateKeyHeader = 111;

        name = "Tajcoin";
        symbol = "TAJ";
        uriScheme = "tajcoin";
        bip44Index = 10;
        unitExponent = 8;
        feeValue = value(100); // 0.000001 TAJ
        minNonDust = value(1);
        softDustLimit = value(1000000); // 0.01 TAJ
        softDustPolicy = SoftDustPolicy.AT_LEAST_BASE_FEE_IF_SOFT_DUST_TXO_PRESENT;
        signedMessageHeader = toBytes("TajCoin Signed Message:\n");
    }

    private static TajcoinMain instance = new TajcoinMain();
    public static synchronized CoinType get() {
        return instance;
    }
}
