package com.coinomi.core.wallet.families.nxt;

import com.coinomi.core.coins.Value;
import com.coinomi.core.coins.nxt.Convert;
import com.coinomi.core.coins.nxt.Transaction;
import com.coinomi.core.messages.TxMessage;
import com.coinomi.core.wallet.AbstractAddress;
import com.coinomi.core.wallet.AbstractTransaction;
import com.coinomi.core.wallet.AbstractWallet;
import com.coinomi.core.wallet.WalletAccount;

import org.bitcoinj.core.TransactionConfidence;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Nullable;

import static com.coinomi.core.Preconditions.checkNotNull;

/**
 * @author vbcs
 * @author John L. Jegutanis
 */
public final class NxtTransaction implements AbstractTransaction {
    final Transaction tx;

    TransactionConfidence.ConfidenceType confidence = TransactionConfidence.ConfidenceType.BUILDING;;

    public NxtTransaction(Transaction transaction) {
        tx = checkNotNull(transaction);
    }

    public void setConfidenceType(TransactionConfidence.ConfidenceType conf) {
        confidence = conf;
    }

    @Override
    public TransactionConfidence.ConfidenceType getConfidenceType() {
        return (tx.getConfirmations() > 0 ) ? confidence : TransactionConfidence.ConfidenceType.PENDING;
    }

    @Override
    public int getAppearedAtChainHeight() {
        return tx.getHeight();
    }

    @Override
    public TransactionConfidence.Source getSource() {
        return TransactionConfidence.Source.NETWORK;
    }

    @Override
    public int getDepthInBlocks() {
        return tx.getConfirmations();
    }

    @Override
    public String getHashAsString() {
        return tx.getFullHash();
    }

    @Override
    public Value getValue(AbstractWallet wallet) {
        if (tx.getSenderId() == wallet.getReceiveAddress().getId()) {
            return Value.valueOf(wallet.getCoinType(), -1 * tx.getAmountNQT());
        } else {
            return Value.valueOf(wallet.getCoinType(), tx.getAmountNQT());
        }
    }

    @Override
    public TxMessage getMessage() {
        if (tx.getMessage() != null) {
            NxtTxMessage message = new NxtTxMessage(tx);
            return message;
        }
        return null;
    }

    @Override
    public Value getFee(WalletAccount wallet) {
        return Value.valueOf(wallet.getCoinType(), tx.getFeeNQT());
    }

    @Override
    public List<Map.Entry<AbstractAddress, Value>> getOutputs(AbstractWallet wallet) {
        List<Map.Entry<AbstractAddress, Value>> outputs = new ArrayList<>();
        outputs.add(new AbstractMap.SimpleEntry<AbstractAddress, Value>
                (new NxtFamilyAddress(wallet.getCoinType(), tx.getRecipientId()),
                        Value.valueOf(wallet.getCoinType(), tx.getAmountNQT())));
        return outputs;

    }

    @Override
    public AbstractAddress getSender(AbstractWallet wallet) {
        return new NxtFamilyAddress(wallet.getCoinType(), tx.getSenderId());
    }

    @Override
    public byte[] getHash() {
        return Convert.parseHexString(tx.getFullHash());
    }

    @Override
    public boolean isGenerated() {
        return false;
    }

    @Override
    public boolean isMine(WalletAccount wallet, Map.Entry<AbstractAddress, Value> output) {
        return wallet.getActiveAddresses().contains(output.getKey());
    }

    @Override
    @Nullable
    public Transaction getRawTransaction() {
        return tx;
    }


    /*public NxtTransaction(WalletAccount account, Transaction tx) {
        super(account, tx);
    }

    @Override
    public void parse(WalletAccount account, Object tx) {
        if (tx != null) {
            long amount = (account.getReceiveAddress().getId() == ((Transaction)tx).getSenderId()) ?
                    -1 * ((Transaction)tx).getAmountNQT() + -1 * ((Transaction)tx).getFeeNQT() : ((Transaction)tx).getAmountNQT();

            this.value = type.value(amount);

            this.fee = type.value(((Transaction)tx).getFeeNQT());

            if (account.getReceiveAddress().getId() == ((Transaction)tx).getSenderId()) {
                AbstractAddress address = new NxtFamilyAddress(this.type, ((Transaction)tx).getRecipientId());
                Value value = type.value(((Transaction)tx).getFeeNQT() + ((Transaction)tx).getAmountNQT());
                outputs.put(address, value);
            }
            else if (account.getReceiveAddress().getId() == ((Transaction)tx).getRecipientId()) {
                AbstractAddress address = account.getReceiveAddress();
                Value value = type.value(((Transaction)tx).getFeeNQT() + ((Transaction)tx).getAmountNQT());
                outputs.put(address, value);
            }
            hashString = ((Transaction) tx).getFullHash();

        }

        parsed = true;
    }

    /*@Override
    public byte[] serialize() {
        checkNotNull(tx, "Cannot serialize null transaction");
        return ((Transaction) tx).getBytes();
    }
    */
}
