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
package com.threewks.thundr.deferred.test;

import com.threewks.thundr.deferred.task.BaseRetryableDeferredTask;

public class MockRetryableDeferredTask extends BaseRetryableDeferredTask {
	private int maxRetries;

	public MockRetryableDeferredTask(int maxRetries) {
		this.maxRetries = maxRetries;
	}

	@Override

	public int maxRetries() {
		return maxRetries;
	}

	@Override
	protected void runInternal() {
		if (retries() < 3) {
			throw new RuntimeException("Failed intentionally! Retry count: " + retries());
		}
	}
}
