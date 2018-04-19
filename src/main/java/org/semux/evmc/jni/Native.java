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

    public static native byte[] execute(long vm, Context context, int revision, byte[] msg, byte[] code);

    public static native void destroy(long vm);

    public static int account_exists(long vm, Context context, byte[] address) {
        return context.accountExists(Evm.getInstance(vm), Address.warp(address)) ? 1 : 0;
    }

    public static byte[] get_storage(long vm, Context context, byte[] address, byte[] key) {
        DataWord value = context.getStorage(Evm.getInstance(vm), Address.warp(address), DataWord.wrap(key));

        return value == null ? DataWord.ZERO.getRaw() : value.getRaw();
    }

    public static void set_storage(long vm, Context context, byte[] address, byte[] key, byte[] value) {
        context.setStorage(Evm.getInstance(vm), Address.warp(address), DataWord.wrap(key), DataWord.wrap(value));
    }
}