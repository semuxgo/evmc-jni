/**
 * Copyright (c) 2018 The Semux Developers
 *
 * Distributed under the MIT software license, see the accompanying file
 * LICENSE or https://opensource.org/licenses/mit-license.php
 */
package org.semux.evmc.jni.type;

public enum Flag {

    /**
     * Static call mode.
     */
    STATIC(1);

    private int code;

    Flag(int code) {
        this.code = code;
    }

    public int code() {
        return code;
    }

}
