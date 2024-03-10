import org.apache.thrift.TException;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TServer.Args;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TTransportFactory;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TSSLTransportFactory.TSSLTransportParameters;

// Generated code
public class Server {
    public static MultiplicationHandler handler;
    public static MultiplicationService.Processor processor;

    public static void main(String [] args) {
        try {
            handler = new MultiplicationHandler();
            processor = new MultiplicationService.Processor(handler);

            Server.simpleServer(processor);

        } catch (Exception x) {
            x.printStackTrace();
        }
    }

    public static void simpleServer(MultiplicationService.Processor processor) {
        try {
            //Create Thrift server socket
            TServerTransport serverTransport = new TServerSocket(55455);
            TTransportFactory factory = new TFramedTransport.Factory();

            //Create service request handler
            //MultiplicationHandler handler = new MultiplicatonHandler();
            //processor = new MultiplicationService.Processor(handler);

            // Following code uses TSimpleServer - which is a single threaded server
            // You can change it TThreadedPoolServer by uncommenting the corresponding
            // two lines below, and commenting the TServer lines

//          TServer.Args args = new TServer.Args(serverTransport);
/***  Using Thread Pool Server below ***/	    
              TThreadPoolServer.Args args = new TThreadPoolServer.Args(serverTransport);

            args.processor(processor);  //Set handler
            args.transportFactory(factory);  //Set FramedTransport (for performance)

            // Run server as a single thread  - you can change it to TThreadedPoolServer by by uncommnenting the
            // corresponding line and commetinting the TServer code below

//                 TServer server = new TSimpleServer(args);
/***  Using Thread Pool Server below ***/	    
               TThreadPoolServer server = new TThreadPoolServer(args);

            server.serve();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	    
}

