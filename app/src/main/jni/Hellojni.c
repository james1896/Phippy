#include "../com_tiffany_phippy_JniHello.h"

/*
 * Class:     com_example_zwjian_myapplication_JniHello
 * Method:    SayHello
 * Signature: ()Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_com_tiffany_phippy_JniHello_SayHello(JNIEnv *env, jobject obj) {
    char *hello = "hello from JNI";
    (*env)->NewStringUTF(env, hello);

}