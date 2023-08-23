package s1014ftjavaangular.userservice.domain.models.dto.request;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Builder
@Data
public class UserSaveMessage implements Serializable {
    private String accountUuid;
    private String accountRol;
    private String name;
    private String lastname;
}
