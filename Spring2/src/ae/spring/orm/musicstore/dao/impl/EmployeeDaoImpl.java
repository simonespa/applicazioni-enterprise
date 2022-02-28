package ae.spring.orm.musicstore.dao.impl;

import ae.spring.orm.musicstore.dao.EmployeeDao;
import ae.spring.orm.musicstore.dto.Employee;

public class EmployeeDaoImpl extends BaseDaoImpl<Employee, Long> implements EmployeeDao
{
    public EmployeeDaoImpl()
    {
        super(Employee.class);
    }

}
