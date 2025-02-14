package com.coinomi.core.coins.nxt;

/******************************************************************************
 * Copyright © 2013-2015 The Nxt Core Developers.                             *
 *                                                                            *
 * See the AUTHORS.txt, DEVELOPER-AGREEMENT.txt and LICENSE.txt files at      *
 * the top-level directory of this distribution for the individual copyright  *
 * holder information and the developer policies on copyright and licensing.  *
 *                                                                            *
 * Unless otherwise agreed in a custom licensing agreement, no part of the    *
 * Nxt software, including this file, may be copied, modified, propagated,    *
 * or distributed except according to the terms contained in the LICENSE.txt  *
 * file.                                                                      *
 *                                                                            *
 * Removal or modification of this copyright notice is prohibited.            *
 *                                                                            *
 ******************************************************************************/

import java.util.Calendar;
import java.util.TimeZone;

public final class Constants {

//    public static final boolean isTestnet = Nxt.getBooleanProperty("nxt.isTestnet");
//    public static final boolean isOffline = Nxt.getBooleanProperty("nxt.isOffline");

    public static final long MAX_BALANCE_NXT = 1000000000;
    public static final long ONE_NXT = 100000000;
    public static final long MAX_BALANCE_NQT = MAX_BALANCE_NXT * ONE_NXT;

    public static final int MAX_ALIAS_URI_LENGTH = 1000;
    public static final int MAX_ALIAS_LENGTH = 100;

    public static final int MAX_ARBITRARY_MESSAGE_LENGTH = 1000;
    public static final int MAX_ENCRYPTED_MESSAGE_LENGTH = 1000;

    public static final int MAX_ACCOUNT_NAME_LENGTH = 100;
    public static final int MAX_ACCOUNT_DESCRIPTION_LENGTH = 1000;

    public static final int MAX_ASSET_NAME_LENGTH = 10;
    public static final int MAX_ASSET_DESCRIPTION_LENGTH = 1000;
    public static final int MAX_ASSET_TRANSFER_COMMENT_LENGTH = 1000;

    public static final int MAX_POLL_NAME_LENGTH = 100;
    public static final int MAX_POLL_DESCRIPTION_LENGTH = 1000;
    public static final int MAX_POLL_OPTION_LENGTH = 100;
    public static final int MAX_POLL_OPTION_COUNT = 100;

    public static final int MAX_DGS_LISTING_NAME_LENGTH = 100;
    public static final int MAX_DGS_LISTING_DESCRIPTION_LENGTH = 1000;
    public static final int MAX_DGS_LISTING_TAGS_LENGTH = 100;
    public static final int MAX_DGS_GOODS_LENGTH = 1000;

    public static final int MAX_HUB_ANNOUNCEMENT_URIS = 100;
    public static final int MAX_HUB_ANNOUNCEMENT_URI_LENGTH = 1000;

    public static final long NXT_EPOCH_BEGINNING;
    static {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        calendar.set(Calendar.YEAR, 2013);
        calendar.set(Calendar.MONTH, Calendar.NOVEMBER);
        calendar.set(Calendar.DAY_OF_MONTH, 24);
        calendar.set(Calendar.HOUR_OF_DAY, 12);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        NXT_EPOCH_BEGINNING = calendar.getTimeInMillis();
    }

    public static final long BURST_EPOCH_BEGINNING;
    static {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        calendar.set(Calendar.YEAR, 2014);
        calendar.set(Calendar.MONTH, Calendar.AUGUST);
        calendar.set(Calendar.DAY_OF_MONTH, 11);
        calendar.set(Calendar.HOUR_OF_DAY, 2);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        BURST_EPOCH_BEGINNING = calendar.getTimeInMillis();
    }

    private Constants() {} // never

    // BTX = json2, BSD = json3, BTDX = json4 , MEC = json5
    //TODO: own WERBUNG
    //JSON response:
    //[
    // {
    //  "imageUrl": "https://cryptowallet.si/partner/p1.png",
    //  "link": "http://p1.cryptowallet.si"
    // },
    //]
    public static final String PARTNERS_URI_OVERVIEW = "http://9e98d434-ec06-49d3-8dba-041726e407a8.pub.cloud.scaleway.com:8080/limxtec";
    public static final String PARTNERS_URI_BTX = "http://9e98d434-ec06-49d3-8dba-041726e407a8.pub.cloud.scaleway.com:8080/btx";
    public static final String PARTNERS_URI_BSD = "http://9e98d434-ec06-49d3-8dba-041726e407a8.pub.cloud.scaleway.com:8080/bsd";
    public static final String PARTNERS_URI_BTDX = "http://9e98d434-ec06-49d3-8dba-041726e407a8.pub.cloud.scaleway.com:8080/btdx";
    public static final String PARTNERS_URI_MEC = "http://9e98d434-ec06-49d3-8dba-041726e407a8.pub.cloud.scaleway.com:8080/mec";
}

