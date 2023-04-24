1) Load The Driver
        Class.forName("com.mysql.jdbc.Driver"); // Keep inside Try Catch to                                                 // Handle classnotfound err
2) Create a Connection
        //java.sql.* Contains the connection api (must import)
        Connection con=DriverManger.getConnection("jdbc:mysql://localhost:3306/dbname","username","password");

3) Create a Query. To fire a query we need: Statement, PreparedStatement or    CallableStatement.

    String q="select * from students";
    Statement stmt=con.createStatement();
    ResultSet set=stmt.executeQuery(q);

4) Process the data:
    while(set.next())
    {
        int id=set.getInt("studentID");
        String name=set.getString("studentName");
        System.out.println(name);
    }

5) Close the connection
    con.close();
