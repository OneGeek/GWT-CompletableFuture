/*
 * Copyright 2016 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package java.util.concurrent.impl;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 *
 */
public interface Promise<V> {

  void resolve(V value);

  void reject(Throwable reason);

  void then(BiConsumer<? super V, ? super Throwable> callback);

  void then(Runnable callback);

  void then(Consumer<? super Throwable> callback);
}
