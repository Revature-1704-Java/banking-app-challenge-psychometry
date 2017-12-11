package com.raveture;

import java.util.ArrayList;
import java.util.HashMap;
import java.io.*;
/**
 * FileAccountDAO
 */
public class FileAccountDAO implements AccountDAO {
    private HashMap <Integer, ArrayList<Integer>> AccountTransactionMap;
    public FileAccountDAO(){
        AccountTransactionMap=new HashMap<>();
    }
    void writeObject(String fileName){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))){
            oos.writeObject(AccountTransactionMap);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    void readObject(String filename){
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))){
            AccountTransactionMap=(HashMap <Integer, ArrayList<Integer>>) ois.readObject();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }catch(ClassNotFoundException e){
            e.printStackTrace();;
        }
    }
	@Override
	public boolean insert(Account account) {
        
		return true;
	}

	@Override
	public boolean update(Account account) {
		return true;
	}

	@Override
	public boolean delete(Account account) {
		return true;
	}

    
}