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
//            TProtocol protocol = new TBinaryProtocol(transport);
            MultiplicationService.Client client = new MultiplicationService.Client(protocol);

            //Try to connect
            transport.open();

	    boolean ack = client.ping();
	    System.out.printf("Ping call to service returned  '%b'\n", ack);

	    client.hello();
	    System.out.printf("Hello call to service as 'oneway', i.e. without waiting for result \n");


            //What you need to do.
            int x  = 17;
            int y = 19;
            if (args.length == 2) {
               x = Integer.parseInt( args[0] );
               y = Integer.parseInt( args[1] );
            }
              

            System.out.printf("Calling multiplication service with params %d and %d\n", x, y);
            int ret = client.multiply(x, y);
            System.out.printf("Result received from server = %d\n", ret);

	    transport.close();
        } catch(TException e) {

        }

    }
}
