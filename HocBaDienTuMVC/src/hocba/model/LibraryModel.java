package hocba.model;

public class LibraryModel {
	public static String pageHTML(String urlpage, int npage, int active) {
		String html = "";
		html += "<nav aria-label=\"Page navigation example\" style=\"text-align: center;\">\r\n" + 
				"<ul class=\"pagination\">\r\n" +
				"<li class=\"page-item\"><a class=\"page-link\" href=\"#\">Previous</a></li>\r\n";
		for(int i = 1; i <= npage; ++i) {
			html +=	"<li class=\"page-item";
			if(i == active) {
				html += " active ";
			}
					
			html += "\"><a class=\"page-link\" href=\""+ urlpage + "?page="+i+"\">" +i+ "</a></li>\r\n";
		}
		

		html += ""
				+ "<li class=\"page-item\"><a class=\"page-link\" href=\"#\">Next</a></li>\r\n" +
				"</ul>\r\n" + 
				"</nav>";
		
		return html;
	}
}
