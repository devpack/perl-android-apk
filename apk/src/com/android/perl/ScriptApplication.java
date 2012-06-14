/*
 * Copyright (C) 2010 Google Inc.
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

/*
 * Copyright (C) 2012, Anthony Prieur & Daniel Oppenheim. All rights reserved.
 *
 * Original from SL4A modified to allow to embed Interpreter and scripts into an APK
 */

package com.android.perl;

import com.android.perl.support.Utils;
import com.googlecode.android_scripting.BaseApplication;
import com.googlecode.android_scripting.interpreter.InterpreterConfiguration;
import com.googlecode.android_scripting.interpreter.InterpreterConfiguration.ConfigurationObserver;
import com.googlecode.android_scripting.interpreter.InterpreterConstants;

import java.util.concurrent.CountDownLatch;

public class ScriptApplication extends BaseApplication implements ConfigurationObserver {

//  private volatile boolean receivedConfigUpdate = false;
//  private final CountDownLatch mLatch = new CountDownLatch(1);

  @Override
  public void onCreate() {
//    mConfiguration = new InterpreterConfiguration(this);
//    mConfiguration.registerObserver(this);
//    mConfiguration.startDiscovering(InterpreterConstants.MIME + Utils.getFileExtension("foo.py"));
  } 

@Override
  public void onConfigurationChanged() {
//	receivedConfigUpdate = true;
//	mLatch.countDown();
  }

//  public boolean readyToStart() {
//
//    try {
//      mLatch.await();
//    } catch (InterruptedException e) {
//      e.printStackTrace();
//    }
//
//    return receivedConfigUpdate;
//  }

}
