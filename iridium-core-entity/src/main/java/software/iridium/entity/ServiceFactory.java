package software.iridium.entity;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;import org.springframework.stereotype.Component;

import software.iridium.entity.ExternalIdentityProviderTemplateEntityService;
import software.iridium.entity.TenantEntityService;
import software.iridium.entity.ExternalIdentityProviderEntityService;

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

    public static ExternalIdentityProviderTemplateEntityService getExternalIdentityProviderTemplateEntityService() {
        return applicationContext.getBean(ExternalIdentityProviderTemplateEntityService.class);
    }

    public static TenantEntityService getTenantEntityService() {
        return applicationContext.getBean(TenantEntityService.class);
    }

    public static ExternalIdentityProviderEntityService getExternalIdentityProviderEntityService() {
        return applicationContext.getBean(ExternalIdentityProviderEntityService.class);
    }

}
