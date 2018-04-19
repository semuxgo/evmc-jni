/**
 * Copyright (c) 2018 The Semux Developers
 *
 * Distributed under the MIT software license, see the accompanying file
 * LICENSE or https://opensource.org/licenses/mit-license.php
 */
package org.semux.evmc.jni;

import org.semux.evmc.jni.type.Address;
import org.semux.evmc.jni.type.DataWord;

public class Native {

    public static native byte[] create_evmjit();

    public static native byte[] create_example_evm();

    public static native void set_option(long vm, byte[] name, byte[] value);

    public static native byte[] execute(Context context, int revision, byte[] msg, byte[] code);

    public static native void destroy(long vm);

    // The following methods are called from JNI

    public static int account_exists(Context context, byte[] address) {
        return context.accountExists(Address.warp(address)) ? 1 : 0;
    }

    public static void get_storage(byte[] result, Context context, byte[] address, byte[] key) {
        DataWord value = context.getStorage(Address.warp(address), DataWord.wrap(key));
        byte[] bytes = (value == null) ? DataWord.ZERO.getRaw() : value.getRaw();

        System.arraycopy(bytes, 0, result, 0, bytes.length);
    }

    public static void set_storage(Context context, byte[] address, byte[] key, byte[] value) {
        context.setStorage(Address.warp(address), DataWord.wrap(key), DataWord.wrap(value));
    }

    public static void get_balance(byte[] result, Context context, byte[] address) {
        DataWord balance = context.getBalance(Address.warp(address));
        byte[] bytes = (balance == null) ? DataWord.ZERO.getRaw() : balance.getRaw();

        System.arraycopy(bytes, 0, result, 0, bytes.length);
    }

    public static int get_code_size(Context context, byte[] address) {
        byte[] code = context.getCode(Address.warp(address));

        return (code == null) ? 0 : code.length;
    }

    public static int copy_code(Context context, byte[] address, int offset, byte[] buffer) {
        byte[] code = context.getCode(Address.warp(address));

        if (code != null && offset > 0 && offset < code.length) {
            int remaining = code.length - offset;
            System.arraycopy(code, offset, buffer, 0, remaining);
            return remaining;
        }

        return 0;
    }

    // TODO:
    //
    // 1. void (*evmc_selfdestruct_fn)(struct evmc_context* context,
    // const struct evmc_address* address,
    // const struct evmc_address* beneficiary);
    //
    // 2. void (*evmc_emit_log_fn)(struct evmc_context* context,
    // const struct evmc_address* address,
    // const uint8_t* data,
    // size_t data_size,
    // const struct evmc_uint256be topics[],
    // size_t topics_count);
    //
    // 3. void (*evmc_call_fn)(struct evmc_result* result,
    // struct evmc_context* context,
    // const struct evmc_message* msg);
}