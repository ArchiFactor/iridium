package software.iridium.entity;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TenantEntityServiceImpl implements TenantEntityService {
    @Autowired
    private EntityManager entityManager;

    @Override
    public TenantEntity getTenantEntityById(String id) {
        return entityManager.find(TenantEntity.class, id);
    }

}
