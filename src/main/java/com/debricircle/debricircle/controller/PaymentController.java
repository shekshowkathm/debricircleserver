package com.debricircle.debricircle.controller;

import java.math.BigInteger;
import java.util.UUID;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.debricircle.debricircle.model.OrderRequest;
import com.debricircle.debricircle.model.OrderResponse;
import com.debricircle.debricircle.repository.IPaymentRepository;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

/**
 * 
 * @author josephine
 * @date 9-OCT-2023
 * 
 */

@CrossOrigin("*")
@RestController
@RequestMapping("/pg")
public class PaymentController {
	private RazorpayClient client;
	@Value("${razorpay1.secretid}")
	private String secret_Id;
	@Value("${razorpay1.secretkey}")
	private String secret_key;
	@Autowired
	private IPaymentRepository paymentRepository;

	@RequestMapping(path = "/createOrder", method = RequestMethod.POST)
	public OrderResponse createOrder(@RequestBody OrderRequest orderRequest) {
		OrderResponse response = new OrderResponse();

		try {
			client = new RazorpayClient(secret_Id, secret_key);

			BigInteger amount = orderRequest.getAmount();
			if (amount == null) {
				throw new IllegalArgumentException("Amount cannot be null");
			}

			Order order = createRazorPayOrder(amount);
			System.out.println("---------------------------");
			String orderId = (String) order.get("id");
			System.out.println("Order ID: " + orderId);
			System.out.println("---------------------------");
			response.setRazorpayOrderId(orderId);
			response.setApplicationFee("" + amount);
			response.setSecretKey(secret_key);
			response.setSecretId(secret_Id);
			response.setPgName("razor1");
			paymentRepository.save(orderRequest);
			return response;

		} catch (RazorpayException e) {
			e.printStackTrace();
		}
		
		return response;
	}

	private Order createRazorPayOrder(BigInteger amount) throws RazorpayException {
		if (amount == null) {
			throw new IllegalArgumentException("Amount cannot be null");
		}

		JSONObject options = new JSONObject();
		options.put("amount", amount.multiply(new BigInteger("100"))); // 100 paise = 1.00 INR
		options.put("currency", "INR");
		String generatedReceipt = "order_" + UUID.randomUUID().toString();
		String truncatedReceipt = generatedReceipt.substring(0, Math.min(generatedReceipt.length(), 40));
		options.put("receipt", truncatedReceipt);
		options.put("payment_capture", 1); // You can enable this if you want to do Auto Capture.
		return client.orders.create(options);
	}
}
