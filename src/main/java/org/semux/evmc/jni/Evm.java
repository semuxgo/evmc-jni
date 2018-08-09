/**
 * Copyright (c) 2018 The Semux Developers
 *
 * Distributed under the MIT software license, see the accompanying file
 * LICENSE or https://opensource.org/licenses/mit-license.php
 */
package org.semux.evmc.jni;

import org.semux.evmc.jni.type.Message;
import org.semux.evmc.jni.type.Result;
import org.semux.evmc.jni.type.Revision;
import org.semux.evmc.jni.util.Bytes;

public class Evm {

    private long pointer;

    private int abiVersion;

    private String name;

    private String version;

    public Evm(long pointer, int abiVersion, String name, String version) {
        this.pointer = pointer;
        this.abiVersion = abiVersion;
        this.name = name;
        this.version = version;
    }

    public void setOption(String name, String value) {
        Native.set_option(pointer, Bytes.of(name), Bytes.of(value));
    }

    public Result execute(StateContext context, Revision revision, Message msg, byte[] code) {
        byte[] result = Native.execute(pointer, context, revision.code(), msg.toBytes(), code);
        if (result == null) {
            throw new EvmError("Failed to execute: " + msg);
        }

        return Result.fromBytes();
    }

    public void destroy() {
        Native.destroy(pointer);
    }

    public long getPointer() {
        return pointer;
    }

    public int getAbiVersion() {
        return abiVersion;
    }

    public String getName() {
        return name;
    }

    public String getVersion() {
        return version;
    }
}
