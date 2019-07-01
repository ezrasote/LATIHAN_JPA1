package com.eksad.latihanjpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.eksad.latihanjpa.model.Employee;

@Repository // class ini disimpan dalam memori, tidak perlu instanciate lagi
public class EmployeeDAOImpl implements EmployeeDAO {
	
	@PersistenceContext // sebagai menjembatani database dengan objek yang dibuat
	EntityManager entityManager; // otomatis akan mapping object dalam class

	@Override
	public List<Employee> getAll() {
		// jpil = memanggil e dari nama class Employee, jadi ditampung kedalam si e itu. jadi kayak alias
		// trus Employee.class itu artinya si e dimasukin ke Employee.class (class employee)
		// diubah menjadi array list (getResultList())
		return entityManager.createQuery("select e from Employee e", Employee.class).getResultList();
	}

	@Override
	public Employee getById(int id) {
		return entityManager.find(Employee.class, id);
	}
	
	@Transactional // yang javax transaction
	@Override
	public void save(Employee employee) {
		//entityManager.getTransaction().begin();
		entityManager.persist(employee); //
	}

	@Transactional
	@Override
	public void update(Employee employee) {
		// TODO Auto-generated method stub
		entityManager.merge(employee);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		Employee employee = getById(id);
		entityManager.remove(employee);
	}

	@Override
	public List<Employee> getByName(String name) {
		// TODO Auto-generated method stub
		// ? fungsinya untuk memasukkan parameter kita, nah 0 nya ini parameter ke berapa
		// dibawahnya kan ditulis name itu parameter ke 0
		return entityManager.createNativeQuery("SELECT * FROM employee WHERE name LIKE ?0 ", Employee.class)
//		return entityManager.createQuery("select e from Employee e where e.name like ?0 ", Employee.class)
		.setParameter(0, "%" + name + "%")
		.getResultList();
	}
	
	

}
