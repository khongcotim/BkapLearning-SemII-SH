package com.dao;

import java.util.List;

public interface IDao <K,V>{
    List<V> getAll();
    boolean create(V newV);
    boolean update(V newV);
    boolean delete(K id);
    V findById(K id);
    V findByName(String nameW);
    public int selectCount();
    public List<V> pagination(int page, int itemOnPage);
}
