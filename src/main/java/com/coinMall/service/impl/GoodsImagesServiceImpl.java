package com.coinMall.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coinMall.bean.ReturnModel;
import com.coinMall.bean.in.goods.GoodsImagesModel;
import com.coinMall.bean.out.goods.GoodsImagesReturn;
import com.coinMall.dao.GoodsImagesMapper;
import com.coinMall.pojo.GoodsImages;
import com.coinMall.service.GoodsImagesService;

/** 
* @author 作者 wubingqiao: 
* @version 创建时间：2018年10月24日 下午5:57:41 
* 类说明 
*/

@Service
public class GoodsImagesServiceImpl implements GoodsImagesService {
	
	private static Logger logger = Logger.getLogger(CommentServiceImpl.class);
	
	@Autowired
	private GoodsImagesMapper goodsImagesMapper;
	
	/***
	 *    得到某个商品的   所有图片
	 */
	@Override
	public ReturnModel getImagesByGoodsId(Long goodsId) {
		ReturnModel returnModel = new ReturnModel();
		
		List<GoodsImagesReturn> goodsImagesModels = new ArrayList<GoodsImagesReturn>();
		try {
			//  记得写  商品查询    是否显示                        //  得到商品的所有的图片信息
			List<GoodsImages> goodsImagesList = goodsImagesMapper.selectByGoodsId(goodsId);
			
			if (goodsImagesList != null && goodsImagesList.size() > 0) {
				for (GoodsImages goodsImages : goodsImagesList) {
					GoodsImagesReturn goodsImageReturn = new GoodsImagesReturn();
					
					/*goodsImageReturn.setGoodsId(goodsImages.getGoodsId());
					goodsImageReturn.setImagesDescirption(goodsImageReturn.getImagesDescirption());
					goodsImageReturn.setImagesDisplay(imagesDisplay);*/
					
					BeanUtils.copyProperties(goodsImageReturn, goodsImages);
					goodsImagesModels.add(goodsImageReturn);
				}
				
				returnModel.setMessage("查询商品成功");
				returnModel.setBodyMessage(goodsImagesModels);
			
				
		        return returnModel;
			} else{
				
				returnModel.setMessage("该商品里面没有图片信息");
				
		        return returnModel;
			}
			
		} catch (Exception e) {
			 logger.error("查询商品异常",e);
        }
        
        returnModel.setCode(-1);
        returnModel.setMessage("查询商品异常");
		
        return returnModel;
	}
		
	/**
	 *      需要删除多个     图片
	 */
	@Override
	public ReturnModel delete(List<Integer> idList) {
		ReturnModel returnModel = new ReturnModel();
		
		if(idList==null || idList.size()==0){
			returnModel.setMessage("请不要传送一个空的值");
			return returnModel;
		}else{
			try {
				for (int i = 0; i < idList.size(); i++) {
					goodsImagesMapper.deleteByPrimaryKey(idList.get(i));
				} 
				
				returnModel.setMessage("删除商品成功");
				
		        return returnModel;
				
			} catch (Exception e) {
				 logger.error("删除商品异常",e);
	        }
	        
	        returnModel.setCode(-1);
	        returnModel.setMessage("删除商品异常");
			
	        return returnModel;
		}		
	}
	

	/**
	 *   增加商品  一个  图片，按照添加顺序进行排序
	 */
	@Override
	public ReturnModel addGoodsImages(GoodsImagesModel goodsImagesModel) {
		GoodsImages goodsImages = new GoodsImages();
		
		//  创建一个返回值  模型
		ReturnModel returnModel  = new ReturnModel() ;
		
		try {
		//  将模型里面的数据全部传送到我们的   goodsImages里面
			BeanUtils.copyProperties(goodsImages, goodsImagesModel);
		//  查询最大的排序      某一个商品最大的排序
			Integer i = goodsImagesMapper.selectMaxSort(goodsImagesModel.getGoodsId());
			
			if(i==null){
				goodsImages.setImagesSort(1);
			}else{
				goodsImages.setImagesSort(i+1);
			}
		//  将图片添加到数据库	
			int j = goodsImagesMapper.insertSelective(goodsImages);
			if (j>0) {
				//  添加商品成功的话
				returnModel.setMessage("增加商品成功");
				return returnModel;
			}			
			
		} catch (IllegalAccessException | InvocationTargetException e) {
			 logger.error("增加商品异常",e);
        }
        
        returnModel.setCode(-1);
        returnModel.setMessage("增加商品异常");
		
		
		return returnModel;
	}
}
