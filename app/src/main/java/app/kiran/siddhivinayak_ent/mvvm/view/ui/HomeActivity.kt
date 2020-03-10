package app.kiran.siddhivinayak_ent.mvvm.view.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import app.kiran.siddhivinayak_ent.R
import app.kiran.siddhivinayak_ent.databinding.ActivityHomeBinding
import app.kiran.siddhivinayak_ent.utils.Constant

class HomeActivity : BaseActivity(), View.OnClickListener {

    lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        binding.lifecycleOwner = this
        initUi()
    }

    override fun initUi() {
        binding.HomeView.cardCustomerName.setOnClickListener(this)
        binding.HomeView.customerCardImage.setOnClickListener(this)
        binding.HomeView.cardTotalSales.setOnClickListener(this)
        binding.HomeView.cardTotalSalesCardImage.setOnClickListener(this)
        binding.HomeView.cardLedger.setOnClickListener(this)
        binding.HomeView.LedgerCardImage.setOnClickListener(this)
        binding.HomeView.cardOutStanding.setOnClickListener(this)
        binding.HomeView.OutStandingCardImage.setOnClickListener(this)
    }

    override fun getContext(): Context? {
        return this
    }

    override fun getLayoutId(): View? {
        return binding.root
    }

    override fun onClick(view: View?) {
        when (view!!.id) {
            R.id.cardCustomerName,
            R.id.customerCardImage -> {
                val intent = Intent(this, CustomerListActivity::class.java)
                intent.putExtra(Constant.FROM_ACTIVITY.CUSTOMER_LIST_TAB,Constant.FROM_ACTIVITY.CUSTOMER_LIST_TAB)
                startActivity(intent)
            }
            R.id.cardTotalSales,
            R.id.cardTotalSalesCardImage -> {
                val intent = Intent(this, CustomerListActivity::class.java)
                intent.putExtra(Constant.FROM_ACTIVITY.SALES_TAB,Constant.FROM_ACTIVITY.SALES_TAB)
                startActivity(intent)
            }
            R.id.cardLedger,
            R.id.LedgerCardImage -> {
                val intent = Intent(this, CustomerListActivity::class.java)
                intent.putExtra(Constant.FROM_ACTIVITY.SALES_TAB,Constant.FROM_ACTIVITY.SALES_TAB)
                startActivity(intent)
            }
            R.id.cardOutStanding,
            R.id.OutStandingCardImage -> {
                val intent = Intent(this, CustomerListActivity::class.java)
                intent.putExtra(Constant.FROM_ACTIVITY.OUT_STANDING,Constant.FROM_ACTIVITY.OUT_STANDING)
                startActivity(intent)
            }
        }
    }
}

