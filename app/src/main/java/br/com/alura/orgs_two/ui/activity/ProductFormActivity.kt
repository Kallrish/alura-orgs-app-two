package br.com.alura.orgs_two.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import br.com.alura.orgs_two.R
import br.com.alura.orgs_two.dao.DaoProducts
import br.com.alura.orgs_two.databinding.ActivityProductFormBinding
import br.com.alura.orgs_two.databinding.ImageFormBinding
import br.com.alura.orgs_two.extensions.imageLoadAttempt
import br.com.alura.orgs_two.model.Product
import br.com.alura.orgs_two.ui.dialog.ImageDialogForm
import coil.load
import java.math.BigDecimal

class ProductFormActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityProductFormBinding.inflate(layoutInflater)
    }

    private var url: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        title = "Cadastrar produto"
        setupSaveButton()
        binding.activityProductFormImage.setOnClickListener {
            ImageDialogForm(this)
                .show(url) {image ->
                    url = image
                    binding.activityProductFormImage.imageLoadAttempt(url)
                }
        }
    }

    private fun setupSaveButton() {
        val buttonSave = binding.activityProductFormBtnSave
        val daoProducts = DaoProducts()
        buttonSave.setOnClickListener {
            val newProduct = createProduct()
            daoProducts.addProducts(newProduct)
            finish()
        }
    }

    private fun createProduct(): Product {
        val fieldName = binding.activityProductFormTietName
        val name = fieldName.text.toString()
        val fieldDescription = binding.activityProductFormTietDescription
        val description = fieldDescription.text.toString()
        val fieldValue = binding.activityProductFormTietValue
        val textValue = fieldValue.text.toString()
        val value = if (textValue.isBlank()) {
            BigDecimal.ZERO
        } else {
            BigDecimal(textValue)
        }

        return Product(
            name = name,
            description = description,
            value = value,
            image = url
        )
    }
}