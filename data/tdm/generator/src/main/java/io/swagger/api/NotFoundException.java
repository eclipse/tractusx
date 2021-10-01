/*
 *
 */
package io.swagger.api;

// TODO: Auto-generated Javadoc
/**
 * The Class NotFoundException.
 */
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-09-22T08:24:51.189Z[GMT]")
public class NotFoundException extends ApiException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -8000903005649088467L;

	/** The code. */
	private final int code;

	/**
	 * Instantiates a new not found exception.
	 *
	 * @param code the code
	 * @param msg  the msg
	 */
	public NotFoundException(int code, String msg) {
		super(code, msg);
		this.code = code;
	}
}
