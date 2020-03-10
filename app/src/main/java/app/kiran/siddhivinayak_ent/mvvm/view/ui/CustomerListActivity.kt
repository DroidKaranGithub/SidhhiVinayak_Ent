package app.kiran.siddhivinayak_ent.mvvm.view.ui

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import app.kiran.siddhivinayak_ent.R
import app.kiran.siddhivinayak_ent.adapter.CustomerListAdapter
import app.kiran.siddhivinayak_ent.databinding.ActivityCustomerListBinding
import app.kiran.siddhivinayak_ent.utils.Constant

class CustomerListActivity : BaseActivity(), View.OnClickListener {

    lateinit var binding: ActivityCustomerListBinding
    lateinit var customerListAdapter: CustomerListAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_customer_list)
        binding.lifecycleOwner = this
        initUi()

    }

    override fun initUi() {
        when {
            intent.hasExtra(Constant.FROM_ACTIVITY.CUSTOMER_LIST_TAB) -> {
                binding.headerLayout.ivAdd.visibility = View.VISIBLE
            }
            intent.hasExtra(Constant.FROM_ACTIVITY.SALES_TAB) -> {

            }
            intent.hasExtra(Constant.FROM_ACTIVITY.LEDGER_TAB) -> {

            }
            intent.hasExtra(Constant.FROM_ACTIVITY.OUT_STANDING) -> {

            }
            //        binding.headerLayout.ivBack. = resources.getColor(R.color.colorPrimary)
        }




        binding.headerLayout.ivOpenNav.visibility = View.GONE
        binding.headerLayout.ivBack.visibility = View.VISIBLE
//        binding.headerLayout.ivBack. = resources.getColor(R.color.colorPrimary)
        binding.headerLayout.tvHeaderTitle.visibility = View.VISIBLE
        binding.headerLayout.clHeader.setBackgroundColor(resources.getColor(R.color.colorPrimaryDark))
        binding.headerLayout.ivBack.setOnClickListener(this)
        binding.rvCustomerList.layoutManager = LinearLayoutManager(getContext())
        customerListAdapter = CustomerListAdapter();
        binding.rvCustomerList.adapter = customerListAdapter
        binding.rvCustomerList.addItemDecoration(
            DividerItemDecoration(
                this,
                LinearLayoutManager.VERTICAL
            )
        )
    }

    override fun getContext(): Context? {
        return this
    }

    override fun getLayoutId(): View? {
        return binding.root
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.ivBack -> {
                onBackPressed()
            }
        }
    }
}
