/*
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package software.iridium.entity;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class ServiceFactory implements ApplicationContextAware {
  private static ConfigurableApplicationContext applicationContext;

  @Override
  public void setApplicationContext(ApplicationContext context) throws BeansException {
    applicationContext = (ConfigurableApplicationContext) context;
  }

  public static boolean isContainerAvailable() {
    return applicationContext != null && applicationContext.isActive();
  }

  public static ExternalIdentityProviderTemplateEntityService
      getExternalIdentityProviderTemplateEntityService() {
    return applicationContext.getBean(ExternalIdentityProviderTemplateEntityService.class);
  }

  public static TenantEntityService getTenantEntityService() {
    return applicationContext.getBean(TenantEntityService.class);
  }

  public static ExternalIdentityProviderEntityService getExternalIdentityProviderEntityService() {
    return applicationContext.getBean(ExternalIdentityProviderEntityService.class);
  }
}
