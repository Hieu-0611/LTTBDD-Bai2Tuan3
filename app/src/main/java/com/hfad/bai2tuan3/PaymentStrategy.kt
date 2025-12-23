package com.hfad.bai2tuan3

interface PaymentStrategy {
    fun pay(amount: Double): String
}

class PayPalStrategy : PaymentStrategy {
    override fun pay(amount: Double) = "Paid $amount via PayPal"
}

class GooglePayStrategy : PaymentStrategy {
    override fun pay(amount: Double) = "Paid $amount via Google Pay"
}

class ApplePayStrategy : PaymentStrategy {
    override fun pay(amount: Double) = "Paid $amount via Apple Pay"
}
