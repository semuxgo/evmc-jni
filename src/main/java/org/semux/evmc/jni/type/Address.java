/**
 * Copyright (c) 2018 The Semux Developers
 *
 * Distributed under the MIT software license, see the accompanying file
 * LICENSE or https://opensource.org/licenses/mit-license.php
 */
package org.semux.evmc.jni.type;

public class Address {

    private byte[] raw;

    public Address(byte[] bytes) {
        if (bytes == null || bytes.length != 20) {
            throw new IllegalArgumentException("Address can't be null or not equal to 20 bytes");
        }

        this.raw = bytes;
    }

    public byte[] getRaw() {
        return raw;
    }
}
