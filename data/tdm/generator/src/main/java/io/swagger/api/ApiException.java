/*
 *
 */
package io.swagger.api;

// TODO: Auto-generated Javadoc
/**
 * The Class ApiException.
 */
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-09-22T08:24:51.189Z[GMT]")
public class ApiException extends Exception {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -2174637728997742359L;

	/** The code. */
	private final int code;

	/**
	 * Instantiates a new api exception.
	 *
	 * @param code the code
	 * @param msg  the msg
	 */
	public ApiException(int code, String msg) {
		super(msg);
		this.code = code;
	}
}
