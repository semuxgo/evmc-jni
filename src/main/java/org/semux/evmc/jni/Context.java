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

public interface Context {

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
     * @return The storage value.
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
     * @return The balance value.
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
     * @param data
     *            The pointer to unindexed data attached to the log.
     * @param topics
     *            The pointer to the array of topics attached to the log.
     * @param topics_count
     *            The number of the topics. Valid values are between 0 and 4
     *            inclusively.
     */
    void emitLog(Address address, byte[] data, DataWord topics[], int topics_count);

    /**
     * Pointer to the callback function supporting EVM calls.
     *
     * @param msg
     *            Call parameters. {@link Message}
     * @return The result of the call.
     */
    Result call(Message msg);
}
