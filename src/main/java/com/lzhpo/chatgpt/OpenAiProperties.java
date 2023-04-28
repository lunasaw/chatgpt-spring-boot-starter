/*
 * Copyright 2023 lzhpo
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.lzhpo.chatgpt;

import java.time.Duration;
import java.util.*;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

/**
 * @author lzhpo
 */
@Data
@ConfigurationProperties(prefix = "openai")
public class OpenAiProperties {

    /**
     * The openAI API keys.
     */
    private List<OpenAiKey> keys = new ArrayList<>();

    /**
     * The openAi endpoint configuration.
     */
    private Map<OpenAiUrl, String> urls = new EnumMap<>(OpenAiUrl.class);

    /**
     * The proxy to request openAi API.
     */
    @NestedConfigurationProperty
    private OpenAiProxy proxy;

    /**
     * The openAi or proxy address.
     */
    private String domain = "https://api.openai.com";

    /**
     * The connect timeout.
     */
    private Duration connectTimeout = Duration.ofMinutes(1);

    /**
     * The read timeout.
     */
    private Duration readTimeout = Duration.ofMinutes(1);

    /**
     * The write timeout.
     */
    private Duration writeTimeout = Duration.ofMinutes(1);
}
