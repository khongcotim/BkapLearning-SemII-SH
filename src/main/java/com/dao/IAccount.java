package com.dao;

import java.util.List;

public interface IAccount <K,O>{
    List<O> getAllAcc();
    O findByEmail(String email);
    O findByPhone(String phone);
    boolean createNew(O newO);
    boolean update(O newO);
    O findByUsrName(String UsrName);
}
