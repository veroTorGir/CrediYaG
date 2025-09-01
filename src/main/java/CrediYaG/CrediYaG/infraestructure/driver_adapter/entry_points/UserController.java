package CrediYaG.CrediYaG.infraestructure.driver_adapter.entry_points;

import CrediYaG.CrediYaG.domain.model.User;
import CrediYaG.CrediYaG.domain.useCase.UserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/usuarios")
@RequiredArgsConstructor
public class UserController {


    private final UserUseCase useCase;
    @GetMapping("")
    public ResponseEntity<User> findById(@RequestParam("id") Long id){
      var user = useCase.searchId(id);
      if(user.getIdentify() != null){
          return new ResponseEntity<>(user, HttpStatus.OK);
      }
      return  new ResponseEntity<>(user, HttpStatus.NOT_FOUND);
    }
}
