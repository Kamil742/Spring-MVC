package com.library.library_management.config;

import com.library.library_management.model.Author;
import com.library.library_management.service.impl.AuthorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import java.util.List;

public class ServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] {ServletConfig.class};

    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
       return null;
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }

    @RequestMapping("/author")
    public static class AuthorController {
        @Autowired
        private AuthorServiceImpl authorService;
    
    
        public Author addAuthor(Author author) {
            return authorService.addAuthor(author);
        }
    
    
        public String updateAuthor(Author author) {
             authorService.addAuthor(author);
             return "added";
        }
    
    
        public String deleteAuthor(Author author) {
            authorService.deleteAuthor(author);
            return "deleted";
        }
    
    
        public Author getById(Long author_id) {
            return authorService.getById(author_id);
        }
    
    
        public List<Author> getAll() {
            return null;
        }
    }
}
