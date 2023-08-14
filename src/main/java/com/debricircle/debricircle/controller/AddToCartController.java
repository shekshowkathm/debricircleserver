package com.debricircle.debricircle.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.debricircle.debricircle.model.AddToCart;
import com.debricircle.debricircle.service.IAddToCartService;

/*
 * @Author : Shek Showkath 
 * 
 *@Date : 04-08-2023
 *
 *@Modified : 14-08-2023
 */

@CrossOrigin
@RestController
@RequestMapping("/addtocart")

public class AddToCartController {
	
	@Autowired
	private IAddToCartService addToCartService;
	
	@PostMapping("/createcart")
	public ResponseEntity<AddToCart> addCart(@RequestBody AddToCart addToCart){
		AddToCart addCartProduct=addToCartService.addCart(addToCart);
		return new ResponseEntity<AddToCart>(addCartProduct,HttpStatus.OK);
	}
	
	@GetMapping("/claimaddtocart")
	public ResponseEntity<List<AddToCart>> getAllAddToCart(){
		List<AddToCart> listOfAllAddToCart=addToCartService.getAllAddToCart();
		return new ResponseEntity<List<AddToCart>>(listOfAllAddToCart,HttpStatus.OK);
	}
	
	@PutMapping("/updatepiece")
	public ResponseEntity<AddToCart> updateAddToCart(@RequestBody AddToCart addToCart){
		AddToCart updatePiece=addToCartService.updateAddToCart(addToCart);
		return new ResponseEntity<AddToCart>(updatePiece,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/getcartdetails/{userid}")
	public ResponseEntity<List<AddToCart>> getCartByUserID(@PathVariable("userid") String userid){
		List<AddToCart> getDetails=addToCartService.getCartByUserID(userid);
		return new ResponseEntity<List<AddToCart>>(getDetails,HttpStatus.OK);
	}
	
	@DeleteMapping("/removecart/{userid}/{productId}")
	public ResponseEntity<Void> removeCart(@PathVariable("userid") String userid,@PathVariable("productId") String productId){
		addToCartService.deleteCartByUseridAndProductID(userid, productId);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	@PutMapping("/incrementpieceofproduct")
	public ResponseEntity<AddToCart> incrementPieceProduct(@RequestBody AddToCart addToCart){
		AddToCart updatePiece=addToCartService.incrementProductPiece(addToCart);
		return new ResponseEntity<AddToCart>(updatePiece,HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/decrementpieceofproduct")
	public ResponseEntity<AddToCart> decrementPieceOfProduct(@RequestBody AddToCart addToCart){
		AddToCart updatePiece=addToCartService.decrementProductPiece(addToCart);
		return new ResponseEntity<AddToCart>(updatePiece,HttpStatus.ACCEPTED);
	}
	
	
}
