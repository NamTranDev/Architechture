#include <jni.h>

JNIEXPORT jstring JNICALL
Java_nam_tran_data_database_DbModule_getDBKEY(JNIEnv *env, jobject instance) {

    return (*env)->  NewStringUTF(env, "NamTranDev");
}