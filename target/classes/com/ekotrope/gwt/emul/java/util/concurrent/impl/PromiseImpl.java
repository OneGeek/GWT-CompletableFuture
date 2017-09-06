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

import jsinterop.annotations.JsFunction;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsPackage;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

/**
 *
 */
final class PromiseImpl<V> implements Promise<V> {
  private V value;
  private Throwable reason;
  private boolean done;
  private final List<Runnable> callbacks = new ArrayList<>();

  @Override
  public void resolve(V value) {
    complete(value, null);
  }

  @Override
  public void reject(Throwable reason) {
    assert reason != null;
    complete(null, reason);
  }

  @Override
  public void then(BiConsumer<? super V, ? super Throwable> callback) {
    assert callback != null;
    then(() -> callback.accept(value, reason));
  }

  @Override
  public void then(Runnable callback) {
    assert callback != null;
    callbacks.add(callback);
    if (done) {
      runCallbacks();
    }
  }

  private void complete(V value, Throwable reason) {
    if (!done) {
      this.value = value;
      this.reason = reason;
      done = true;
      runCallbacks();
    }
  }

  private void runCallbacks() {
    if (!callbacks.isEmpty()) {
      setTimeout(() -> {
        for (Runnable callback : callbacks) {
          callback.run();
        }
        callbacks.clear();
      }, 0);
    }
  }

  // TODO: use $entry?
  @JsMethod(namespace = JsPackage.GLOBAL)
  private static native int setTimeout(TimerCallback callback, int time);

  @FunctionalInterface
  @JsFunction
  private interface TimerCallback {
    void onTick();
  }
}
