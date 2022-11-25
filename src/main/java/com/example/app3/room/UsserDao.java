package com.example.app3.room;

import com.example.app3.model.Usser;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface UsserDao {
    @Query("SELECT * FROM usser")
    List<Usser> getAll();

    @Query("SELECT * FROM usser WHERE id IN (:userIds)")
    List<Usser> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM usser WHERE name LIKE :first AND " +
            "sex LIKE :last LIMIT 1")
    Usser findByName(String first, String last);

    @Insert
    long insertUser(Usser user);

    @Insert
    long[] insertAll(Usser... users);

    @Insert
    long[] insertAllList(List<Usser> users);

    @Delete
    int delete(Usser usser);
}
