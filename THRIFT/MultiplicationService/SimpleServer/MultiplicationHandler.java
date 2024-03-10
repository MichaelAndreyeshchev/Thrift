import org.apache.thrift.TException;

public class MultiplicationHandler implements MultiplicationService.Iface {

	@Override
	 public boolean  ping() throws TException {
	    System.out.println("Ping call received");
	    return true;
	 }

	
	@Override
	 public void hello() throws TException {
	    System.out.println("Hello call received");
	    return ;
	 }

	
	@Override
	 public int multiply(int n1, int n2) throws TException {
	    System.out.println("Multiply(" + n1 + "," + n2 + ")");
	    return n1 * n2;
	 }

	
}
