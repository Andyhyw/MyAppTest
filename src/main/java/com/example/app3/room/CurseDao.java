package com.example.app3.room;

import com.example.app3.model.Curse;
import com.example.app3.model.User;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface CurseDao {//mapping   xml

    @Query("SELECT * FROM curse")
    List<Curse> getAll();

    @Query("SELECT * FROM curse WHERE id IN (:curseIds)")
    List<Curse> loadAllByIds(int[] curseIds);

    @Query("SELECT * FROM curse WHERE curse_name LIKE :curse_name LIMIT 1")
    Curse findByName(String curse_name);

    @Query("SELECT * FROM curse WHERE id LIKE :id  LIMIT 1")
    Curse findByID(int id);

    @Insert
    void insertAll(Curse... curses);

    @Insert
    void insertAllList(List<Curse> curseList);

    @Delete
    void delete(Curse curse);
}
