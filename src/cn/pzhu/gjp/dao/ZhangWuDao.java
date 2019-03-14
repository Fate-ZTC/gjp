package cn.pzhu.gjp.dao;

import cn.pzhu.gjp.domain.ZhangWu;
import cn.pzhu.gjp.tools.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/*
 * 实现对数据表gjp_zhangwu的增删改查操作
 * dbutils工具类完成，类成员创建QueryRunner对象，指定数据源
 */
public class ZhangWuDao {
	private QueryRunner qr=new QueryRunner(JDBCUtils.getDataSource());
	/*
	 * 定义一个方法，实现删除账务功能
	 * 视图层调用，传递int类型主键
	 * 调用dao层方法,完成删除
	 */
	public void deleteZhangWu(int zwid){
		//执行删除的sql语句
		try{
		String sql="delete FROM gjp_zhangwu WHERE zwid=?";
		qr.update(sql, zwid);
		}catch(SQLException ex){
			System.out.println(ex);
			throw new RuntimeException("删除账务失败");
		}
	}
	/*
	 * 定义一个方法，实现修改账务功能
	 * 由业务层调用，传递参数，也是ZhangWu对象
	 * 调用dao层的方法，修改数据表
	 */
	public void editZhangWu(ZhangWu zw){
		try{
		//执行修改的sql语句
		String sql="update gjp_zhangwu set flname=?, money=?,zhanghu=?,createtime=?,description=? where zwid=?";
		Object[] params={zw.getFlname(),zw.getMoney(),zw.getZhanghu(),zw.getCreatetime(),zw.getDescription(),zw.getZwid()};
		//调用qr对象的方法update执行更新
		qr.update(sql,params);
		}catch(SQLException ex){
			System.out.println(ex);
			throw new RuntimeException("账户修改失败");
		}
	}
	/*
	 * 定义一个方法，实现账务的添加功能
	 * 由业务层调用，传递参数（传递过来的参数不能是5个数据，传递的是一个ZhangWu对象）
	 * 调用dao层方法，写入数据库
	 */
	public void addZhangWu(ZhangWu zw){
		try{
		//添加账务的SQL语句
		String sql="INSERT INTO gjp_zhangwu (flname,money,zhanghu,createtime,description) VALUES(?,?,?,?,?)";
		//创建对象数组，存储5个占位符的实际参数
		//实际参数是传递过来的ZHANGWU对象
		Object[] params={zw.getFlname(),zw.getMoney(),zw.getZhanghu(),zw.getCreatetime(),zw.getDescription()};
		//调用qr对象中的方法update执行添加
		qr.update(sql, params);
		}catch(SQLException ex){
			System.out.println(ex);
			throw new RuntimeException("账户添加失败");
		}
	}
	/*
	 * 定义方法，查询数据库，带有条件去查询账务表
	 * 由业务层调用，查询结果集存储到Bean对象，存储到List集合
	 * 调用者传递2个日期字符串
	 */
	public List<ZhangWu> select(String startDate,String endDate){
		try{
			//条件查询的sql语句
			String sql="select * from gjp_zhangwu where createtime between ? and ?";
			//定义对象数组，存贮？占位符
			Object[] params={startDate,endDate};
			//调用qr对象的方法query查询数据表，获得结果集
			List<ZhangWu> list=qr.query(sql, new BeanListHandler<>(ZhangWu.class),params);
			return list;
		}catch(SQLException ex){
			System.out.println(ex);
			throw new RuntimeException("条件查询失败");
		}
	}
	/*
	 * 查询数据库，获取数据
	 * 方法由业务层调用
	 */
	public List<ZhangWu> selectAll() {
		try{
			//查询账务数据的sql语句
			String sql="SELECT * FROM gjp_zhangwu";
			//调用qr对象的方法query方法，结果集BeanListHandler
			return qr.query(sql, new BeanListHandler<>(ZhangWu.class));
		}catch(SQLException ex){
			System.out.println(ex);
			throw new RuntimeException("查询所有账务失败");
		}
		}
	}

