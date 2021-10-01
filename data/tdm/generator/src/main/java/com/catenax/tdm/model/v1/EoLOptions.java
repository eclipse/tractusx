/*
 *
 */
package com.catenax.tdm.model.v1;

import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

// TODO: Auto-generated Javadoc
/**
 * EoLOptions.
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-09-14T13:39:46.417Z[GMT]")

public class EoLOptions {

	/** The reuse options. */
	@JsonProperty("reuseOptions")
	private ReuseOptionsSelection reuseOptions = null;

	/** The recycling options. */
	@JsonProperty("recyclingOptions")
	private RecyclingOptionsSelection recyclingOptions = null;

	/** The disassembly steps. */
	@JsonProperty("disassemblySteps")
	private StepsSequenceCharacteristics disassemblySteps = null;

	/** The recycling steps. */
	@JsonProperty("recyclingSteps")
	private StepsSequenceCharacteristics recyclingSteps = null;

	/**
	 * Disassembly steps.
	 *
	 * @param disassemblySteps the disassembly steps
	 * @return the eo L options
	 */
	public EoLOptions disassemblySteps(StepsSequenceCharacteristics disassemblySteps) {
		this.disassemblySteps = disassemblySteps;
		return this;
	}

	/**
	 * Equals.
	 *
	 * @param o the o
	 * @return true, if successful
	 */
	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		final EoLOptions eoLOptions = (EoLOptions) o;
		return Objects.equals(this.reuseOptions, eoLOptions.reuseOptions)
				&& Objects.equals(this.recyclingOptions, eoLOptions.recyclingOptions)
				&& Objects.equals(this.disassemblySteps, eoLOptions.disassemblySteps)
				&& Objects.equals(this.recyclingSteps, eoLOptions.recyclingSteps);
	}

	/**
	 * Get disassemblySteps.
	 *
	 * @return disassemblySteps
	 */
	@Schema(description = "")

	@Valid
	public StepsSequenceCharacteristics getDisassemblySteps() {
		return disassemblySteps;
	}

	/**
	 * Get recyclingOptions.
	 *
	 * @return recyclingOptions
	 */
	@Schema(required = true, description = "")
	@NotNull

	@Valid
	public RecyclingOptionsSelection getRecyclingOptions() {
		return recyclingOptions;
	}

	/**
	 * Get recyclingSteps.
	 *
	 * @return recyclingSteps
	 */
	@Schema(description = "")

	@Valid
	public StepsSequenceCharacteristics getRecyclingSteps() {
		return recyclingSteps;
	}

	/**
	 * Get reuseOptions.
	 *
	 * @return reuseOptions
	 */
	@Schema(required = true, description = "")
	@NotNull

	@Valid
	public ReuseOptionsSelection getReuseOptions() {
		return reuseOptions;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(reuseOptions, recyclingOptions, disassemblySteps, recyclingSteps);
	}

	/**
	 * Recycling options.
	 *
	 * @param recyclingOptions the recycling options
	 * @return the eo L options
	 */
	public EoLOptions recyclingOptions(RecyclingOptionsSelection recyclingOptions) {
		this.recyclingOptions = recyclingOptions;
		return this;
	}

	/**
	 * Recycling steps.
	 *
	 * @param recyclingSteps the recycling steps
	 * @return the eo L options
	 */
	public EoLOptions recyclingSteps(StepsSequenceCharacteristics recyclingSteps) {
		this.recyclingSteps = recyclingSteps;
		return this;
	}

	/**
	 * Reuse options.
	 *
	 * @param reuseOptions the reuse options
	 * @return the eo L options
	 */
	public EoLOptions reuseOptions(ReuseOptionsSelection reuseOptions) {
		this.reuseOptions = reuseOptions;
		return this;
	}

	/**
	 * Sets the disassembly steps.
	 *
	 * @param disassemblySteps the new disassembly steps
	 */
	public void setDisassemblySteps(StepsSequenceCharacteristics disassemblySteps) {
		this.disassemblySteps = disassemblySteps;
	}

	/**
	 * Sets the recycling options.
	 *
	 * @param recyclingOptions the new recycling options
	 */
	public void setRecyclingOptions(RecyclingOptionsSelection recyclingOptions) {
		this.recyclingOptions = recyclingOptions;
	}

	/**
	 * Sets the recycling steps.
	 *
	 * @param recyclingSteps the new recycling steps
	 */
	public void setRecyclingSteps(StepsSequenceCharacteristics recyclingSteps) {
		this.recyclingSteps = recyclingSteps;
	}

	/**
	 * Sets the reuse options.
	 *
	 * @param reuseOptions the new reuse options
	 */
	public void setReuseOptions(ReuseOptionsSelection reuseOptions) {
		this.reuseOptions = reuseOptions;
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 *
	 * @param o the o
	 * @return the string
	 */
	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("class EoLOptions {\n");

		sb.append("    reuseOptions: ").append(toIndentedString(reuseOptions)).append("\n");
		sb.append("    recyclingOptions: ").append(toIndentedString(recyclingOptions)).append("\n");
		sb.append("    disassemblySteps: ").append(toIndentedString(disassemblySteps)).append("\n");
		sb.append("    recyclingSteps: ").append(toIndentedString(recyclingSteps)).append("\n");
		sb.append("}");
		return sb.toString();
	}
}
