package br.edu.unicv.unicvfoods.api.controller;

import br.edu.unicv.unicvfoods.domain.exception.ResourceNotFoundException;
import br.edu.unicv.unicvfoods.domain.model.GenericEntity;
import br.edu.unicv.unicvfoods.domain.service.GenericService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
public abstract class GenericController<T extends GenericEntity<T>> {

    private final GenericService<T> service;

    @GetMapping
    public ResponseEntity<Page<T>> getPage(Pageable pageable) {
        return ResponseEntity.ok(service.getPage(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<T> get(@PathVariable Long id) throws ResourceNotFoundException {
        return ResponseEntity.ok(service.get(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<T> update(@PathVariable Long id, @RequestBody T updated) throws ResourceNotFoundException {
        return ResponseEntity.ok(service.update(id, updated));
    }

    @PostMapping
    public ResponseEntity<T> create(@RequestBody T created) {
        return ResponseEntity.ok(service.create(created));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) throws ResourceNotFoundException {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
