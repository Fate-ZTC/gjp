package cn.pzhu.gjp.controller;

import java.util.List;

import cn.pzhu.gjp.domain.ZhangWu;
import cn.pzhu.gjp.service.ZhangWuService;
/*
 * 控制层
 * 接受视图层数据，数据传递给service层
 * 成员位置，创建service对象
 */
public class ZhangWuController {
	private ZhangWuService service=new ZhangWuService();
	/*
	 * 定义一个方法，实现删除账务功能
	 * 视图层调用，传递int类型主键
	 * 调用Service层方法
	 */
	public void deleteZhangWu(int zwid){
		service.deleteZhangWu(zwid);
	}
	/*
	 * 定义一个方法，实现修改账务功能
	 * 由视图层调用，传递参数，也是ZhangWu对象
	 * 调用service层的方法，传递ZhangWu对象
	 */
	public void editZhangWu(ZhangWu zw){
		service.editZhangWu(zw);
	}
	/*
	 * 定义一个方法，实现账务的添加功能
	 * 由视图层调用，传递参数（传递过来的参数不能是5个数据，传递的是一个ZhangWu对象）
	 * 方法调用service层方法，传递对象，获取结果集(添加成功的行数)
	 */
	public void addZhangWu(ZhangWu zw){
		service.addZhangWu(zw);
	}
	/*
	 * 定义方法，实现条件查询
	 * 方法由控制层调用，传递两个日期字符串
	 * 调用Dao层的方法，传递两个日期字符串
	 * 获取查询结果集
	 */
	public List<ZhangWu> select(String startDate,String endDate){
		return service.select(startDate,endDate);
	}
	/*
	 * 控制层类定义方法，实现查询所有数据的功能
	 * 方法由试图层调用，方法调用Service层
	 */
	public List<ZhangWu> selectAll(){
		return service.selectAll();
		
	}
}
