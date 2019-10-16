package com.coinomi.stratumj;

import java.util.Objects;

/**
 * @author John L. Jegutanis
 */
final public class ServerAddress {
    final private String host;
    final private int port;
    private boolean enabled;
    private boolean defaultAddress;

    public ServerAddress(String host, int port) {
        this(host, port, true, true);
    }

    public ServerAddress(String host, int port, boolean enabled, boolean defaultAddress) {
        this.host = host;
        this.port = port;
        this.enabled = enabled;
        this.defaultAddress = defaultAddress;
    }

    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServerAddress that = (ServerAddress) o;
        return port == that.port &&
                enabled == that.enabled &&
                defaultAddress == that.defaultAddress &&
                Objects.equals(host, that.host);
    }

    @Override
    public int hashCode() {
        return Objects.hash(host, port, enabled, defaultAddress);
    }

    @Override
    public String toString() {
        return "ServerAddress{" +
                "host='" + host + '\'' +
                ", port=" + port +
                '}';
    }

    public boolean isDefaultAddress() {
        return defaultAddress;
    }
}
