package com.coinomi.wallet.ui;

import android.content.Intent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.coinomi.core.wallet.WalletAccount;
import com.coinomi.wallet.Constants;
import com.coinomi.wallet.R;
import com.coinomi.wallet.ui.common.BasePartnersDataFragment;

/**
 * @author John L. Jegutanis
 */
public abstract class WalletFragment extends BasePartnersDataFragment implements ViewUpdateble {
    abstract public WalletAccount getAccount();

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_connections) {
            Intent intent = new Intent(getContext(), CoinConnectionsActivity.class);
            intent.putExtra(Constants.ARG_ACCOUNT_ID, getAccount().getId());
            startActivity(intent);
            return true;
        } else if (item.getItemId() == R.id.action_coin_links) {
            Intent intent = new Intent(getContext(), CoinInfoActivity.class);
            intent.putExtra(Constants.ARG_ACCOUNT_ID, getAccount().getId());
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
