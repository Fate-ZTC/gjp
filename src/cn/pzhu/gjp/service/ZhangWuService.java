package cn.pzhu.gjp.service;

import java.util.List;

import cn.pzhu.gjp.dao.ZhangWuDao;
import cn.pzhu.gjp.domain.ZhangWu;
/*
 * 业务层类
 * 接受上一层，控制层的数据
 * 经过计算，床底给dao层，操作数据库
 * 调用dao中的类，类成员位置，创建dao对象
 */
public class ZhangWuService {
	private ZhangWuDao dao=new ZhangWuDao();
	/*
	 * 定义一个方法，实现删除账务功能
	 * 控制层调用，传递int类型主键
	 * 调用dao层方法
	 */
	public void deleteZhangWu(int zwid){
		dao.deleteZhangWu(zwid);
	}
	/*
	 * 定义一个方法，实现修改账务功能
	 * 由控制层调用，传递参数，也是ZhangWu对象
	 * 调用dao层的方法，传递ZhangWu对象
	 */
	public void editZhangWu(ZhangWu zw){
		dao.editZhangWu(zw);
	}
	/*
	 * 定义一个方法，实现账务的添加功能
	 * 由控制层调用，传递参数（传递过来的参数不能是5个数据，传递的是一个ZhangWu对象）
	 * 方法调用dao层方法，传递对象，获取结果集(添加成功的行数)
	 */
	public void addZhangWu(ZhangWu zw){
		dao.addZhangWu(zw);
	}
	/*
	 * 定义方法，实现条件查询
	 * 方法由控制层调用，传递两个日期字符串
	 * 调用Dao层的方法，传递两个日期字符串
	 * 获取查询结果集
	 */
	public List<ZhangWu> select(String startDate,String endDate){
		return dao.select(startDate,endDate);
	}
	/*
	 * 定义方法，实现查询所有的账务数据
	 * 此方法，有控制层调用，去调用dao层的方法
	 */
	public List<ZhangWu> selectAll(){
		return dao.selectAll();
	}
}
