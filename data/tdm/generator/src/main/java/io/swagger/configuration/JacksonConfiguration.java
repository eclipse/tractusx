/*
 *
 */
package io.swagger.configuration;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.threeten.bp.Instant;
import org.threeten.bp.OffsetDateTime;
import org.threeten.bp.ZonedDateTime;

import com.fasterxml.jackson.datatype.threetenbp.ThreeTenModule;

// TODO: Auto-generated Javadoc
/**
 * The Class JacksonConfiguration.
 */
@Configuration
public class JacksonConfiguration {

	/**
	 * Three ten module.
	 *
	 * @return the three ten module
	 */
	@Bean
	@ConditionalOnMissingBean(ThreeTenModule.class)
	ThreeTenModule threeTenModule() {
		final ThreeTenModule module = new ThreeTenModule();
		module.addDeserializer(Instant.class, CustomInstantDeserializer.INSTANT);
		module.addDeserializer(OffsetDateTime.class, CustomInstantDeserializer.OFFSET_DATE_TIME);
		module.addDeserializer(ZonedDateTime.class, CustomInstantDeserializer.ZONED_DATE_TIME);
		return module;
	}
}
