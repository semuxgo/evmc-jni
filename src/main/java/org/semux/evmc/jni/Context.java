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
     * @param vm
     *            The execution instance.
     * @param address
     *            The address of the account the query is about.
     * @return 1 if exists, 0 otherwise.
     */
    boolean accountExists(Evm vm, Address address);

    /**
     * Get storage callback function.
     *
     * This callback function is used by an EVM to query the given contract storage
     * entry.
     *
     * @param vm
     *            The execution instance.
     * @param address
     *            The address of the contract.
     * @param key
     *            The index of the storage entry.
     * @return The storage value.
     */
    DataWord getStorage(Evm vm, Address address, DataWord key);

    /**
     * Set storage callback function.
     *
     * This callback function is used by an EVM to update the given contract storage
     * entry.
     *
     * @param vm
     *            The execution instance.
     * @param address
     *            The address of the contract.
     * @param key
     *            The index of the storage entry.
     * @param value
     *            The value to be stored.
     */
    void setStorage(Evm vm, Address address, DataWord key, DataWord value);

    /**
     * Get balance callback function.
     *
     * This callback function is used by an EVM to query the balance of the given
     * address.
     *
     * @param vm
     *            The execution instance.
     * @param address
     *            The address.
     * @return The balance value.
     */
    DataWord getBalance(Evm vm, Address address);

    /**
     * Get code size callback function.
     *
     * This callback function is used by an EVM to get the size of the code stored
     * in the account at the given address. For accounts not having a code, this
     * function returns 0.
     *
     * @param vm
     * @param address
     * @return
     */
    int getCodeSize(Evm vm, Address address);

    /**
     * Copy code callback function.
     *
     * This callback function is used by an EVM to request a copy of the code of the
     * given account to the memory buffer provided by the EVM. The Client MUST copy
     * the requested code, starting with the given offset, to the provided memory
     * buffer up to the size of the buffer or the size of the code, whichever is
     * smaller.
     *
     * @param vm
     *            The pointer to the Client execution context.
     * @param address
     *            The address of the account.
     * @param codeOffset
     *            The offset of the code to copy.
     * @param buffer
     *            The pointer to the memory buffer allocated by the EVM to store a
     *            copy of the requested code.
     * @return The number of bytes copied to the buffer by the Client.
     */
    int copyCode(Evm vm, Address address, int codeOffset, byte[] buffer);

    /**
     * Selfdestruct callback function.
     *
     *
     * This callback function is used by an EVM to SELFDESTRUCT given contract. The
     * execution of the contract will not be stopped, that is up to the EVM.
     *
     * @param vm
     *            The execution instance.
     * @param address
     *            The address of the contract to be selfdestructed.
     * @param beneficiary
     *            The address where the remaining ETH is going to be transferred.
     */
    void selfdestruct(Evm vm, Address address, Address beneficiary);

    /**
     * Log callback function.
     *
     * This callback function is used by an EVM to inform about a LOG that happened
     * during an EVM bytecode execution.
     *
     * @param vm
     *            The execution instance.
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
    void emitLog(Evm vm, Address address, byte[] data, DataWord topics[], int topics_count);

    /**
     * Pointer to the callback function supporting EVM calls.
     *
     * @param vm
     *            The execution instance.
     * @param msg
     *            Call parameters. {@link Message}
     * @return The result of the call.
     */
    Result call(Evm vm, Message msg);
}
