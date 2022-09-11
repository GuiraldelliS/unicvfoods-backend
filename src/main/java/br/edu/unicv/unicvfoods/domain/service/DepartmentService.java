package br.edu.unicv.unicvfoods.domain.service;

import br.edu.unicv.unicvfoods.domain.model.DepartmentModel;
import br.edu.unicv.unicvfoods.domain.repository.DepartmentRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@AllArgsConstructor
@Service
public class DepartmentService {
    
    private final DepartmentRepository departmentRepository;

    public List<DepartmentModel> listAll() {
        return departmentRepository.findAll();
    }
    public DepartmentModel getDepartment(Long departmentId) throws NoSuchElementException {
        return departmentRepository.findById(departmentId).orElseThrow();
    }

    public DepartmentModel update(Long departmentId, DepartmentModel departmentModel) throws NoSuchElementException {
        if (!departmentRepository.existsById(departmentId)) throw new NoSuchElementException();
        departmentModel.setId(departmentId);
        return departmentRepository.save(departmentModel);
    }

    public DepartmentModel add(DepartmentModel departmentModel) {
        return departmentRepository.save(departmentModel);
    }

    public void remove(Long departmentId) throws NoSuchElementException {
        if (!departmentRepository.existsById(departmentId)) throw new NoSuchElementException();
        departmentRepository.deleteById(departmentId);
    }

}
