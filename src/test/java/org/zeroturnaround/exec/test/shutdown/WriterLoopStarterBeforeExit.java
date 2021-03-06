/*
 * Copyright (C) 2013 ZeroTurnaround <support@zeroturnaround.com>
 * Contains fragments of code from Apache Commons Exec, rights owned
 * by Apache Software Foundation (ASF).
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
package org.zeroturnaround.exec.test.shutdown;

import org.zeroturnaround.exec.ProcessExecutor;

/**
 * Starts {@link WriterLoop} and destroys it on JVM exit.
 */
public class WriterLoopStarterBeforeExit {

  private static final long SLEEP_AFTER_START = 2000;

  public static void main(String[] args) throws Exception {
    new ProcessExecutor("java", "-cp", "target/test-classes", WriterLoop.class.getName()).destroyOnExit().start();
    Thread.sleep(SLEEP_AFTER_START);
    // Cause the launched process to be destroyed
    System.exit(0);
  }

}
