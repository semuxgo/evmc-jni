/**
 * Copyright (c) 2018 The Semux Developers
 *
 * Distributed under the MIT software license, see the accompanying file
 * LICENSE or https://opensource.org/licenses/mit-license.php
 */
package org.semux.evmc.jni.type;

public class TransactionContext {

    /**
     * The transaction gas price.
     */
    private DataWord txGasPrice;

    /**
     * The transaction origin account.
     */
    private Address txOrigin;

    /**
     * The miner of the block.
     */
    private Address blockCoinbase;

    /**
     * The block number.
     */
    private long blockNumber;

    /**
     * The block timestamp.
     */
    private long blockTimestamp;

    /**
     * The block gas limit.
     */
    private long blockGasLimit;

    /**
     * The block difficulty.
     */
    private DataWord blockDifficulty;

    public TransactionContext(DataWord txGasPrice, Address txOrigin, Address blockCoinbase, long blockNumber,
            long blockTimestamp, long blockGasLimit, DataWord blockDifficulty) {
        this.txGasPrice = txGasPrice;
        this.txOrigin = txOrigin;
        this.blockCoinbase = blockCoinbase;
        this.blockNumber = blockNumber;
        this.blockTimestamp = blockTimestamp;
        this.blockGasLimit = blockGasLimit;
        this.blockDifficulty = blockDifficulty;
    }

    public DataWord getTxGasPrice() {
        return txGasPrice;
    }

    public Address getTxOrigin() {
        return txOrigin;
    }

    public Address getBlockCoinbase() {
        return blockCoinbase;
    }

    public long getBlockNumber() {
        return blockNumber;
    }

    public long getBlockTimestamp() {
        return blockTimestamp;
    }

    public long getBlockGasLimit() {
        return blockGasLimit;
    }

    public DataWord getBlockDifficulty() {
        return blockDifficulty;
    }
}
