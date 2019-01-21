package com.coinMall.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aliyun.openservices.shade.com.alibaba.fastjson.JSON;
import com.coinMall.bean.ReturnModel;
import com.coinMall.bean.enums.Subcode;
import com.coinMall.bean.in.order.ShopCartModel;
import com.coinMall.bean.out.order.MyShopCartReturn;
import com.coinMall.common.BaseService;
import com.coinMall.dao.ShopCartMapper;
import com.coinMall.dao.UserInfoMapper;
import com.coinMall.pojo.ShopCart;
import com.coinMall.pojo.UserInfo;
import com.coinMall.service.ShopCartService;

/** 
 * @author jiangjiayi
 * @date 2018年10月24日
 */
@Service
public class ShopCartServiceImpl extends BaseService implements ShopCartService {

	private static Logger logger = Logger.getLogger(ShopCartServiceImpl.class);
	
	@Autowired
	private ShopCartMapper shopCartMapper;
	@Autowired
	private UserInfoMapper userInfoMapper;
	
	@Override
	public ReturnModel addShopCart(ShopCartModel shopCartModel) {
		ReturnModel returnModel = new ReturnModel();
		try {
			if(shopCartModel.getCartTotal() > 20){
				returnModel.setSubCode(Subcode.BUSINESS_ERROR.getSubcode());
				returnModel.setMessage("加入购物车数量不能超过20个");
				return returnModel;
			}
			
			//根据stockId查库存 TODO
			Integer stockTotal = 1;
			if(shopCartModel.getCartTotal() > stockTotal){
				returnModel.setSubCode(Subcode.BUSINESS_ERROR.getSubcode());
				returnModel.setMessage("库存不足");
				return returnModel;
			}
			
			//根据用户id,商品id,规格id查询有无购物车记录
			ShopCart shopCartByMultiId = shopCartMapper.getShopCartByMultiId(shopCartModel.getUid(), shopCartModel.getGoodsId(), shopCartModel.getStockId());
			
			//无记录则新增
			if(shopCartByMultiId == null){
				ShopCart record = new ShopCart();
				BeanUtils.copyProperties(record, shopCartModel);
				record.setCartTime(new Date());
				shopCartMapper.insertSelective(record);
			}else{//有记录修改数量
				Integer cartTotal = shopCartByMultiId.getCartTotal();
				int newTotal = cartTotal + shopCartModel.getCartTotal();
				if(newTotal > 20){
					returnModel.setSubCode(Subcode.BUSINESS_ERROR.getSubcode());
					returnModel.setMessage("加入购物车失败");
					return returnModel;
				}else{
					ShopCart record = new ShopCart();
					record.setCartId(shopCartByMultiId.getCartId());
					record.setCartTotal(newTotal);
					record.setCartTime(new Date());
					shopCartMapper.updateByPrimaryKeySelective(record);
				}
			}
			
		} catch (Exception e) {
			logger.error("加入购物车异常", e);
			returnModel.setCode(-1);
			returnModel.setMessage("加入购物车异常");
		}
		return returnModel;
	}

