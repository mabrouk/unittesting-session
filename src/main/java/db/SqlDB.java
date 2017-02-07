package db;

import java.util.Map;

/**
 * Created by ahmad on 2/7/17.
 */
public interface SqlDB {
    void beginTransaction();
    void insert(String tableName, Map<String, Object> values);
    void endTransaction();
}
