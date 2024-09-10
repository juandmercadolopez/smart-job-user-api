package cl.bci.user.controller;

import cl.bci.user.exception.InvalidArgumentException;
import cl.bci.user.model.request.UserModel;
import cl.bci.user.model.response.ErrorResponse;
import cl.bci.user.model.response.InfoResponse;
import cl.bci.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<Object> create(@Valid @RequestBody UserModel user) {

        try {
            return new ResponseEntity(userService.createUser(user), HttpStatus.CREATED);
        }catch (InvalidArgumentException e) {
            return new ResponseEntity(new ErrorResponse(e.getMessage()), HttpStatus.BAD_REQUEST);
        }

    }

    @PutMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<InfoResponse> update(@Valid @RequestBody UserModel user) {

        return new ResponseEntity(userService.updateUser(user), HttpStatus.OK);

    }

    @GetMapping(value = "/{uuid}", produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<UserModel> getById(@PathVariable String uuid) {

        return new ResponseEntity<>(userService.getUserById(uuid), HttpStatus.OK);

    }

    @GetMapping(value = "/getAll", produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<List<UserModel>> getAll() {
        return new ResponseEntity(userService.getAllUsers(), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{uuid}")
    private ResponseEntity<Void> delete(@PathVariable String uuid) {
        userService.deleteUser(uuid);
        return ResponseEntity.ok().build();
    }


}
