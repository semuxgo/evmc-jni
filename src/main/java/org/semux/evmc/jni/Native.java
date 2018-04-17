/**
 * Copyright (c) 2018 The Semux Developers
 *
 * Distributed under the MIT software license, see the accompanying file
 * LICENSE or https://opensource.org/licenses/mit-license.php
 */
package org.semux.evmc.jni;

public class Native {

    public static native long create_evmjit();

    public static native long create_example_evm();

    public static native void set_option(long vm, byte[] name, byte[] value);

    public static native byte[] execute(long vm, Context context, int revision, byte[] msg, byte[] code);

    public static native void destroy(long vm);
}
