/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import model.Employee;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class LocationDao {
    public Session currSession = null;
	public LocationDao(){
		HibernateUtil.createSessionFactory();
		currSession=HibernateUtil.getSessionFactory().openSession();  
	}
	public void finalize(){
		currSession.close();
	}

    public void save(ArrayList<Location> newLocationList){
		Transaction t=currSession.beginTransaction();  
      		for(int i=0;i<newLocationList.size();i++){
			currSession.persist((Location)newLocationList.get(i));
		}
      		t.commit(); 
 	}
	public void printEmployees(){
		Query query=currSession.createQuery("from Location");  
    		List<Location> list=query.list();  
      
   		Iterator<Location> itr=list.iterator();  
		while(itr.hasNext()){  
			Location loc=itr.next();  
			System.out.println("Emp Name: "+loc.getFirstName());  
    		}  
	}
}

}
