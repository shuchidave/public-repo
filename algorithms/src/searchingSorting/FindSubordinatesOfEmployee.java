package searchingSorting;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindSubordinatesOfEmployee {

	public static void main(String[] args) {
		Collection<Employee> employees = new ArrayList<Employee>();	
		
		Employee emp = new Employee("Shuchi", "Anthony");
		employees.add(emp);
		Employee emp2 = new Employee("Anthony", "Jonathan");
		employees.add(emp2);
		Employee emp3 = new Employee("Jonathan", "Anoop");
		employees.add(emp3);
		Employee emp4 = new Employee("Anoop", "Cyril");
		employees.add(emp4);
		Employee emp5 = new Employee("Harshal", "Shuchi");
		employees.add(emp5);
		Employee emp6 = new Employee("Cyril", null);
		employees.add(emp6);
		Employee emp7 = new Employee("Surag", "Jonathan");
		employees.add(emp7);
		
		//Cyril->Anoop->Jonathan->Anthony->Shuchi->Harshal
		
		List<String> subOrdinates = findSubordinates(emp3.getName(), employees);
		System.out.println("Subordinates of employee:"+emp3.getName());
		for (String str : subOrdinates) {
			System.out.println(str);
		}
	}
	
	public static List<String> findSubordinates(String name, Collection<Employee> employees){
		List<String> subordinates = new ArrayList<String>();
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		for (Employee employee : employees) {
			List<String> tempList = null;
				if(map.containsKey(employee.getManager())){
					tempList = map.get(employee.getManager());
					tempList.add(employee.getName());
					map.put(employee.getManager(), tempList);
				}else{
					tempList = new ArrayList<String>();
					tempList.add(employee.getName());
					map.put(employee.getManager(), tempList);
				}
		}
		
		for(Map.Entry<String, List<String>> entry: map.entrySet()){
			System.out.println("Looking for:" + name+ ", map key:"+entry.getKey()+", map value:"+entry.getValue());
			if(name.equals(entry.getKey())){
				subordinates.addAll(entry.getValue());
				// Add all indirect suordinates
				for(String sub: entry.getValue()){
					allIndirectSubordinates(sub,map, subordinates);
				}
			}
		}
		return subordinates;
	}
	public static void allIndirectSubordinates(String forEmp, Map<String, List<String>> mainMap, List<String> subordinates)
	{
		 if (!mainMap.containsKey(forEmp))
	        {
			 //subordinates.add(forEmp);
	            return;
	        }
		
		if(mainMap.containsKey(forEmp)){
			subordinates.addAll(mainMap.get(forEmp));
			for(String sub: mainMap.get(forEmp)){
				allIndirectSubordinates(sub, mainMap, subordinates);
			}
		}
	}
}
class Employee{
	private String name;
	private String manager;
	Employee(){}
	Employee(String n, String mgr){
		name=n;
		manager=mgr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}
	
	
}
