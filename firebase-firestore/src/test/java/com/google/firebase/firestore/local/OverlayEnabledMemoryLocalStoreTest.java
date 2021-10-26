// Copyright 2021 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.firebase.firestore.local;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

@RunWith(RobolectricTestRunner.class)
@Config(manifest = Config.NONE)
public class OverlayEnabledMemoryLocalStoreTest extends LocalStoreTestCase {
  private static boolean enabled = false;

  @BeforeClass
  public static void beforeClass() {
    enabled = Persistence.OVERLAY_SUPPORT_ENABLED;
    Persistence.OVERLAY_SUPPORT_ENABLED = true;
  }

  @AfterClass
  public static void afterClass() {
    Persistence.OVERLAY_SUPPORT_ENABLED = enabled;
  }

  @Override
  Persistence getPersistence() {
    return PersistenceTestHelpers.createEagerGCMemoryPersistence();
  }

  @Override
  boolean garbageCollectorIsEager() {
    return true;
  }

  @Test
  @Override
  // TODO(Overlay): Delete this when we resolve Idempotent Transformations issue.
  public void testHoldsBackOnlyNonIdempotentTransforms() {}
}