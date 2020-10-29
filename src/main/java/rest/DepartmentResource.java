package rest;

import domain.Department;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rest.base.BaseResource;

@RestController
@RequestMapping("/api/department")
public class DepartmentResource extends BaseResource<Department> {

}
