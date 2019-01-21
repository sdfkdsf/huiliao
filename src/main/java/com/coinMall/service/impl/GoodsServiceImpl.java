package com.coinMall.service.impl;

import com.coinMall.bean.ReturnModel;
import com.coinMall.bean.in.goods.GoodsModel;
import com.coinMall.service.GoodsService;

import java.util.List;

import org.springframework.stereotype.Service;


import com.coinMall.bean.ReturnModel;
import com.coinMall.dao.GoodsInfoMapper;
import com.coinMall.pojo.GoodsInfo;
import com.coinMall.service.GoodsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;


/** 
* @author 作者 wubingqiao: 
* @version 创建时间：2018年10月23日 下午2:22:06 
* 
* 
* 			说明：     如果是     数据库表：  goodsInfo
* 						通用Mapper  ：   goodsInfoMapper   
* 						输入模型：  goodsModel
* 						
* 						
* 类说明 
*/
@Service
public class GoodsServiceImpl implements GoodsService {


    private static Logger logger = Logger.getLogger(CommentServiceImpl.class);

    @Autowired
    private GoodsInfoMapper goodsMapper;

    /**
     *    分页     得到所有的商品
     * @return
     * @param pageIndex
     * @param pageSize
     */
    @Override
    public ReturnModel getList(Integer pageIndex, Integer pageSize) {
            //   创建返回  模型
        ReturnModel returnModel = new ReturnModel();

        try {
            //设置  分页   信息设置
            PageHelper.startPage(pageIndex,pageSize);

//            得到所有的  商品信息
            List<GoodsInfo> goodsList= goodsMapper.getGoodsList();
            
            List<GoodsModel> goodsModelList = new ArrayList<GoodsModel>();
            
            if (goodsList!=null && goodsList.size()>0) {
            	for(GoodsInfo goods :  goodsList){
                	GoodsModel goodsModel = new GoodsModel();
            //  将我们的   商品信息存储到    商品模型中去       	
                	BeanUtils.copyProperties(goodsModel, goods);
                	
                	//  添加到集合中去~~~
                	goodsModelList.add(goodsModel);
                };
                
                PageInfo<GoodsInfo> pageInfo = new PageInfo<>(goodsList);
                
                // 将所有的  结果集全部发给我们的    转换成goods

                returnModel.setBodyMessage(pageInfo);
			}
             
        } catch (Exception e) {
            logger.error("查询商品列表信息异常",e);
            returnModel.setCode(-1);
        }
        
        returnModel.setMessage("查询商品列表信息异常");
        return new ReturnModel();
    }

    /***
     *      删除多个商品信息
     * @param idList
     * @return
     */
    @Override
    public ReturnModel delete(List<Long> idList) {

        //   创建返回  模型
        ReturnModel returnModel = new ReturnModel();

        if (idList!=null && idList.size()>0) {
            try {
                int count = 0 ;
                for (Long id : idList) {
                    GoodsInfo goods = goodsMapper.selectByPrimaryKey(id);

                    goods.setGoodsStatus(0);

                    count += goodsMapper.updateByPrimaryKey(goods);
                }


                returnModel.setCode(0);
                returnModel.setMessage("删除商品成功");

            } catch (Exception e) {
                logger.error("查询商品列表异常",e);
                returnModel.setCode(-1);
                returnModel.setMessage("查询商品异常");
            }
        }

        return returnModel;
    }

    /**
     *       根据商品的  Id   得到商品信息
     * @param goodsId
     * @return
     */
    @Override
    public ReturnModel getOneByGoodsId(Long goodsId) {
        ReturnModel returnModel = new ReturnModel();
        try {
            GoodsInfo goods = goodsMapper.selectByPrimaryKey(goodsId);
            if (goods!=null){
                //    浏览次数  增加一次浏览次数。。。
                goods.setGoodsBrowseTotal(goods.getGoodsBrowseTotal()+1);
                goodsMapper.insertSelective(goods);

                returnModel.setBodyMessage(goods);
            }else {
                returnModel.setMessage("商品信息不存在");
            }
        } catch (Exception e) {
            logger.error("查询商品异常",e);
            returnModel.setCode(-1);
            returnModel.setMessage("查询商品异常");
        }

        return returnModel;
    }

    /***
     *    添加一个商品信息。      或者        修改一个商品信息
     * @param goods
     * @return
     */
    @Override
    public ReturnModel InsertGoods(GoodsModel goodsModel) {
    	// 创建一个查询的   goods  信息
        GoodsInfo goods = new GoodsInfo();
        
    //  创建一个返回类型
        ReturnModel returnModel = new ReturnModel();
    	
    	if (0 == goodsModel.getGoodsId()  || goodsModel.getGoodsId() == null) {
	
	        try {
	        	//   新增商品里面  所需要添加的一些信息、、、
	        	goodsModel.setGoodsCreateTime(new Date());
	
	            BeanUtils.copyProperties(goods, goodsModel);
	
	            int a = goodsMapper.insertSelective(goods);
	            
	            if (a>0) {
	                returnModel.setMessage("增加商品OK");
	                
	                return returnModel;
				}
	                        
	        } catch (Exception e) {
	            logger.error("增加商品异常",e);
	        }
	        
	        returnModel.setCode(-1);
	        returnModel.setMessage("增加商品异常");
	
	        return returnModel;
	    }else{
	    	 
	    	 try {
	    		//  将查询到的商品信息  ，全部  转换到我们的    Goods商品里面去;
				BeanUtils.copyProperties(goods, goodsModel);
				goods.setGoodsCreateTime(new Date());
				
				int i = goodsMapper.updateByPrimaryKeySelective(goods);
				if (i>0) {
		            returnModel.setMessage("修改商品成功");	
		            return returnModel;
				}
			} catch (Exception e) {
				logger.error("修改商品异常",e);
			}
	    	 
	    	 returnModel.setCode(-1);
	         returnModel.setMessage("修改商品异常");
	         
	         return returnModel;
	    }
    }
}
