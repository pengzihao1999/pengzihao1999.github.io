package com.pzh.blog.service;

import com.pzh.blog.dao.TypeDao;
import com.pzh.blog.domain.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TypeServiceImp implements ITypeService {
    
    
    @Autowired
    private TypeDao typeDao;
    @Override
    public void saveType(Type type) {
        typeDao.save(type);
    }

    @Override
    public void deleteType(Long id) {
        typeDao.deleteById(id);
    }

    @Override
    public Type updateType(Type type) {
//        查询到当前id的type
//        Optional<Type> byId = typeDao.findById(type.getId());
        return typeDao.save(type);

    }

    @Override
    public Type selectOneType(Long id) {
        return typeDao.findById(id).get();
    }

    @Override
    public Page<Type> TypePage(Pageable pageable) {
        return typeDao.findAll(pageable);
    }

    @Override
    public Type findTypeByName(Type type) {
        return typeDao.findByNameEquals(type.getName());
    }

    @Override
    public List<Type> findTypes() {
       return typeDao.findAll();
    }

    @Override
    public List<Type> ListfindTopBlog() {
        List<Type> topType = typeDao.findTopBlog();
        return topType;
    }

    @Override
    public Page<Type> findTypes(Pageable pageable) {
        return typeDao.findAll(pageable);
    }


}
