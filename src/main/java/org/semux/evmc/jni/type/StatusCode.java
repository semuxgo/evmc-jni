/**
 * Copyright (c) 2018 The Semux Developers
 *
 * Distributed under the MIT software license, see the accompanying file
 * LICENSE or https://opensource.org/licenses/mit-license.php
 */
package org.semux.evmc.jni.type;

public enum StatusCode {

    /**
     * Execution finished with success.
     */
    SUCCESS(0),

    /**
     * Generic execution failure.
     */
    FAILURE(1),

    OUT_OF_GAS(2),

    /**
     * Unknown instruction encountered by the Evm.
     */
    UNDEFINED_INSTRUCTION(3),

    BAD_JUMP_DESTINATION(4),

    STACK_OVERFLOW(5),

    STACK_UNDERFLOW(6),

    /**
     * Execution terminated with REVERT opcode.
     */
    REVERT(7),

    /**
     * Tried to execute an operation which is restricted in static mode.
     */
    STATIC_MODE_VIOLATION(8),

    /**
     * The dedicated INVALID instruction was hit.
     */
    INVALID_INSTRUCTION(9),

    /**
     * Tried to read outside memory bounds.
     *
     * An example is RETURNDATACOPY reading past the available buffer.
     */
    INVALID_MEMORY_ACCESS(10),

    /**
     * Exceptions produced by precompiles/system contracts.
     *
     * An example: elliptic curve functions handed invalid EC points
     */
    PRECOMPILE_FAILURE(11),

    /**
     * The EVM rejected the execution of the given code or message.
     *
     * This error SHOULD be used to signal that the EVM is not able to or willing to
     * execute the given code type or message. If an EVM returns the ::REJECTED
     * status code, the Client MAY try to execute it in other EVM implementation.
     * For example, the Client tries running a code in the EVM 1.5. If the code is
     * not supported there, the execution falls back to the EVM 1.0.
     */
    REJECTED(-1),

    /**
     * EVM implementation internal error.
     */
    INTERNAL_ERROR(-2);

    private int code;

    StatusCode(int code) {
        this.code = code;
    }

    public int code() {
        return code;
    }
}
