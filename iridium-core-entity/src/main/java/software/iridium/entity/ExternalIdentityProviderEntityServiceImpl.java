package software.iridium.entity;

import jakarta.persistence.EntityManager;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ExternalIdentityProviderEntityServiceImpl implements ExternalIdentityProviderEntityService {
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<ExternalIdentityProviderEntity> getExternalIdentityProviderEntitysByTenantId(String tenantId) {
        if (tenantId == null) {
            return List.of();
        }
        return entityManager.createQuery("SELECT e FROM ExternalIdentityProviderEntity e WHERE e.tenantId = :tenantId", ExternalIdentityProviderEntity.class)
                .setParameter("tenantId", tenantId)
                .getResultList();
    }

    @Override
    public ExternalIdentityProviderEntity getExternalIdentityProviderEntityById(String id) {
        return entityManager.find(ExternalIdentityProviderEntity.class, id);
    }

}
