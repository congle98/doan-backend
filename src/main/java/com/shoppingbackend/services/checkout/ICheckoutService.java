package com.shoppingbackend.services.checkout;

import com.shoppingbackend.dto.request.Purchase;
import com.shoppingbackend.dto.response.PurchaseResponse;

public interface ICheckoutService {
    PurchaseResponse placeOrder(Purchase purchase);
}
