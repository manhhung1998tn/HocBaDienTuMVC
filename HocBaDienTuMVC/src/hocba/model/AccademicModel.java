package hocba.model;

import java.util.ArrayList;

import hocba.dao.Accademic_YearDAO;
import hocba.dao.ConnectionPool;
import hocba.model.object.Accademic_YearObject;

public class AccademicModel {

	public static ArrayList<Accademic_YearObject> getAccademic(int idClass, int term, ConnectionPool cp){
		ArrayList<Accademic_YearObject> list = null;
		Accademic_YearDAO accademic_YearDAO = new Accademic_YearDAO(cp);
		
		
		
		
		return list;
	}
	
	public static String accademicShow(ArrayList<Accademic_YearObject> list) {
		String html = "";
		
		
		return html;
	}
}
