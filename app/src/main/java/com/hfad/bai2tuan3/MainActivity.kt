package com.hfad.bai2tuan3

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.hfad.bai2tuan3.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: PaymentAdapter

    private val methods = listOf(
        PaymentMethod.PayPal,
        PaymentMethod.GooglePay,
        PaymentMethod.ApplePay
    )

    private var picked: PaymentMethod? = null
    private val processor = PaymentProcessor()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Mặc định: chưa chọn
        binding.imgSelectedLarge.setImageResource(R.drawable.ic_payment_placeholder)
        binding.btnContinue.isEnabled = false

        adapter = PaymentAdapter(methods) { method ->
            picked = method
            adapter.setSelected(method)

            // Update UI khi chọn
            binding.imgSelectedLarge.setImageResource(method.largeIconRes)
            binding.btnContinue.isEnabled = true
        }

        binding.rvPayments.adapter = adapter

        binding.btnContinue.setOnClickListener {
            val m = picked ?: return@setOnClickListener
            val result = processor.checkout(amount = 99.0, method = m)
            Toast.makeText(this, result, Toast.LENGTH_SHORT).show()
        }
    }
}
