import java.util.*;

public class test 
{
	public static void main(String [] args)
	{
		String [] paths = {
			"t", "test", "."
		};
		Object [] tmpl_args = {
			"filename", "",
			"debug", "",
			"case_sensitive", "",
			"strict", "true",
			"loop_context_vars", "true",
			"global_vars", "",
			"path", "."
		};

		if(args.length==0)
			//tmpl_args[1]="test.tmpl";
			tmpl_args[1]="if.tmpl";
		else
			tmpl_args[1]=args[0];

		for(int i=1; i<args.length; i++)
			if(args[i].equals("debug"))
				tmpl_args[3]="true";
			else if(args[i].equals("case"))
				tmpl_args[5]="true";
			else if(args[i].equals("nostrict"))
				tmpl_args[7]="";
			else if(args[i].equals("global"))
				tmpl_args[11]="true";

		try {
			HTML.Template tmpl = new HTML.Template(tmpl_args);
			tmpl.setParam("Full_name", "<Tellis>");
			tmpl.setParam("full_name", "<Philip>");
			tmpl.setParam("Lists", getLists());
			tmpl.setParam("Myloop", getLoop());
			System.out.print(tmpl.output());
		} catch(Exception e) {
			System.err.println("Exception: " + e);
		}
	}

	private static Vector getLoop()
	{
		Vector v = new Vector();
		Hashtable h = new Hashtable();
		h.put("name", "philip");
		v.addElement(h);
		h = new Hashtable();
		v.addElement(h);
		v.addElement(null);
		h = new Hashtable();
		h.put("name", "sam");
		v.addElement(h);
		return v;
	}
	
	private static Vector getLists()
	{
		Vector v = new Vector();

		Hashtable h = new Hashtable();
		h.put("items", getItems());
		v.addElement(h);
		v.addElement(null);
		v.addElement(h);
		v.addElement(new Hashtable());
		v.addElement(h);
		return v;
	}

	private static Vector getItems()
	{
		Vector v = new Vector();
		Hashtable h = new Hashtable();

		h.put("link", "true");
		h.put("item", "http://www.ncst.ernet.in");
		h.put("Item_Name", "NCST");
		h.put("new", "true");

		v.addElement(h);

		h = new Hashtable();
		h.put("file", "true");
		h.put("file_url", "myfile.txt");
		h.put("file_head", "This is my file");
		v.addElement(h);

		h = new Hashtable();
		h.put("file", "true");
		h.put("file_head", "This is not my file");
		v.addElement(h);

		return v;
	}
}
