package com.coinomi.core.coins;

import com.google.bitcoin.core.Coin;

/**
 * @author Giannis Dzegoutanis
 */
public class BitcoinMain extends CoinType {
    public BitcoinMain() {
        id = "bitcoin.main";

        addressHeader = 0;
        p2shHeader = 5;
        acceptableAddressCodes = new int[] { addressHeader, p2shHeader };

        name = "Bitcoin";
        symbol = "BTC";
        uriScheme = "bitcoin";
        bip44Index = 0;
        feePerKb = Coin.valueOf(10000);
        minNonDust = Coin.valueOf(5460);
    }

    private static BitcoinMain instance;
    public static synchronized BitcoinMain get() {
        if (instance == null) {
            instance = new BitcoinMain();
        }
        return instance;
    }
}
