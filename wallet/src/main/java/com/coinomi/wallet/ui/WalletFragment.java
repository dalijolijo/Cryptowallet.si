package com.coinomi.wallet.ui;

import com.coinomi.core.wallet.WalletAccount;
import com.coinomi.wallet.ui.common.BasePartnersDataFragment;

/**
 * @author John L. Jegutanis
 */
public abstract class WalletFragment extends BasePartnersDataFragment implements ViewUpdateble {
    abstract public WalletAccount getAccount();
}
