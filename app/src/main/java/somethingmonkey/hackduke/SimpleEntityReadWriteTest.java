//package somethingmonkey.hackduke;
//
//import android.arch.persistence.room.Dao;
//import android.arch.persistence.room.Database;
//import android.arch.persistence.room.Room;
//import android.content.Context;
//
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//
//import java.io.IOException;
//import java.util.List;
//
//import static com.google.common.base.Predicates.equalTo;
//
//@RunWith(AndroidJUnit4.class)
//public class SimpleEntityReadWriteTest {
//    private DataDao mUserDao;
//    private DataDataBase mDb;
//
//    @Before
//    public void createDb() {
//        Context context = InstrumentationRegistry.getTargetContext();
//        mDb = Room.inMemoryDatabaseBuilder(context, DataDataBase.class).build();
//        mUserDao = mDb.daoAccess();
//    }
//
//    @After
//    public void closeDb() throws IOException {
//        mDb.close();
//    }
//
//    @Test
//    public void writeUserAndReadInList() throws Exception {
//        DataEntity user = TestUtil.createUser(3);
//        user.setName("george");
//        mUserDao.insert(user);
//        List<User> byName = mUserDao.findUsersByName("george");
//        assertThat(byName.get(0), equalTo(user));
//    }
//}