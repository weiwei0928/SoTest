#include <jni.h>
#include <string>

void test();

extern "C" JNIEXPORT jstring JNICALL
Java_com_ww_sotest_MainActivity_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}

int max(int num1, int num2)
{
    int result;

    if (num1 > num2)
        result = num1;
    else
        result = num2;

    return result;
}

extern "C"
JNIEXPORT jstring JNICALL
Java_com_ww_sotest_MainActivity_invokeNative(JNIEnv *env, jobject thiz) {
    // TODO: implement invokeNative()
}
extern "C"

extern "C"
JNIEXPORT jint JNICALL
Java_com_ww_sotest_MainActivity_maxNum(JNIEnv *env, jobject thiz, jint a, jint b) {
    int ret = max(a,b);
    return ret;
}
