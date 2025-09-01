package CrediYaG.CrediYaG.domain.useCase;

import CrediYaG.CrediYaG.domain.model.User;
import CrediYaG.CrediYaG.domain.model.getaways.UserGetaway;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserUseCase {
    private final UserGetaway userGetaway;
    public User saveUser(User user) throws Exception {
        if(user.getIdentify()== null){
            throw new Exception();
        }
        return userGetaway.save(user);

    }
    public void deleteForId(Long id){
        try{
            userGetaway.delete(id);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public User searchId(Long id){
        try {
            return userGetaway.searchId(id);
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
            return new User();
        }
    }

}
