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
        return ResponseEntity.ok(userListFindAllUseCase.findAll());
    }

    @GetMapping(value="/{type}")
    public ResponseEntity<?> getAllByType(@PathVariable String type){
        return ResponseEntity.ok(userListByTypeUseCase.findAllByType(type));
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<?> getAllById(@PathVariable String id){
        return  ResponseEntity.ok(userListByIdUseCase.findById(id));
    }

}
