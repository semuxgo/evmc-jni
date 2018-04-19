/**
 * Copyright (c) 2018 The Semux Developers
 *
 * Distributed under the MIT software license, see the accompanying file
 * LICENSE or https://opensource.org/licenses/mit-license.php
 */
package org.semux.evmc.jni.type;

import java.util.Arrays;

public class Message {

    /**
     * The destination of the message.
     */
    private Address destination;

    /**
     * The sender of the message.
     */
    private Address sender;

    /**
     * The amount of Ether transferred with the message.
     */
    private DataWord value;

    /**
     * The message input data.
     */
    private byte[] inputData;

    /**
     * The optional hash of the code of the destination account. The null hash MUST
     * be used when not specified.
     */
    private DataWord codeHash;

    /**
     * The amount of gas for message execution.
     */
    private long gas;

    /**
     * The call depth.
     */
    private int depth;

    /**
     * The kind of the call. For zero-depth calls {@link CallKind#CALL} SHOULD be
     * used.
     */
    private CallKind kind;

    /**
     * Additional flags modifying the call execution behavior.
     *
     * In the current version the only valid values are {@link Flag#STATIC} or 0.
     */
    private int flags;

    /**
     * Creates a message instance.
     *
     * @param destination
     * @param sender
     * @param value
     * @param inputData
     * @param codeHash
     * @param gas
     * @param depth
     * @param kind
     * @param flags
     */
    public Message(Address destination, Address sender, DataWord value, byte[] inputData,
            DataWord codeHash, long gas, int depth, CallKind kind, int flags) {
        this.destination = destination;
        this.sender = sender;
        this.value = value;
        this.inputData = inputData;
        this.codeHash = codeHash;
        this.gas = gas;
        this.depth = depth;
        this.kind = kind;
        this.flags = flags;
    }

    public static Message fromBytes(byte[] bytes) {
        return null;
    }

    public byte[] toBytes() {
        return null;
    }

    public Address getDestination() {
        return destination;
    }

    public Address getSender() {
        return sender;
    }

    public DataWord getValue() {
        return value;
    }

    public byte[] getInputData() {
        return inputData;
    }

    public DataWord getCodeHash() {
        return codeHash;
    }

    public long getGas() {
        return gas;
    }

    public int getDepth() {
        return depth;
    }

    public CallKind getKind() {
        return kind;
    }

    public int getFlags() {
        return flags;
    }

    @Override
    public String toString() {
        return "Message{" +
                "destination=" + destination +
                ", sender=" + sender +
                ", value=" + value +
                ", inputData=" + Arrays.toString(inputData) +
                ", codeHash=" + codeHash +
                ", gas=" + gas +
                ", depth=" + depth +
                ", kind=" + kind +
                ", flags=" + flags +
                '}';
    }
}
