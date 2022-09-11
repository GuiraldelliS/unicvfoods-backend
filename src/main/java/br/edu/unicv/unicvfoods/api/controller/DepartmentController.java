package br.edu.unicv.unicvfoods.api.controller;

import br.edu.unicv.unicvfoods.domain.model.DepartmentModel;
import br.edu.unicv.unicvfoods.domain.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    @GetMapping
    public List<DepartmentModel> getDepartments() {
        return departmentService.listAll();
    }

    @GetMapping(value = "/{departmentId}")
    public ResponseEntity<DepartmentModel> getDepartment(@PathVariable Long departmentId) {
        try {
            DepartmentModel departmentModel = departmentService.getDepartment(departmentId);
            return ResponseEntity.ok(departmentModel);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DepartmentModel add(@Valid @RequestBody DepartmentModel departmentModel) {
        return departmentService.add(departmentModel);
    }

    @PutMapping(value = "/{departmentId}")
    public ResponseEntity<DepartmentModel> update(@PathVariable Long departmentId, @Valid @RequestBody DepartmentModel departmentModel) {
        try {
            DepartmentModel department = departmentService.update(departmentId, departmentModel);
            return ResponseEntity.ok(department);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(value = "/{departmentId}")
    public ResponseEntity<String> remove(@PathVariable Long departmentId) {
        try {
            departmentService.remove(departmentId);
            return ResponseEntity.noContent().build();
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
