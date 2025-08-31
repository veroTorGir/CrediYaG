package CrediYaG.CrediYaG.domain.model.getaways;

import CrediYaG.CrediYaG.domain.model.User;

public interface UserGetaway {
    User save(User user);
    void delete (Long id);
    User searchId(Long id);
}
