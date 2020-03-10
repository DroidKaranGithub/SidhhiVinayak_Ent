package app.kiran.siddhivinayak_ent.mvvm.view.ui

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import app.kiran.siddhivinayak_ent.R
import app.kiran.siddhivinayak_ent.common.AppManager
import app.kiran.siddhivinayak_ent.common.PrefManager
import app.kiran.siddhivinayak_ent.common.connectivity.display.NetworkStatusDisplayer
import app.kiran.siddhivinayak_ent.utils.Constant
import app.kiran.siddhivinayak_ent.utils.Utils
import com.developer.kalert.KAlertDialog
import com.novoda.merlin.*
import java.lang.Exception

abstract class BaseActivity : AppCompatActivity(), Connectable, Disconnectable, Bindable {

    var mContext: Context? = null
    var networkStatusDisplayer: NetworkStatusDisplayer? = null
    var merlinsBeard: MerlinsBeard? = null
    lateinit var merlin: Merlin
    lateinit var prefManager: PrefManager
    lateinit var appManager: AppManager
    lateinit var pDialogLoading: KAlertDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mContext = this
        appManager = AppManager.getInstance(this)
        prefManager = appManager.prefManager
        pDialogLoading = KAlertDialog(this, KAlertDialog.PROGRESS_TYPE)
            .setTitleText(resources.getString(R.string.loading))
        pDialogLoading.setCancelable(false)
        merlin = Merlin.Builder()
            .withConnectableCallbacks()
            .withDisconnectableCallbacks()
            .withBindableCallbacks()
            .build(mContext)

        merlinsBeard = MerlinsBeard.Builder()
            .build(mContext)
        networkStatusDisplayer = NetworkStatusDisplayer(resources, merlinsBeard)
        merlin.bind()

        overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(R.anim.trans_right_in, R.anim.trans_right_out)
    }

    fun registerConnectable(connectable: Connectable?) {
        merlin.registerConnectable(connectable)
    }

    protected fun registerDisconnectable(disconnectable: Disconnectable) {
        merlin.registerDisconnectable(disconnectable)
    }

    protected fun registerBindable(bindable: Bindable) {
        merlin.registerBindable(bindable)
    }

    override fun onResume() {
        super.onResume()
        registerConnectable(this)
        registerDisconnectable(this)
        registerBindable(this)
    }

    override fun onStop() {
        super.onStop()
        merlin.unbind()
    }

    override fun onConnect() {

    }

    override fun onDisconnect() {
        networkStatusDisplayer!!.displayNegativeMessage(
            R.string.No_internet_available,
            getLayoutId()
        )
    }

    override fun onBind(networkStatus: NetworkStatus?) {
        if (!networkStatus!!.isAvailable) {
            onDisconnect()
        }
    }

    override fun onPause() {
        super.onPause()
        networkStatusDisplayer!!.reset()
    }

    override fun onDestroy() {
        super.onDestroy()
        networkStatusDisplayer = null
    }

    fun isConnected(show: Boolean): Boolean {
        if (show) {
            if (merlinsBeard!!.isConnected) {

            } else {
                networkStatusDisplayer!!.displayNegativeMessage(
                    R.string.No_internet_available,
                    getLayoutId()
                )
            }
        }
        return merlinsBeard!!.isConnected
    }

    abstract fun initUi()

    abstract fun getContext(): Context?

    abstract fun getLayoutId(): View?

    protected fun showProgressBar(show: Boolean) {
        if (show) {
            try {
                if (pDialogLoading.isShowing) pDialogLoading.dismiss()
                pDialogLoading.show()
            } catch (e: Exception) {
                e.printStackTrace()
            }

        } else {
            try {
                if (pDialogLoading.isShowing) pDialogLoading.dismiss()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    protected fun showErrorDialog(message :String?, showTitle : Boolean){
        val  kAlertDialog = KAlertDialog(mContext, KAlertDialog.ERROR_TYPE)
        if (showTitle) kAlertDialog.titleText = mContext!!.resources.getString(R.string.Oops)
        kAlertDialog.setContentText(message).show()
    }


    protected fun showErrorDialog(message: String?, title : String?){
        KAlertDialog(mContext, KAlertDialog.ERROR_TYPE)
            .setTitleText(title)
            .setContentText(message).show()
    }

  protected fun showSuccessDialog(message: String?){
      KAlertDialog(mContext, KAlertDialog.SUCCESS_TYPE)
          .setContentText(message).show()
  }

    protected fun showMessageDialog(message: String?, showTitle: Boolean){

        val kAlertDialog = KAlertDialog(mContext, KAlertDialog.ERROR_TYPE)
        if (showTitle) kAlertDialog.titleText = mContext!!.resources.getString(R.string.Oops)
        kAlertDialog.setCancelable(true)
        kAlertDialog.setCanceledOnTouchOutside(true)
        kAlertDialog.setContentText(message).show()
    }

    protected fun showDialogAsStatus(status : Int, message: String?){
        if (status == Constant.STATUS.FAIL){
            showErrorDialog(message, false)
        }else if (status ==Constant.STATUS.EXPIRED){
            mContext?.let { Utils.checkLoginWithDialog(it) }
        }
    }
}