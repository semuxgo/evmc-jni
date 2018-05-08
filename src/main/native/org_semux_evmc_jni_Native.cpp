#include "org_semux_evmc_jni_Native.h"

#include <evmc.h>
#include <evmjit.h>
#include <cstdint>
#include <cstdlib>
#include <cstring>

/**
 * Encodes a 32-bit integer in its BE format.
 */
inline void encode_int(int32_t num, jbyte *dest) {
    dest[0] = (num >> 24) & 0xff;
    dest[1] = (num >> 16) & 0xff;
    dest[2] = (num >> 8) & 0xff;
    dest[3] = num & 0xff;
}

/**
 * Decodes a 32-bit integer.
 */
inline int32_t decode_int(jbyte *dest) {
    return ((int32_t) dest[0] << 24) | ((int32_t) dest[1] << 16)
            | ((int32_t) dest[2] << 8) | ((int32_t) dest[3]);
}

/**
 * Encodes a 64-bit integer in its BE format.
 */
inline void encode_long(int64_t num, jbyte *dest) {
    encode_int(num >> 32, dest);
    encode_int(num & 0xffffffff, dest + 4);
}

/**
 * Decodes a 64-bit integer.
 */
inline int64_t decode_long(jbyte *dest) {
    return ((int64_t) decode_int(dest) << 32) | (int64_t) decode_int(dest + 4);
}

/**
 * Encodes an byte array: size + raw bytes.
 */
inline void encode_bytes(const uint8_t *bytes, size_t size, jbyte *dest) {
    encode_int(size, dest);
    memcpy(dest += 4, bytes, size);
}

/**
 * Encodes an instance object.
 */
jbyteArray encode_instance(JNIEnv *env, struct evmc_instance *instance) {
    int name_size = strlen(instance->name);
    int version_size = strlen(instance->version);
    int size = 8 + 4 + name_size + 4 + version_size + 4;
    jbyte *buf = (jbyte *) malloc(size);
    jbyte *ptr = buf;

    // encode
    encode_long((int64_t) instance, ptr);
    encode_int(instance->abi_version, ptr + 8);
    encode_bytes((const uint8_t *) instance->name, name_size, ptr += 4);
    encode_bytes((const uint8_t *) instance->version, version_size, ptr +=
            name_size);

    // copy back
    jbyteArray bytes = env->NewByteArray(size);
    env->SetByteArrayRegion(bytes, 0, size, buf);
    free(buf);

    return bytes;
}

JNIEXPORT jbyteArray JNICALL Java_org_semux_evmc_jni_Native_create_1evmjit(
        JNIEnv *env, jclass cls) {
    struct evmc_instance *instance = evmjit_create();

    if (instance == nullptr) {
        return nullptr;
    } else {
        return encode_instance(env, instance);
    }
}

JNIEXPORT void JNICALL Java_org_semux_evmc_jni_Native_set_1option(JNIEnv *env,
        jclass cls, jlong, jbyteArray, jbyteArray) {
}

JNIEXPORT jbyteArray JNICALL Java_org_semux_evmc_jni_Native_execute(JNIEnv *env,
        jclass cls, jobject, jint, jbyteArray, jbyteArray) {
    return nullptr;
}

JNIEXPORT void JNICALL Java_org_semux_evmc_jni_Native_destroy(JNIEnv *env,
        jclass cls, jlong instance) {
    struct evmc_instance *p = (struct evmc_instance *) instance;
    p->destroy(p);
}
