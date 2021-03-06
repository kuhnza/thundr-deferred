/*
 * This file is a component of thundr, a software library from 3wks.
 * Read more: http://www.3wks.com.au/thundr
 * Copyright (C) 2013 3wks, <thundr@3wks.com.au>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.threewks.thundr.deferred.provider;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class InMemoryQueueProviderTest {
	private InMemoryQueueProvider provider;

	@Before
	public void before() {
		provider = new InMemoryQueueProvider();
	}

	@Test
	public void shouldSendAndReceiveSingleMessage() {
		provider.send("Hello");
		List<String> messages = provider.receive();
		assertThat(messages.size(), is(1));
		assertThat(messages, hasItem("Hello"));
	}

	@Test
	public void shouldSendAndReceiveMultipleMessages() {
		provider.send("Hello");
		provider.send("World");
		List<String> messages = provider.receive();
		assertThat(messages.size(), is(2));
		assertThat(messages, hasItems("Hello", "World"));

	}
}
