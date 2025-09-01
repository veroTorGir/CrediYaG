package CrediYaG.CrediYaG.infraestructure.driver_adapter.jpa_repository;

import CrediYaG.CrediYaG.domain.model.User;
import CrediYaG.CrediYaG.domain.model.getaways.UserGetaway;
import CrediYaG.CrediYaG.infraestructure.driver_adapter.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UsergatewayImpl implements
        UserGetaway{

    private final UserMapper userMapper;
    private final UserDataJPARepository userDataJPARepository;

    @Override
    public User save(User user) {
        UserData userData = userMapper.toData(user);

        UserData savedData = userDataJPARepository.save(userData);

        return userMapper.toUser(savedData);
    };

    @Override
    public void delete(Long id) {
        userDataJPARepository.deleteById(id);
    }

    @Override
    public User searchId(Long id) {
        var user = userDataJPARepository.findById(id);

        return userMapper.toUser(user.get());
    }

}
