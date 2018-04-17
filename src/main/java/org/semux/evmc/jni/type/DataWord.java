/**
 * Copyright (c) 2018 The Semux Developers
 *
 * Distributed under the MIT software license, see the accompanying file
 * LICENSE or https://opensource.org/licenses/mit-license.php
 */
package org.semux.evmc.jni.type;

import java.math.BigInteger;
import java.util.Arrays;

import org.semux.evmc.jni.util.Bytes;
import org.semux.evmc.jni.util.Hex;

/**
 * Big-endian 256-bit data word.
 */
public class DataWord {

    public static final int SIZE = 32;

    private byte[] raw = new byte[SIZE];

    /**
     * Constructs a data word from byte array. Zeros are padded to the left if
     * needed.
     *
     * @param bytes
     */
    public DataWord(byte[] bytes) {
        if (bytes == null || bytes.length > SIZE) {
            throw new IllegalArgumentException("Input bytes can't be null or larger than " + SIZE + " bytes");
        }

        System.arraycopy(bytes, 0, raw, SIZE - bytes.length, bytes.length);
    }

    /**
     * Converts an integer number into data word.
     *
     * @param number
     */
    public DataWord(int number) {
        this(Bytes.of(number));
    }

    /**
     * Converts a long integer number into data word.
     *
     * @param number
     */
    public DataWord(long number) {
        this(Bytes.of(number));
    }

    /**
     * Converts a BigInteger into data word.
     *
     * @param number
     */
    public DataWord(BigInteger number) {
        this(number.toByteArray());
    }

    /**
     * Returns the raw byte array. The client should not modify the returned
     * contents.
     *
     * @return
     */
    public byte[] getRaw() {
        return raw;
    }

    /**
     * Clones this data word.
     */
    public DataWord clone() {
        return new DataWord(raw);
    }

    /**
     * Returns the hex string representation.
     *
     * @return
     */
    public String toString() {
        return Hex.encode(raw);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(raw);
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof DataWord && Arrays.equals(raw, ((DataWord) obj).raw);
    }
}