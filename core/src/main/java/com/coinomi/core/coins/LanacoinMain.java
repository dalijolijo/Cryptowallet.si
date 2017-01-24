package com.coinomi.core.coins;

import com.coinomi.core.coins.families.PeerFamily;

/**
 * @author John L. Jegutanis
 */
public class LanacoinMain extends PeerFamily {
    private LanacoinMain() {
        id = "lanacoin.main";

        addressHeader = 48;
        p2shHeader = 5;
        acceptableAddressCodes = new int[] { addressHeader, p2shHeader };
        spendableCoinbaseDepth = 15;
        dumpedPrivateKeyHeader = 176;

        name = "Lanacoin";
        symbol = "LANA";
        uriScheme = "lanacoin";
        bip44Index = 10;
        unitExponent = 8;
        feeValue = value(100); // 0.000001 LANA
        minNonDust = value(1);
        softDustLimit = value(1000000); // 0.01 LANA
        softDustPolicy = SoftDustPolicy.AT_LEAST_BASE_FEE_IF_SOFT_DUST_TXO_PRESENT;
        signedMessageHeader = toBytes("LanaCoin Signed Message:\n");
    }

    private static LanacoinMain instance = new LanacoinMain();
    public static synchronized CoinType get() {
        return instance;
    }
}
