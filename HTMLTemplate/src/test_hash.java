import java.util.*;

public class test_hash 
{
	public static void main(String [] args)
	{
		String [] paths = {
			"t", "test", "."
		};
		Hashtable tmpl_args = new Hashtable();
		tmpl_args.put("filename", "");
		tmpl_args.put("debug", Boolean.FALSE);
		tmpl_args.put("case_sensitive", Boolean.FALSE);
		tmpl_args.put("strict", Boolean.TRUE);
		tmpl_args.put("loop_context_vars", Boolean.TRUE);
		tmpl_args.put("path", paths);

		if(args.length==0)
			tmpl_args.put("filename", "test.tmpl");
		else
			tmpl_args.put("filename", args[0]);

		for(int i=1; i<args.length; i++)
			if(args[i].equals("debug"))
				tmpl_args.put("debug", Boolean.TRUE);
			else if(args[i].equals("case"))
				tmpl_args.put("case_sensitive", Boolean.TRUE);
			else if(args[i].equals("nostrict"))
				tmpl_args.put("strict", Boolean.FALSE);

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
		h.put("item_name", "NCST");
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
