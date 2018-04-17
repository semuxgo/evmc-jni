/**
 * Copyright (c) 2018 The Semux Developers
 *
 * Distributed under the MIT software license, see the accompanying file
 * LICENSE or https://opensource.org/licenses/mit-license.php
 */
package org.semux.evmc.jni.type;

public enum Revision {

    FRONTIER(0),

    HOMESTEAD(1),

    TANGERINE_WHISTLE(2),

    SPURIOUS_DRAGON(3),

    BYZANTIUM(4),

    CONSTANTINOPLE(5);

    private int code;

    Revision(int code) {
        this.code = code;
    }

    public int code() {
        return code;
    }
}
