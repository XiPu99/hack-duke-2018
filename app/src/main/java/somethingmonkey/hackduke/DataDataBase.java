package somethingmonkey.hackduke;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {DataEntity.class}, version = 1)
public abstract class DataDataBase extends RoomDatabase {
    public abstract DataDao daoAccess();
}