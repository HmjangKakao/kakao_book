#include <jni.h>

JNIEXPORT jstring JNICALL
Java_com_hmjang_kakaobook_KeyHolder_getApiKey(JNIEnv *env, jobject instance) {
 return (*env)->  NewStringUTF(env, "MGJhMDdkMjAyYTM0NDAwMjdjYjkwMzk0ZDMyYTJmZmU=");
}