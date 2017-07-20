package com.tiffany.phippy;

/**
 * Created by moses on 20/07/2017.
 */

public class PHIUserManager extends  Object{


    protected String userName;
    private String save_userName_key = "save_userName_key";
    protected boolean downloadImageOnlyWIFI;
    private String save_downloadImageOnlyWIFI_key = "save_downloadImageOnlyWIFI_key";



    //--------------------------------
    //  set get
    //--------------------------------

    public String getUserName() {

        this.userName = CommonUtils.getString(PHIApplication.getContext(),save_userName_key);
        return userName;

    }

    public void setUserName(String userName) {

        CommonUtils.saveString(PHIApplication.getContext(),save_userName_key,userName);
        this.userName = userName;
    }

    public boolean isDownloadImageOnlyWIFI() {
        this.downloadImageOnlyWIFI = CommonUtils.getBoolean(PHIApplication.getContext(),save_downloadImageOnlyWIFI_key);
        return downloadImageOnlyWIFI;
    }

    public void setDownloadImageOnlyWIFI(boolean downloadImageOnlyWIFI) {
        CommonUtils.saveBoolean(PHIApplication.getContext(),save_downloadImageOnlyWIFI_key,downloadImageOnlyWIFI);
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
