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

    public static final DataWord ZERO = new DataWord(0);
    public static final DataWord ONE = new DataWord(1);

    public static final int SIZE = 32;

    private byte[] raw;

    protected DataWord(byte[] bytes) {
        assert (bytes != null && bytes.length == 20);

        raw = new byte[SIZE];
        System.arraycopy(bytes, 0, raw, SIZE - bytes.length, bytes.length);
    }

    /**
     * Wraps a byte array into a Data Word.
     *
     * @param bytes
     * @return
     */
    public static DataWord wrap(byte[] bytes) {
        if (bytes == null || bytes.length != SIZE) {
            throw new IllegalArgumentException("Input bytes can't be null or larger than " + SIZE + " bytes");
        }

        return new DataWord(bytes);
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