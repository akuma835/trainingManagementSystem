package com.cg.tms.dao;


import java.util.List;

import com.cg.tms.entity.Center;

public class FetchCentersImpl implements IFetchAllDetails<Center> {

	@Override
	public List<Center> retrieveAll() {
	 List<Center> centers ;
	 centers= DatabaseCollection.center;
		return centers;
	}

	@Override
	public Center retrieve(int id) {
		List<Center> centers;
		Center center=null;
		centers=retrieveAll();
		for (Center c: centers) {
			if (c.getCenterId()==(id)) {
				center=c;
				break;
			}
		}
		return center;
	}

}
