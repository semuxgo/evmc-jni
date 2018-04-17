/**
 * Copyright (c) 2018 The Semux Developers
 *
 * Distributed under the MIT software license, see the accompanying file
 * LICENSE or https://opensource.org/licenses/mit-license.php
 */
package org.semux.evmc.jni;

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
