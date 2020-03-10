package app.kiran.siddhivinayak_ent.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import app.kiran.siddhivinayak_ent.R
import app.kiran.siddhivinayak_ent.databinding.RawCustomerListBinding
import kotlinx.android.synthetic.main.raw_customer_list.view.*


class CustomerListAdapter : RecyclerView.Adapter<CustomerListAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.raw_customer_list, parent, false)
        val binding = RawCustomerListBinding.bind(view)
        return MyViewHolder(binding.root)
    }

    override fun getItemCount(): Int {
        return 10
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.customerCard.tag = position
        
    }


    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var customerCard = itemView.cardCustomer
    }


}


