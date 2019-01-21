package com.coinMall.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.coinMall.bean.ReturnModel;
import com.coinMall.bean.in.goods.CategoryModel;
import com.coinMall.bean.out.goods.CategoryReturn;
import com.coinMall.dao.CategoryMapper;
import com.coinMall.pojo.Category;
import com.coinMall.service.CategoryService;

/** 
* @author 作者 wubingqiao: 
* @version 创建时间：2018年10月23日 上午11:11:37 
* 类说明 
*/
@Service
public class CategoryServiceImpl implements CategoryService {

	private static Logger logger = Logger.getLogger(CommentServiceImpl.class);

    @Autowired
    private CategoryMapper categoryMapper;
    
    /***
     *      得到  这个分类下面所有的子类分类
     */
	@Override
	public ReturnModel getAllSonCategory(Integer categoryId) {
		ReturnModel returnModel = new ReturnModel();
		
		try {
//	  得到所有的  子类   分层；	
			List<Category> categorys = categoryMapper.getAllSonCategory(categoryId);
			
			List<CategoryReturn> categoryReturns = new ArrayList<>();
			if (categorys != null && categorys.size() > 0) {
				for (Category category : categorys) {
					CategoryReturn categoryReturn = new CategoryReturn();
					BeanUtils.copyProperties(categoryReturn, category);
					categoryReturns.add(categoryReturn);
				}
				
				returnModel.setMessage("得到子层级成功");
				returnModel.setBodyMessage(categoryReturns);
				return returnModel;
			} 
		} catch (Exception e) {
			 logger.error("得到子层级异常",e);
        } 
		
        returnModel.setMessage("得到子层级异常");
		
        return returnModel;
	}
    
    
    /**
     *    根据     分类Id删除   这个分类；  
     */
    @Override
	public ReturnModel deleteCategory(Integer categoryId) {
    	
    	ReturnModel returnModel = new ReturnModel();
    	
    	try {
			//首先查询这个category是否有子类
			Integer i = categoryMapper.haveSonCategory(categoryId);
			if (i == null || i == 0) {
				categoryMapper.deleteByPrimaryKey(categoryId);
				 returnModel.setMessage("删除层级查询分类  成功");
					
			     return returnModel;	     
			} else{
				returnModel.setMessage("你说选择的层级有子类层级，请删完子类层级后在删除这一层级");
				
			     return returnModel;	
			}
		} catch (Exception e) {
			 logger.error("删除层级查询分类异常",e);
        } 
		
        returnModel.setCode(-1);
        returnModel.setMessage("删除层级查询分类异常");
		
        return returnModel;
	}
    
    
    
    /**
     *     增加  一个分类信息
     */
    @Override
	public ReturnModel addCategory(CategoryModel categoryModel) {
    	
    	ReturnModel returnModel = new ReturnModel();
    	
    	//  创建一个查询    category  类的  信息
    	Category category = new Category();	
    	
    	try {
			BeanUtils.copyProperties(category, categoryModel);
			
			List<String> categoryTitles = categoryMapper.getAllTitle();
			
			if(categoryTitles.contains(category.getCategoryName())){
		        returnModel.setMessage("已经含有该分类信息，所以添加不成功");
		        return returnModel;
			}
			
			int i = categoryMapper.insertSelective(category);
			
			if(i>0){
				returnModel.setMessage("添加分类信息成功");
				
		        return returnModel;
			}	
			
		} catch (Exception e) {
			 logger.error("根据层级查询分类信息异常",e);
        } 
		
        returnModel.setCode(-1);
        returnModel.setMessage("根据层级查询分类信息异常");
		
        return returnModel;
	}

    /***
     *    根据层级ID   查找所有的   分类信息;
     */
	@Override
	public ReturnModel getCategorysByLevel(Integer categoryLevel) {
		
		ReturnModel returnModel = new ReturnModel();
		
		List<CategoryReturn> categoryReturns = new ArrayList<>();
		
		try {
			//  根据层级查询到的    分类信息; 
			List<Category> categories = categoryMapper.getCategorysByLevel(categoryLevel);
			
			for (Category category : categories) {
				CategoryReturn categoryReturn = new CategoryReturn();
				BeanUtils.copyProperties(categoryReturn, category);
				
				categoryReturns.add(categoryReturn);
			} 
			
			returnModel.setMessage("根据层级查询分类信息成功");
			returnModel.setBodyMessage(categoryReturns);
			return returnModel;
			
		} catch (Exception e) {
			 logger.error("根据层级查询分类信息异常",e);
        } 
		
        returnModel.setCode(-1);
        returnModel.setMessage("根据层级查询分类信息异常");
		
        return returnModel;
	}	
}
















