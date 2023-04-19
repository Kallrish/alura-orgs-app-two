package br.com.alura.orgs_two.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.alura.orgs_two.dao.DaoProducts
import br.com.alura.orgs_two.databinding.ActivityProductsListBinding
import br.com.alura.orgs_two.ui.recyclerview.adapter.AdapterProductList

class ProductsListActivity : AppCompatActivity() {

    private val dao = DaoProducts()
    private val adapter = AdapterProductList(context = this, products = dao.searchAllProducts())
    private val binding by lazy {
        ActivityProductsListBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupRecyclerView()
        setupFab()
    }

    override fun onResume() {
        super.onResume()
        adapter.update(dao.searchAllProducts())

    }

    private fun setupFab() {
        val fabAddProduct = binding.activityProductListEfabAddProduct
        fabAddProduct.setOnClickListener {
            goToProductForm()
        }
    }

    private fun goToProductForm() {
        val intent = Intent(this, ProductFormActivity::class.java)
        startActivity(intent)
    }

    private fun setupRecyclerView() {
        val rvProductList = binding.activityProductListProductList
        rvProductList.adapter = adapter
        adapter.itemClick = {
            val intent = Intent(
                this,
                ProductDetailsActivity::class.java
            ).apply {
                putExtra(PRODUCT_KEY, it)
            }
            startActivity(intent)
        }
    }

}