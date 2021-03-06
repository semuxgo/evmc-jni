/**
 * Copyright (c) 2018 The Semux Developers
 *
 * Distributed under the MIT software license, see the accompanying file
 * LICENSE or https://opensource.org/licenses/mit-license.php
 */
package org.semux.evmc.jni.type;

import java.util.Arrays;

/**
 * The EVM code execution result.
 */
public class Result {
    /**
     * The execution status code.
     */
    StatusCode statusCode;

    /**
     * The amount of gas left after the execution.
     *
     * If <code>statusCode</code> is not {@link StatusCode#SUCCESS} nor
     * {@link StatusCode#REVERT} the value MUST be 0.
     */
    long gasLeft;

    /**
     * The reference to output data.
     *
     * The output contains data coming from RETURN opcode (iff
     * <code>statusCode</code> field is {@link StatusCode#SUCCESS}) or from REVERT
     * opcode.
     */
    byte[] outputData;

    /**
     * The address of the contract created by CREATE opcode.
     *
     * This field has valid value only if the result describes successful CREATE
     * (<code>statusCode</code>e is {@link StatusCode#SUCCESS}).
     */
    Address createAddress;

    /**
     * Reserved data that MAY be used by a evmc_result object creator.
     *
     * This reserved 4 bytes together with 20 bytes from create_address form 24
     * bytes of memory called "optional data" within evmc_result struct to be
     * optionally used by the evmc_result object creator.
     */
    byte[] padding;

    public Result(StatusCode statusCode, long gasLeft, byte[] outputData, Address createAddress, byte[] padding) {
        this.statusCode = statusCode;
        this.gasLeft = gasLeft;
        this.outputData = outputData;
        this.createAddress = createAddress;
        this.padding = padding;
    }

    public static Result fromBytes() {
        return null;
    }

    public byte[] toBytes() {
        return null;
    }

    public StatusCode getStatusCode() {
        return statusCode;
    }

    public long getGasLeft() {
        return gasLeft;
    }

    public byte[] getOutputData() {
        return outputData;
    }

    public Address getCreateAddress() {
        return createAddress;
    }

    public byte[] getPadding() {
        return padding;
    }

    @Override
    public String toString() {
        return "Result{" +
                "statusCode=" + statusCode +
                ", gasLeft=" + gasLeft +
                ", outputData=" + Arrays.toString(outputData) +
                ", createAddress=" + createAddress +
                ", padding=" + Arrays.toString(padding) +
                '}';
    }
}
