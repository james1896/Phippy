package com.tiffany.phippy;

/**
 * Created by moses on 20/07/2017.
 */

public class PHIUserManager extends  Object{


    protected String userName;
    protected boolean downloadImageOnlyWIFI;



    //--------------------------------
    //  set get
    //--------------------------------

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public boolean isDownloadImageOnlyWIFI() {
        return downloadImageOnlyWIFI;
    }

    public void setDownloadImageOnlyWIFI(boolean downloadImageOnlyWIFI) {
        this.downloadImageOnlyWIFI = downloadImageOnlyWIFI;
    }

    //--------------------------------
    //  单利
    //--------------------------------
    private static PHIUserManager instance;
    //私有的构造方法
    private PHIUserManager(){};
    //公有的同步静态方法
    public static synchronized PHIUserManager getInstance() {
        if (instance == null) {
            instance = new PHIUserManager();
        }
        return instance;
    }


}
