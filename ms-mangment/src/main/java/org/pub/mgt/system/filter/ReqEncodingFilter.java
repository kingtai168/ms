package org.pub.mgt.system.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @author liufeng
 * 
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class ReqEncodingFilter implements Filter {

	/**
	 * The default character encoding to set for requests that pass through this
	 * filter.
	 */
	protected String encoding = null;

	/**
	 * The filter configuration object we are associated with. If this value is
	 * null, this filter instance is not currently configured.
	 */
	protected FilterConfig filterConfig = null;

	//private static ThreadLocal layerThreadLocal = new ThreadLocal();

	/**
	 * Should a character encoding specified by the client be ignored?
	 */
	protected boolean ignore = true;

	public void init(FilterConfig config) throws ServletException {

		this.filterConfig = config;
		this.encoding = filterConfig.getInitParameter("encoding");
		String value = filterConfig.getInitParameter("ignore");
		if (value == null) {
			this.ignore = true;
		} else if (value.equalsIgnoreCase("true")
				|| value.equalsIgnoreCase("yes")) {
			this.ignore = true;
		} else {
			this.ignore = false;
		}
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		if (ignore || (request.getCharacterEncoding() == null)) {
			request.setCharacterEncoding(selectEncoding(request));
			response.setContentType("text/html; charset="+encoding);
		}
		chain.doFilter(request, response);
	}

	/**
	 * Select an appropriate character encoding to be used, based on the
	 * characteristics of the current request and/or filter initialization
	 * parameters. If no character encoding should be set, return
	 * <code>null</code>.
	 * <p>
	 * The default implementation unconditionally returns the value configured
	 * by the <strong>encoding</strong> initialization parameter for this
	 * filter.
	 * 
	 * @param request
	 *            The servlet request we are processing
	 */
	protected String selectEncoding(ServletRequest request) {
		return (this.encoding);
	}

	public void destroy() {
		this.encoding = null;
		this.filterConfig = null;
	}

	public FilterConfig getFilterConfig() {
		// TODO Method stub generated by Lomboz
		return null;
	}

	public void setFilterConfig(FilterConfig config) {
		// TODO Method stub generated by Lomboz
	}
}