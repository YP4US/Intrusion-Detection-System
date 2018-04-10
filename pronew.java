
//Yogesh Pawar
import java.io.*;
import java.util.*;
import java.sql.*;
import java.net.*;





class pronew
{
	public static void main(String[] args) {

		int i=0,j=0,count=0;
		String[] words=new String[15];
		String sample=" EE03";
		String query="";
		String name="";
		String tagno="";
//---------------------------------------------read file----------------------------------------------------------------------

		try
	{
		File file = new File("test.txt");
		 BufferedReader fr = new BufferedReader(new InputStreamReader(new FileInputStream(file), "ASCII"));
        while(true)
        {
            String line = fr.readLine();
            if(line==null)
                break;
             words = line.split("\n");//those are your words
        }


	}
	catch (Exception e) {
			e.printStackTrace();
		}

//----------------------------------------------database---------------------------------------------------------------------
		try
		{
						ResultSet results;
			Class.forName("oracle.jdbc.driver.OracleDriver");
     		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","yogesh");
			Statement statement = con.createStatement( );
			InputStreamReader isr=new InputStreamReader(System.in);
			BufferedReader br=new BufferedReader(isr);
			PreparedStatement pstmt = null;
			System.out.println("Database working properly");
			String text="";
			Statement stmt = null;
    		query ="select * from db2";
        	stmt = con.createStatement();
        	ResultSet rs = stmt.executeQuery(query);

	        	while (rs.next()) 
        	{
            	name = rs.getString(1);
            	tagno = rs.getString(2);
            	System.out.println(name + "\t" + tagno );
//----------------------------compare-----------------------------------
				  for(j = 0; j < words.length; j++)
    				{
        				if(tagno.equals(words[j]) )
        					{
           						count++;
        					}

    				}	
//-----------------------------------------------------------------------
			}


		}
			catch (Exception e) {
			e.printStackTrace();
		}


//--------------------------------------------compare result-----------------------------------------------------------------------


                 if (count>0)
            {
            	System.out.println("Relax!!!!! Yeah Person is authorized and detected with tag no. EE03 ");
            	System.out.println("\nName of Person Detected is:" +name);
            }
            else
            {
            	System.out.println("Alert!!!!!!!!! Person is not authorized with no tag record");
            }



	}
}


/*
 EE08
 EE03
 EE08
 EE03
*/