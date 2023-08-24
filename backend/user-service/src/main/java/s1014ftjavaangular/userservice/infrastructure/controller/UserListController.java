package s1014ftjavaangular.userservice.infrastructure.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import s1014ftjavaangular.userservice.domain.usecase.UserListByIdUseCase;
import s1014ftjavaangular.userservice.domain.usecase.UserListByTypeUseCase;
import s1014ftjavaangular.userservice.domain.usecase.UserListFindAllUseCase;

@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
@RestController
public class UserListController {

    private final UserListByIdUseCase userListByIdUseCase;
    private final UserListFindAllUseCase userListFindAllUseCase;
    private final UserListByTypeUseCase userListByTypeUseCase;

    @GetMapping()
    public ResponseEntity<?> getAll(){
        var response = userListFindAllUseCase.findAll();

        return response.isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(response);
    }

    @GetMapping("/type/{type}")
    public ResponseEntity<?> getAllByType(@PathVariable String type){
        var response = userListByTypeUseCase.findAllByType(type);

        return response.isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(response);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<?> getAllById(@PathVariable String id){
        var response = userListByIdUseCase.findById(id);

        return response.isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(response);
    }

}
