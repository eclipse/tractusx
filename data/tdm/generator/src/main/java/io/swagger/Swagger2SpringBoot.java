/*
 *
 */
package io.swagger;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import springfox.documentation.oas.annotations.EnableOpenApi;

// TODO: Auto-generated Javadoc
/**
 * The Class Swagger2SpringBoot.
 */
@SpringBootApplication
@EnableOpenApi
@ComponentScan(basePackages = { "io.swagger", "io.swagger.api", "io.swagger.configuration", "com.catenax.tdm.dao",
		"com.catenax.tdm.api" })
@EntityScan(basePackages = { "com.catenax.tdm.model.v1" })
@EnableJpaRepositories(basePackages = { "com.catenax.tdm.dao" })
public class Swagger2SpringBoot implements CommandLineRunner {

	/**
	 * The Class ExitException.
	 */
	static class ExitException extends RuntimeException implements ExitCodeGenerator {

		/** The Constant DEFAULT_EXIT_CODE. */
		private static final int DEFAULT_EXIT_CODE = 10;
		/** The Constant serialVersionUID. */
		private static final long serialVersionUID = 1L;

		/**
		 * Gets the exit code.
		 *
		 * @return the exit code
		 */
		@Override
		public int getExitCode() {
			return DEFAULT_EXIT_CODE;
		}

	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws Exception the exception
	 */
	public static void main(String[] args) throws Exception {
		new SpringApplication(Swagger2SpringBoot.class).run(args);
	}

	/**
	 * Run.
	 *
	 * @param arg0 the arg 0
	 * @throws Exception the exception
	 */
	@Override
	public void run(String... arg0) throws Exception {
		if (arg0.length > 0 && "exitcode".equals(arg0[0])) {
			throw new ExitException();
		}
	}
}
