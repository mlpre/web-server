package service;

import domain.Department;
import org.springframework.stereotype.Service;
import service.base.BaseService;

import javax.transaction.Transactional;

@Service
@Transactional
public class DepartmentService extends BaseService<Department> {
}
