package software.iridium.entity;

import java.util.List;

public interface ExternalIdentityProviderEntityService {
    List<ExternalIdentityProviderEntity> getExternalIdentityProviderEntitysByTenantId(String tenantId);
    ExternalIdentityProviderEntity getExternalIdentityProviderEntityById(String id);
}
