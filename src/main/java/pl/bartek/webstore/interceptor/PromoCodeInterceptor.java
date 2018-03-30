/*
 * Copyright (c) 2018.
 * Bartosz Niesobski - All rights reserved.
 */

package pl.bartek.webstore.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

public class PromoCodeInterceptor implements HandlerInterceptor {

	private String promoCode;
	private String errorRedirect;
	private String offerRedirect;

	@Override
	public boolean preHandle(final HttpServletRequest request, final HttpServletResponse response, final Object handler)
					throws Exception {
		final String givenPromoCode =
						request.getParameterValues("promo") == null ? "" : request.getParameterValues("promo")[0];
		if(request.getRequestURI().endsWith("/products/specialOffer")){
			if(givenPromoCode.equals(promoCode)){
				response.sendRedirect(offerRedirect);
			}
			else{
				response.sendRedirect(errorRedirect);
			}
			return false;
		}
		return true;
	}

	public void setPromoCode(final String promoCode) {
		this.promoCode = promoCode;
	}

	public void setErrorRedirect(final String errorRedirect) {
		this.errorRedirect = errorRedirect;
	}

	public void setOfferRedirect(final String offerRedirect) {
		this.offerRedirect = offerRedirect;
	}
}
