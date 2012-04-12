/**
 * Licensed to jclouds, Inc. (jclouds) under one or more
 * contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  jclouds licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.jclouds.savvis.vpdc;

import static org.jclouds.savvis.vpdc.reference.VPDCConstants.PROPERTY_VPDC_TIMEOUT_TASK_COMPLETED;

import java.net.URI;
import java.util.Properties;

import org.jclouds.apis.ApiType;
import org.jclouds.compute.ComputeServiceContext;
import org.jclouds.compute.internal.BaseComputeServiceApiMetadata;

import com.google.common.reflect.TypeToken;

/**
 * Implementation of {@link org.jclouds.types.ApiMetadata} for Savvis Symphony VPDC services.
 * 
 * @author Kedar Dave
 */
public class VPDCApiMetadata
      extends
      BaseComputeServiceApiMetadata<VPDCClient, VPDCAsyncClient, ComputeServiceContext<VPDCClient, VPDCAsyncClient>, VPDCApiMetadata> {

   @Override
   public Builder toBuilder() {
      return new Builder().fromApiMetadata(this);
   }

   public VPDCApiMetadata() {
      this(new Builder());
   }

   protected VPDCApiMetadata(Builder builder) {
      super(builder);
   }

   protected static Properties defaultProperties() {
      Properties properties = BaseComputeServiceApiMetadata.Builder.defaultProperties();
      properties.setProperty(PROPERTY_VPDC_TIMEOUT_TASK_COMPLETED, 600l * 1000l + "");
      return properties;
   }

   public static class Builder
         extends
         BaseComputeServiceApiMetadata.Builder<VPDCClient, VPDCAsyncClient, ComputeServiceContext<VPDCClient, VPDCAsyncClient>, VPDCApiMetadata> {

      protected Builder() {
         id("savvis-symphonyvpdc")
         .type(ApiType.COMPUTE)
         .name("Savvis Symphony VPDC API")
         .identityName("Username")
         .credentialName("Password")
         .documentation(URI.create("https://api.savvis.net/doc/spec/api/index.html"))
         .version("1.0")
         .buildVersion("2.3")
         .defaultEndpoint("https://api.savvis.net/vpdc")
         .defaultProperties(VPDCApiMetadata.defaultProperties())
         .javaApi(VPDCClient.class, VPDCAsyncClient.class)
         .contextBuilder(TypeToken.of(VPDCContextBuilder.class));
      }

      @Override
      public VPDCApiMetadata build() {
         return new VPDCApiMetadata(this);
      }

      @Override
      public Builder fromApiMetadata(VPDCApiMetadata in) {
         super.fromApiMetadata(in);
         return this;
      }

   }

}