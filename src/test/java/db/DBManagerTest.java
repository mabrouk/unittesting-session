package db;

import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;

/**
 * Created by ahmad on 2/7/17.
 */
public class DBManagerTest {


    @Test
    public void testNewUserTransaction() {
        User user = new User();
        SqlDB mockedDB = mock(SqlDB.class);
        DBManager subject = new DBManager(mockedDB);
        subject.newUser(user);

        InOrder inOrder = Mockito.inOrder(mockedDB);
        inOrder.verify(mockedDB).beginTransaction();
        inOrder.verify(mockedDB, times(2)).insert(anyString(), any());
        inOrder.verify(mockedDB).endTransaction();
    }
}
