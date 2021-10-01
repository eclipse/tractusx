/*
 *
 */
package io.swagger.api;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

// TODO: Auto-generated Javadoc
/**
 * The Class ApiOriginFilter.
 */
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-09-22T08:24:51.189Z[GMT]")
public class ApiOriginFilter implements javax.servlet.Filter {

	/**
	 * Destroy.
	 */
	@Override
	public void destroy() {
	}

	/**
	 * Do filter.
	 *
	 * @param request  the request
	 * @param response the response
	 * @param chain    the chain
	 * @throws IOException      Signals that an I/O exception has occurred.
	 * @throws ServletException the servlet exception
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		final HttpServletResponse res = (HttpServletResponse) response;
		res.addHeader("Access-Control-Allow-Origin", "*");
		res.addHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
		res.addHeader("Access-Control-Allow-Headers", "Content-Type");
		chain.doFilter(request, response);
	}

	/**
	 * Inits the.
	 *
	 * @param filterConfig the filter config
	 * @throws ServletException the servlet exception
	 */
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}
}
