import org.apache.thrift.TException;
import org.apache.thrift.transport.TTransportFactory;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSSLTransportFactory.TSSLTransportParameters;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;

public class Client {
    public static void main(String [] args) {
        //Create client connect.
        try {

            String serverHostName = "localhost";
            if (args.length == 1) {
               serverHostName = args[0];
            }

            TTransport  transport = new TSocket(serverHostName, 55455);

            TProtocol protocol = new TBinaryProtocol(new TFramedTransport(transport));
            kvstorage.Client client = new kvstorage.Client(protocol);

            //Try to connect
            transport.open();

            //What you need to do.
       	    client.ping();

	    //Put an key-value pair -- in this case course number and course title
            String key = new String("CSCI-5105");
            String val = new String("Introduction to Distributed Systems");
            int ret = client.put(key, val);

	    // Now we query the service with the course number as the key 
            String ans = client.get(key);
            System.out.printf("KEY == " + key + " , and COURSE TITLE  = " + ans + "\n");

        } catch(TException e) {

        }

    }
}
