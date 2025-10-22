package com.ityefan.abstractdemo3;

public  abstract class People {
    public final void  write(){
        System.out.println("\t\t\t《我的爸爸》");
        System.out.println("\t我的爸爸是一个很好的人，下面我来介绍一下我爸爸");
        writemain();
        System.out.println("\t你的爸爸是怎样的呢");
    }
    public abstract void writemain();
}
