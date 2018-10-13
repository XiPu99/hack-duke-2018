package somethingmonkey.hackduke;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface DataDao {

    @Query("SELECT * FROM DataEntity LIMIT 1")
    List<DataEntity> getAll();

    @Insert
    void insertAll(DataEntity note);

    @Update
    void update(DataEntity repos);

    @Delete
    void delete(DataEntity user);

    @Query("SELECT * FROM DataEntity WHERE date LIKE :strdate")
    public List<DataEntity> findUserWithName(String strdate);

    @Query("DELETE FROM DataEntity")
    void deleteAll();

}