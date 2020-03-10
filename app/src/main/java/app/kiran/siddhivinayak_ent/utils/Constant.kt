package app.kiran.siddhivinayak_ent.utils

import android.os.Environment

object Constant {
    const val APP_NAME = "LevelAgentUser"

    const val INTENT_100 = 100
    const val INTENT_200 = 200
    const val INTENT_300 = 300

    const val LIGHT = 1
    const val REGULAR = 2
    const val SEMI_BOLD = 3
    const val BOLD = 4
    const val EXTRABOLD = 5


    const val CURRENCY = "$"
    const val COUNTRY_CODE = ""
    var STRIP_PUBLISH_KEY = ""
    //
    var BASE_URL = "http://demo.magespider.com/LevelAgent/api/"
    var RANDOM_IMAGE_USER = "https://i.picsum.photos/id/1011/5472/3648.jpg"
    var RANDOM_IMAGE_PROPERTY = "https://www.bajajfinserv.in/Loan_Against_PropertyEligibility_Banner_Image_LAP_Banner_Mobile.jpg"


    var APP_HOME =
        Environment.getExternalStorageDirectory().path + "/" + APP_NAME
    var DIR_USERDATA = "$APP_HOME/userdata"
    const val BROADCAST_VERIFY = "com.magespider.parkeyspot.receiver.otp"

    var PER_PAGE_LIMIT = 15
    var DEVICE_TYPE = "2" // 2 for android


    var SERVER_DATE_FORMAT = "yyyy-MM-dd hh:mm:ss" // server format

    var DISPLAY_DATE_FORMAT = "dd MMM, yyyy hh:mm a" // display format format

    var DISPLAY_DATE_FORMAT_SEC =
        "dd MMM, yyyy hh:mm:ss a" // display format format with second


    var SERVER_DATE_FORMAT_SHORT = "yyyy-MM-dd" // server format

    var DISPLAY_DATE_FORMAT_SHORT = "dd MMM, yyyy" // display format format


    // Api Response
    interface API_TYPE {
        companion object {
            const val GET = "GET"
            const val POST = "POST"
            const val PUT = "PUT"
        }
    }

    interface SHORT_BY {
        companion object {
            const val ASC = "asc"
            const val DESC = "desc"
        }
    }

    interface PIN_TYPE {
        companion object {
            const val CURRENT = "CURRENT"
            const val DESTINATION = "DESTINATION"
        }
    }

    interface STATUS {
        companion object {
            const val FAIL = 0
            const val SUCCESS = 1
            const val EXPIRED = 2
            const val VERIFY = 2
            const val EMAIL_NOT_REGISTER = 3
            const val EMAIL_ALREADY_REGISTER = 5
            const val PROFILE_IS_INCOMPLETE = 6 /*0 = Faild
1 = Success
2 = Token Expired
3 = account not verified
4 = email is not registered with us
5 = Already registered with us*/
        }
    }

    interface GENDER {
        companion object {
            const val MALE = "MALE"
            const val FEMALE = "FEMALE"
            const val OTHER = "OTHER"
        }
    }

    interface FROM_ACTIVITY {
        companion object {
            const val CUSTOMER_LIST_TAB = "CUSTOMER_LIST_TAB"
            const val SALES_TAB = "SALES_TAB"
            const val LEDGER_TAB = "LEDGER_TAB"
            const val OUT_STANDING = "OUT_STANDING"
        }
    }

    interface INTENT_EXTRA {
        companion object {
            const val REGISTER_BEAN = "REGISTER_BEAN"
            const val VERY_OTP_BEAN = "VERY_OTP_BEAN"
            const val TO_VERIFY_OTP = "TO_VERIFY_OTP"
            const val EMAIL = "EMAIL"
            const val TITLE = "TITLE"
        }
    }

    interface SAVE_AS {
        companion object {
            const val HOME = "1"
            const val WORK = "2"
        }
    }

    interface FONT {
        companion object {
            const val MON_BOLD = "font/Montserrat-Bold.ttf"
        }
    }


    interface CMS_TYPE {
        companion object {
            const val TERMS = "terms"
            const val PRIVACY = "privacy"
            const val LEAGAL = "leagal"
            const val INVITES = "invites-work"
        }
    }

    interface SOCIAL_LOGIN {
        companion object {
            const val GOOGLE = "google"
            const val FACEBOOK = "facebook"
        }
    }

    interface PROFILE_STEPS {
        companion object {
            const val PERSONAL_INFO = "personal_info"
            const val ADDRESS = "address"
            const val PLATE = "plate"
            const val PAYMENT = "payment"
            const val PLAN = "plan"
        }
    }

    interface USER_ROLE {
        companion object {
            const val USER = "user"
            const val DRIVER = "driver"
        }
    }
}