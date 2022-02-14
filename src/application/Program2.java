package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("*****************Teste 1 findBy**********");
		Department department = departmentDao.findById(2);
		System.out.println(department);
		
		
		
		System.out.println("\n*********************teste 2 findAll************");
		List<Department> list = departmentDao.findAll();
		
		for(Department dep : list) {
			System.out.println(dep);
		}
		
		
		System.out.println("\n*********************teste 3 insert*************");
		Department newDepartment = new Department(null, "Acessorios");
		departmentDao.insert(newDepartment);
		System.out.println("id " + newDepartment.getId());
		
		System.out.println("\n*************************teste 4 update***************");
		Department dep = departmentDao.findById(3);
		dep.setName("Mouse");
		departmentDao.update(dep);
		System.out.println("UPDATE concluido");
		
		
		
		System.out.println("\n***************** TESTE 5 DELETE **********");
		System.out.println("entre com Id ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("id deletado.");
		sc.close();
		

	}
	

}
