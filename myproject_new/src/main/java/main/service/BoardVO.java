package main.service;

public class BoardVO {
	
	//접근지정자
	private int unq;
	private String title;
	private String pass;
	private String name;
	private String content;
	private int hits;
	private String rdate;
	//페이징처리 변수
	private int viewPage = 1;
	private int startIndex = 1;
	private int endIndex = 10;
	
	//검색 시 사용하는 변수
	private String searchGubun;
	private String searchText;
	
	//get, set
	public String getSearchGubun() {
		return searchGubun;
	}

	public void setSearchGubun(String searchGubun) {
		this.searchGubun = searchGubun;
	}

	public String getSearchText() {
		return searchText;
	}

	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}

	
	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public int getEndIndex() {
		return endIndex;
	}

	public void setEndIndex(int endIndex) {
		this.endIndex = endIndex;
	}

	public int getViewPage() {
		return viewPage;
	}

	public void setViewPage(int viewPage) {
		this.viewPage = viewPage;
	}

	public BoardVO() {
		// TODO Auto-generated constructor stub
	}
	
	public BoardVO(int unq, String title, String pass, String name, String content, int hits, String rdate) {
		super();
		this.unq = unq;
		this.title = title;
		this.pass = pass;
		this.name = name;
		this.content = content;
		this.hits = hits;
		this.rdate = rdate;
	}

	public int getUnq() {
		return unq;
	}
	public void setUnq(int unq) {
		this.unq = unq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getHits() {
		return hits;
	}
	public void setHits(int hits) {
		this.hits = hits;
	}
	public String getRdate() {
		return rdate;
	}
	public void setRdate(String rdate) {
		this.rdate = rdate;
	}
}
