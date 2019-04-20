package test.book.service;

import test.book.dao.BookDao;
import test.book.domain.Book;

public class BookService {
    BookDao bd=new BookDao();
    public Book Query(Book book) throws BookException
    {
		String _id=book.getBookID();
	  Book bk=bd.findBookByBookID(_id);
	  if(bk==null)
	  {
		  throw new BookException("没有这本书，请输入其他的BookID");
	  }
      return bk;
    }
    public void add(Book book1) throws BookException
    {
    	String _id2=book1.getBookID();
    	Book bk2=bd.findBookByBookID(_id2);
    	if(bk2!=null)
    	{
    		 throw new BookException("这本书已经有了 ，不能在新增啦");
    	}
    	else
    	{
    		bd.Add(book1);
    	}
    }
    public void delectbook(Book book2) throws BookException
    {
    	String _id2=book2.getBookID();
    	Book bk2=bd.findBookByBookID(_id2);
    	
    	if(bk2==null)
    	{
    		 throw new BookException("数据库里面没有这本书,在换一本删看看!");
    	}
    	else
    	{
    		bd.deletebook(_id2);
    	}
    }
}
