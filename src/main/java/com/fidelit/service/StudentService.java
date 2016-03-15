package com.fidelit.service;
import java.util.List;

import com.fidelit.model.Blog;

public interface StudentService {
	List<Blog> getBlogsByClass(String studentclass);
}
