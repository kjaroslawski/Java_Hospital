package core;

import java.util.Collection;
import java.util.Iterator;

import dao.VisitsDaoImpl;
import dao.interf.VisitsDao;
import dto.VisitsDto;
import tables.Tables;

public class Visits {

	public void getDoctorVisits(Integer id) {
		VisitsDao visitsDao = new VisitsDaoImpl();
		Collection<VisitsDto> visitsDtoCol = visitsDao.getDoctorVisit(id);
		Tables.printVisitsHeader();
		for (Iterator<VisitsDto> iterator = visitsDtoCol.iterator(); iterator.hasNext();) {
			VisitsDto visitsDto = (VisitsDto) iterator.next();
			Tables.printVisitsTable(visitsDto);
		}
		Tables.printVisitsFooter();
	}

	public void createVisit(VisitsDto visitsDto) {
		VisitsDao visitsDao = new VisitsDaoImpl();
		System.out.println(visitsDto.getVisit_start());
		visitsDao.create(visitsDto);
	}

	public void deleteVisit(Integer id) {
		VisitsDao visitsDao = new VisitsDaoImpl();
		visitsDao.delete(id);
	}
}
