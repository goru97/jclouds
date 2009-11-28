package org.jclouds.servers;

import com.google.common.base.Service;

import java.util.SortedSet;
import java.util.concurrent.Future;

/**
 * @author Ivan Meredith
 */
public interface Server extends Service {
   public String getId();

   public State rebootAndWait();

   public Future<State> reboot();

   public Boolean supportsPlatforms();

   public Platform createPlatform(String id/*, Archive archive  , mount? */);

   public Platform getPlatform(String id);

   public SortedSet<Platform> listPlatforms();

   public SortedSet<Instance> listInstances(/* platform("mybilling-1.0.1").tags("production"  */);
}
