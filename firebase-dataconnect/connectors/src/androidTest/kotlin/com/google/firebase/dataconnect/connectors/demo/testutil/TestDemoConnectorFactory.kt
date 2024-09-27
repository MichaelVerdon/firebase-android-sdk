/*
 * Copyright 2024 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.firebase.dataconnect.connectors.demo.testutil

import com.google.firebase.FirebaseApp
import com.google.firebase.dataconnect.DataConnectSettings
import com.google.firebase.dataconnect.FirebaseDataConnect
import com.google.firebase.dataconnect.connectors.demo.DemoConnector
import com.google.firebase.dataconnect.connectors.demo.getInstance
import com.google.firebase.dataconnect.connectors.testutil.TestConnectorFactory
import com.google.firebase.dataconnect.testutil.TestDataConnectFactory
import com.google.firebase.dataconnect.testutil.TestFirebaseAppFactory

/**
 * A JUnit test rule that creates instances of [DemoConnector] for use during testing, and closes
 * their underlying [FirebaseDataConnect] instances upon test completion.
 */
class TestDemoConnectorFactory(
  firebaseAppFactory: TestFirebaseAppFactory,
  dataConnectFactory: TestDataConnectFactory
) : TestConnectorFactory<DemoConnector>(firebaseAppFactory, dataConnectFactory) {
  override fun createConnector(firebaseApp: FirebaseApp, settings: DataConnectSettings) =
    DemoConnector.getInstance(firebaseApp, settings)
}