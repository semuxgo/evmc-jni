/**
 * Copyright (c) 2018 The Semux Developers
 *
 * Distributed under the MIT software license, see the accompanying file
 * LICENSE or https://opensource.org/licenses/mit-license.php
 */
package org.semux.evmc.jni;

public class VM {

    private long pointer;

    public VM(long pointer) {
        this.pointer = pointer;
    }
}
