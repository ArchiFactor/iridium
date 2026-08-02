package software.iridium.entity;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ExternalIdentityProviderTemplateEntityServiceImpl implements ExternalIdentityProviderTemplateEntityService {
    @Autowired
    private EntityManager entityManager;

    @Override
    public ExternalIdentityProviderTemplateEntity getExternalIdentityProviderTemplateEntityById(String id) {
        return entityManager.find(ExternalIdentityProviderTemplateEntity.class, id);
    }

}
