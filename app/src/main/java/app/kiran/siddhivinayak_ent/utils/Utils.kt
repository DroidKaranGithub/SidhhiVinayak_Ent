package app.kiran.siddhivinayak_ent.utils

import android.app.Activity
import android.app.DatePickerDialog
import android.content.Context
import android.content.Intent
import android.os.Handler
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.view.animation.Animation
import android.view.inputmethod.InputMethodManager
import android.widget.DatePicker
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatEditText
import app.kiran.siddhivinayak_ent.MyApplication
import app.kiran.siddhivinayak_ent.R
import app.kiran.siddhivinayak_ent.common.AppManager
import app.kiran.siddhivinayak_ent.common.PrefConst
import app.kiran.siddhivinayak_ent.common.PrefManager
import app.kiran.siddhivinayak_ent.mvvm.view.ui.LoginActivity
import app.kiran.siddhivinayak_ent.mvvm.view.ui.SplashActivity
import com.developer.kalert.KAlertDialog

import java.util.*

object Utils {

    lateinit var appManager1: AppManager
    lateinit var prefManager1: PrefManager
    val c = Calendar.getInstance()
    val year = c.get(Calendar.YEAR)
    val month = c.get(Calendar.MONTH)
    val day = c.get(Calendar.DAY_OF_MONTH)
    var hour = c.get(Calendar.HOUR_OF_DAY)
    var minute = c.get(Calendar.MINUTE)
    fun Utils(appManager: AppManager, prefManager: PrefManager) {
        appManager1 = appManager
        prefManager1 = prefManager
    }

    fun makeFullScreenActivity(activity: AppCompatActivity) {

        val window = activity.window
        activity.requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
    }
    /*interface SelectFilterDates {

        fun selectedDate(start_date : String, end_date : String)
    }*/

    fun customEmoBounceAnimation(iv: View, handler: Handler, customEmoBounce: Animation) {
        iv.startAnimation(customEmoBounce)
        handler.postDelayed({
            iv.visibility = View.INVISIBLE
            iv.clearAnimation()
        }, 499)
    }

    fun hideKeyBoardFromView(context: Context) {
        val inputMethodManager =
            context.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        // Find the currently focused view, so we can grab the correct window
        // token from it.
        var view = (context as Activity).currentFocus
        // If no view currently has focus, create a new one, just so we can grab
        // a window token from it
        if (view == null) {
            view = View(context)
        }
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }


    fun print(mesg: String) {
        if (true) {
            println(mesg)
        }
    }


    fun print(title: String, mesg: String) {
        if (true) {
            print("$title :: $mesg")
        }
    }

    fun toast(context: Activity, msg: String, isShort: Boolean) {

        val layoutValue: View = context.layoutInflater.inflate(R.layout.toast, null)
        val toast = Toast(context)
        toast.duration = Toast.LENGTH_SHORT
        var textView: TextView
        textView = layoutValue.findViewById(R.id.tvToastMsg)
        toast.view = layoutValue
        toast.show()

    }
    fun toast(context: Context?, message: String?) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
    fun setDateTimeField(editText: AppCompatEditText, context: Context) {
        val arrayDate: Array<String>
        if (!editText.getText().toString().isEmpty()) {
            val date = editText.getText().toString().trim()
            arrayDate = date.split(("-").toRegex()).dropLastWhile({ it.isEmpty() }).toTypedArray()
        } else {
            arrayDate =
                "01-01-2000".split(("-").toRegex()).dropLastWhile({ it.isEmpty() }).toTypedArray()
        }
        val newDate = Calendar.getInstance()
        val pYear = newDate.get(Calendar.YEAR)
        val pMonth = newDate.get(Calendar.MONTH)
        val pDay = newDate.get(Calendar.DAY_OF_MONTH)
        val sDay = Integer.parseInt(arrayDate[0].trim({ it <= ' ' }))
        val sMonth = Integer.parseInt(
            String.format(
                "%02d",
                Integer.parseInt(arrayDate[1].trim({ it <= ' ' }))
            )
        )
        val sYear = Integer.parseInt(
            String.format(
                "%02d",
                Integer.parseInt(arrayDate[2].trim({ it <= ' ' }))
            )
        )
        val dateDialog = DatePickerDialog(context, object : DatePickerDialog.OnDateSetListener {
            override fun onDateSet(
                view: DatePicker, year: Int, monthOfYear: Int,
                dayOfMonth: Int
            ) {
                val newDate = Calendar.getInstance()
                newDate.set(year, monthOfYear, dayOfMonth)
                editText.setText(
                    StringBuilder().append(dayOfMonth).append("-").append(((if (((monthOfYear + 1) < 10)) "0" else "") + (monthOfYear + 1))).append(
                        "-"
                    ).append(((if (((year) < 10)) "0" else "") + (year))).append("")
                )
            }
        }, pYear, pMonth + 1, pDay)
        dateDialog.getDatePicker().setMaxDate(Date().getTime())
        Utils.print("date::" + Date().getTime())
        dateDialog.show()
    }

