import org.apache.thrift.TException;
import java.util.*;

public class kvHandler implements kvstorage.Iface
{
        HashMap <String, String> m1 = new HashMap<String, String>();

        @Override
        public boolean ping() throws TException {
		System.out.println("I got ping()");
		return true;
		}

        @Override
        public String get(String key) throws TException {
                return m1.get(key);
        }

        @Override
        public int put(String key, String val) throws TException {
                m1.put(key, val);
                return 0;
        }
}

