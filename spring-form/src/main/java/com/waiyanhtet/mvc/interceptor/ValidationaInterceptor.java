package com.waiyanhtet.mvc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class ValidationaInterceptor implements HandlerInterceptor {

	private static final String BINDING_KEY = "org.springframework.validation.BindingResult";
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("Post interceptor");
		var allError = modelAndView.getModel().entrySet()
			.stream()
			.filter(entry -> entry.getKey().startsWith(BINDING_KEY))
			.map(entry -> entry.getValue())
			.filter(value -> value instanceof BindingResult result)
			.map(obj -> (BindingResult)obj)
			.flatMap(result -> result.getAllErrors().stream())
			.map(error -> error.getDefaultMessage()).toList();
		modelAndView.getModelMap().put("allError", allError);
		System.out.println(allError);
	
			
	}
}
