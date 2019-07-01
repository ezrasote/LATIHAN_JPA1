package com.eksad.latihanjpa;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.eksad.latihanjpa.dao.EmployeeDAO;
import com.eksad.latihanjpa.model.Employee;

@Configuration
public class Action {
	
	@Autowired // memanggil employee tanpa perlu inisialisasi lagi
	EmployeeDAO employeeDAO;
	
//	@Bean
//	public List<Employee> getAll() {
//		List<Employee> employees = employeeDAO.getAll();
//		
//		// perulangan mengikuti kondisi dalam list (jumlah dalam list)
//		for(Employee employee : employees) {
//			System.out.println("ID : " + employee.getId());
//			System.out.println("Name : " + employee.getName());
//			System.out.println("Address : " + employee.getAddress());
//			System.out.println("DOB : " + employee.getDob());
//			System.out.println("==================================");
//		}
//		
//		return employees; // karna variabel awal yang dibuat namanya employees
//		
//	}
	
	@Bean
	public Employee getById() {
		Employee employee = employeeDAO.getById(2);
		
		System.out.println("Get By Id = 2");
		System.out.println("ID : " + employee.getId());
		System.out.println("Name : " + employee.getName());
		System.out.println("Address : " + employee.getAddress());
		System.out.println("DOB : " + employee.getDob());
		System.out.println("==================================");
		
		return employee; // karna variabel awal yang dibuat namanya employee
	}
	
	// pas mau running yang ini, yang public list itu ditutup
//	@Bean
//	public boolean save() {
//		try {
//			Employee employee = new Employee();
//			
//			employee.setName("Humaira");
//			employee.setAddress("London");
//			
//			String dateString = "1998-01-31";
//			Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
//			employee.setDob(date);
//			
//			employeeDAO.save(employee);
//			System.out.println("Data Berhasil Tersimpan!");
//			
//			return true;
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			System.out.println("Data Gagal Tersimpan..");
//			e.printStackTrace();
//			return false;
//		}
//	}
	
//	@Bean
//	public boolean update () {
//		try {
//			Employee employee = new Employee();
//			
//			employee.setId(1);
//			employee.setName("Salira");
//			employee.setAddress("Paris");
//			
//			String dateString = "1998-01-31";
//			Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
//			employee.setDob(date);
//			
//			employeeDAO.update(employee);
//			System.out.println("Data Berhasil Diperbaharui");
//			
//			return true;
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			System.out.println("Data Gagal Tersimpan..");
//			e.printStackTrace();
//			return false;
//		}
//	}
	
//	@Transactional // ketika aplikasi kita melakukan transaksi update atau hapus atau simpan ke database
//	@Bean
//	public boolean delete() {
//		try {
//			employeeDAO.delete(5);
//			System.out.println("Data Berhasil Dihapus!");
//			return true;
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			System.out.println("Data Gagal Dihapus..");
//			return false;
//		}
//	}
	
	@Bean
	public List <Employee> getByName() {
		List<Employee> employees = employeeDAO.getByName("Humaira");
		
		for(Employee employee : employees) {
			System.out.println("ID : " + employee.getId());
			System.out.println("Name : " + employee.getName());
			System.out.println("Address : " + employee.getAddress());
			System.out.println("DOB : " + employee.getDob());
			System.out.println("==================================");
		}
		
		return employees;
	}

}
