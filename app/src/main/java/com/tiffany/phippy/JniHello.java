package com.tiffany.phippy;

/**
 * Created by moses on 13/08/2017.
 */

public class JniHello {
    //使用静态代码块来加载相应的so文件
    static {
        System.loadLibrary("hello");//需要加载的so文件的名称
    }

    //声明一个由 native 修饰的函数
    public native String SayHello();
}
