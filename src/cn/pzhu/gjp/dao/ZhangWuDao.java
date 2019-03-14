package cn.pzhu.gjp.dao;

import cn.pzhu.gjp.domain.ZhangWu;
import cn.pzhu.gjp.tools.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/*
 * ʵ�ֶ����ݱ�gjp_zhangwu����ɾ�Ĳ����
 * dbutils��������ɣ����Ա����QueryRunner����ָ������Դ
 */
public class ZhangWuDao {
	private QueryRunner qr=new QueryRunner(JDBCUtils.getDataSource());
	/*
	 * ����һ��������ʵ��ɾ��������
	 * ��ͼ����ã�����int��������
	 * ����dao�㷽��,���ɾ��
	 */
	public void deleteZhangWu(int zwid){
		//ִ��ɾ����sql���
		try{
		String sql="delete FROM gjp_zhangwu WHERE zwid=?";
		qr.update(sql, zwid);
		}catch(SQLException ex){
			System.out.println(ex);
			throw new RuntimeException("ɾ������ʧ��");
		}
	}
	/*
	 * ����һ��������ʵ���޸�������
	 * ��ҵ�����ã����ݲ�����Ҳ��ZhangWu����
	 * ����dao��ķ������޸����ݱ�
	 */
	public void editZhangWu(ZhangWu zw){
		try{
		//ִ���޸ĵ�sql���
		String sql="update gjp_zhangwu set flname=?, money=?,zhanghu=?,createtime=?,description=? where zwid=?";
		Object[] params={zw.getFlname(),zw.getMoney(),zw.getZhanghu(),zw.getCreatetime(),zw.getDescription(),zw.getZwid()};
		//����qr����ķ���updateִ�и���
		qr.update(sql,params);
		}catch(SQLException ex){
			System.out.println(ex);
			throw new RuntimeException("�˻��޸�ʧ��");
		}
	}
	/*
	 * ����һ��������ʵ���������ӹ���
	 * ��ҵ�����ã����ݲ��������ݹ����Ĳ���������5�����ݣ����ݵ���һ��ZhangWu����
	 * ����dao�㷽����д�����ݿ�
	 */
	public void addZhangWu(ZhangWu zw){
		try{
		//��������SQL���
		String sql="INSERT INTO gjp_zhangwu (flname,money,zhanghu,createtime,description) VALUES(?,?,?,?,?)";
		//�����������飬�洢5��ռλ����ʵ�ʲ���
		//ʵ�ʲ����Ǵ��ݹ�����ZHANGWU����
		Object[] params={zw.getFlname(),zw.getMoney(),zw.getZhanghu(),zw.getCreatetime(),zw.getDescription()};
		//����qr�����еķ���updateִ�����
		qr.update(sql, params);
		}catch(SQLException ex){
			System.out.println(ex);
			throw new RuntimeException("�˻����ʧ��");
		}
	}
	/*
	 * ���巽������ѯ���ݿ⣬��������ȥ��ѯ�����
	 * ��ҵ�����ã���ѯ������洢��Bean���󣬴洢��List����
	 * �����ߴ���2�������ַ���
	 */
	public List<ZhangWu> select(String startDate,String endDate){
		try{
			//������ѯ��sql���
			String sql="select * from gjp_zhangwu where createtime between ? and ?";
			//����������飬������ռλ��
			Object[] params={startDate,endDate};
			//����qr����ķ���query��ѯ���ݱ���ý����
			List<ZhangWu> list=qr.query(sql, new BeanListHandler<>(ZhangWu.class),params);
			return list;
		}catch(SQLException ex){
			System.out.println(ex);
			throw new RuntimeException("������ѯʧ��");
		}
	}
	/*
	 * ��ѯ���ݿ⣬��ȡ����
	 * ������ҵ������
	 */
	public List<ZhangWu> selectAll() {
		try{
			//��ѯ�������ݵ�sql���
			String sql="SELECT * FROM gjp_zhangwu";
			//����qr����ķ���query�����������BeanListHandler
			return qr.query(sql, new BeanListHandler<>(ZhangWu.class));
		}catch(SQLException ex){
			System.out.println(ex);
			throw new RuntimeException("��ѯ��������ʧ��");
		}
		}
	}

