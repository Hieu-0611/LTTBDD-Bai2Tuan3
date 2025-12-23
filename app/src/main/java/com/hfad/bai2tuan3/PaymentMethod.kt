package com.hfad.bai2tuan3

sealed class PaymentMethod(
    val id: String,
    val displayName: String,
    val smallIconRes: Int,
    val largeIconRes: Int,
    val strategy: PaymentStrategy
) {
    data object PayPal : PaymentMethod(
        id = "paypal",
        displayName = "PayPal",
        smallIconRes = R.drawable.ic_paypal_small,
        largeIconRes = R.drawable.ic_paypal_large,
        strategy = PayPalStrategy()
    )

    data object GooglePay : PaymentMethod(
        id = "gpay",
        displayName = "GooglePay",
        smallIconRes = R.drawable.ic_gpay_small,
        largeIconRes = R.drawable.ic_gpay_large,
        strategy = GooglePayStrategy()
    )

    data object ApplePay : PaymentMethod(
        id = "applepay",
        displayName = "ApplePay",
        smallIconRes = R.drawable.ic_applepay_small,
        largeIconRes = R.drawable.ic_applepay_large,
        strategy = ApplePayStrategy()
    )
}

class PaymentProcessor {
    fun checkout(amount: Double, method: PaymentMethod): String {
        return method.strategy.pay(amount)
    }
}
