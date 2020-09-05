#include <jni.h>

JNIEXPORT jstring JNICALL
Java_com_hmjang_kakaobook_KeyHolder_getApiKey(JNIEnv *env, jobject instance) {
 return (*env)->  NewStringUTF(env, "0ba07d202a3440027cb90394d32a2ffe");
}