
typedef i32 int // We can use typedef to get pretty names for the types we are using

service MultiplicationService
{
        bool ping(),
        oneway void hello(),
        int multiply(1:int n1, 2:int n2)
}
