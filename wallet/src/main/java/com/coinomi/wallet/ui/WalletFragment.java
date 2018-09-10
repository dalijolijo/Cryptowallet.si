package com.coinomi.wallet.ui;

import android.support.v4.app.Fragment;

import com.coinomi.core.wallet.WalletAccount;
import com.coinomi.wallet.ui.common.BaseFragment;

/**
 * @author John L. Jegutanis
 */
public abstract class WalletFragment extends BaseFragment implements ViewUpdateble {
    abstract public WalletAccount getAccount();
}
