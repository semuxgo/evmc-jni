/**
 * Copyright (c) 2018 The Semux Developers
 *
 * Distributed under the MIT software license, see the accompanying file
 * LICENSE or https://opensource.org/licenses/mit-license.php
 */
package org.semux.evmc.jni;

public class EvmException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public EvmException() {
    }

    public EvmException(String message) {
        super(message);
    }

    public EvmException(String message, Throwable cause) {
        super(message, cause);
    }
}
