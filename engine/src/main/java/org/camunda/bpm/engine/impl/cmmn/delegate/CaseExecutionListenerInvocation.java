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
package org.camunda.bpm.engine.impl.cmmn.delegate;

import org.camunda.bpm.engine.delegate.CaseExecutionListener;
import org.camunda.bpm.engine.delegate.DelegateCaseExecution;
import org.camunda.bpm.engine.impl.delegate.DelegateInvocation;

/**
 * Class handling invocations of ExecutionListeners
 *
 * @author Roman Smirnov
 */
public class CaseExecutionListenerInvocation extends DelegateInvocation {

  protected final CaseExecutionListener listenerInstance;
  protected final DelegateCaseExecution caseExecution;

  public CaseExecutionListenerInvocation(CaseExecutionListener listenerInstance, DelegateCaseExecution caseExecution) {
    super(caseExecution, null);
    this.listenerInstance = listenerInstance;
    this.caseExecution = caseExecution;
  }

  protected void invoke() throws Exception {
    listenerInstance.notify(caseExecution);
  }

}
