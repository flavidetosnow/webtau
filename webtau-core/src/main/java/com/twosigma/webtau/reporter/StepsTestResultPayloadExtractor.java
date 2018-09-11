/*
 * Copyright 2018 TWO SIGMA OPEN SOURCE, LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.twosigma.webtau.reporter;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class StepsTestResultPayloadExtractor implements TestResultPayloadExtractor {
    @Override
    public Stream<TestResultPayload> extract(Stream<TestStep<?, ?>> testSteps) {
        List<? extends Map<String, ?>> stepsAsMaps = testSteps.map(TestStep::toMap).collect(toList());

        return Stream.of(new TestResultPayload("steps", stepsAsMaps));
    }
}