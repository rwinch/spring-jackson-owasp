/*
 * Copyright 2002-2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package sample;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 *
 * @author Rob Winch
 *
 */
@Configuration
public class OwaspConfig {

	@Bean
	public MappingJackson2HttpMessageConverter owaspJacksonConverter() {
		return new MappingJackson2HttpMessageConverter(objectMapper());
	}

	@Bean
	@Primary
	public ObjectMapper objectMapper() {
		JsonFactory factory = new JsonFactory();
		factory.setCharacterEscapes(new OwaspCharacterEscapes());
		return new ObjectMapper(factory);
	}
}
