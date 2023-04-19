package br.com.alura.orgs_two.ui.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.alura.orgs_two.R
import br.com.alura.orgs_two.databinding.ProductItemBinding
import br.com.alura.orgs_two.extensions.formatBrazilCurrency
import br.com.alura.orgs_two.extensions.imageLoadAttempt
import br.com.alura.orgs_two.model.Product
import coil.load
import java.math.BigDecimal
import java.text.NumberFormat
import java.util.*

class AdapterProductList(
    private val context: Context,
    products: List<Product>,
    var itemClick: (product:Product) -> Unit = {}
) : RecyclerView.Adapter<AdapterProductList.ViewHolder>() {

    private val products = products.toMutableList()

    inner class ViewHolder(private val binding: ProductItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        private val name = binding.productItemName
        private val description = binding.productItemDescription
        private val value = binding.productItemValue
        private val image = binding.productItemImage

        private lateinit var product: Product

        init {
            itemView.setOnClickListener{
                if (::product.isInitialized) {
                    itemClick(product)
                }
            }
        }

        fun link(product: Product) {
            this.product = product
            name.text = product.name
            description.text = product.description
            val formattedValue = product.value.formatBrazilCurrency()
            value.text = formattedValue

            val visibility =  if(product.image != null) {
                View.VISIBLE
            } else {
                View.GONE
            }
            image.visibility = visibility

            image.imageLoadAttempt(product.image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val binding = ProductItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = products[position]
        holder.link(product)
    }

    override fun getItemCount(): Int = products.size

    fun update(products: List<Product>) {
        this.products.clear()
        this.products.addAll(products)
        notifyDataSetChanged()
    }
}
