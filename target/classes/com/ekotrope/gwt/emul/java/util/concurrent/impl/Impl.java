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

/**
 *
 */
public class Impl {

  public static final Promises IMPL = isSupported() ? new NativePromisesImpl() :
      new PromisesImpl();

  /*
   * Implementation taken from:
   * https://github.com/jakearchibald/es6-promise/blob/master/lib/promise/polyfill.js
   */
  private static native boolean isSupported() /*-{
    return typeof Promise === "function"
        // Some of these methods are missing from
        // Firefox/Chrome experimental implementations
        && "resolve" in Promise
        && "reject" in Promise
        && "all" in Promise
        && "race" in Promise
        // Older version of the spec had a resolver object
        // as the arg rather than a function
        && (function() {
          var resolve;
          new Promise(function(r) { resolve = r; });
          return typeof resolve === "function";
        }());
  }-*/;

  private Impl() { }
}
