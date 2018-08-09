/**
 * Copyright (c) 2018 The Semux Developers
 *
 * Distributed under the MIT software license, see the accompanying file
 * LICENSE or https://opensource.org/licenses/mit-license.php
 */
package org.semux.evmc.jni.type;

/**
 * Represents the address of account.
 */
public class Address {

    private byte[] raw;

    protected Address(byte[] bytes) {
        this.raw = bytes;
    }

    public static Address warp(byte[] bytes) {
        if (bytes == null || bytes.length != 20) {
            throw new IllegalArgumentException("Address can't be null or not equal to 20 bytes");
        }

        return new Address(bytes);
    }

    public byte[] getRaw() {
        return raw;
    }
}
