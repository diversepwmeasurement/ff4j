package org.ff4j.cache;

import org.ff4j.core.Feature;
import org.ff4j.core.FeatureStore;
import org.ff4j.store.InMemoryFeatureStore;
import org.junit.Assert;
import org.junit.Test;

/*
 * #%L
 * ff4j-cache-redis
 * %%
 * Copyright (C) 2013 - 2014 Ff4J
 * %%
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
 * #L%
 */

public class RedisCacheManagerTestIT {

    @Test
    public void testPutGet() {
       
        // Initializing cache manager
        FeatureCacheManager cache = new FeatureCacheProviderRedis();

        // Initializing Features for test
        FeatureStore store = new InMemoryFeatureStore("test-redis-ff4j.xml");
        Feature fold = store.read("forth");
        
        // Put in Cache
        cache.put(fold);
        
        // Retrieve object
        Feature fcached = cache.get("forth");
        Assert.assertEquals(fcached.getUid(), fold.getUid());
        Assert.assertEquals(fcached.getAuthorizations(), fold.getAuthorizations());

    }
}