    fun setDateTimeFieldForDeliveryDate(editText: AppCompatEditText, context: Context) {
        val arrayDate: Array<String>
        if (!editText.getText().toString().isEmpty()) {
            val date = editText.getText().toString().trim()
            arrayDate = date.split(("-").toRegex()).dropLastWhile({ it.isEmpty() }).toTypedArray()
        } else {
            arrayDate =
                "01-01-2000".split(("-").toRegex()).dropLastWhile({ it.isEmpty() }).toTypedArray()
        }
        val newDate = Calendar.getInstance()
        val pYear = newDate.get(Calendar.YEAR)
        val pMonth = newDate.get(Calendar.MONTH)
        val pDay = newDate.get(Calendar.DAY_OF_MONTH)
        val sDay = Integer.parseInt(arrayDate[0].trim({ it <= ' ' }))
        val sMonth = Integer.parseInt(
            String.format(
                "%02d",
                Integer.parseInt(arrayDate[1].trim({ it <= ' ' }))
            )
        )
        val sYear = Integer.parseInt(
            String.format(
                "%02d",
                Integer.parseInt(arrayDate[2].trim({ it <= ' ' }))
            )
        )
        val dateDialog = DatePickerDialog(context, object : DatePickerDialog.OnDateSetListener {
            override fun onDateSet(
                view: DatePicker, year: Int, monthOfYear: Int,
                dayOfMonth: Int
            ) {
                val newDate = Calendar.getInstance()
                newDate.set(year, monthOfYear, dayOfMonth)
                if (newDate.equals(Calendar.getInstance())) {

                } else {
                    editText.setText(
                        StringBuilder().append(dayOfMonth).append("-").append(((if (((monthOfYear + 1) < 10)) "0" else "") + (monthOfYear + 1))).append(
                            "-"
                        ).append(((if (((year) < 10)) "0" else "") + (year))).append("")
                    )
                }
            }
        }, pYear, pMonth, pDay)
        dateDialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000)

        Utils.print("date::" + Date().getTime())
        dateDialog.show()
    }

    fun checkLoginWithDialog(context: Context) {
        KAlertDialog(context, KAlertDialog.WARNING_TYPE)
            .setTitleText(context.resources.getString(R.string.login))
            .setContentText(context.resources.getString(R.string.session_expired_please_login_again))
            .setCancelText(context.resources.getString(R.string.cancel))
            .setConfirmText(context.resources.getString(R.string.login).toUpperCase())
            .showCancelButton(true)
            .setCancelClickListener { sDialog: KAlertDialog -> sDialog.dismiss() }
            .setConfirmClickListener { sDialog: KAlertDialog ->
                sDialog.dismiss()
                Utils.logoutFromApp(context)
                context.startActivity(
                    Intent(context, SplashActivity::class.java).putExtra(
                        "DIALOG",
                        ""
                    )
                )
            }
            .show()
    }

    fun logoutFromApp(mContext: Context) {
        Utils.print(
            "Clearing Token = " + MyApplication.getAppManager().getPrefManager().getString(
                PrefConst.PREF_USER_TOKEN_SECURITY
            )
        )
        val keyList: List<String> = ArrayList()
        MyApplication.getAppManager().getPrefManager().clearExcept(keyList)
        MyApplication.setAppManager(null)
        mContext.startActivity(Intent(mContext, LoginActivity::class.java))
        (mContext as Activity).finishAffinity()
    }

}
