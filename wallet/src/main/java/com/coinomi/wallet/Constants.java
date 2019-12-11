package com.coinomi.wallet;

import android.text.format.DateUtils;

import com.coinomi.core.coins.BitcoreMain;
import com.coinomi.core.coins.BitcoinMain;
import com.coinomi.core.coins.BitsendMain;
import com.coinomi.core.coins.BitcloudMain;
import com.coinomi.core.coins.MegacoinMain;
import com.coinomi.core.coins.CoinID;
import com.coinomi.core.coins.CoinType;
import com.coinomi.core.network.CoinAddress;
import com.coinomi.stratumj.ServerAddress;
import com.google.common.collect.ImmutableList;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author John L. Jegutanis
 * @author Andreas Schildbach
 */
public class Constants {

    public static final int SEED_ENTROPY_DEFAULT = 192;
    public static final int SEED_ENTROPY_EXTRA = 256;

    public static final String ARG_SEED = "seed";
    public static final String ARG_PASSWORD = "password";
    public static final String ARG_SEED_PASSWORD = "seed_password";
    public static final String ARG_EMPTY_WALLET = "empty_wallet";
    public static final String ARG_SEND_TO_ADDRESS = "send_to_address";
    public static final String ARG_SEND_TO_COIN_TYPE = "send_to_coin_type";
    public static final String ARG_SEND_TO_ACCOUNT_ID = "send_to_account_id";
    public static final String ARG_SEND_VALUE = "send_value";
    public static final String ARG_TX_MESSAGE = "tx_message";
    public static final String ARG_COIN_ID = "coin_id";
    public static final String ARG_ACCOUNT_ID = "account_id";
    public static final String ARG_MULTIPLE_COIN_IDS = "multiple_coin_ids";
    public static final String ARG_MULTIPLE_CHOICE = "multiple_choice";
    public static final String ARG_SEND_REQUEST = "send_request";
    public static final String ARG_TRANSACTION_ID = "transaction_id";
    public static final String ARG_ERROR = "error";
    public static final String ARG_MESSAGE = "message";
    public static final String ARG_ADDRESS = "address";
    public static final String ARG_ADDRESS_STRING = "address_string";
    public static final String ARG_EXCHANGE_ENTRY = "exchange_entry";
    public static final String ARG_URI = "test_wallet";
    public static final String ARG_PRIVATE_KEY = "private_key";
    public static final String ARG_ADDRESS_TYPE_ERROR = "address_type_error";

    public static final int PERMISSIONS_REQUEST_CAMERA = 0;

    public static final String WALLET_FILENAME_PROTOBUF = "wallet";
    public static final long WALLET_WRITE_DELAY = 5;
    public static final TimeUnit WALLET_WRITE_DELAY_UNIT = TimeUnit.SECONDS;

    public static final long STOP_SERVICE_AFTER_IDLE_SECS = 30 * 60; // 30 mins

    public static final String HTTP_CACHE_NAME = "http_cache";
    public static final int HTTP_CACHE_SIZE = 256 * 1024; // 256 KiB
    public static final int NETWORK_TIMEOUT_MS = 15 * (int) DateUtils.SECOND_IN_MILLIS;

    public static final String TX_CACHE_NAME = "tx_cache";
    public static final int TX_CACHE_SIZE = 5 * 1024 * 1024; // 5 MiB, TODO currently not enforced

    public static final long RATE_UPDATE_FREQ_MS = 30 * DateUtils.SECOND_IN_MILLIS;

    /** Default currency to use if all default mechanisms fail. */
    public static final String DEFAULT_EXCHANGE_CURRENCY = "USD";

    public static final Charset UTF_8 = Charset.forName("UTF-8");
    public static final Charset US_ASCII = Charset.forName("US-ASCII");

    public static final char CHAR_HAIR_SPACE = '\u200a';
    public static final char CHAR_THIN_SPACE = '\u2009';
    public static final char CHAR_ALMOST_EQUAL_TO = '\u2248';
    public static final char CHAR_CHECKMARK = '\u2713';
    public static final char CURRENCY_PLUS_SIGN = '+';
    public static final char CURRENCY_MINUS_SIGN = '-';

    public static final String MARKET_APP_URL = "market://details?id=%s";
    public static final String BINARY_URL = "https://github.com/LIMXTEC/x-wallet/releases";

    public static final String VERSION_URL = "https://cryptowallet.si/version";
    public static final String SUPPORT_EMAIL = "support@cryptowallet.si";

