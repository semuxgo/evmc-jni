/**
 * Copyright (c) 2018 The Semux Developers
 *
 * Distributed under the MIT software license, see the accompanying file
 * LICENSE or https://opensource.org/licenses/mit-license.php
 */
package org.semux.evmc.jni;

import org.semux.evmc.jni.type.Address;
import org.semux.evmc.jni.type.DataWord;
import org.semux.evmc.jni.type.Message;
import org.semux.evmc.jni.type.Result;

public interface StateContext {

    /**
     * Check account existence callback function
     *
     * @param address
     *            The address of the account the query is about.
     * @return 1 if exists, 0 otherwise.
     */
    boolean accountExists(Address address);

    /**
     * Get storage callback function.
     *
     * @param address
     *            The address of the contract.
     * @param key
     *            The index of the storage entry.
     * @return The storage value; if not exists, return ZERO.
     */
    DataWord getStorage(Address address, DataWord key);

    /**
     * Set storage callback function.
     *
     * @param address
     *            The address of the contract.
     * @param key
     *            The index of the storage entry.
     * @param value
     *            The value to be stored.
     */
    void setStorage(Address address, DataWord key, DataWord value);

    /**
     * Get balance callback function.
     *
     * @param address
     *            The address.
     * @return The balance of the account; return zero if account doesn't exist
     */
    DataWord getBalance(Address address);

    /**
     * Get code callback function.
     *
     * @param address
     * @return
     */
    byte[] getCode(Address address);

    /**
     * Selfdestruct callback function.
     *
     * @param address
     *            The address of the contract to be selfdestructed.
     * @param beneficiary
     *            The address where the remaining ETH is going to be transferred.
     */
    void selfdestruct(Address address, Address beneficiary);

    /**
     * Log callback function.
     *
     * @param address
     *            The address of the contract that generated the log.
     * @param topics
     *            The topics of the log
     * @param data
     *            The unstructured data.
     */
    void emitLog(Address address, DataWord[] topics, byte[] data);

    /**
     * Pointer to the callback function supporting EVM calls.
     *
     * @param msg
     *            Call parameters. {@link Message}
     * @return The result of the call.
     */
    Result call(Message msg);
}
