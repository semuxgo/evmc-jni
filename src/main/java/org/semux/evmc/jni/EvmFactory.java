/**
 * Copyright (c) 2018 The Semux Developers
 *
 * Distributed under the MIT software license, see the accompanying file
 * LICENSE or https://opensource.org/licenses/mit-license.php
 */
package org.semux.evmc.jni;

import java.nio.ByteBuffer;

import org.semux.evmc.jni.util.Bytes;

public class EvmFactory {

    /**
     * Creates an EVMJIT instance.
     *
     * @return
     */
    public static Evm createEvmjit() {
        byte[] vm = Native.create_evmjit();

        if (vm == null || vm.length == 0) {
            throw new EvmException("Failed to create EVMJIT instance");
        }

        return decodeEvm(vm);
    }

    protected static Evm decodeEvm(byte[] bytes) {
        ByteBuffer buf = ByteBuffer.wrap(bytes);

        long pointer = buf.getLong();
        int abiVersion = buf.getInt();
        byte[] name = new byte[buf.getInt()];
        buf.get(name);
        byte[] version = new byte[buf.getInt()];
        buf.get(version);

        return new Evm(pointer, abiVersion, Bytes.toString(name), Bytes.toString(version));
    }
}
