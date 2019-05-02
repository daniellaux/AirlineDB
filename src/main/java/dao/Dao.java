package dao;

import java.util.List;

public interface Dao<T> {
	void addRecord(T t);

	void removeRecord(T t);

	void updateRecord(T t);
	
	T getRecordById(T t);

	List<T> getRecordByName(String t);

	List<T> returnAllRecords();
	
}
