package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		SellerDao sellerDao = DaoFactory.createSelerDao();
		
		System.out.println("=== TESTE 1: SELLER FINDBYID ===");		
		Seller seller = sellerDao.findById(3);		
		System.out.println(seller);
		
		System.out.println("\n=== TESTE 2: SELLER FINDBYDEPARTMENT ===");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		
		for(Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== TESTE 3: SELLER FINDALL ===");
		 list = sellerDao.findAll();
		
		for(Seller obj : list) {
			System.out.println(obj);
		}
		
		
		System.out.println("\n=== TESTE 4: SELLER INSERT ===");
		Seller newseller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department);
		sellerDao.insert(newseller);
		System.out.println("new id= " + newseller.getId());
		
		
		System.out.println("\n=== TESTE 5: SELLER UPDATE ===");
		seller = sellerDao.findById(1);
		seller.setName("Bruce Wayne");
		sellerDao.update(seller);
		System.out.println("Update completo");
		
		
		System.out.println("\n=== TESTE 6: SELLER DELETE ===");
		System.out.println("entre com Id ");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("id deletado.");
		sc.close();

	}
	

}
