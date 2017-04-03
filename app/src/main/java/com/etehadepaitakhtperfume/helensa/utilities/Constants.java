package com.etehadepaitakhtperfume.helensa.utilities;

import android.net.Uri;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class Constants {

    /*private static String WEB_SERVER = "http://crm.tehrangasco.ir/support/api/rest/public/";*/
    private static String WEB_SERVER = "http://support.appchar.com/api/rest/public/";
    public static String SIGN_UP_URL = WEB_SERVER + "user";
    public static String APP_INSTALLATIONS_URL = WEB_SERVER + "app_installation";
    public static String LOGIN_URL = WEB_SERVER + "user/token";
    public static String TOPICS_URL = WEB_SERVER + "topics";
    public static String POST_TICKET_URL = WEB_SERVER + "tickets";
    public static String GET_TICKETS_URL = WEB_SERVER + "tickets";
    public static String GET_FAQS_URL = WEB_SERVER + "faq";
    public static String GET_NEWS_URL = WEB_SERVER + "news";
    public static String GET_TICKET_URL = WEB_SERVER + "tickets/";
    public static String CLOSE_TICKET_URL = WEB_SERVER + "tickets/";
    public static String REPLY_TICKET_URL = WEB_SERVER + "tickets/";
    public static String POST_ATTACHMENT_TICKET = WEB_SERVER + "tickets/attachment";
    public static String FORGOT_PASSWORD_URL = WEB_SERVER + "user/forget_password";
    public static String CHANGE_PASSWORD_URL = WEB_SERVER + "user/change_password";
    public static String TICKET_TRACKING_URL = WEB_SERVER + "tickets/ticket-tracking";
    public static String USER_TICKET_STATS = WEB_SERVER + "tickets/stats";
    public static String GET_COMPANY_URL = WEB_SERVER + "company";

    public static int OPEN_FORM_ACTIVITY_REQUEST_CODE = 808;


    //Name Strings:
    static String LOG_TAG = "****ASHKAN ** DEBUG****";

    // local


    //Shared Pref Keys
    static String SP_FILE_NAME_BASE = "sp_file_base";
    static String FALSE = "FALSE";
    public static String TRUE = "TRUE";

    //INTENT KEYS:
    public static String PARENT_ID = "PARENT_ID";
    public static String TITLE = "TITLE";
    public static String MAX_NUMBER = "MAX_NUMBER";
    public static String HEADER_IMAGE = "HEADER_IMAGE";
    public static String LINK = "LINK";
    public static String POSITION = "POSITION";
    public static String FROM_SPLASH = "FROM_SPLASH";
    public static String TYPE = "TYPE";
    public static String IMAGE = "IMAGE";
    public static String ID = "ID";
    public static String TICKET_ID = "TICKET_ID";
    public static String CREATED = "CREATED";
    public static String DATA = "DATA";
    public static String TOKEN = "TOKEN";
    public static String EMAIL = "EMAIL";
    public static String PHONE = "PHONE";
    public static String PASSWORD = "PASSWORD";
    public static String LOGGED_IN_USER = "LOGGED_IN_USER";
    public static String USER_ID = "USER_ID";
    public static String APP_INSTALLATION_ID = "USER_ID";
    public static String TICKET_NUMBER = "TICKET_NUMBER";
    public static String IS_REPLIED = "IS_REPLIED";
    public static String DEPARTMENT_NAME = "DEPARTMENT_NAME";
    public static String STATUS = "STATUS";
    public static String ISGUEST = "IS_GUEST";
    public static String PARENTISGUESTLOGIN = "PARENT_IS_GUEST_LOGIN";
    public static String VIEWED_NEWS = "VIEWED_NEWS";


    // 0 : new items
    // 1 : top items
    public static String LIST_TYPE = "LIST_TYPE";
    public static final int TYPE_NEW_ITEMS = 0;
    public static final int TYPE_TOP_ITEMS = 1;
    public static final String TOP_ITEMS_PARAMETER = "&sortby=SortBy-5";
    public static final String NEW_ITEMS_PARAMETER = "&sortby=SortBy-2";

    public static String GROUP_ID = "GROUP_ID";
    public static String HOME_LIST_TYPE = "HOME_LIST_TYPE";
    public static String PRODUCT_ID = "PRODUCT_ID";
    public static String PRODUCT_LIST = "PRODUCT_LIST";
    public static String TECHNICAL_SPEC = "TECHNICAL_SPEC";
    public static String MODEL_JSON = "MODEL_JSON";


    //Numbers:
    public static int NOTIFICATION_CHECK_INTERVAL = 30 * 60 * 1000;
    public static final int VOLLEY_TIME_OUT = 25000;
    public static int COUNT = 7;
    public static final int CAMERA_CAPTURE_IMAGE_REQUEST_CODE = 100;
    public static final int GALLERY_PICK_IMAGE_REQUEST_CODE = 101;
    public static final int MEDIA_TYPE_IMAGE = 1;
    public static final int MEDIA_TYPE_VIDEO = 2;

    // directory name to store captured images and videos
    private static final String IMAGE_DIRECTORY_NAME = "Faraz";

    public static final int NOTIFICATION_ID = 900;
    static boolean DEBUG = true;

    public static String persianNumbers(String num) {
        try {
            char[] persianNumbers = {'٠', '١', '٢', '٣', '٤', '٥', '٦', '٧', '٨', '٩'};
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < num.length(); i++) {
                if (Character.isDigit(num.charAt(i))) {
                    builder.append(persianNumbers[(int) (num.charAt(i)) - 48]);
                } else {
                    builder.append(num.charAt(i));
                }
            }
            return builder.toString();
        } catch (Exception e) {
            return num;
        }
    }

    public static String formatPrice(String num) {
        DecimalFormat formatter = new DecimalFormat("#,###,###");
        return formatter.format(Float.valueOf(num));
    }

    /**
     * Creating file uri to store image/video
     */
    public static Uri getOutputMediaFileUri(int type) {
        return Uri.fromFile(getOutputMediaFile(type));
    }

    /**
     * returning image / video
     */
    private static File getOutputMediaFile(int type) {

        // External sdcard location
        File mediaStorageDir = new File(
                Environment
                        .getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),
                IMAGE_DIRECTORY_NAME);

        // Create the storage directory if it does not exist
        if (!mediaStorageDir.exists()) {
            if (!mediaStorageDir.mkdirs()) {
                Log.d(IMAGE_DIRECTORY_NAME, "Oops! Failed create "
                        + IMAGE_DIRECTORY_NAME + " directory");
                return null;
            }
        }

        // Create a media file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss",
                Locale.getDefault()).format(new Date());
        File mediaFile;
        if (type == MEDIA_TYPE_IMAGE) {
            mediaFile = new File(mediaStorageDir.getPath() + File.separator
                    + "IMG_" + timeStamp + ".jpg");
        } else if (type == MEDIA_TYPE_VIDEO) {
            mediaFile = new File(mediaStorageDir.getPath() + File.separator
                    + "VID_" + timeStamp + ".mp4");
        } else {
            return null;
        }

        return mediaFile;
    }

}
