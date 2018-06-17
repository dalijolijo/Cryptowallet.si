package com.coinomi.core.coins;

import com.coinomi.core.coins.families.PeerFamily;

/**
 * @author John L. Jegutanis
 */
public class NetkoMain extends PeerFamily {
    private NetkoMain() {
        id = "netko.main";

        addressHeader = 53;
        p2shHeader = 5;
        acceptableAddressCodes = new int[] { addressHeader, p2shHeader };
        spendableCoinbaseDepth = 300;
        dumpedPrivateKeyHeader = 177;

        name = "Netko";
        symbol = "Netko";
        uriScheme = "netko";
        bip44Index = 10;
        unitExponent = 8;
        feeValue = value(100); // 0.000001 NETKO
        minNonDust = value(1);
        softDustLimit = value(1000000); // 0.01 NETKO
        softDustPolicy = SoftDustPolicy.AT_LEAST_BASE_FEE_IF_SOFT_DUST_TXO_PRESENT;
        signedMessageHeader = toBytes("Netko Signed Message:\n");
    }

    private static NetkoMain instance = new NetkoMain();
    public static synchronized CoinType get() {
        return instance;
    }
}