    public static final HashMap<CoinType, Integer> COINS_ICONS;
    public static final HashMap<CoinType, String> COINS_BLOCK_EXPLORERS;

    static {
        COINS_ICONS = new HashMap<>();
        COINS_ICONS.put(CoinID.BITCORE_MAIN.getCoinType(), R.drawable.bitcore);
        COINS_ICONS.put(CoinID.BITSEND_MAIN.getCoinType(), R.drawable.bitsend);
        COINS_ICONS.put(CoinID.BITCLOUD_MAIN.getCoinType(), R.drawable.bitcloud);
        COINS_ICONS.put(CoinID.MEGACOIN_MAIN.getCoinType(), R.drawable.megacoin);

        COINS_BLOCK_EXPLORERS = new HashMap<>();
	COINS_BLOCK_EXPLORERS.put(CoinID.BITCORE_MAIN.getCoinType(), "https://chainz.cryptoid.info/btx/tx.dws?%s");
        COINS_BLOCK_EXPLORERS.put(CoinID.BITSEND_MAIN.getCoinType(), "https://chainz.cryptoid.info/bsd/tx.dws?%s");
        COINS_BLOCK_EXPLORERS.put(CoinID.BITCLOUD_MAIN.getCoinType(), "https://chainz.cryptoid.info/btdx/tx.dws?%s");
        COINS_BLOCK_EXPLORERS.put(CoinID.MEGACOIN_MAIN.getCoinType(), "https://chainz.cryptoid.info/mec/tx.dws?%s");
    }

    public static final CoinType DEFAULT_COIN = BitcoinMain.get();
    public static final List<CoinType> DEFAULT_COINS = ImmutableList.of((CoinType) BitcoinMain.get());

    //TODO: deactivate coins which not support electrumX yet
    public static final List<CoinType> SUPPORTED_COINS = ImmutableList.of(
            BitcoreMain.get(),
            BitsendMain.get(),
            BitcloudMain.get(),
            MegacoinMain.get()
    );

    public static List<CoinAddress> getCoinsServerAddresses() {
        return getEnabledCoinsServerAddresses(false);
    }

    public static List<CoinAddress> getEnabledCoinsServerAddresses() {
        return getEnabledCoinsServerAddresses(true);
    }

    private static List<CoinAddress> getEnabledCoinsServerAddresses(boolean filterEnabled) {
        ArrayList<CoinAddress> coinAddresses = new ArrayList<>();
        for (CoinType supportedCoins : SUPPORTED_COINS) {
            coinAddresses.add(getCoinAddress(supportedCoins, filterEnabled));
        }
        return coinAddresses;
    }

    private static CoinAddress getCoinAddress(CoinType coinType, boolean filterEnabled) {
        ArrayList<ServerAddress> addressesForCoin = new ArrayList<>();
        if (coinType instanceof BitcoreMain) {
            addressesForCoin.add(new ServerAddress("ele1.bitcore.cc", 50002));
            addressesForCoin.add(new ServerAddress("ele2.bitcore.cc", 50002));
            addressesForCoin.add(new ServerAddress("ele3.bitcore.cc", 50002));
            addressesForCoin.add(new ServerAddress("ele4.bitcore.cc", 50002));
        } else if (coinType instanceof BitsendMain) {
            addressesForCoin.add(new ServerAddress("ele1.bitsend.info", 50002));
        } else if (coinType instanceof BitcloudMain) {
            addressesForCoin.add(new ServerAddress("ele1.bit-cloud.info", 50002));
        } else if (coinType instanceof MegacoinMain) {
            addressesForCoin.add(new ServerAddress("ele1.megacoin.eu", 50002));
        }

        // check for user defined addresses
        addUserDefinedAddresses(addressesForCoin, coinType, filterEnabled);

        return new CoinAddress(coinType, addressesForCoin);
    }

    private static void addUserDefinedAddresses(ArrayList<ServerAddress> addressesForCoin, CoinType coinType, boolean filterEnabled) {
        List<ServerAddress> userDefinedCoinAddresses = WalletApplication.getInstance().getConfiguration().getUserDefinedCoinAddresses(coinType);
        if (filterEnabled) {
            for (ServerAddress sa : userDefinedCoinAddresses) {
                if (sa.isEnabled()) {
                    addressesForCoin.add(sa);
                }
            }
        } else {
            addressesForCoin.addAll(userDefinedCoinAddresses);
        }
    }

    private static CoinAddress getCoinAddress(CoinType coinType) {
        return getCoinAddress(coinType, false);
    }
}
