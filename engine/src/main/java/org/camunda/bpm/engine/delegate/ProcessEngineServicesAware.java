/*
 * Copyright © 2013-2018 camunda services GmbH and various authors (info@camunda.com)
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
package org.camunda.bpm.engine.delegate;

import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.ProcessEngineServices;

/**
 * <p>Interface providing access to the {@link ProcessEngineServices} from Java
 * delegation code.</p>
 *
 * @author Daniel Meyer
 *
 */
public interface ProcessEngineServicesAware {

  /**
   * Returns the {@link ProcessEngineServices} providing access to the
   * public API of the process engine.
   *
   * @return the {@link ProcessEngineServices}.
   */
  ProcessEngineServices getProcessEngineServices();

  /**
   * Returns the {@link ProcessEngine} providing access to the
   * public API of the process engine.
   *
   * @return the {@link ProcessEngine}.
   */
  ProcessEngine getProcessEngine();

}
