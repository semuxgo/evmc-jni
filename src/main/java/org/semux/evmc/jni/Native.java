/**
 * Copyright (c) 2018 The Semux Developers
 *
 * Distributed under the MIT software license, see the accompanying file
 * LICENSE or https://opensource.org/licenses/mit-license.php
 */
package org.semux.evmc.jni;

import java.util.Arrays;

import org.semux.evmc.jni.type.Address;
import org.semux.evmc.jni.type.DataWord;
import org.semux.evmc.jni.type.Message;
import org.semux.evmc.jni.type.Result;

public class Native {

    public static native byte[] create_evmjit();

    public static native void set_option(long vm, byte[] name, byte[] value);

    public static native byte[] execute(Context context, int revision, byte[] msg, byte[] code);

    public static native void destroy(long vm);

    /*
     * The following methods are called from JNI
     */

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

    public static void selfdestruct(Context context, byte[] address, byte[] beneficiary) {
        context.selfdestruct(Address.warp(address), Address.warp(beneficiary));
    }

    public static void emit_log(Context context, byte[] address, byte[] data, byte[] topics) {
        DataWord[] arr = new DataWord[topics.length / DataWord.SIZE];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = DataWord.wrap(Arrays.copyOfRange(topics, i * DataWord.SIZE, (i + 1) * DataWord.SIZE));
        }
        context.emitLog(Address.warp(address), data, arr);
    }

    public static byte[] call(Context context, byte[] msg) {
        Result result = context.call(Message.fromBytes(msg));
        return result.toBytes();
    }
}