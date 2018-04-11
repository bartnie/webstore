/*
 * Copyright (c) 2018.
 * Bartosz Niesobski - All rights reserved.
 */

package pl.bartek.webstore.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import pl.bartek.webstore.entity.Cart;
import pl.bartek.webstore.entity.CartEntry;
import pl.bartek.webstore.entity.Product;
import pl.bartek.webstore.exception.AbstractNotFoundException;
import pl.bartek.webstore.exception.CartNotFoundException;
import pl.bartek.webstore.service.cart.CartService;
import pl.bartek.webstore.service.product.ProductService;

@Controller
@RequestMapping("/cart/rest")
public class CartRestController {

	@Autowired
	CartService cartService;

	@Autowired
	ProductService productService;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity createCart(@RequestBody final Cart cart) {
		cartService.add(cart);
		return new ResponseEntity(HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{cartId}")
	public ResponseEntity<Cart> getCartById(@PathVariable final String cartId) {
		return new ResponseEntity<>(cartService.findById(cartId), HttpStatus.OK);
	}

	@RequestMapping(value = "/{cartId}", method = RequestMethod.DELETE)
	public ResponseEntity deleteCart(@PathVariable final String cartId) {
		cartService.removeById(cartId);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(value = "/add/{productId}", method = RequestMethod.POST)
	public ResponseEntity addItem(@PathVariable final String productId, final HttpServletRequest request) {
		final String sessionId = request.getSession().getId();
		Cart cart;
		try {
			cart = cartService.findById(sessionId);
		} catch (final CartNotFoundException e) {
				cart = new Cart(sessionId);
		}
		final Product product = productService.findById(productId);
		cartService.addCartEntry(cart, new CartEntry(product));
		cartService.add(cart);
		return new ResponseEntity(HttpStatus.ACCEPTED);
	}

	@RequestMapping(value = "/remove/{productId}", method = RequestMethod.POST)
	public ResponseEntity removeItem(@PathVariable final String productId, final HttpServletRequest request) {
		final String sessionId = request.getSession().getId();
		final Cart cart = cartService.findById(sessionId);
		final Product product = productService.findById(productId);
		cartService.removeCartEntry(cart, new CartEntry(product));
		cartService.add(cart);
		return new ResponseEntity(HttpStatus.ACCEPTED);
	}

	@RequestMapping(value = "/current/cartId")
	public String getCurrentCartId(final HttpServletRequest request){
		return request.getSession().getId();
	}

	@ExceptionHandler(AbstractNotFoundException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Invalid request, check sent data")
	public void handleClientErrors(final Exception e) {
	}

	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Internal server error")
	public void handleServerErrors(final Exception e) {
	}

}
