/**
 * Copyright (c) 2018 The Semux Developers
 *
 * Distributed under the MIT software license, see the accompanying file
 * LICENSE or https://opensource.org/licenses/mit-license.php
 */
package org.semux.evmc.jni.type;

public enum CallKind {

    /**
     * Request CALL.
     */
    CALL(0),

    /**
     * Request DELEGATECALL. The value param ignored.
     */
    DELEGATECALL(1),

    /**
     * Request CALLCODE.
     */
    CALLCODE(2),

    /**
     * Request CREATE. Semantic of some params changes.
     */
    CREATE(3);

    private int code;

    CallKind(int code) {
        this.code = code;
    }

    public int code() {
        return code;
    }
}
