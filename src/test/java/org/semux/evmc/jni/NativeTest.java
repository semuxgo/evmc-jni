/**
 * Copyright (c) 2018 The Semux Developers
 *
 * Distributed under the MIT software license, see the accompanying file
 * LICENSE or https://opensource.org/licenses/mit-license.php
 */
package org.semux.evmc.jni;

import java.util.Locale;

public class NativeTest {
    public static void main(String[] args) {
        String name = System.getProperty("os.name").toLowerCase(Locale.US);
        String arch = System.getProperty("os.arch").toLowerCase(Locale.US);
        String version = System.getProperty("os.version").toLowerCase(Locale.US);

        System.out.println(name + "/" + arch + "/" + version);
    }
}
