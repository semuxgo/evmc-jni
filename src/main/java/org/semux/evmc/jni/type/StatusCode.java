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

    /**
     * Execution terminated with REVERT opcode.
     */
    REVERT(2),

    /**
     * The execution has run out of gas.
     */
    OUT_OF_GAS(3),

    /**
     * The designated INVALID instruction has been hit during execution.
     */
    INVALID_INSTRUCTION(4),

    /**
     * An undefined instruction has been encountered.
     */
    UNDEFINED_INSTRUCTION(5),

    /**
     * The execution has attempted to put more items on the EVM stack than the
     * specified limit.
     */
    STACK_OVERFLOW(6),

    /**
     * Execution of an opcode has required more items on the EVM stack.
     */
    STACK_UNDERFLOW(7),

    /**
     * Execution has violated the jump destination restrictions.
     */
    BAD_JUMP_DESTINATION(8),

    /**
     * Tried to read outside memory bounds.
     */
    INVALID_MEMORY_ACCESS(9),

    /**
     * Call depth has exceeded the limit (if any)
     */
    CALL_DEPTH_EXCEEDED(10),

    /**
     * Tried to execute an operation which is restricted in static mode.
     */
    STATIC_MODE_VIOLATION(11),

    /**
     * A call to a precompiled or system contract has ended with a failure.
     */
    PRECOMPILE_FAILURE(12),

    /**
     * Contract validation has failed (e.g. due to EVM 1.5 jump validity, Casper's
     * purity checker or ewasm contract rules).
     */
    CONTRACT_VALIDATION_FAILURE(13),

    /**
     * EVM implementation generic internal error.
     */
    INTERNAL_ERROR(-1),

    /**
     * The execution of the given code and/or message has been rejected by the EVM
     * implementation.
     */
    REJECTED(-2);

    private int code;

    StatusCode(int code) {
        this.code = code;
    }

    public int code() {
        return code;
    }
}