	@Override
	public ReturnModel getMyShopCart(Integer uid) {
		ReturnModel returnModel = new ReturnModel();
		try {
			//验证用户UID
			if(!verifyUser(uid)) return setModelError(returnModel, Subcode.PARAM_ERROR);
			
			MyShopCartReturn shopCartReturn = new MyShopCartReturn();
			//查询我的金币 
			UserInfo userInfo = userInfoMapper.selectByPrimaryKey(uid);
			shopCartReturn.setMyGold(userInfo.getGoldTotal());
			List<MyShopCartReturn.ShopCartReturn> shopCartList = new ArrayList<>();
			
			List<ShopCart> shopCartListByUid = shopCartMapper.getShopCartListByUid(uid);
			//根据商品id批量查询 TODO
			
			for (ShopCart sc : shopCartListByUid) {
				MyShopCartReturn.ShopCartReturn scr = new MyShopCartReturn.ShopCartReturn();
				scr.setGoodsImg("缺商品接口");
				scr.setGoodsName("缺商品接口");
				scr.setNormValue("缺商品接口");
				scr.setStockGold(123456d);
				scr.setIsValidGoods(1);//查库存，商品是否上下架
				
				scr.setCartId(sc.getCartId());
				scr.setCartTotal(sc.getCartTotal());
				scr.setGoodsId(sc.getGoodsId());
				scr.setStockGoldSubtotal(123456d*sc.getCartTotal());
				
				shopCartList.add(scr);
			}
			shopCartReturn.setShopCartList(shopCartList);
			
			returnModel.setBodyMessage(JSON.toJSONString(shopCartReturn));
		} catch (Exception e) {
			logger.error("我的购物车异常", e);
			returnModel.setCode(-1);
			returnModel.setMessage("我的购物车异常");
		}
		return returnModel;
	}

	@Override
	public ReturnModel updateCartTotal(Long cartId, Integer number) {
		ReturnModel returnModel = new ReturnModel();
		try {
			if(number != 1 && number != -1) return setModelError(returnModel, Subcode.PARAM_ERROR);
			
			ShopCart selectByPrimaryKey = shopCartMapper.selectByPrimaryKey(cartId);
			if(selectByPrimaryKey != null){
				Long stockId = selectByPrimaryKey.getStockId();
				Integer cartTotal = selectByPrimaryKey.getCartTotal();
				//查商品是否下架 TODO
				
				//查库存 TODO
				Integer stockTotal = 22;//库存
				
				//原来购物车数量大于库存 或者 购物车数量加减后还是大于库存
				if(number > 0){
					if(cartTotal >= stockTotal){
						returnModel.setSubCode(Subcode.OPERATION_ERROR.getSubcode());
						returnModel.setMessage("库存不足");
						return returnModel;
					}
					if(cartTotal >= 20){
						return setModelError(returnModel, Subcode.OPERATION_ERROR);
					}
					shopCartMapper.updateCartTotalById(cartId, number);
				}else if(number < 0){
					if((cartTotal+number) <= 0){
						return setModelError(returnModel, Subcode.OPERATION_ERROR);
					}
					int updateCartTotalById = shopCartMapper.updateCartTotalById(cartId, number);
					if(updateCartTotalById > 0){
						if((cartTotal+number) > stockTotal){
							returnModel.setSubCode(Subcode.BUSINESS_ERROR.getSubcode());
							returnModel.setMessage("库存不足");
							return returnModel;
						}
					}
				}
				
			}
			
		} catch (Exception e) {
			logger.error("加减购物车商品数量异常", e);
			returnModel.setCode(-1);
			returnModel.setMessage("加减购物车商品数量异常");
		}
		return returnModel;
	}

	@Override
	public ReturnModel getMyShopCartGoodsTotal(Integer uid) {
		ReturnModel returnModel = new ReturnModel();
		try {
			//验证用户UID
			if(!verifyUser(uid)) return setModelError(returnModel, Subcode.PARAM_ERROR);
			
			Map<String, Integer> map = new HashMap<>();
			
			
			List<ShopCart> shopCartListByUid = shopCartMapper.getShopCartListByUid(uid);
			List<Long> stockIds = new ArrayList<>();
			for (ShopCart sc : shopCartListByUid) {
				stockIds.add(sc.getStockId());
			}
			//根据商品id批量查询 TODO
			
			int total = 0;
			//如果商品未上架或库存为0，不进行累加
			
			map.put("total", total);
			
			returnModel.setBodyMessage(JSON.toJSONString(map));
			
		} catch (Exception e) {
			logger.error("统计购物车有效商品数量异常", e);
			returnModel.setCode(-1);
			returnModel.setMessage("统计购物车有效商品数量异常");
		}
		return returnModel;
	}

}
