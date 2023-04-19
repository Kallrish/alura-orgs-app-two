package br.com.alura.orgs_two.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.alura.orgs_two.databinding.ActivityProductDetailsBinding
import br.com.alura.orgs_two.extensions.formatBrazilCurrency
import br.com.alura.orgs_two.extensions.imageLoadAttempt
import br.com.alura.orgs_two.model.Product

class ProductDetailsActivity: AppCompatActivity() {

    private val binding by lazy {
        ActivityProductDetailsBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        tryLoadingProduct()
    }

    private fun tryLoadingProduct() {
        intent.getParcelableExtra<Product>(PRODUCT_KEY)?.let { loadedProduct ->
            fillFields(loadedProduct)
        } ?: finish()
    }

    private fun fillFields(loadedProduct: Product) {
        with(binding) {
            activityProductDetailImage.imageLoadAttempt(loadedProduct.image)
            activityProductDetailTvName.text = loadedProduct.name
            activityProductDetailTvDescription.text = loadedProduct.description
            activityProductDetailTvValue.text =
                loadedProduct.value.formatBrazilCurrency()
        }
    }
}